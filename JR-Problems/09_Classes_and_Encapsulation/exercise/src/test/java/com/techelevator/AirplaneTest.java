package com.techelevator;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AirplaneTest {

	@Before
	public void Airplane_HasRequiredMembers() {
		Class klass = Airplane.class;

		Constructor<Airplane> constructor = SafeReflection.getConstructor(klass, String.class, Integer.TYPE,
				Integer.TYPE);
		assertTrue("You do not have the required constructor(String, int, int)", constructor != null);

		Method method = SafeReflection.getMethod(klass, "getPlaneNumber");
		assertTrue("Airplane class needs the getPlaneNumber() method.", method != null);
		assertTrue("getPlaneNumber() method needs to return type: String", method.getReturnType() == String.class);

		method = SafeReflection.getMethod(klass, "setPlaneNumber", String.class);
		assertTrue("Airplane class should not have a setPlaneNumber(String) method", method == null);

		method = SafeReflection.getMethod(klass, "getBookedFirstClassSeats");
		assertTrue("Airplane class needs the getBookedFirstClassSeats() method.", method != null);
		assertTrue("getBookedFirstClassSeats() method needs to return type: int",
				method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setBookedFirstClassSeats", Integer.TYPE);
		assertTrue("Airplane class should not have a setBookedFirstClassSeats(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getAvailableFirstClassSeats");
		assertTrue("Airplane class needs the getAvailableFirstClassSeats() method.", method != null);
		assertTrue("getAvailableFirstClassSeats() method needs to return type: int",
				method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setAvailableFirstClassSeats", Integer.TYPE);
		assertTrue("Airplane class should not have a setAvailableFirstClassSeats(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getTotalFirstClassSeats");
		assertTrue("Airplane class needs the getTotalFirstClassSeats() method.", method != null);
		assertTrue("getTotalFirstClassSeats() method needs to return type: int",
				method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setTotalFirstClassSeats", Integer.TYPE);
		assertTrue("Airplane class should not have a setTotalFirstClassSeats(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getBookedCoachSeats");
		assertTrue("Airplane class needs the getBookedCoachSeats() method.", method != null);
		assertTrue("getBookedCoachSeats() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setBookedCoachSeats", Integer.TYPE);
		assertTrue("Airplane class should not have a setBookedCoachSeats(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getAvailableCoachSeats");
		assertTrue("Airplane class needs the getAvailableCoachSeats() method.", method != null);
		assertTrue("getAvailableCoachSeats() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setAvailableCoachSeats", Integer.TYPE);
		assertTrue("Airplane class should not have a setAvailableCoachSeats(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getTotalCoachSeats");
		assertTrue("Airplane class needs the getTotalCoachSeats() method.", method != null);
		assertTrue("getTotalCoachSeats() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setTotalCoachSeats", Integer.TYPE);
		assertTrue("Airplane class should not have a setTotalCoachSeats(int) method", method == null);

		method = SafeReflection.getMethod(klass, "reserveSeats", Boolean.TYPE, Integer.TYPE);
		assertTrue("Airplane class needs the reserveSeats(boolean, int) method.", method != null);
		assertTrue("reserveSeats(boolean, int) method needs to return type: boolean",
				method.getReturnType() == Boolean.TYPE);

		assertFalse("Airplane class must not be abstract. Remove the 'abstract' modifier on Airplane.", Modifier.isAbstract(klass.getModifiers()));
	}

	@Test
	public void airplaneConstructor() {
		Class klass = Airplane.class;

		Constructor<Airplane> constructor = SafeReflection.getConstructor(klass, String.class, Integer.TYPE,
				Integer.TYPE);
		assertTrue("You do not have the required constructor(String, int, int)", constructor != null);
		try {
			Airplane airplane = constructor.newInstance("ABC123", 2, 3);
			Method getPlaneNumber = SafeReflection.getMethod(klass, "getPlaneNumber");
			Method getTotalFirstClassSeats = SafeReflection.getMethod(klass, "getTotalFirstClassSeats");
			Method getTotalCoachSeats = SafeReflection.getMethod(klass, "getTotalCoachSeats");
			Method getBookedFirstClassSeats = SafeReflection.getMethod(klass, "getBookedFirstClassSeats");
			Method getBookedCoachSeats = SafeReflection.getMethod(klass, "getBookedCoachSeats");
			assertTrue("Testing constructor with Airplane(\"ABC123\", 2, 3) and expected PlaneNumber property to hold \"ABC123\".",
					"ABC123".equals((String) getPlaneNumber.invoke(airplane)));
			assertTrue("Testing constructor with Airplane(\"ABC123\", 2, 3) and expected totalFirstClassSeats property to return 2",
					2 == (int) getTotalFirstClassSeats.invoke(airplane));
			assertTrue("Testing constructor with Airplane(\"ABC123\", 2, 3) and expected TotalCoachSeats property to return 3.",
					3 == (int) getTotalCoachSeats.invoke(airplane));
			assertTrue("New planes should initially have 0 booked first class seats.",
					0 == (int) getBookedFirstClassSeats.invoke(airplane));
			assertTrue("New planes should initially have 0 booked coach seats.",
					0 == (int) getBookedCoachSeats.invoke(airplane));
		} catch (Exception e) {
			fail("Failed to instantiate Airplane");
		}
	}

	@Test
	public void airplaneGetAvailableSeatsTest() {
		Class klass = Airplane.class;

		Constructor<Airplane> constructor = SafeReflection.getConstructor(klass, String.class, Integer.TYPE,
				Integer.TYPE);
		assertTrue("You do not have the required constructor(String, int, int)", constructor != null);
		try {
			Airplane airplane = constructor.newInstance("ABC123", 2, 3);
			Method getAvailableFirstClassSeats = SafeReflection.getMethod(klass, "getAvailableFirstClassSeats");
			Method getAvailableCoachSeats = SafeReflection.getMethod(klass, "getAvailableCoachSeats");
			assertTrue(
					"No seats have been booked for first class. There are 2 first class seats, 2 should be available.",
					2 == (int) getAvailableFirstClassSeats.invoke(airplane));
			assertTrue("No seats have been booked for coach. There are 3 coach seats, 3 should be available.",
					3 == (int) getAvailableCoachSeats.invoke(airplane));
		} catch (Exception e) {
			fail("Failed to instantiate Airplane");
		}
	}

	@Test
	public void airplaneReserveSeatsTest() {
		Class klass = Airplane.class;

		Constructor<Airplane> constructor = SafeReflection.getConstructor(klass, String.class, Integer.TYPE,
				Integer.TYPE);
		assertTrue("You do not have the required constructor(String, int, int)", constructor != null);
		try {
			Airplane airplane = constructor.newInstance("ABC123", 2, 3);
			Method reserveSeats = SafeReflection.getMethod(klass, "reserveSeats", Boolean.TYPE, Integer.TYPE);
			Method getAvailableFirstClassSeats = SafeReflection.getMethod(klass, "getAvailableFirstClassSeats");
			Method getBookedFirstClassSeats = SafeReflection.getMethod(klass, "getBookedFirstClassSeats");
			Method getAvailableCoachSeats = SafeReflection.getMethod(klass, "getAvailableCoachSeats");
			Method getBookedCoachSeats = SafeReflection.getMethod(klass, "getBookedCoachSeats");

			// Reserve one less than available
			boolean firstClassResult = (boolean) reserveSeats.invoke(airplane, new Object[] { true, 1 });
			boolean coachResult = (boolean) reserveSeats.invoke(airplane, new Object[] { false, 2 });
			assertTrue("reserveSeats should return true if a seat can be booked.", firstClassResult);
			assertTrue("reserveSeats should return true if a seat can be booked.", coachResult);
			assertEquals("AvailableFirstClassSeats did not return the correct value. Total 2, Booked 1, Available 1",
					1, (int) getAvailableFirstClassSeats.invoke(airplane));
			assertEquals("BookedFirstClassSeats did not return the correct value. Total 2, Booked 1, Available 1",
					1, (int) getBookedFirstClassSeats.invoke(airplane));
			assertEquals("AvailableCoachClassSeats did not return the correct value. Total 3, Booked 2, Available 1",
					1, (int) getAvailableCoachSeats.invoke(airplane));
			assertEquals("BookedCoachSeats did not return the correct value. Total 3, Booked 2, Available 1",
					2, (int) getBookedCoachSeats.invoke(airplane));

			// Reserve the exact number available
			airplane = constructor.newInstance("ABC123", 2, 3);
			firstClassResult = (boolean) reserveSeats.invoke(airplane, new Object[] { true, 2 });
			coachResult = (boolean) reserveSeats.invoke(airplane, new Object[] { false, 3 });
			assertTrue("reserveSeats should return true if seats can be booked.", firstClassResult);
			assertTrue("reserveSeats should return true if seats can be booked.", coachResult);
			assertEquals("AvailableFirstClassSeats did not return the correct value. Total 2, Booked 2, Available 0",
					0, (int) getAvailableFirstClassSeats.invoke(airplane));
			assertEquals("BookedFirstClassSeats did not return the correct value. Total 2, Booked 2, Available 0",
					2, (int) getBookedFirstClassSeats.invoke(airplane));
			assertEquals("AvailableCoachClassSeats did not return the correct value. Total 3, Booked 3, Available 0",
					0, (int) getAvailableCoachSeats.invoke(airplane));
			assertEquals("BookedCoachSeats did not return the correct value. Total 3, Booked 3, Available 0",
					3, (int) getBookedCoachSeats.invoke(airplane));

			// Reserve one more than available
			airplane = constructor.newInstance("ABC123", 2, 3);
			firstClassResult = (boolean) reserveSeats.invoke(airplane, new Object[] { true, 3 });
			coachResult = (boolean) reserveSeats.invoke(airplane, new Object[] { false, 4 });
			assertFalse("reserveSeats should return false if seats cannot be booked.", firstClassResult);
			assertFalse("reserveSeats should return false if seats cannot be booked.", coachResult);
			assertEquals("AvailableFirstClassSeats did not return the correct value. Total 2, Booked 0, Available 2",
					2, (int) getAvailableFirstClassSeats.invoke(airplane));
			assertEquals("BookedFirstClassSeats did not return the correct value. Total 2, Booked 0, Available 2",
					0, (int) getBookedFirstClassSeats.invoke(airplane));
			assertEquals("AvailableCoachClassSeats did not return the correct value. Total 3, Booked 0, Available 3",
					3, (int) getAvailableCoachSeats.invoke(airplane));
			assertEquals("BookedCoachSeats did not return the correct value. Total 3, Booked 0, Available 3",
					0, (int) getBookedCoachSeats.invoke(airplane));
		} catch (Exception e) {
			fail("Failed to instantiate Airplane");
		}
	}

}
