package com.techelevator;

import com.techelevator.testing.TestingLibrary;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	@Test
	public void exercise01_array2List() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Correctly converts an array to a List");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "Apple", "Orange", "Banana" }}, Arrays.asList("Apple", "Orange", "Banana")));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "Red", "Orange", "Yellow" }}, Arrays.asList("Red", "Orange", "Yellow")));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "Left", "Right", "Forward", "Back" }}, Arrays.asList("Left", "Right", "Forward", "Back")));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "One" }}, Arrays.asList("One")));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "array2List", String[].class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise02_list2Array() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Correctly converts a List to an array");

		happyPath.addTest(new TestingLibrary.Test(new Object[] {Arrays.asList("Apple", "Orange", "Banana") }, new String[] { "Apple", "Orange", "Banana" }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {Arrays.asList("Red", "Orange", "Yellow") }, new String[] { "Red", "Orange", "Yellow" }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {Arrays.asList("Left", "Right", "Forward", "Back") }, new String[] { "Left", "Right", "Forward", "Back" }));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "list2Array", List.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise03_no4LetterWords() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns List with 4 letter words removed");

		happyPath.addTest(new TestingLibrary.Test(new Object[] {new String[] {"Train", "Boat", "Car"} }, Arrays.asList("Train", "Car")));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {new String[] {"Red", "White", "Blue"} }, Arrays.asList("Red", "White")));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {new String[] {"Jack", "Jill", "Jane", "John", "Jim"} }, Arrays.asList("Jim")));

		TestingLibrary.TestGroup no4LetterWords = new TestingLibrary.TestGroup("Handles arrays with no 4 letter words");

		no4LetterWords.addTest(new TestingLibrary.Test(new Object[] {new String[] {"January", "February", "March"} }, Arrays.asList("January", "February", "March")));
		no4LetterWords.addTest(new TestingLibrary.Test(new Object[] {new String[] {"April"} }, Arrays.asList("April")));

		TestingLibrary.TestGroup all4LetterWords = new TestingLibrary.TestGroup("Handles arrays with all 4 letter words");

		all4LetterWords.addTest(new TestingLibrary.Test(new Object[] {new String[] {"Left", "Down"} }, new ArrayList<String>()));
		all4LetterWords.addTest(new TestingLibrary.Test(new Object[] {new String[] {"Mars"} }, new ArrayList<String>()));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, no4LetterWords, all4LetterWords);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "no4LetterWords", String[].class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise04_arrayInt2ListDouble() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Correctly converts an int array to a List of Doubles");

		happyPath.addTest(new TestingLibrary.Test(new Object[] {new int[] { 2, 4, 6, 8 } }, Arrays.asList(1.0, 2.0, 3.0, 4.0)));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {new int[] { 1, 3, 5, 7 } }, Arrays.asList(0.5, 1.5, 2.5, 3.5)));

		TestingLibrary.TestGroup zeroAndNegativeNums = new TestingLibrary.TestGroup("Handles zeroes and negative numbers");

		zeroAndNegativeNums.addTest(new TestingLibrary.Test(new Object[] {new int[] {-2, 0, 2 } }, Arrays.asList(-1.0, 0.0, 1.0)));
		zeroAndNegativeNums.addTest(new TestingLibrary.Test(new Object[] {new int[] { -11 } }, Arrays.asList(-5.5)));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, zeroAndNegativeNums);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "arrayInt2ListDouble", int[].class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise05_findLargest() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Correctly finds largest number");

		happyPath.addTest(new TestingLibrary.Test(new Object[] {Arrays.asList(11, 200, 43, 84, 9917, 4321, 1, 33333, 8997) }, 33333));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {Arrays.asList(3, 2, 1) }, 3));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {Arrays.asList(1, 2, 3) }, 3));

		TestingLibrary.TestGroup allNegativeNums = new TestingLibrary.TestGroup("Correctly finds largest number when all values are negative");

		allNegativeNums.addTest(new TestingLibrary.Test(new Object[] {Arrays.asList(-2, -6, -3) }, -2));
		allNegativeNums.addTest(new TestingLibrary.Test(new Object[] {Arrays.asList(-1) }, -1));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, allNegativeNums);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "findLargest", List.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise06_oddOnly() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns correct List with even numbers removed");

		happyPath.addTest(new TestingLibrary.Test(new Object[] {new Integer[] { 112, 201, 774, 92, 9, 83, 41872 } }, Arrays.asList(201, 9, 83)));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {new Integer[] { 1143, 555, 7, 1772, 9953, 643 } }, Arrays.asList(1143, 555, 7, 9953, 643)));
		happyPath.addTest(new TestingLibrary.Test(new Object[] {new Integer[] { 734, 233, 782, 811, 3, 9999 } }, Arrays.asList(233, 811, 3, 9999)));

		TestingLibrary.TestGroup allOddNums = new TestingLibrary.TestGroup("Correctly handles input of all odd numbers");

		allOddNums.addTest(new TestingLibrary.Test(new Object[] {new Integer[] { 1, 3, 5 } }, Arrays.asList(1, 3, 5)));
		allOddNums.addTest(new TestingLibrary.Test(new Object[] {new Integer[] { -1, 1 } }, Arrays.asList(-1, 1)));

		TestingLibrary.TestGroup allEvenNums = new TestingLibrary.TestGroup("Correctly handles input of all even numbers");

		allEvenNums.addTest(new TestingLibrary.Test(new Object[] {new Integer[] { 2, 4, 6 } }, new ArrayList<Integer>()));
		allEvenNums.addTest(new TestingLibrary.Test(new Object[] {new Integer[] { -2, 2 } }, new ArrayList<Integer>()));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, allOddNums);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "oddOnly", Integer[].class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise07_foundIntTwice() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Correctly determines if number occurs twice or more");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(55, 17, 3, 6, 12), 4 }, false));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(5, 7, 9, 5, 11), 5 }, true));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(6, 8, 10, 11, 13), 8 }, false));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(9, 9, 44, 2, 88, 9), 9 }, true));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(1), 1 }, false));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "foundIntTwice", List.class, int.class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise08_fizzBuzzList() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Correctly fizzes and buzzes the array");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { new Integer[] { 1, 2, 3 } }, Arrays.asList("1", "2", "Fizz")));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new Integer[] { 4, 5, 6 } }, Arrays.asList("4", "Buzz", "Fizz")));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new Integer[] { 7, 8, 9, 10, 11, 12, 13, 14, 15 } }, Arrays.asList("7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz")));

		TestingLibrary.TestGroup shortArrays = new TestingLibrary.TestGroup("Correctly handles short arrays");

		shortArrays.addTest(new TestingLibrary.Test(new Object[] { new Integer[] { 1 } }, Arrays.asList("1")));
		shortArrays.addTest(new TestingLibrary.Test(new Object[] { new Integer[] { 3 } }, Arrays.asList("Fizz")));
		shortArrays.addTest(new TestingLibrary.Test(new Object[] { new Integer[] { 5 } }, Arrays.asList("Buzz")));
		shortArrays.addTest(new TestingLibrary.Test(new Object[] { new Integer[] { 15 } }, Arrays.asList("FizzBuzz")));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, shortArrays);
		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "fizzBuzzList", Integer[].class);
		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void exercise09_interleaveLists() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Correctly interleaves same length Lists");

		happyPath.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6) }, Arrays.asList(1, 4, 2, 5, 3, 6)));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(1), Arrays.asList(2) }, Arrays.asList(1, 2)));

		TestingLibrary.TestGroup firstLonger = new TestingLibrary.TestGroup("Correctly interleaves Lists when first is longer");

		firstLonger.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(1, 2, 3, 99), Arrays.asList(4, 5, 6) }, Arrays.asList(1, 4, 2, 5, 3, 6, 99)));
		firstLonger.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(1, 2, 3, 99, 100), Arrays.asList(4, 5, 6) }, Arrays.asList(1, 4, 2, 5, 3, 6, 99, 100)));

		TestingLibrary.TestGroup secondLonger = new TestingLibrary.TestGroup("Correctly interleaves Lists when second is longer");

		secondLonger.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6, 99) }, Arrays.asList(1, 4, 2, 5, 3, 6, 99)));
		secondLonger.addTest(new TestingLibrary.Test(new Object[] { Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6, 99, 100) }, Arrays.asList(1, 4, 2, 5, 3, 6, 99, 100)));

		List<TestingLibrary.TestGroup> testGroups = Arrays.asList(happyPath, firstLonger, secondLonger);

		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercises.class, "interleaveLists", List.class, List.class);

		TestingLibrary.runTestSuite(test);
	}
}
