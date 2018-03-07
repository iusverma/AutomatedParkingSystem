package com.whiteclark.aps.commands;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.whiteclark.aps.Car;
import com.whiteclark.aps.Grid;
import com.whiteclark.aps.ParkingGrid;
import com.whiteclark.aps.enums.Direction;
import com.whiteclark.aps.enums.Status;

/**
 * Test class for MoveRightCommand
 */
public class MoveRightCommandTest {

private static MoveRightCommand moveRightCommand = new MoveRightCommand();
	
	@BeforeClass
	private void init() {
		Grid grid = new Grid(1,1);
		Car car = new Car(grid);
		ParkingGrid.getParkingGrid().setCar(car);
	}

	/** 
	 * By default new car is headed towards UP/NORTH,
	 */
	@Test
	public void testExecuteTurnRightFromNorth() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.NORTH);
		Assert.assertEquals(moveRightCommand.execute(), Status.SUCCESS);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getMovingTowards(),Direction.EAST);
	}

	@Test
	public void testExecuteTurnRightFromEast() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.EAST);
		Assert.assertEquals(moveRightCommand.execute(), Status.SUCCESS);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getMovingTowards(),Direction.SOUTH);
	}

	@Test
	public void testExecuteTurnRightFromSouth() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.SOUTH);
		Assert.assertEquals(moveRightCommand.execute(), Status.SUCCESS);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getMovingTowards(),Direction.WEST);
	}

	@Test
	public void testExecuteTurnRightFromWest() {
		ParkingGrid.getParkingGrid().getCar().setMovingTowards(Direction.WEST);
		Assert.assertEquals(moveRightCommand.execute(), Status.SUCCESS);
		Assert.assertEquals(ParkingGrid.getParkingGrid().getCar().getMovingTowards(),Direction.NORTH);
	}
}
