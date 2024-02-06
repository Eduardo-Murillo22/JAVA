package com.techelevator;

import com.techelevator.testing.TestingLibrary;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	@Test
	public void exercise01_helloName() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct hello message");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Bob" }, "Hello Bob!"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Alice" }, "Hello Alice!"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "" }, "Hello !"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello" }, "Hello Hello!"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xyz" }, "Hello xyz!"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "helloName", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise02_makeAbba() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct ABBA (first, second, second, first) message");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hi", "Bye" }, "HiByeByeHi"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Yo", "Alice" }, "YoAliceAliceYo"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "What", "Up" }, "WhatUpUpWhat"));

		TestingLibrary.TestGroup emptyStrings = new TestingLibrary.TestGroup("Handles empty string inputs correctly");
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "A", "" }, "AA"));
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "", "B" }, "BB"));
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "", "" }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, emptyStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "makeAbba", String.class, String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise03_makeTags() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct tag and contents");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "i", "Yay" }, "<i>Yay</i>"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "i", "Hello" }, "<i>Hello</i>"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "cite", "Yay" }, "<cite>Yay</cite>"));

		TestingLibrary.TestGroup emptyStrings = new TestingLibrary.TestGroup("Correctly handles empty string inputs");
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "i", "" }, "<i></i>"));
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "", "B" }, "<>B</>"));
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "", "" }, "<></>"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, emptyStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "makeTags", String.class, String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise04_makeOutWord() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "<<>>", "Yay" }, "<<Yay>>"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "<<>>", "WooHoo" }, "<<WooHoo>>"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "[[]]", "word" }, "[[word]]"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "ABYZ", "word" }, "ABwordYZ"));

		TestingLibrary.TestGroup emptyStrings = new TestingLibrary.TestGroup("Correctly handles empty string inputs");
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "ABCD", "" }, "ABCD"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, emptyStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "makeOutWord", String.class, String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise05_extraEnd() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello" }, "lololo"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "ab" }, "ababab"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hi" }, "HiHiHi"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "  " }, "      "));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "extraEnd", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise06_firstTwo() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string for inputs two or more characters long");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello" }, "He"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "abcdefg" }, "ab"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "ab" }, "ab"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "    " }, "  "));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Generates correct string for inputs less than two characters");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "" }, ""));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "a" }, "a"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "firstTwo", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise07_firstHalf() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "WooHoo" }, "Woo"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "HelloThere" }, "Hello"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "abcdef" }, "abc"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "ab" }, "a"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "firstHalf", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise08_withoutEnd() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello" }, "ell"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "java" }, "av"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "coding" }, "odin"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "ab" }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "withoutEnd", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise09_comboString() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello", "hi" }, "hiHellohi"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "hi", "Hello" }, "hiHellohi"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "aaa", "b" }, "baaab"));

		TestingLibrary.TestGroup emptyStrings = new TestingLibrary.TestGroup("Generates correct string with empty inputs");

		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "", "hi" }, "hi"));
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "hi", "" }, "hi"));
		emptyStrings.addTest(new TestingLibrary.Test(new Object[] { "", "a" }, "a"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, emptyStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "comboString", String.class, String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise10_nonStart() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello", "There" }, "ellohere"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "java", "code" }, "avaode"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "shotl", "java" }, "hotlava"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Generates correct string using inputs with length of 1");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "a", "bc" }, "c"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "bc", "a" }, "c"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "a", "a" }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "nonStart", String.class, String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise11_left2() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello"}, "lloHe"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "java" }, "vaja"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "12345678" }, "34567812"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Generates correct string using inputs with length of 2");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "ab" }, "ab"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "XY" }, "XY"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "left2", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise12_right2() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello"}, "loHel"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "java" }, "vaja"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "12345678" }, "78123456"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Generates correct string using inputs with length of 2");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "ab" }, "ab"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "XY" }, "XY"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "right2", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise13_theEnd() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello", true}, "H"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello", false }, "o"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "12345678", true }, "1"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "12345678", false }, "8"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Generates correct string using inputs with length of 1");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "X", true }, "X"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "X", false }, "X"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "theEnd", String.class, boolean.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise14_withoutEnd2() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string for inputs 3 characters or longer");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello" }, "ell"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "abc" }, "b"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "12345678" }, "234567"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Generates correct string for short inputs");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "XY" }, ""));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "X" }, ""));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "" }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "withoutEnd2", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise15_middleTwo() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Generates correct string for inputs 4 characters or longer");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "string" }, "ri"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "code" }, "od"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "12345678" }, "45"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Generates correct string for short inputs");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "XY" }, "XY"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "ab" }, "ab"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "middleTwo", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise16_endsLy() {
		TestingLibrary.TestGroup lyStrings = new TestingLibrary.TestGroup("Returns true for strings that end in \"ly\"");

		lyStrings.addTest(new TestingLibrary.Test(new Object[] { "oddly" }, true));
		lyStrings.addTest(new TestingLibrary.Test(new Object[] { "barely" }, true));
		lyStrings.addTest(new TestingLibrary.Test(new Object[] { "ly" }, true));

		TestingLibrary.TestGroup nonLyStrings = new TestingLibrary.TestGroup("Returns false for strings that don't end in \"ly\"");

		nonLyStrings.addTest(new TestingLibrary.Test(new Object[] { "oddl" }, false));
		nonLyStrings.addTest(new TestingLibrary.Test(new Object[] { "bare" }, false));
		nonLyStrings.addTest(new TestingLibrary.Test(new Object[] { "X" }, false));
		nonLyStrings.addTest(new TestingLibrary.Test(new Object[] { "" }, false));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(lyStrings, nonLyStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "endsLy", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise17_nTwice() {
		TestingLibrary.TestGroup nonOverlapping = new TestingLibrary.TestGroup("Returns correct string for non-overlapping substrings");

		nonOverlapping.addTest(new TestingLibrary.Test(new Object[] { "Hello", 2 }, "Helo"));
		nonOverlapping.addTest(new TestingLibrary.Test(new Object[] { "Chocolate", 3 }, "Choate"));
		nonOverlapping.addTest(new TestingLibrary.Test(new Object[] { "Chocolate", 1 }, "Ce"));
		nonOverlapping.addTest(new TestingLibrary.Test(new Object[] { "Code", 2 }, "Code"));

		TestingLibrary.TestGroup overlapping = new TestingLibrary.TestGroup("Returns correct string for overlapping and zero length substrings");

		overlapping.addTest(new TestingLibrary.Test(new Object[] { "Hello", 4 }, "Hellello"));
		overlapping.addTest(new TestingLibrary.Test(new Object[] { "Code", 4 }, "CodeCode"));
		overlapping.addTest(new TestingLibrary.Test(new Object[] { "Anything", 0 }, ""));
		overlapping.addTest(new TestingLibrary.Test(new Object[] { "", 0 }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(nonOverlapping, overlapping);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "nTwice", String.class, int.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise18_twoChar() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string for n in range");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "java", 0 }, "ja"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "java", 2 }, "va"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "ab", 0 }, "ab"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "1234567890", 8 }, "90"));

		TestingLibrary.TestGroup outOfRange = new TestingLibrary.TestGroup("Returns first two characters for n not in range");

		outOfRange.addTest(new TestingLibrary.Test(new Object[] { "Hello", 5 }, "He"));
		outOfRange.addTest(new TestingLibrary.Test(new Object[] { "AB", 1 }, "AB"));
		outOfRange.addTest(new TestingLibrary.Test(new Object[] { "ABCDE", -1 }, "AB"));
		outOfRange.addTest(new TestingLibrary.Test(new Object[] { "ABCDE", 6 }, "AB"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, outOfRange);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "twoChar", String.class, int.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise19_middleThree() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Extracts correct substring");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Candy" }, "and"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "abc" }, "abc"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "123456789" }, "456"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "abc   123" }, "   "));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "middleThree", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise20_hasBad() {
		TestingLibrary.TestGroup hasBad = new TestingLibrary.TestGroup("Returns true when bad appears at index 0 or 1");

		hasBad.addTest(new TestingLibrary.Test(new Object[] { "badxx" }, true));
		hasBad.addTest(new TestingLibrary.Test(new Object[] { "xbadxx" }, true));
		hasBad.addTest(new TestingLibrary.Test(new Object[] { "bad" }, true));
		hasBad.addTest(new TestingLibrary.Test(new Object[] { "xbad" }, true));

		TestingLibrary.TestGroup doesntHaveBad = new TestingLibrary.TestGroup("Returns false when bad doesn't appear at index 0 or 1");

		doesntHaveBad.addTest(new TestingLibrary.Test(new Object[] { "Hello" }, false));
		doesntHaveBad.addTest(new TestingLibrary.Test(new Object[] { "baxd" }, false));
		doesntHaveBad.addTest(new TestingLibrary.Test(new Object[] { "ba" }, false));
		doesntHaveBad.addTest(new TestingLibrary.Test(new Object[] { "b" }, false));
		doesntHaveBad.addTest(new TestingLibrary.Test(new Object[] { "" }, false));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(hasBad, doesntHaveBad);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "hasBad", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise21_stringTimes() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string for non-empty strings and positive n's");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hi", 2 }, "HiHi"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hi", 3 }, "HiHiHi"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hi", 1 }, "Hi"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "X", 10 }, "XXXXXXXXXX"));

		TestingLibrary.TestGroup doesntHaveBad = new TestingLibrary.TestGroup("Returns correct string for empty strings and zero n's");

		doesntHaveBad.addTest(new TestingLibrary.Test(new Object[] { "Hello", 0 }, ""));
		doesntHaveBad.addTest(new TestingLibrary.Test(new Object[] { "", 0 }, ""));
		doesntHaveBad.addTest(new TestingLibrary.Test(new Object[] { "", 100 }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, doesntHaveBad);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "stringTimes", String.class, int.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise22_frontTimes() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string for long inputs and positive n's");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Chocolate", 1 }, "Cho"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Chocolate", 2 }, "ChoCho"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "1234", 3 }, "123123123"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Returns correct string for short inputs and zero n's");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "Ab", 2 }, "AbAb"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "A", 2 }, "AA"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "", 100 }, ""));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "Abcd", 0 }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "frontTimes", String.class, int.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise23_countXX() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct count of xx's");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xx" }, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxx" }, 2));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxaxx" }, 2));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "aaaxx" }, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxxxxxxx"}, 7));

		TestingLibrary.TestGroup noXxs = new TestingLibrary.TestGroup("Returns zero when no xx's");

		noXxs.addTest(new TestingLibrary.Test(new Object[] { "xXxXxX" }, 0));
		noXxs.addTest(new TestingLibrary.Test(new Object[] { "x" }, 0));
		noXxs.addTest(new TestingLibrary.Test(new Object[] { "" }, 0));
		noXxs.addTest(new TestingLibrary.Test(new Object[] { "12345" }, 0));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, noXxs);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "countXX", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise24_doubleX() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns true when first x followed by another x");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xx" }, true));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxx" }, true));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxax" }, true));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "aaaxx" }, true));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxxxxxxx"}, true));

		TestingLibrary.TestGroup noXxs = new TestingLibrary.TestGroup("Returns false when no x's or first x not followed by an x");

		noXxs.addTest(new TestingLibrary.Test(new Object[] { "xXxxXxxX" }, false));
		noXxs.addTest(new TestingLibrary.Test(new Object[] { "x" }, false));
		noXxs.addTest(new TestingLibrary.Test(new Object[] { "" }, false));
		noXxs.addTest(new TestingLibrary.Test(new Object[] { "12345" }, false));
		noXxs.addTest(new TestingLibrary.Test(new Object[] { "12345x" }, false));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, noXxs);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "doubleX", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise25_stringBits() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string from long string inputs");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hello" }, "Hlo"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Hi" }, "H"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Heeololeo" }, "Hello"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "123456" }, "135"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Returns correct string from short string inputs");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "H" }, "H"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "" }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "stringBits", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise26_stringSplosion() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Code" }, "CCoCodCode"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "abc" }, "aababc"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "a" }, "a"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "x" }, "x"));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "stringSplosion", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise27_last2() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string from long string inputs");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "hixxhi" }, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xaxxaxaxx" }, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "axxxaaxx" }, 2));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxxx" }, 2));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "13121311" }, 0));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "1717171" }, 2));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Returns correct string from short string inputs");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "xx" }, 0));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "x" }, 0));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "" }, 0));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "last2", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise28_stringX() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string from long string inputs");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxHxix" }, "xHix"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "abxxxcd" }, "abcd"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xabxxxcdx" }, "xabcdx"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxxx" }, "xx"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "abcd" }, "abcd"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Returns correct string from short string inputs");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "xx" }, "xx"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "x" }, "x"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "ab" }, "ab"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "a" }, "a"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "" }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "stringX", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise29_altPairs() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string from string inputs four and longer");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "kitten" }, "kien"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "Chocolate" }, "Chole"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "CodingHorror" }, "Congrr"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "1234" }, "12"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "1234567" }, "1256"));

		TestingLibrary.TestGroup shortStrings = new TestingLibrary.TestGroup("Returns correct string from string inputs less than four");

		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "abc" }, "ab"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "ab" }, "ab"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "a" }, "a"));
		shortStrings.addTest(new TestingLibrary.Test(new Object[] { "" }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortStrings);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "altPairs", String.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise30_stringYak() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct string from string inputs with one or more yaks");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { "yakpak" }, "pak"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "pakyak" }, "pak"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "yak123ya" }, "123ya"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "xxyakzz" }, "xxzz"));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "yakyakyakyakyak" }, ""));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { "1234yak5678yak90" }, "1234567890"));

		TestingLibrary.TestGroup noYaks = new TestingLibrary.TestGroup("Returns correct string from string inputs with no yaks");

		noYaks.addTest(new TestingLibrary.Test(new Object[] { "12345678" }, "12345678"));
		noYaks.addTest(new TestingLibrary.Test(new Object[] { "12" }, "12"));
		noYaks.addTest(new TestingLibrary.Test(new Object[] { "1" }, "1"));
		noYaks.addTest(new TestingLibrary.Test(new Object[] { "" }, ""));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, noYaks);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "stringYak", String.class);
		TestingLibrary.runTestSuite(test);
	}

}
