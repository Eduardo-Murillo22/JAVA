package com.techelevator;

import com.techelevator.testing.TestingLibrary;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	@Test
	public void exercise00_01_isRainExpected() {
		// precipitationExpected, highTemperatureF GT 32
		TestingLibrary.TestGroup rainExpected = new TestingLibrary.TestGroup("Returns true when precipitation is expected and the high is greater than 32");
		rainExpected.addTest(new TestingLibrary.Test(new Object[]{true, 90}, true));
		rainExpected.addTest(new TestingLibrary.Test(new Object[]{true, 33}, true));

		// precipitationExpected, highTemperatureF LTE 32
		TestingLibrary.TestGroup rainNotExpected = new TestingLibrary.TestGroup("Returns false when precipitation is expected and the high is 32 or less");
		rainNotExpected.addTest(new TestingLibrary.Test(new Object[]{true, 32}, false));
		rainNotExpected.addTest(new TestingLibrary.Test(new Object[]{true, 0}, false));

		// precipitationExpected false, highTemperatureF irrelevant
		TestingLibrary.TestGroup noPrecipitationExpected = new TestingLibrary.TestGroup("Returns false when precipitation isn't expected");
		noPrecipitationExpected.addTest(new TestingLibrary.Test(new Object[]{false, 90}, false));
		noPrecipitationExpected.addTest(new TestingLibrary.Test(new Object[]{false, 32}, false));
		noPrecipitationExpected.addTest(new TestingLibrary.Test(new Object[]{false, 0}, false));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(rainExpected);
		testGroups.add(rainNotExpected);
		testGroups.add(noPrecipitationExpected);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise00_GettingStarted.class, "isRainExpected", boolean.class, int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise01_01_gradeTestPassFail() {
		// score GTE 70
		TestingLibrary.TestGroup testPass = new TestingLibrary.TestGroup("Returns true when score is 70 or greater");
		testPass.addTest(new TestingLibrary.Test(new Object[]{105}, true));
		testPass.addTest(new TestingLibrary.Test(new Object[]{100}, true));
		testPass.addTest(new TestingLibrary.Test(new Object[]{70}, true));

		// score LT 70
		TestingLibrary.TestGroup testFail = new TestingLibrary.TestGroup("Returns false when score is less than 70");
		testFail.addTest(new TestingLibrary.Test(new Object[]{69}, false));
		testFail.addTest(new TestingLibrary.Test(new Object[]{0}, false));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(testPass);
		testGroups.add(testFail);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise01_TestGrading.class, "gradeTestPassFail", int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise01_02_gradeTestNumeric() {
		// score GTE 90
		TestingLibrary.TestGroup testGrade3 = new TestingLibrary.TestGroup("Returns 3 when score is 90 or greater");
		testGrade3.addTest(new TestingLibrary.Test(new Object[]{105}, 3));
		testGrade3.addTest(new TestingLibrary.Test(new Object[]{100}, 3));
		testGrade3.addTest(new TestingLibrary.Test(new Object[]{95}, 3));
		testGrade3.addTest(new TestingLibrary.Test(new Object[]{90}, 3));

		// score GTE 50 and LTE 89
		TestingLibrary.TestGroup testGrade2 = new TestingLibrary.TestGroup("Returns 2 when score is between 50 and 89");
		testGrade2.addTest(new TestingLibrary.Test(new Object[]{89}, 2));
		testGrade2.addTest(new TestingLibrary.Test(new Object[]{70}, 2));
		testGrade2.addTest(new TestingLibrary.Test(new Object[]{50}, 2));

		// score GTE 25 and LTE 49
		TestingLibrary.TestGroup testGrade1 = new TestingLibrary.TestGroup("Returns 1 when score is between 25 and 49");
		testGrade1.addTest(new TestingLibrary.Test(new Object[]{49}, 1));
		testGrade1.addTest(new TestingLibrary.Test(new Object[]{25}, 1));

		// score LT 25
		TestingLibrary.TestGroup testGrade0 = new TestingLibrary.TestGroup("Returns 0 when score is less than 25");
		testGrade0.addTest(new TestingLibrary.Test(new Object[]{24}, 0));
		testGrade0.addTest(new TestingLibrary.Test(new Object[]{0}, 0));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(testGrade3);
		testGroups.add(testGrade2);
		testGroups.add(testGrade1);
		testGroups.add(testGrade0);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise01_TestGrading.class, "gradeTestNumeric", int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise01_03_gradeTestLetter() {
		// score GTE 90
		TestingLibrary.TestGroup testGradeA = new TestingLibrary.TestGroup("Returns 'A' when score is 90 or greater");
		testGradeA.addTest(new TestingLibrary.Test(new Object[]{105}, 'A'));
		testGradeA.addTest(new TestingLibrary.Test(new Object[]{91}, 'A'));
		testGradeA.addTest(new TestingLibrary.Test(new Object[]{90}, 'A'));

		// score GTE 80 and LTE 89
		TestingLibrary.TestGroup testGradeB = new TestingLibrary.TestGroup("Returns 'B' when score is between 80 and 89");
		testGradeB.addTest(new TestingLibrary.Test(new Object[]{89}, 'B'));
		testGradeB.addTest(new TestingLibrary.Test(new Object[]{88}, 'B'));
		testGradeB.addTest(new TestingLibrary.Test(new Object[]{81}, 'B'));
		testGradeB.addTest(new TestingLibrary.Test(new Object[]{80}, 'B'));

		// score GTE 70 and LTE 79
		TestingLibrary.TestGroup testGradeC = new TestingLibrary.TestGroup("Returns 'C' when score is between 70 and 79");
		testGradeC.addTest(new TestingLibrary.Test(new Object[]{79}, 'C'));
		testGradeC.addTest(new TestingLibrary.Test(new Object[]{78}, 'C'));
		testGradeC.addTest(new TestingLibrary.Test(new Object[]{71}, 'C'));
		testGradeC.addTest(new TestingLibrary.Test(new Object[]{70}, 'C'));

		// score GTE 60 and LTE 69
		TestingLibrary.TestGroup testGradeD = new TestingLibrary.TestGroup("Returns 'D' when score is between 60 and 69");
		testGradeD.addTest(new TestingLibrary.Test(new Object[]{69}, 'D'));
		testGradeD.addTest(new TestingLibrary.Test(new Object[]{68}, 'D'));
		testGradeD.addTest(new TestingLibrary.Test(new Object[]{61}, 'D'));
		testGradeD.addTest(new TestingLibrary.Test(new Object[]{60}, 'D'));

		// score LT 60
		TestingLibrary.TestGroup testGradeF = new TestingLibrary.TestGroup("Returns 'F' when score is less than 60");
		testGradeF.addTest(new TestingLibrary.Test(new Object[]{59}, 'F'));
		testGradeF.addTest(new TestingLibrary.Test(new Object[]{0}, 'F'));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(testGradeA);
		testGroups.add(testGradeB);
		testGroups.add(testGradeC);
		testGroups.add(testGradeD);
		testGroups.add(testGradeF);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise01_TestGrading.class, "gradeTestLetter", int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise02_01_canDrive() {
		// hasPermit is true, withLicensedPassenger is true
		TestingLibrary.TestGroup canDrive = new TestingLibrary.TestGroup("Returns true when driver has permit and licensed passenger");
		canDrive.addTest(new TestingLibrary.Test(new Object[]{true, true}, true));

		// either hasPermit is true or withLicensedPassenger is true, but not both are true
		TestingLibrary.TestGroup cannotDriveNoPermitOrLicensedPassenger = new TestingLibrary.TestGroup("Returns false when driver has no permit or licensed passenger");
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false}, false));		// has permit, but no licensed passenger
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true}, false));		// has licensed passenger, but no permit
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, false}, false));	// has neither permit nor licensed passenger (tested for completeness-sake)

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(canDrive);
		testGroups.add(cannotDriveNoPermitOrLicensedPassenger);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise02_CanDrive.class, "canDrive", boolean.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise02_02_canDriveAgeLimit() {
		// hasPermit is true, withLicensedPassenger is true, passengerAge GTE 21
		TestingLibrary.TestGroup canDrive = new TestingLibrary.TestGroup("Returns true when driver has permit and licensed passenger 21 or over");
		canDrive.addTest(new TestingLibrary.Test(new Object[]{true, true, 80}, true));
		canDrive.addTest(new TestingLibrary.Test(new Object[]{true, true, 22}, true));
		canDrive.addTest(new TestingLibrary.Test(new Object[]{true, true, 21}, true));

		// hasPermit is true, withLicensedPassenger is true, passengerAge LT 21
		TestingLibrary.TestGroup cannotDrivePassengerUnderage = new TestingLibrary.TestGroup("Returns false when driver has permit and licensed passenger under 21");
		cannotDrivePassengerUnderage.addTest(new TestingLibrary.Test(new Object[]{true, true, 20}, false));
		cannotDrivePassengerUnderage.addTest(new TestingLibrary.Test(new Object[]{true, true, 16}, false));

		// either hasPermit is true or withLicensedPassenger is true, but not both are true, passengerAge irrelevant
		TestingLibrary.TestGroup cannotDriveNoPermitOrLicensedPassenger = new TestingLibrary.TestGroup("Returns false when driver has no permit or licensed passenger");
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 80}, false));  // has permit, but no licensed passenger, passenger's age irrelevant
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 21}, false));  //
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 16}, false));  //
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 80}, false));  // has licensed passenger, but no permit, passenger's age irrelevant
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 21}, false));  //
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 16}, false));  //
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, false, 80}, false));	// has neither permit nor licensed passenger, passenger's age irrelevant
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, false, 21}, false));	//   tested for completeness-sake
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, false, 16}, false));	//

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(canDrive);
		testGroups.add(cannotDrivePassengerUnderage);
		testGroups.add(cannotDriveNoPermitOrLicensedPassenger);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise02_CanDrive.class, "canDrive", boolean.class, boolean.class, int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise02_03_canDriveGuardian() {
		// hasPermit is true, withLicensedPassenger is true, passengerAge GTE 21
		TestingLibrary.TestGroup canDrive = new TestingLibrary.TestGroup("Returns true when driver has permit and licensed passenger who is 21 or older");
		canDrive.addTest(new TestingLibrary.Test(new Object[]{true, true, 80, true}, true));
		canDrive.addTest(new TestingLibrary.Test(new Object[]{true, true, 21, true}, true));
		canDrive.addTest(new TestingLibrary.Test(new Object[]{true, true, 80, false}, true));
		canDrive.addTest(new TestingLibrary.Test(new Object[]{true, true, 21, false}, true));

		// hasPermit is true, withLicensedPassenger is true, passengerAge GTE 18 and LTE 20, isPassengerOurGuardian is true
		TestingLibrary.TestGroup canDrivePassenger18Guardian = new TestingLibrary.TestGroup("Returns true when driver has permit and licensed passenger between 18 and 20 who is their guardian");
		canDrivePassenger18Guardian.addTest(new TestingLibrary.Test(new Object[]{true, true, 20, true}, true));
		canDrivePassenger18Guardian.addTest(new TestingLibrary.Test(new Object[]{true, true, 18, true}, true));

		// hasPermit is true, withLicensedPassenger is true, passengerAge GTE 18 and LTE 20, isPassengerOurGuardian is false
		TestingLibrary.TestGroup cannotDrivePassenger18NotGuardian = new TestingLibrary.TestGroup("Returns false when driver has permit and licensed passenger between 18 and 20 who isn't their guardian");
		cannotDrivePassenger18NotGuardian.addTest(new TestingLibrary.Test(new Object[]{true, true, 20, false}, false));
		cannotDrivePassenger18NotGuardian.addTest(new TestingLibrary.Test(new Object[]{true, true, 18, false}, false));

		// hasPermit is true, withLicensedPassenger is true, passengerAge LT 18, isPassengerOurGuardian irrelevant
		TestingLibrary.TestGroup cannotDrivePassengerUnderage = new TestingLibrary.TestGroup("Returns false when driver has permit and licensed passenger under 18");
		cannotDrivePassengerUnderage.addTest(new TestingLibrary.Test(new Object[]{true, true, 17, false}, false));
		cannotDrivePassengerUnderage.addTest(new TestingLibrary.Test(new Object[]{true, true, 17, true}, false));

		// either hasPermit is true or withLicensedPassenger is true, but not both are true, passengerAge and isPassengerOUrGuardian irrelevant
		TestingLibrary.TestGroup cannotDriveNoPermitOrLicensedPassenger = new TestingLibrary.TestGroup("Returns false when diver has no permit or licensed passenger");
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 80, true}, false));	// has permit, by no licensed passenger, passenger's age and guardian status irrelevant
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 21, true}, false));	//
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 16, true}, false));	//
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 80, false}, false));	// has permit, by no licensed passenger, passenger's age and guardian status irrelevant
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 21, false}, false));	//
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{true, false, 16, false}, false));	//
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 80, true}, false));	// has licensed passenger, but no permit, passenger's age and guardian status irrelevant
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 21, true}, false));	//
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 16, true}, false));	//
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 80, false}, false));	// has neither permit nor licensed passenger, passenger's age and guardian status irrelevant
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 21, false}, false));	//   tested for completeness-sake
		cannotDriveNoPermitOrLicensedPassenger.addTest(new TestingLibrary.Test(new Object[]{false, true, 16, false}, false));	//

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(canDrive);
		testGroups.add(canDrivePassenger18Guardian);
		testGroups.add(cannotDrivePassenger18NotGuardian);
		testGroups.add(cannotDrivePassengerUnderage);
		testGroups.add(cannotDriveNoPermitOrLicensedPassenger);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise02_CanDrive.class, "canDrive", boolean.class, boolean.class, int.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise03_01_calculateShippingRate() {
		// weight GT 40
		TestingLibrary.TestGroup shippingRateWeightOver40 = new TestingLibrary.TestGroup("Returns 0.75 when weight is greater than 40 lbs.");
		shippingRateWeightOver40.addTest(new TestingLibrary.Test(new Object[]{50}, 0.75));
		shippingRateWeightOver40.addTest(new TestingLibrary.Test(new Object[]{41}, 0.75));

		// weight LTE 40
		TestingLibrary.TestGroup shippingRateWeightUpTo40 = new TestingLibrary.TestGroup("Returns 0.5 when weight is 40 lbs. or less");
		shippingRateWeightUpTo40.addTest(new TestingLibrary.Test(new Object[]{40}, 0.5));
		shippingRateWeightUpTo40.addTest(new TestingLibrary.Test(new Object[]{35}, 0.5));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(shippingRateWeightOver40);
		testGroups.add(shippingRateWeightUpTo40);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise03_ShippingTotal.class, "calculateShippingRate", int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise03_02_calculateShippingTotal() {
		// weight GT 40
		TestingLibrary.TestGroup shippingTotalWeightOver40 = new TestingLibrary.TestGroup("Returns correct total when weight is greater than 40 lbs.");
		shippingTotalWeightOver40.addTest(new TestingLibrary.Test(new Object[]{50}, 37.5));
		shippingTotalWeightOver40.addTest(new TestingLibrary.Test(new Object[]{41}, 30.75));

		// weight LTE 40
		TestingLibrary.TestGroup shippingTotalWeightUpTo40 = new TestingLibrary.TestGroup("Returns correct total when weight is 40 lbs. or less");
		shippingTotalWeightUpTo40.addTest(new TestingLibrary.Test(new Object[]{40}, 20.0));
		shippingTotalWeightUpTo40.addTest(new TestingLibrary.Test(new Object[]{35}, 17.5));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(shippingTotalWeightOver40);
		testGroups.add(shippingTotalWeightUpTo40);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise03_ShippingTotal.class, "calculateShippingTotal", int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise03_03_calculateShippingTotalDiscounted() {
		// weight GT 40, hasDiscount is true
		TestingLibrary.TestGroup shippingTotalWeightOver40Discounted = new TestingLibrary.TestGroup("Returns correct total when weight is greater than 40 lbs. and there's a discount");
		shippingTotalWeightOver40Discounted.addTest(new TestingLibrary.Test(new Object[]{50, true}, 33.75));
		shippingTotalWeightOver40Discounted.addTest(new TestingLibrary.Test(new Object[]{41, true}, 27.675));

		// weight GT 40, hasDiscount is false
		TestingLibrary.TestGroup shippingTotalWeightOver40NoDiscount = new TestingLibrary.TestGroup("Returns correct total when weight is greater than 40 lbs. and no discount");
		shippingTotalWeightOver40NoDiscount.addTest(new TestingLibrary.Test(new Object[]{50, false}, 37.5));
		shippingTotalWeightOver40NoDiscount.addTest(new TestingLibrary.Test(new Object[]{41, false}, 30.75));

		// weight LTE 40, hasDiscount is true
		TestingLibrary.TestGroup shippingTotalWeightUpTo40Discounted = new TestingLibrary.TestGroup("Returns correct total when weight is 40 lbs. or less and there's a discount");
		shippingTotalWeightUpTo40Discounted.addTest(new TestingLibrary.Test(new Object[]{40, true}, 18.0));
		shippingTotalWeightUpTo40Discounted.addTest(new TestingLibrary.Test(new Object[]{35, true}, 15.75));

		// weight LTE 40, hasDiscount is false
		TestingLibrary.TestGroup shippingTotalWeightUpTo40NoDiscount = new TestingLibrary.TestGroup("Returns correct total when weight is 40 lbs. or less and no discount");
		shippingTotalWeightUpTo40NoDiscount.addTest(new TestingLibrary.Test(new Object[]{40, false}, 20.0));
		shippingTotalWeightUpTo40NoDiscount.addTest(new TestingLibrary.Test(new Object[]{35, false}, 17.5));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(shippingTotalWeightOver40Discounted);
		testGroups.add(shippingTotalWeightOver40NoDiscount);
		testGroups.add(shippingTotalWeightUpTo40Discounted);
		testGroups.add(shippingTotalWeightUpTo40NoDiscount);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise03_ShippingTotal.class, "calculateShippingTotal", int.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise04_01_calculateStayTotal() {
		// numberOfNights GTE 3
		TestingLibrary.TestGroup stayTotalDiscountRate = new TestingLibrary.TestGroup("Returns correct amount when stay is 3 nights or more");
		stayTotalDiscountRate.addTest(new TestingLibrary.Test(new Object[]{5}, 449.95));
		stayTotalDiscountRate.addTest(new TestingLibrary.Test(new Object[]{3}, 269.97));

		// numberOfNights LT 3
		TestingLibrary.TestGroup stayTotalDailyRate = new TestingLibrary.TestGroup("Returns correct amount when stay is less than 3 nights");
		stayTotalDailyRate.addTest(new TestingLibrary.Test(new Object[]{2}, 199.98));
		stayTotalDailyRate.addTest(new TestingLibrary.Test(new Object[]{1}, 99.99));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(stayTotalDiscountRate);
		testGroups.add(stayTotalDailyRate);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise04_HotelReservation.class, "calculateStayTotal", int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise04_02_calculateStayTotalParking() {
		// numberOfNights GTE 3, includesParking is true
		TestingLibrary.TestGroup stayTotalDiscountRateWithParking = new TestingLibrary.TestGroup("Returns correct amount when stay is 3 nights or more and parking is included");
		stayTotalDiscountRateWithParking.addTest(new TestingLibrary.Test(new Object[]{5, true}, 574.95));
		stayTotalDiscountRateWithParking.addTest(new TestingLibrary.Test(new Object[]{3, true}, 344.97));

		// numberOfNights GTE 3, includesParking is false
		TestingLibrary.TestGroup stayTotalDiscountRateNoParking = new TestingLibrary.TestGroup("Returns correct amount when stay is 3 nights or more and no parking");
		stayTotalDiscountRateNoParking.addTest(new TestingLibrary.Test(new Object[]{5, false}, 449.95));
		stayTotalDiscountRateNoParking.addTest(new TestingLibrary.Test(new Object[]{3, false}, 269.97));

		// numberOfNights LT 3, includesParking is true
		TestingLibrary.TestGroup stayTotalDailyRateWithParking = new TestingLibrary.TestGroup("Returns correct amount when stay is less than 3 nights and parking is included");
		stayTotalDailyRateWithParking.addTest(new TestingLibrary.Test(new Object[]{2, true}, 249.98));
		stayTotalDailyRateWithParking.addTest(new TestingLibrary.Test(new Object[]{1, true}, 124.99));

		// numberOfNights LT 3, includesParking is false
		TestingLibrary.TestGroup stayTotalDailyRateNoParking = new TestingLibrary.TestGroup("Returns correct amount when stay is less than 3 nights and no parking");
		stayTotalDailyRateNoParking.addTest(new TestingLibrary.Test(new Object[]{2, false}, 199.98));
		stayTotalDailyRateNoParking.addTest(new TestingLibrary.Test(new Object[]{1, false}, 99.99));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(stayTotalDiscountRateWithParking);
		testGroups.add(stayTotalDiscountRateNoParking);
		testGroups.add(stayTotalDailyRateWithParking);
		testGroups.add(stayTotalDailyRateNoParking);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise04_HotelReservation.class, "calculateStayTotal", int.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise04_03_calculateStayTotalLateCheckout() {
		// numberOfNights GTE 3, includesParking is true, includesLateCheckout is true
		TestingLibrary.TestGroup stayTotalDiscountRateWithParkingLateCheckout = new TestingLibrary.TestGroup("Returns correct amount when stay is 3 nights or more with parking included and late checkout");
		stayTotalDiscountRateWithParkingLateCheckout.addTest(new TestingLibrary.Test(new Object[]{5, true, true}, 594.95));
		stayTotalDiscountRateWithParkingLateCheckout.addTest(new TestingLibrary.Test(new Object[]{3, true, true}, 364.97));

		// numberOfNights GTE 3, includesParking is true, includesLateCheckout is false
		TestingLibrary.TestGroup stayTotalDiscountRateWithParkingLateNoLateCheckout = new TestingLibrary.TestGroup("Returns correct amount when stay is 3 nights or more with parking included but no late checkout");
		stayTotalDiscountRateWithParkingLateNoLateCheckout.addTest(new TestingLibrary.Test(new Object[]{5, true, false}, 574.95));
		stayTotalDiscountRateWithParkingLateNoLateCheckout.addTest(new TestingLibrary.Test(new Object[]{3, true, false}, 344.97));

		// numberOfNights GTE 3, includesParking is false, includesLateCheckout is true
		TestingLibrary.TestGroup stayTotalDiscountRateWithNoParkingLateCheckout = new TestingLibrary.TestGroup("Returns correct amount when stay is 3 nights or more with no parking but late checkout");
		stayTotalDiscountRateWithNoParkingLateCheckout.addTest(new TestingLibrary.Test(new Object[]{5, false, true}, 469.95));
		stayTotalDiscountRateWithNoParkingLateCheckout.addTest(new TestingLibrary.Test(new Object[]{3, false, true}, 289.97));

		// numberOfNights GTE 3, includesParking is false, includesLateCheckout is false
		TestingLibrary.TestGroup stayTotalDiscountRateWithNoParkingNoLateCheckout = new TestingLibrary.TestGroup("Returns correct amount when stay is 3 nights or more with no parking or late checkout");
		stayTotalDiscountRateWithNoParkingNoLateCheckout.addTest(new TestingLibrary.Test(new Object[]{5, false, false}, 449.95));
		stayTotalDiscountRateWithNoParkingNoLateCheckout.addTest(new TestingLibrary.Test(new Object[]{3, false, false}, 269.97));

		// numberOfNights LT 3, includesParking is true, includesLateCheckout is true
		TestingLibrary.TestGroup stayTotalDailyRateWithParkingLateCheckout = new TestingLibrary.TestGroup("Returns correct amount when stay is less than 3 nights with parking included and late checkout");
		stayTotalDailyRateWithParkingLateCheckout.addTest(new TestingLibrary.Test(new Object[]{2, true, true}, 269.98));
		stayTotalDailyRateWithParkingLateCheckout.addTest(new TestingLibrary.Test(new Object[]{1, true, true}, 144.99));

		// numberOfNights LT 3, includesParking is true, includesLateCheckout is false
		TestingLibrary.TestGroup stayTotalDailyRateWithParkingNoLateCheckout = new TestingLibrary.TestGroup("Returns correct amount when stay is less than 3 nights with parking included but no late checkout");
		stayTotalDailyRateWithParkingNoLateCheckout.addTest(new TestingLibrary.Test(new Object[]{2, true, false}, 249.98));
		stayTotalDailyRateWithParkingNoLateCheckout.addTest(new TestingLibrary.Test(new Object[]{1, true, false}, 124.99));

		// numberOfNights LT 3, includesParking is false, includesLateCheckout is true
		TestingLibrary.TestGroup stayTotalDailyRateWithNoParkingLateCheckout = new TestingLibrary.TestGroup("Returns correct amount when stay is less than 3 nights with no parking but late checkout");
		stayTotalDailyRateWithNoParkingLateCheckout.addTest(new TestingLibrary.Test(new Object[]{2, false, true}, 219.98));
		stayTotalDailyRateWithNoParkingLateCheckout.addTest(new TestingLibrary.Test(new Object[]{1, false, true}, 119.99));

		// numberOfNights LT 3, includesParking is false, includesLateCheckout is false
		TestingLibrary.TestGroup stayTotalDailyRateWithNoParkingNoLateCheckout = new TestingLibrary.TestGroup("Returns correct amount when stay is less than 3 nights with no parking or late checkout");
		stayTotalDailyRateWithNoParkingNoLateCheckout.addTest(new TestingLibrary.Test(new Object[]{2, false, false}, 199.98));
		stayTotalDailyRateWithNoParkingNoLateCheckout.addTest(new TestingLibrary.Test(new Object[]{1, false, false}, 99.99));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(stayTotalDiscountRateWithParkingLateCheckout);
		testGroups.add(stayTotalDiscountRateWithParkingLateNoLateCheckout);
		testGroups.add(stayTotalDiscountRateWithNoParkingLateCheckout);
		testGroups.add(stayTotalDiscountRateWithNoParkingNoLateCheckout);
		testGroups.add(stayTotalDailyRateWithParkingLateCheckout);
		testGroups.add(stayTotalDailyRateWithParkingNoLateCheckout);
		testGroups.add(stayTotalDailyRateWithNoParkingLateCheckout);
		testGroups.add(stayTotalDailyRateWithNoParkingNoLateCheckout);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise04_HotelReservation.class, "calculateStayTotal", int.class, boolean.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise05_01_acceptPackageWeight() {
		// weightPounds LTE 40
		TestingLibrary.TestGroup acceptPackageWeightUpTo40 = new TestingLibrary.TestGroup("Returns true when weight is acceptable");
		acceptPackageWeightUpTo40.addTest(new TestingLibrary.Test(new Object[]{40}, true));
		acceptPackageWeightUpTo40.addTest(new TestingLibrary.Test(new Object[]{30}, true));

		// weightPounds GT 40
		TestingLibrary.TestGroup acceptPackageWeightOver40 = new TestingLibrary.TestGroup("Returns false when weight is over");
		acceptPackageWeightOver40.addTest(new TestingLibrary.Test(new Object[]{41}, false));
		acceptPackageWeightOver40.addTest(new TestingLibrary.Test(new Object[]{50}, false));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(acceptPackageWeightUpTo40);
		testGroups.add(acceptPackageWeightOver40);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise05_AcceptPackage.class, "acceptPackage", int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise05_02_acceptPackageWeightVolume() {
		// weightPounds LTE 40, volume LTE 10,368
		TestingLibrary.TestGroup acceptPackageWeightUpTo40VolumeUpTo10368 = new TestingLibrary.TestGroup("Returns true when weight and volume are acceptable");
		acceptPackageWeightUpTo40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{40, 36, 24, 12}, true));	// weight 40, permute dimensions
		acceptPackageWeightUpTo40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{40, 36, 12, 24}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{40, 24, 36, 12}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{40, 24, 12, 36}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{40, 36, 24, 12}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{40, 12, 24, 36}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{30, 36, 24, 12}, true));	// weight 30, no need to further permute dimensions

		// weightPounds LTE 40, volume GT 10,368
		TestingLibrary.TestGroup rejectPackageWeightUpTo40VolumeOver10368 = new TestingLibrary.TestGroup("Returns false when weight is acceptable but volume is over");
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 37, 24, 12}, false));	// weight 40, permute dimensions
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 37, 12, 24}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 24, 37, 12}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 24, 12, 37}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 37, 24, 12}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 12, 24, 37}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{30, 37, 24, 12}, false));	// weight 30, no need to further permute dimensions

		// weightPounds GT 40, volume LTE 10,368
		TestingLibrary.TestGroup rejectPackageWeightOver40VolumeUpTo10368 = new TestingLibrary.TestGroup("Returns false when volume is acceptable but weight is over");
		rejectPackageWeightOver40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{41, 36, 24, 12}, false));
		rejectPackageWeightOver40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{50, 36, 24, 12}, false));

		// Since the package is rejected if either the weightPounds or volume tests fail, it's not necessary to test if they fail together.

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(acceptPackageWeightUpTo40VolumeUpTo10368);
		testGroups.add(rejectPackageWeightUpTo40VolumeOver10368);
		testGroups.add(rejectPackageWeightOver40VolumeUpTo10368);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise05_AcceptPackage.class, "acceptPackage", int.class, int.class, int.class, int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise05_03_acceptPackageWeightVolumeDimensions() {
		// weightPounds LTE 40, volume LTE 10,368, dimension LTE 66, isSurchargePaid irrelevant
		TestingLibrary.TestGroup acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66 = new TestingLibrary.TestGroup("Returns true when weight, volume, and dimensions are acceptable");
		acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66.addTest(new TestingLibrary.Test(new Object[]{40, 36, 24, 12, true}, true));	// weight 40, permute dimensions
		acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66.addTest(new TestingLibrary.Test(new Object[]{40, 36, 12, 24, true}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66.addTest(new TestingLibrary.Test(new Object[]{40, 24, 36, 12, true}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66.addTest(new TestingLibrary.Test(new Object[]{40, 24, 12, 36, false}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66.addTest(new TestingLibrary.Test(new Object[]{40, 36, 24, 12, false}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66.addTest(new TestingLibrary.Test(new Object[]{40, 12, 24, 36, false}, true));	//
		acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66.addTest(new TestingLibrary.Test(new Object[]{30, 36, 24, 12, true}, true));	// weight 30, no need to further permute dimensions
		acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66.addTest(new TestingLibrary.Test(new Object[]{30, 36, 24, 12, true}, true));	// weight 30, no need to further permute dimensions

		// weightPounds LTE 40, volume LTE 10,368, dimension GT 66, isSurchargePaid is true
		TestingLibrary.TestGroup rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66IsSurchargePaid = new TestingLibrary.TestGroup("Returns true when weight and volume are acceptable, but package is over-sized with surcharge paid");
		rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66IsSurchargePaid.addTest(new TestingLibrary.Test(new Object[]{40, 67, 12, 12, true}, true));	// weight 40, rotate too large dimension
		rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66IsSurchargePaid.addTest(new TestingLibrary.Test(new Object[]{40, 12, 67, 12, true}, true));	//
		rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66IsSurchargePaid.addTest(new TestingLibrary.Test(new Object[]{40, 12, 12, 67, true}, true));	//
		rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66IsSurchargePaid.addTest(new TestingLibrary.Test(new Object[]{30, 67, 12, 12, true}, true));	// weight 30, no need to further permute dimensions

		// weightPounds LTE 40, volume LTE 10,368, at least one dimension GT 66, isSurchargePaid is false
		TestingLibrary.TestGroup rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66SurchargeNotPaid = new TestingLibrary.TestGroup("Returns false when weight and volume are acceptable, but package is over-sized with no surcharge paid");
		rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66SurchargeNotPaid.addTest(new TestingLibrary.Test(new Object[]{40, 67, 12, 12, false}, false));	// weight 40, rotate too large dimension
		rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66SurchargeNotPaid.addTest(new TestingLibrary.Test(new Object[]{40, 12, 67, 12, false}, false));	//
		rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66SurchargeNotPaid.addTest(new TestingLibrary.Test(new Object[]{40, 12, 12, 67, false}, false));	//
		rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66SurchargeNotPaid.addTest(new TestingLibrary.Test(new Object[]{30, 67, 12, 12, false}, false));	// weight 30, no need to further permute dimensions

		// weightPounds LTE 40, volume GT 10,368, dimension and isSurcharge irrelevant
		TestingLibrary.TestGroup rejectPackageWeightUpTo40VolumeOver10368 = new TestingLibrary.TestGroup("Returns false when weight is acceptable but volume is over");
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 37, 24, 12, true}, false));	// weight 40, permute dimensions
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 37, 12, 24, true}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 24, 37, 12, true}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 24, 12, 37, false}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 37, 24, 12, false}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{40, 12, 24, 37, false}, false));	//
		rejectPackageWeightUpTo40VolumeOver10368.addTest(new TestingLibrary.Test(new Object[]{30, 37, 24, 12, false}, false));	// weight 30, no need to further permute dimensions

		// weightPounds GT 40, volume LTE 10,368, dimension and isSurcharge irrelevant
		TestingLibrary.TestGroup rejectPackageWeightOver40VolumeUpTo10368 = new TestingLibrary.TestGroup("Returns false when volume is acceptable but weight is over");
		rejectPackageWeightOver40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{41, 36, 24, 12, false}, false));
		rejectPackageWeightOver40VolumeUpTo10368.addTest(new TestingLibrary.Test(new Object[]{50, 36, 24, 12, false}, false));

		// Since the package is rejected if weightPounds, volume, or dimension with surcharge tests fail, it's not necessary to test if they fail together.

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(acceptPackageWeightUpTo40VolumeUpTo10368DimensionUpTo66);
		testGroups.add(rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66IsSurchargePaid);
		testGroups.add(rejectPackageWeightUpTo40VolumeUpTo10368DimensionOver66SurchargeNotPaid);

		testGroups.add(rejectPackageWeightUpTo40VolumeOver10368);
		testGroups.add(rejectPackageWeightOver40VolumeUpTo10368);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise05_AcceptPackage.class, "acceptPackage", int.class, int.class, int.class, int.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise06_01_determineRaceBlock() {
		// age LT 18, isEarlyRegistration irrelevant
		TestingLibrary.TestGroup determineRaceBlockLess18 = new TestingLibrary.TestGroup("Returns 3 when runner is under 18");
		determineRaceBlockLess18.addTest(new TestingLibrary.Test(new Object[]{17, true}, 3));
		determineRaceBlockLess18.addTest(new TestingLibrary.Test(new Object[]{12, true}, 3));
		determineRaceBlockLess18.addTest(new TestingLibrary.Test(new Object[]{17, false}, 3));
		determineRaceBlockLess18.addTest(new TestingLibrary.Test(new Object[]{12, false}, 3));

		// age GTE 18, isEarlyRegistration is true
		TestingLibrary.TestGroup determineRaceBlock18EarlyRegistration = new TestingLibrary.TestGroup("Returns 1 when runner is 18 or over and an early registration");
		determineRaceBlock18EarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{18, true}, 1));
		determineRaceBlock18EarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{80, true}, 1));

		// age GTE 18, isEarlyRegistration is false
		TestingLibrary.TestGroup determineRaceBlock18NotEarlyRegistration = new TestingLibrary.TestGroup("Returns 2 when runner is 18 or over and not an early registration");
		determineRaceBlock18NotEarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{18, false}, 2));
		determineRaceBlock18NotEarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{80, false}, 2));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(determineRaceBlockLess18);
		testGroups.add(determineRaceBlock18EarlyRegistration);
		testGroups.add(determineRaceBlock18NotEarlyRegistration);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise06_RaceDay.class, "determineRaceBlock", int.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise06_02_getBibNumber() {
		// age LT 18, isEarlyRegistration irrelevant
		TestingLibrary.TestGroup getBibNumberLess18 = new TestingLibrary.TestGroup("Returns correct bib number when runner is under 18");
		getBibNumberLess18.addTest(new TestingLibrary.Test(new Object[]{17, 1, true}, 1));
		getBibNumberLess18.addTest(new TestingLibrary.Test(new Object[]{12, 2, true}, 2));
		getBibNumberLess18.addTest(new TestingLibrary.Test(new Object[]{17, 3, false}, 3));
		getBibNumberLess18.addTest(new TestingLibrary.Test(new Object[]{12, 4, false}, 4));

		// age GTE 18, isEarlyRegistration is true
		TestingLibrary.TestGroup getBibNumber18EarlyRegistration = new TestingLibrary.TestGroup("Returns correct bib number when runner is 18 or over and an early registration");
		getBibNumber18EarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{80, 1, true}, 1001));
		getBibNumber18EarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{18, 2, true}, 1002));

		// age GTE 18, isEarlyRegistration is false
		TestingLibrary.TestGroup getBibNumber18NotEarlyRegistration = new TestingLibrary.TestGroup("Returns correct bib number when runner is 18 or over and not an early registration");
		getBibNumber18NotEarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{80, 1, false}, 1));
		getBibNumber18NotEarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{18, 2, false}, 2));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(getBibNumberLess18);
		testGroups.add(getBibNumber18EarlyRegistration);
		testGroups.add(getBibNumber18NotEarlyRegistration);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise06_RaceDay.class, "getBibNumber", int.class, int.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise06_03_getConfirmedBibNumber() {
		// age LT 18, isEarlyRegistration irrelevant
		TestingLibrary.TestGroup getConfirmedBibNumberLess18 = new TestingLibrary.TestGroup("Returns correct bib number when runner is under 18");
		getConfirmedBibNumberLess18.addTest(new TestingLibrary.Test(new Object[]{17, 1, true}, 1));
		getConfirmedBibNumberLess18.addTest(new TestingLibrary.Test(new Object[]{12, 2, true}, 2));
		getConfirmedBibNumberLess18.addTest(new TestingLibrary.Test(new Object[]{17, 3, false}, 3));
		getConfirmedBibNumberLess18.addTest(new TestingLibrary.Test(new Object[]{12, 4, false}, 4));

		// age GTE 18, isEarlyRegistration is true
		TestingLibrary.TestGroup getConfirmedBibNumber18EarlyRegistration = new TestingLibrary.TestGroup("Returns correct bib number when runner is 18 or over and an early registration");
		getConfirmedBibNumber18EarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{80, 1, true}, 1001));
		getConfirmedBibNumber18EarlyRegistration.addTest(new TestingLibrary.Test(new Object[]{18, 2, true}, 1002));

		// age GTE 18, isEarlyRegistration is false, registrationNumber LTE 1000
		TestingLibrary.TestGroup getConfirmedBibNumber18NotEarlyRegistrationless1000 = new TestingLibrary.TestGroup("Returns correct bib number when runner is 18 or over, not an early registration, but a spot remains");
		getConfirmedBibNumber18NotEarlyRegistrationless1000.addTest(new TestingLibrary.Test(new Object[]{80, 999, false}, 999));
		getConfirmedBibNumber18NotEarlyRegistrationless1000.addTest(new TestingLibrary.Test(new Object[]{18, 1000, false}, 1000));

		// age GTE 18, isEarlyRegistration is false, registrationNumber GT 1000
		TestingLibrary.TestGroup getConfirmedBibNumber18NotEarlyRegistration1001 = new TestingLibrary.TestGroup("Returns -1 when runner is 18 or over, not an early registration, and no spots remain");
		getConfirmedBibNumber18NotEarlyRegistration1001.addTest(new TestingLibrary.Test(new Object[]{80, 1001, false}, -1));
		getConfirmedBibNumber18NotEarlyRegistration1001.addTest(new TestingLibrary.Test(new Object[]{18, 1111, false}, -1));

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(getConfirmedBibNumberLess18);
		testGroups.add(getConfirmedBibNumber18EarlyRegistration);
		testGroups.add(getConfirmedBibNumber18NotEarlyRegistrationless1000);
		testGroups.add(getConfirmedBibNumber18NotEarlyRegistration1001);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise06_RaceDay.class, "getConfirmedBibNumber", int.class, int.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise07_01_isStoreOpen() {
		TestingLibrary.TestGroup storeOpen = new TestingLibrary.TestGroup("Returns true when within open hours");
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{8}, true));			// opening
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{9}, true));
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{15}, true));
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{16}, true));		// last full hour before closing

		TestingLibrary.TestGroup storeClosed = new TestingLibrary.TestGroup("Returns false when not within open hours");
		storeClosed.addTest(new TestingLibrary.Test(new Object[]{0}, false));		// midnight
		storeClosed.addTest(new TestingLibrary.Test(new Object[]{7}, false));		// one hour before opening
		storeClosed.addTest(new TestingLibrary.Test(new Object[]{17}, false));		// closing hour
		storeClosed.addTest(new TestingLibrary.Test(new Object[]{24}, false));		// midnight

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(storeOpen);
		testGroups.add(storeClosed);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise07_StoreHours.class, "isStoreOpen", int.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise07_02_isStoreOpenCurrentDay() {
		TestingLibrary.TestGroup storeOpen = new TestingLibrary.TestGroup("Returns true when within open hours on Monday, Wednesday, or Friday");
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{8, 'M'}, true));		// opening Monday
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{8, 'W'}, true));		// opening Wednesday
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{8, 'F'}, true));		// opening Friday
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{16, 'M'}, true));		// last full hour Monday
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{16, 'W'}, true));		// last full hour Wednesday
		storeOpen.addTest(new TestingLibrary.Test(new Object[]{16, 'F'}, true));		// last full hour Friday

		TestingLibrary.TestGroup storeClosedHours = new TestingLibrary.TestGroup("Returns false when not within open hours on Monday, Wednesday, or Friday");
		storeClosedHours.addTest(new TestingLibrary.Test(new Object[]{7, 'M'}, false));       // too early Monday
		storeClosedHours.addTest(new TestingLibrary.Test(new Object[]{7, 'W'}, false));       // too early Wednesday
		storeClosedHours.addTest(new TestingLibrary.Test(new Object[]{7, 'F'}, false));       // too early Friday
		storeClosedHours.addTest(new TestingLibrary.Test(new Object[]{17, 'M'}, false));      // too late Monday
		storeClosedHours.addTest(new TestingLibrary.Test(new Object[]{17, 'W'}, false));      // too late Wednesday
		storeClosedHours.addTest(new TestingLibrary.Test(new Object[]{17, 'F'}, false));      // too late Friday

		TestingLibrary.TestGroup storeClosedDay = new TestingLibrary.TestGroup("Returns false when not open at all on that day");
		storeClosedDay.addTest(new TestingLibrary.Test(new Object[]{8, 'S'}, false));     // not open Saturday, current hour is meaningless
		storeClosedDay.addTest(new TestingLibrary.Test(new Object[]{16, 'U'}, false));	  // not open Sunday, current hour is meaningless
		storeClosedDay.addTest(new TestingLibrary.Test(new Object[]{14, 'H'}, false));	  // not open Sunday, current hour is meaningless
		storeClosedDay.addTest(new TestingLibrary.Test(new Object[]{10, 'T'}, false));	  // not open Sunday, current hour is meaningless

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(storeOpen);
		testGroups.add(storeClosedHours);
		testGroups.add(storeClosedDay);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise07_StoreHours.class, "isStoreOpen", int.class, char.class);

		TestingLibrary.runTestSuite(testSuite);
	}

	@Test
	public void exercise07_03_isStoreOpenSummer() {
		TestingLibrary.TestGroup mondayFriday = new TestingLibrary.TestGroup("Returns correct open status when Monday or Friday");
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{8, 'M', true}, true));       // opening Monday (summer)
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{8, 'F', true}, true));       // opening Friday (summer)
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{16, 'M', true}, true));      // last full hour Monday (summer)
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{16, 'F', true}, true));      // last full hour Friday (summer)
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{8, 'M', false}, true));      // opening Monday
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{8, 'F', false}, true));      // opening Friday
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{16, 'M', false}, true));     // last full hour Monday
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{16, 'F', false}, true));     // last full hour Friday
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{7, 'M', true}, false));      // too early Monday
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{7, 'F', true}, false));      // too early Friday
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{17, 'M', false}, false));    // too late Monday
		mondayFriday.addTest(new TestingLibrary.Test(new Object[]{17, 'F', false}, false));    // too late Friday

		TestingLibrary.TestGroup wedSatNotSummer = new TestingLibrary.TestGroup("Returns correct open status when Wednesday or Saturday and not summer hours");
		wedSatNotSummer.addTest(new TestingLibrary.Test(new Object[]{8, 'W', false}, true));     // opening Wednesday
		wedSatNotSummer.addTest(new TestingLibrary.Test(new Object[]{16, 'W', false}, true));    // last full hour Wednesday
		wedSatNotSummer.addTest(new TestingLibrary.Test(new Object[]{7, 'W', false}, false));    // too early Wednesday
		wedSatNotSummer.addTest(new TestingLibrary.Test(new Object[]{17, 'W', false}, false));   // too late Wednesday
		wedSatNotSummer.addTest(new TestingLibrary.Test(new Object[]{8, 'S', false}, false));    // closed Saturday
		wedSatNotSummer.addTest(new TestingLibrary.Test(new Object[]{15, 'S', false}, false));   // closed Saturday

		TestingLibrary.TestGroup wedSatSummer = new TestingLibrary.TestGroup("Returns correct open status when Wednesday or Saturday and is summer hours");
		wedSatSummer.addTest(new TestingLibrary.Test(new Object[]{8, 'W', true}, true));      // opening Wednesday
		wedSatSummer.addTest(new TestingLibrary.Test(new Object[]{17, 'W', true}, true));     // previous close Wednesday
		wedSatSummer.addTest(new TestingLibrary.Test(new Object[]{19, 'W', true}, true));     // last full hour Wednesday
		wedSatSummer.addTest(new TestingLibrary.Test(new Object[]{7, 'W', true}, false));     // too early Wednesday
		wedSatSummer.addTest(new TestingLibrary.Test(new Object[]{20, 'W', true}, false));    // too late Wednesday
		wedSatSummer.addTest(new TestingLibrary.Test(new Object[]{9, 'S', true}, true));      // opening Saturday
		wedSatSummer.addTest(new TestingLibrary.Test(new Object[]{14, 'S', true}, true));     // last full hour Saturday

		TestingLibrary.TestGroup storeClosedDay = new TestingLibrary.TestGroup("Returns false when not open at all on that day");
		storeClosedDay.addTest(new TestingLibrary.Test(new Object[]{16, 'U', true}, false));    // not open Saturday, current hour is meaningless
		storeClosedDay.addTest(new TestingLibrary.Test(new Object[]{16, 'U', false}, false));	  // not open Sunday, current hour is meaningless
		storeClosedDay.addTest(new TestingLibrary.Test(new Object[]{14, 'H', true}, false));	  // not open Sunday, current hour is meaningless
		storeClosedDay.addTest(new TestingLibrary.Test(new Object[]{10, 'T', false}, false));	  // not open Sunday, current hour is meaningless

		List<TestingLibrary.TestGroup> testGroups = new ArrayList<>();
		testGroups.add(mondayFriday);
		testGroups.add(wedSatNotSummer);
		testGroups.add(wedSatSummer);
		testGroups.add(storeClosedDay);

		TestingLibrary.TestSuite testSuite = new TestingLibrary.TestSuite(testGroups, Exercise07_StoreHours.class, "isStoreOpen", int.class, char.class, boolean.class);

		TestingLibrary.runTestSuite(testSuite);
	}
}
