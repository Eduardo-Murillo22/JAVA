package com.techelevator;

import com.techelevator.compile.DynamicCompiler;
import com.techelevator.compile.ITest;
import com.techelevator.parse.DynamicParser;
import com.techelevator.solution.Solutions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Base Class for all solution tests. This abstraction allows each test class to focus
 * on the results of the exercise
 */
public abstract class BaseSolution {

    private static final String FILE_PATH = "src/main/java/com/techelevator/Exercises.java";
    private static Solutions solutions;
    private DynamicParser dp = new DynamicParser();
    String solutionCode;
    String code;
    String sourceCode;
    List<String> varTypeNames = new ArrayList<>();
    String[] parts;
    String lastVarType;
    String lastVarName;
    DynamicCompiler dc = new DynamicCompiler();
    String assembleSourceCode;
    ITest iTest;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Load the Solutions
        try (FileReader fr = new FileReader(FILE_PATH)) {
            solutions = new Solutions(fr);
        }
    }

    @BeforeEach
    public void setup(TestInfo testInfo) throws Exception {
        String displayName = testInfo.getDisplayName().replace("()", "");
        solutionCode = displayName.replaceAll("testSolution", "");
        code = solutions.getSolutionCode(solutionCode);

        if ((code != null) && (!code.isEmpty())) {
            // Find the type and name of the variable the student declared.
            sourceCode = "public class Test {" + "public void doSomething(){" + code + "}}";
            varTypeNames = dp.parse(sourceCode);
            parts = varTypeNames.get(varTypeNames.size() - 1).split(":");
            lastVarType = parts[0];
            lastVarName = parts[1];

            // Assemble the "runnable" source code using the student's solution, and the last variable type and name
            assembleSourceCode = dc.assembleSourceCode(code, lastVarType, lastVarName);

            // Compile the assembled source and create a new instance of the ITest class
            Class<ITest> compiledTest = dc.compile(assembleSourceCode);
            iTest = compiledTest.getDeclaredConstructor().newInstance();
            iTest.setLastVarType(lastVarType);

            assertTrue(varTypeNames.size() > 0, "You must declare at least one variable.");
            assertVariableNaming(varTypeNames);
            assertConstantNaming(varTypeNames);
        } else {
            throw new RuntimeException("Exercise {" + solutionCode + "} is incomplete.");
        }
    }

    public void assertCorrectResults(ITest iTest, String expectedValue) {
        assertEquals(expectedValue, iTest.getStringResult(), getStudentCodeForReview());
    }

    public void assertCorrectResults(ITest iTest, int expectedValue) {
        if (iTest.getLastVarType().equals("byte")) {
            assertEquals((byte)expectedValue, iTest.getByteResult(), getStudentCodeForReview());
        }
        else if (iTest.getLastVarType().equals("long")) {
            assertEquals((long)expectedValue, iTest.getLongResult(), getStudentCodeForReview());
        }
        else if (iTest.getLastVarType().equals("short")) {
            assertEquals((long)expectedValue, iTest.getShortResult(), getStudentCodeForReview());
        }
        else {
            assertEquals(expectedValue, iTest.getIntResult(), getStudentCodeForReview());
        }
    }

    public void assertCorrectResults(ITest iTest, long expectedValue) {
        assertEquals(expectedValue, iTest.getLongResult(), getStudentCodeForReview());
    }

    public void assertCorrectResults(ITest iTest, double expectedValue, double delta) {
        if (iTest.getLastVarType().equals("float")) {
            assertEquals(expectedValue, iTest.getFloatResult(), delta, getStudentCodeForReview());
        }
        else {
            assertEquals(expectedValue, iTest.getDoubleResult(), delta, getStudentCodeForReview());
        }
    }

    private String getStudentCodeForReview() {
        return "\n\nREVIEW YOUR SOLUTION CODE:\n==========\n" + code + "\n==========\n";
    }

    private void assertVariableNaming(List<String> varTypeNames) {
        for (String varTypeName : varTypeNames) {
            String[] parts = varTypeName.split(":");
            if (Boolean.parseBoolean(parts[2]) == false) {
                String varName = parts[1];
                Matcher m = Pattern.compile("^[a-z]").matcher(varName);
                if (m.find() == false) {
                    fail("Variable name '" + varName + "' must start with a lowercase character.");
                }
                m = Pattern.compile("_+").matcher(varName);
                if (m.find() == true) {
                    fail("Variable name '" + varName + "' must not contain underscore characters");
                }
                m = Pattern.compile("\\$+").matcher(varName);
                if (m.find() == true) {
                    fail("Variable name '" + varName + "' must not contain dollar sign characters.");
                }
                assertTrue(varName.length() >= 2, "Variable name '" + varName +
                    "' must be 2 or more characters long.");
            }
        }
    }

    private void assertConstantNaming(List<String> varTypeNames) {
        for (String varTypeName : varTypeNames) {
            String[] parts = varTypeName.split(":");
            if (Boolean.parseBoolean(parts[2])) {
                String varName = parts[1];
                Matcher m = Pattern.compile("^[A-Z]").matcher(varName);
                if (m.find() == false) {
                    fail("Constant name '" + varName + "' must start with an uppercase character.");
                }
                m = Pattern.compile("[a-z]+").matcher(varName);
                if (m.find() == true) {
                    fail("Constant name '" + varName + "' must not contain lowercase characters.");
                }
                m = Pattern.compile("\\$+").matcher(varName);
                if (m.find() == true) {
                    fail("Constant name '" + varName + "' must not contain dollar sign characters.");
                }
                m = Pattern.compile("_+$").matcher(varName);
                if (m.find() == true) {
                    fail("Constant name '" + varName + "' must not end with a underscore character.");
                }
                assertTrue(varName.length() >= 2, "Constant name '" + varName +
                    "' must be 2 or more characters long.");
            }
        }
    }
}
