package com.techelevator;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElevatorTest {

	@Before
	public void elevatorRequiredMembers() {
		Class klass = Elevator.class;

		Constructor<Elevator> constructor = SafeReflection.getConstructor(klass, Integer.TYPE);
		assertTrue("You do not have the required constructor(int)", constructor != null);

		Method method = SafeReflection.getMethod(klass, "getCurrentFloor");
		assertTrue("Elevator class needs the getCurrentFloor() method.", method != null);
		assertTrue("getCurrentFloor() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setCurrentFloor", Integer.TYPE);
		assertTrue("Elevator class should not have a setCurrentFloor(int) method", method == null);

		method = SafeReflection.getMethod(klass, "getNumberOfFloors");
		assertTrue("Elevator class needs the getNumberOfFloors() method.", method != null);
		assertTrue("getNumberOfFloors() method needs to return type: int", method.getReturnType() == Integer.TYPE);

		method = SafeReflection.getMethod(klass, "setNumberOfFloors", Integer.TYPE);
		assertTrue("Elevator class should not have a setNumberOfFloors(int) method", method == null);

		method = SafeReflection.getMethod(klass, "isDoorOpen");
		assertTrue("Elevator class needs the isDoorOpen() method.", method != null);
		assertTrue("isDoorOpen() method needs to return type: boolean", method.getReturnType() == Boolean.TYPE);

		method = SafeReflection.getMethod(klass, "setDoorOpen", Integer.TYPE);
		assertTrue("Elevator class should not have a setDoorOpen(boolean) method", method == null);

		method = SafeReflection.getMethod(klass, "openDoor");
		assertTrue("Elevator class needs the openDoor() method.", method != null);
		assertTrue("openDoor() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "closeDoor");
		assertTrue("Elevator class needs the closeDoor() method.", method != null);
		assertTrue("closeDoor() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "goUp", Integer.TYPE);
		assertTrue("Elevator class needs the goUp() method.", method != null);
		assertTrue("goUp() method needs to return type: void", method.getReturnType() == void.class);

		method = SafeReflection.getMethod(klass, "goDown", Integer.TYPE);
		assertTrue("Elevator class needs the goDown() method.", method != null);
		assertTrue("goDown() method needs to return type: void", method.getReturnType() == void.class);

		assertFalse("Elevator class must not be abstract. Remove the 'abstract' modifier on Elevator.", Modifier.isAbstract(klass.getModifiers()));
	}

	@Test
	public void elevatorConstructor() {
		Class klass = Elevator.class;

		Constructor<Elevator> constructor = SafeReflection.getConstructor(klass, Integer.TYPE);
		assertTrue("You do not have the required constructor(int)", constructor != null);
		try {
			Elevator elevator = constructor.newInstance(3);
			Method getCurrentFloor = SafeReflection.getMethod(klass, "getCurrentFloor");
			Method getNumberOfFloors = SafeReflection.getMethod(klass, "getNumberOfFloors");
			Method isDoorOpen = SafeReflection.getMethod(klass, "isDoorOpen");

			assertTrue("CurrentLevel for new Elevators should return 1.", 1 == (int) getCurrentFloor.invoke(elevator));
			assertTrue("NumberOfLevels should be equal to the argument passed into the Constructor.",
					3 == (int) getNumberOfFloors.invoke(elevator));
			assertFalse("The door should be closed for new elevators.", (boolean) isDoorOpen.invoke(elevator));
		} catch (Exception e) {
			fail("Failed to instantiate Elevator");
		}
	}

	@Test
	public void elevatorOpenDoorTests() {
		Class klass = Elevator.class;

		Constructor<Elevator> constructor = SafeReflection.getConstructor(klass, Integer.TYPE);
		assertTrue("You do not have the required constructor(int)", constructor != null);
		try {
			Elevator elevator = constructor.newInstance(3);
			Method openDoor = SafeReflection.getMethod(klass, "openDoor");
			Method closeDoor = SafeReflection.getMethod(klass, "closeDoor");
			Method isDoorOpen = SafeReflection.getMethod(klass, "isDoorOpen");

			openDoor.invoke(elevator);
			assertTrue("The door should be open after calling OpenDoor.", (boolean) isDoorOpen.invoke(elevator));
			closeDoor.invoke(elevator);
			assertFalse("The door should be closed after calling CloseDoor.", (boolean) isDoorOpen.invoke(elevator));
		} catch (Exception e) {
			fail("Failed to instantiate Elevator");
		}
	}

	@Test
	public void elevatorMoveUpAndDownTests() {
		Class klass = Elevator.class;

		Constructor<Elevator> constructor = SafeReflection.getConstructor(klass, Integer.TYPE);
		assertTrue("You do not have the required constructor(int)", constructor != null);
		try {
			Elevator elevator = constructor.newInstance(5);
			Method openDoor = SafeReflection.getMethod(klass, "openDoor");
			Method closeDoor = SafeReflection.getMethod(klass, "closeDoor");
			Method goUp = SafeReflection.getMethod(klass, "goUp", Integer.TYPE);
			Method goDown = SafeReflection.getMethod(klass, "goDown", Integer.TYPE);
			Method getCurrentFloor = SafeReflection.getMethod(klass, "getCurrentFloor");
			Method isDoorOpen = SafeReflection.getMethod(klass, "isDoorOpen");

			// Newly instantiated elevator is on floor 1 and door is closed
			assertTrue("Newly instantiated elevator is not on floor 1.",
					1 == (int) getCurrentFloor.invoke(elevator));
			assertFalse("Newly instantiated elevator's door is not closed.", (boolean) isDoorOpen.invoke(elevator));

			// Move up to floor 2
			goUp.invoke(elevator, new Object[] { 2 });
			assertTrue("The elevator did not go up to the floor 2.",
					2 == (int) getCurrentFloor.invoke(elevator));

			// Open the door
			openDoor.invoke(elevator);
			assertTrue("The elevator door did not open.", (boolean) isDoorOpen.invoke(elevator));

			// Attempt to move up to floor 3 with door open
			goUp.invoke(elevator, new Object[] { 3 });
			assertTrue("The elevator moved from floor 2 to floor 3 with the door open.",
					2 == (int) getCurrentFloor.invoke(elevator));

			// Close the door
			closeDoor.invoke(elevator);
			assertFalse("The elevator door did not close.", (boolean) isDoorOpen.invoke(elevator));

			// Move up to floor 4
			goUp.invoke(elevator, new Object[] { 4 });
			assertTrue("The elevator did not move up to floor 4.",
					4 == (int) getCurrentFloor.invoke(elevator));

			// Attempt to move "up" to floor 3 from floor 4
			goUp.invoke(elevator, new Object[] { 3 });
			assertTrue("The elevator moved \"up\" to floor 3 from floor 4.",
					4 == (int) getCurrentFloor.invoke(elevator));

			// Move up to the top floor
			goUp.invoke(elevator, new Object[] { 5 });
			assertTrue("The elevator did not move up to the top floor.",
					5 == (int) getCurrentFloor.invoke(elevator));

			// Attempt to move past the top floor
			goUp.invoke(elevator, new Object[] { 6 });
			assertTrue("The elevator went past the top floor.", 5 == (int) getCurrentFloor.invoke(elevator));

			// Move down to floor 3 from floor 5
			goDown.invoke(elevator, new Object[] { 3 });
			assertTrue("The elevator did not move down to the floor 3.",
					3 == (int) getCurrentFloor.invoke(elevator));

			// Open the door
			openDoor.invoke(elevator);
			assertTrue("The elevator door did not open.", (boolean) isDoorOpen.invoke(elevator));

			// Attempt to move down to floor 2 with door open
			goDown.invoke(elevator, new Object[] { 2 });
			assertTrue("The elevator moved from floor 3 to floor 2 with the door open.",
					3 == (int) getCurrentFloor.invoke(elevator));

			// Close the door
			closeDoor.invoke(elevator);
			assertFalse("The elevator door did not close.", (boolean) isDoorOpen.invoke(elevator));

			// Move down to the floor 2
			goDown.invoke(elevator, new Object[] { 2 });
			assertTrue("The elevator did not move down to floor 2.",
					2 == (int) getCurrentFloor.invoke(elevator));

			// Attempt to move "down" from floor 2 to floor 3
			goDown.invoke(elevator, new Object[] { 3 });
			assertTrue("The elevator moved \"down\" to floor 3 from floor 2.",
					2 == (int) getCurrentFloor.invoke(elevator));

			// Move down to the bottom floor
			goDown.invoke(elevator, new Object[] { 1 });
			assertTrue("The elevator did not move down to the bottom floor.",
					1 == (int) getCurrentFloor.invoke(elevator));

			// Attempt to move below the bottom floor
			goDown.invoke(elevator, new Object[] { 0 });
			assertTrue("The elevator went below the bottom floor.", 1 == (int) getCurrentFloor.invoke(elevator));

		} catch (Exception e) {
			fail("Failed to instantiate Elevator");
		}
	}
}
