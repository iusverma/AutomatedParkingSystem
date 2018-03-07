package com.whiteclark.aps.commands;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.whiteclark.aps.Car;
import com.whiteclark.aps.Grid;
import com.whiteclark.aps.ParkingGrid;
import com.whiteclark.aps.enums.Direction;
import com.whiteclark.aps.enums.Status;

/**
 * Test class for MoveForwardCommand
 */
public class MoveForwardCommandTest {
	
private static MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
	
	@BeforeClass
	private void init() {
		Grid grid = new Grid(1,1);
		Car car = new Car(grid);
		ParkingGrid.getParkingGrid().setCar(car);
	}
	
	// Following tests for happy scenario and successful movement
	@Test
	public void testMoveForwardTowardsNorth() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.NORTH);
		Assert.assertEquals(moveForwardCommand.execute(), Status.SUCCESS);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getCurrentGrid().getRow(),2);
	}
	
	@Test
	public void testMoveForwardTowardsSouth() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.SOUTH);
		Assert.assertEquals(moveForwardCommand.execute(), Status.SUCCESS);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getCurrentGrid().getRow(),1);
	}
	
	@Test
	public void testMoveForwardTowardsEast() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.EAST);
		Assert.assertEquals(moveForwardCommand.execute(), Status.SUCCESS);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getCurrentGrid().getSlot(),2);
	}
	
	@Test
	public void testMoveForwardTowardsWest() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.WEST);
		Assert.assertEquals(moveForwardCommand.execute(), Status.SUCCESS);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getCurrentGrid().getSlot(),1);
	}

	// Following tests for negative scenario and when there is no space in grid to move
	@Test
	public void testMoveForwardBeyondGridInNorth() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.NORTH);
		ParkingGrid.getParkingGrid().getCar().getCurrentGrid().setRow(15);
		Assert.assertEquals(moveForwardCommand.execute(), Status.FAILED);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getCurrentGrid().getRow(),15);
	}
	
	@Test
	public void testMoveForwardBeyondGridInSouth() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.SOUTH);
		ParkingGrid.getParkingGrid().getCar().getCurrentGrid().setRow(1);
		Assert.assertEquals(moveForwardCommand.execute(), Status.FAILED);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getCurrentGrid().getRow(),1);
	}
	
	@Test
	public void testMoveForwardBeyondGridInEast() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.EAST);
		ParkingGrid.getParkingGrid().getCar().getCurrentGrid().setSlot(15);
		Assert.assertEquals(moveForwardCommand.execute(), Status.FAILED);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getCurrentGrid().getSlot(),15);
	}
	
	@Test
	public void testMoveForwardBeyondGridInWest() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.WEST);
		ParkingGrid.getParkingGrid().getCar().getCurrentGrid().setSlot(1);
		Assert.assertEquals(moveForwardCommand.execute(), Status.FAILED);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getCurrentGrid().getSlot(),1);
	}
}
