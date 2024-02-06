package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class HomeworkAssignmentTest {

	@Before
	public void homeworkAssignmentRequiredMethods() {

		Class klass = HomeworkAssignment.class;

		Constructor<HomeworkAssignment> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class);
		assertTrue("You do not have the required constructor(int, String)", constructor != null);

		Method method = SafeReflection.getMethod(klass, "getPossibleMarks");
		assertTrue("HomeworkAssignment class needs the getPossibleMarks() method.", method != null);
		assertTrue("getPossibleMarks() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setPossibleMarks", Integer.TYPE);
		assertTrue("HomeworkAssignment class should not have a setPossibleMarks(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getEarnedMarks");
		assertTrue("HomeworkAssignment class needs the getEarnedMarks() method.", method != null);
		assertTrue("getEarnedMarks() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setEarnedMarks", Integer.TYPE);
		assertTrue("HomeworkAssignment class needs the setEarnedMarks(int) method.", method != null);
		assertTrue("setEarnedMarks(int) method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "getSubmitterName");
		assertTrue("HomeworkAssignment class needs the getSubmitterName() method.", method != null);
		assertTrue("getSubmitterName() method needs to return type: String", method.getReturnType() == String.class);

		method = SafeReflection.getMethod(klass, "setSubmitterName", String.class);
		assertTrue("HomeworkAssignment class should not have a setSubmitterName(String) method", method == null);

		method = SafeReflection.getMethod(klass, "getLetterGrade");
		assertTrue("HomeworkAssignment class needs the getLetterGrade() method.", method != null);
		assertTrue("getLetterGrade() method needs to return type: String", method.getReturnType() == String.class);

		assertFalse("HomeworkAssignment class must not be abstract. Remove the 'abstract' modifier on HomeworkAssignment.", Modifier.isAbstract(klass.getModifiers()));
	}

	@Test
	public void homeworkAssignmentConstructor() {
		Class klass = HomeworkAssignment.class;

		Constructor<HomeworkAssignment> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class);
		assertTrue("You do not have the required constructor(int, String)", constructor != null);
		try {
			HomeworkAssignment homeworkAssignment = constructor.newInstance(100, "T. Tester");
			Method method = SafeReflection.getMethod(klass, "getPossibleMarks");
			assertTrue("Passed 100 into constructor and expected possibleMarks equal 100",
					100 == (int) method.invoke(homeworkAssignment));
			method = SafeReflection.getMethod(klass, "getSubmitterName");
			assertTrue("Passed 'T. Tester' into constructor and expected submitterName equal `T. Tester`",
					"T. Tester".equals((String) method.invoke(homeworkAssignment)));
		} catch (Exception e) {
			fail("Failed to instantiate HomeworkAssignment");
		}
	}

	@Test
	public void homeworkAssignmentLetterGradeTests() {
		Class klass = HomeworkAssignment.class;

		Constructor<HomeworkAssignment> constructor = SafeReflection.getConstructor(klass, Integer.TYPE, String.class);
		assertTrue("You do not have the required constructor(int, String)", constructor != null);
		try {
			final int POSSIBLE_MARKS = 200;
			HomeworkAssignment homeworkAssignment = constructor.newInstance(POSSIBLE_MARKS, "T. Tester");
			Method getLetterGrade = SafeReflection.getMethod(klass, "getLetterGrade");
			Method setEarnedMarks = SafeReflection.getMethod(klass, "setEarnedMarks", Integer.TYPE);

			int[] testsForGradeA = { 100, 91, 90 };
			int[] testsForGradeB = { 89, 81, 80 };
			int[] testsForGradeC = { 79, 71, 70 };
			int[] testsForGradeD = { 69, 61, 60 };
			int[] testsForGradeF = { 59, 50, 23, 1, 0 };

			Map<String, int[]> testSuite = new HashMap<>();
			testSuite.put("A", testsForGradeA);
			testSuite.put("B", testsForGradeB);
			testSuite.put("C", testsForGradeC);
			testSuite.put("D", testsForGradeD);
			testSuite.put("F", testsForGradeF);

			for (Map.Entry<String, int[]> test : testSuite.entrySet())
			{
				String letterGrade = test.getKey();
				int[] testsForGrade = test.getValue();
				for (int earnedMarks : testsForGrade)
				{
					setEarnedMarks.invoke(homeworkAssignment, earnedMarks * 2);
					assertTrue("Expected " + letterGrade + " for score of " + (earnedMarks * 2) + " out of " + POSSIBLE_MARKS + " (" + earnedMarks +"%)", letterGrade.equals(getLetterGrade.invoke(homeworkAssignment)));
				}
			}
		} catch (Exception e) {
			fail("Failed to instantiate HomeworkAssignment");
		}
	}
}
