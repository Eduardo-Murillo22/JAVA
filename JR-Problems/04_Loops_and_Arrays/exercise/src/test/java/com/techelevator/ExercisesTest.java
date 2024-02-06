package com.techelevator;

import com.techelevator.testing.TestingLibrary;
import org.junit.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	private final int SMALL_CHEESE = 10;
	private final int SMALL_PEPPERONI = 11;

	private final int MEDIUM_CHEESE = 20;
	private final int MEDIUM_PEPPERONI = 21;

	private final int LARGE_CHEESE = 30;
	private final int LARGE_PEPPERONI = 31;

	private final int CALZONE = 40;
	private final int SPAGHETTI_PIE = 41;
	private final int BAKED_ZITI = 42;

	private final static char SMALL_TSHIRT = 'S';
	private final static char MEDIUM_TSHIRT = 'M';
	private final static char LARGE_TSHIRT = 'L';

	@Test
	public void Exercise01_01_createOrder() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Array contains the correct item numbers in the expected order");
		happyPath.addTest(new TestingLibrary.Test(new Object[] {}, new int[] { SMALL_CHEESE, CALZONE, LARGE_PEPPERONI, SPAGHETTI_PIE }));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise01_StoreOrders.class, "createOrder", new Class[] {});

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise01_02_getCalzoneSales() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns the count of the item number for calzones");
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new int[]{CALZONE, SMALL_CHEESE, LARGE_CHEESE, CALZONE, SMALL_CHEESE}}, 2));
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new int[]{CALZONE, SMALL_CHEESE, SMALL_CHEESE}}, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, CALZONE, SMALL_CHEESE}}, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, SMALL_CHEESE, CALZONE}}, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new int[]{BAKED_ZITI, SMALL_CHEESE, CALZONE, SPAGHETTI_PIE}}, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new int[]{CALZONE, CALZONE, SMALL_CHEESE}}, 2));
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new int[]{CALZONE, CALZONE, CALZONE}}, 3));

		TestingLibrary.TestGroup zeroCalzone = new TestingLibrary.TestGroup("Returns 0 when calzones are not present");
		zeroCalzone.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, SMALL_PEPPERONI, SMALL_CHEESE}}, 0));
		zeroCalzone.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_PEPPERONI, BAKED_ZITI}}, 0));
		zeroCalzone.addTest(new TestingLibrary.Test(new Object[]{new int[]{}}, 0));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);
		testGroups.add(zeroCalzone);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise01_StoreOrders.class, "getCalzoneSales", int[].class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise01_03_getCheesePizzaRevenue() {
		TestingLibrary.TestGroup oneCheese = new TestingLibrary.TestGroup("Returns the correct amount for one cheese pizza");
		oneCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE}}, 8));
		oneCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{MEDIUM_CHEESE}}, 11));
		oneCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{LARGE_CHEESE}}, 14));

		TestingLibrary.TestGroup multiCheese = new TestingLibrary.TestGroup("Returns the correct amount for multiple cheese pizzas");
		multiCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, MEDIUM_CHEESE}}, 19));
		multiCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{MEDIUM_CHEESE, LARGE_CHEESE}}, 25));
		multiCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, MEDIUM_CHEESE, LARGE_CHEESE}}, 33));
		multiCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, SMALL_CHEESE}}, 16));
		multiCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{MEDIUM_CHEESE, MEDIUM_CHEESE}}, 22));
		multiCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{LARGE_CHEESE, LARGE_CHEESE}}, 28));

		TestingLibrary.TestGroup cheeseAndOthers = new TestingLibrary.TestGroup("Returns the correct amount for cheese pizzas with other items");
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, CALZONE}}, 8));
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{MEDIUM_CHEESE, BAKED_ZITI}}, 11));
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{LARGE_CHEESE, SPAGHETTI_PIE}}, 14));
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, SMALL_PEPPERONI}}, 8));
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{MEDIUM_CHEESE, MEDIUM_PEPPERONI}}, 11));
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{LARGE_CHEESE, LARGE_PEPPERONI}}, 14));
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, SMALL_PEPPERONI, MEDIUM_CHEESE}}, 19));
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_CHEESE, SMALL_PEPPERONI, MEDIUM_CHEESE, SMALL_PEPPERONI, LARGE_CHEESE}}, 33));
		cheeseAndOthers.addTest(new TestingLibrary.Test(new Object[]{new int[]{MEDIUM_CHEESE, SMALL_PEPPERONI, LARGE_CHEESE}}, 25));

		TestingLibrary.TestGroup noCheese = new TestingLibrary.TestGroup("Returns 0 when there are no cheese pizzas");
		noCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{SMALL_PEPPERONI, MEDIUM_PEPPERONI, LARGE_PEPPERONI}}, 0));
		noCheese.addTest(new TestingLibrary.Test(new Object[]{new int[]{BAKED_ZITI, SPAGHETTI_PIE, CALZONE}}, 0));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(oneCheese);
		testGroups.add(multiCheese);
		testGroups.add(cheeseAndOthers);
		testGroups.add(noCheese);

		// Create and run the test suite
		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise01_StoreOrders.class, "getCheesePizzaRevenue", int[].class);
		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise02_01_generateSeatingChart() {
		TestingLibrary.TestGroup allElementsTrue = new TestingLibrary.TestGroup("Returns an array of the correct values and length");
		allElementsTrue.addTest(new TestingLibrary.Test(new Object[]{1}, new boolean[]{true}));
		allElementsTrue.addTest(new TestingLibrary.Test(new Object[]{2}, new boolean[]{true, true}));
		allElementsTrue.addTest(new TestingLibrary.Test(new Object[]{3}, new boolean[]{true, true, true}));
		allElementsTrue.addTest(new TestingLibrary.Test(new Object[]{4}, new boolean[]{true, true, true, true}));
		allElementsTrue.addTest(new TestingLibrary.Test(new Object[]{5}, new boolean[]{true, true, true, true, true}));

		TestingLibrary.TestGroup zeroLength = new TestingLibrary.TestGroup("Returns an array of zero length for 0");
		zeroLength.addTest(new TestingLibrary.Test(new Object[]{0}, new boolean[0]));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(allElementsTrue);
		testGroups.add(zeroLength);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise02_BoardingGate.class, "generateSeatingChart", int.class);
		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise02_02_getAvailableSeatCount() {
		TestingLibrary.TestGroup available = new TestingLibrary.TestGroup("Returns the correct number of available seats");
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true}}, 1));
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, false, false, false}}, 1));
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, false, true, false}}, 2));
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, true, true, false}}, 2));
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, false, true, true}}, 2));
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, true, true, false}}, 3));
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, true, false, true}}, 3));
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, false, true, true}}, 3));
		available.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, true, true, true}}, 3));

		TestingLibrary.TestGroup notAvailable = new TestingLibrary.TestGroup("Returns 0 for no available seats");
		notAvailable.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false}}, 0));
		notAvailable.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, false, false}}, 0));
		notAvailable.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, false, false, false, false, false}}, 0));

		TestingLibrary.TestGroup noSeatsGiven = new TestingLibrary.TestGroup("Returns 0 for no seats given");
		noSeatsGiven.addTest(new TestingLibrary.Test(new Object[]{new boolean[0]}, 0));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(available);
		testGroups.add(notAvailable);
		testGroups.add(noSeatsGiven);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise02_BoardingGate.class, "getAvailableSeatCount", boolean[].class);
		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise02_03_getNumberOfFullRows() {
		TestingLibrary.TestGroup fullRows = new TestingLibrary.TestGroup("Returns the correct number of full rows");
		fullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, false, false}}, 1));
		fullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, false, false, false, false, false}}, 2));
		fullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, false, false, true, true, true}}, 1));
		fullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, true, true, false, false, false}}, 1));
		fullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, true, true, false, false, false}}, 1));

		TestingLibrary.TestGroup noFullRows = new TestingLibrary.TestGroup("Returns 0 for no full rows");
		noFullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, true, true}}, 0));
		noFullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, true, true, true, true, true}}, 0));
		noFullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, true, true, true, true, true, true, true, true}}, 0));
		noFullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{false, true, true, false, true, true}}, 0));
		noFullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, false, true, true, false, true}}, 0));
		noFullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, true, false, true, true, false}}, 0));
		noFullRows.addTest(new TestingLibrary.Test(new Object[]{new boolean[]{true, false, true, false, true, false}}, 0));

		TestingLibrary.TestGroup noRowsGiven = new TestingLibrary.TestGroup("Returns 0 for no rows given");
		noRowsGiven.addTest(new TestingLibrary.Test(new Object[]{new boolean[0]}, 0));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(fullRows);
		testGroups.add(noFullRows);
		testGroups.add(noRowsGiven);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise02_BoardingGate.class, "getNumberOfFullRows", boolean[].class);
		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise03_01_buildOrder() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Array contains the correct shirt sizes in the expected order");
		happyPath.addTest(new TestingLibrary.Test(new Object[0], new char[]{SMALL_TSHIRT, SMALL_TSHIRT, SMALL_TSHIRT, MEDIUM_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT}));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise03_Shirts.class, "buildOrder", new Class[0]);
		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise03_02_buildBulkOrder() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns the correct array of shirt sizes");
		happyPath.addTest(new TestingLibrary.Test(new Object[] { 1 }, new char[] { SMALL_TSHIRT }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { 2 }, new char[] { SMALL_TSHIRT, MEDIUM_TSHIRT }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { 3 }, new char[] { SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { 4 }, new char[] { SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT, SMALL_TSHIRT }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { 5 }, new char[] { SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT, SMALL_TSHIRT, MEDIUM_TSHIRT }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { 6 }, new char[] { SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT, SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT }));

		TestingLibrary.TestGroup zeroLength = new TestingLibrary.TestGroup("Returns an array of zero length for 0");
		zeroLength.addTest(new TestingLibrary.Test(new Object[] { 0 }, new char[] {}));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);
		testGroups.add(zeroLength);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise03_Shirts.class, "buildBulkOrder", int.class);
		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise03_03_placeRequest() {
		TestingLibrary.TestGroup smallIn = new TestingLibrary.TestGroup("Returns true if a small t-shirt is in the order");
		smallIn.addTest(new TestingLibrary.Test(new Object[] { new char[] { SMALL_TSHIRT } }, true));
		smallIn.addTest(new TestingLibrary.Test(new Object[] { new char[] { SMALL_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT } }, true));
		smallIn.addTest(new TestingLibrary.Test(new Object[] { new char[] { MEDIUM_TSHIRT, SMALL_TSHIRT, LARGE_TSHIRT } }, true));
		smallIn.addTest(new TestingLibrary.Test(new Object[] { new char[] { MEDIUM_TSHIRT, LARGE_TSHIRT, SMALL_TSHIRT } }, true));
		smallIn.addTest(new TestingLibrary.Test(new Object[] { new char[] { SMALL_TSHIRT, SMALL_TSHIRT } }, true));

		TestingLibrary.TestGroup noSmall = new TestingLibrary.TestGroup("Returns false if no small t-shirts are in the order");
		noSmall.addTest(new TestingLibrary.Test(new Object[] { new char[] { } }, false));
		noSmall.addTest(new TestingLibrary.Test(new Object[] { new char[] { MEDIUM_TSHIRT } }, false));
		noSmall.addTest(new TestingLibrary.Test(new Object[] { new char[] { LARGE_TSHIRT } }, false));
		noSmall.addTest(new TestingLibrary.Test(new Object[] { new char[] { MEDIUM_TSHIRT, LARGE_TSHIRT } }, false));
		noSmall.addTest(new TestingLibrary.Test(new Object[] { new char[] { MEDIUM_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT } }, false));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(smallIn);
		testGroups.add(noSmall);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise03_Shirts.class, "placeRequest", char[].class);
		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void Exercise04_01_getFirstCard() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns the first card of the hand");

		happyPath.addTest(new TestingLibrary.Test(new Object[]{new String[]{"3-H", "7-H", "5-H", "8-H", "6-H"}}, "3-H"));
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new String[]{"1-C", "1-D", "1-H", "1-S", "2-C"}}, "1-C"));
		happyPath.addTest(new TestingLibrary.Test(new Object[]{new String[]{"K-C", "Q-D", "J-H", "10-S", "Q-C"}}, "K-C"));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);

		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercise04_Cards.class, "getFirstCard", String[].class);

		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void Exercise04_02_discardFirstCard() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns the array without the first card");
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "3-H", "7-H", "5-H", "8-H", "6-H" } },
				new String[] { "7-H", "5-H", "8-H", "6-H" }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "1-C", "1-D", "1-H", "1-S", "2-C" } },
				new String[] { "1-D", "1-H", "1-S", "2-C" }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "K-C", "Q-D", "J-H", "10-S", "Q-C" } },
				new String[] { "Q-D", "J-H", "10-S", "Q-C" }));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);

		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercise04_Cards.class, "discardFirstCard", String[].class);

		TestingLibrary.runTestSuite(test);

	}

	@Test
	public void Exercise04_03_discardTopCard() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns the deck without the first card");
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "8-C", "10-H", "J-C", "8-D", "6-S", "Q-C", "2-D" } },
				new String[] { "10-H", "J-C", "8-D", "6-S", "Q-C", "2-D" }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "2-C", "A-S", "K-S", "Q-S", "J-S", "10-S" } },
				new String[] { "A-S", "K-S", "Q-S", "J-S", "10-S" }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new String[] { "4-D", "6-S", "K-D" } },
				new String[] { "6-S", "K-D" }));

		TestingLibrary.TestGroup emptyDeck = new TestingLibrary.TestGroup("Returns an empty deck when no cards left");
		emptyDeck.addTest(new TestingLibrary.Test(new Object[] { new String[] { "9-H" } }, new String[] {}));
		emptyDeck.addTest(new TestingLibrary.Test(new Object[] { new String[] {} }, new String[] {}));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);
		testGroups.add(emptyDeck);

		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercise04_Cards.class, "discardTopCard", String[].class);

		TestingLibrary.runTestSuite(test);

	}

	@Test
	public void Exercise05_01_belowFreezing() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns the number of days where temperature is 32 or less");
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 32, 31, 30, 29, 30, 31, 32 } }, 7));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 33, 30, 37, 32, 38, 31, 36 } }, 3));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { -7, -3, 19, 35, 30 } }, 4));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 33, -7, 31, -3, 34, 32 } }, 4));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 33, -11 } }, 1));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 32, 33 } }, 1));

		TestingLibrary.TestGroup zeroOrEmpty = new TestingLibrary.TestGroup("Returns 0 for no freezing days or no days given");
		zeroOrEmpty.addTest(new TestingLibrary.Test(new Object[] { new int[] { 33, 43, 55, 37, 44, 52, 34 } }, 0));
		zeroOrEmpty.addTest(new TestingLibrary.Test(new Object[] { new int[] {} }, 0));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);
		testGroups.add(zeroOrEmpty);

		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercise05_Weather.class, "belowFreezing", int[].class);

		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void Exercise05_02_hottestDay() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns the temperature of the hottest day");
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 81, 93, 94, 105, 99, 95, 101, 90, 89, 92 } }, 105));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 23, 24 } }, 24));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 34, 33 } }, 34));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 55 } }, 55));

		TestingLibrary.TestGroup atOrBelowZero = new TestingLibrary.TestGroup("Returns the correct value when values are all at zero or less");
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { -9, -12, 0, -2, -7 } }, 0));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 0 } }, 0));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { -7, -2, -11, -9, -4 } }, -2));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { -22 } }, -22));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);
		testGroups.add(atOrBelowZero);

		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercise05_Weather.class, "hottestDay", int[].class);

		TestingLibrary.runTestSuite(test);
	}

	@Test
	public void Exercise05_03_fixTemperatures() {
		TestingLibrary.TestGroup happyPath = new TestingLibrary.TestGroup("Returns an array of the corrected temperatures");
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { 33, 30, 32, 37, 44, 31, 41 } }, new int[] { 35, 30, 34, 37, 46, 31, 43 }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { -7, -33, 19, 35 } }, new int[] { -5, -33, 21, 35 }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { -1, 0, 1 } }, new int[] { 1, 0, 3 }));
		happyPath.addTest(new TestingLibrary.Test(new Object[] { new int[] { -1 } }, new int[] { 1 }));

		TestingLibrary.TestGroup emptyArray = new TestingLibrary.TestGroup("Returns an empty array when there are no temperatures given");
		emptyArray.addTest(new TestingLibrary.Test(new Object[] { new int[] {} }, new int[] {}));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(happyPath);
		testGroups.add(emptyArray);

		TestingLibrary.TestSuite test = new TestingLibrary.TestSuite(testGroups, Exercise05_Weather.class, "fixTemperatures", int[].class);

		TestingLibrary.runTestSuite(test);
	}
}
