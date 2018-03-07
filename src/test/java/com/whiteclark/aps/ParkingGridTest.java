package com.whiteclark.aps;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests the overall functionality for ParkingGrid
 */
public class ParkingGridTest {
	private static ParkingGrid parkingGrid = ParkingGrid.getParkingGrid();
	private static Car car;
	
	@BeforeClass
	private void init() {
		Grid grid = new Grid(3,3);
		car = new Car(grid);
	}

	@Test
	public void testParkingGridObjectNotNull() {
		Assert.assertNotNull(parkingGrid);
	}
	
	/**
	 * Test that car object is added for sending command 
	 */
	@Test
	public void testAddCarForSendingCommand() {
		parkingGrid.setCar(car);
		Assert.assertNotNull(parkingGrid.getCar());
	}

	/**
	 * Tests that a parking slot is blocked once the car is placed on it.
	 */
	@Test
	public void testGirdAlocatedToCarIsBlocked() {
		Car carInGrid = parkingGrid.getCar();
		int [][] parkingSlots = parkingGrid.getParkingSlots();
		int blocked = parkingSlots[carInGrid.getCurrentGrid().getRow()-1][carInGrid.getCurrentGrid().getSlot()-1];
		Assert.assertTrue(blocked>0);
	}

	/**
	 * Test that car to move is modified
	 */
	@Test
	public void testUpdateCarForSendingCommand() {
		Grid newGrid = new Grid(4,5);
		Car newCar = new Car(newGrid);
		parkingGrid.setCar(newCar);
		Assert.assertEquals(parkingGrid.getCar().getCurrentGrid().toString(),"4,5");
	}
	
	/**
	 * Test that car object can be set as NULL,
	 * it is perfectly ok to have no car in grid
	 */
	@Test
	public void testSetCarAsNull() {
		parkingGrid.setCar(null);
		Assert.assertNull(parkingGrid.getCar());
	}
}
