package com.whiteclark.aps;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.whiteclark.aps.enums.Direction;

/**
 * This class tests the overall functionality for Car class
 */
public class CarTest {
	private static Car car;
	private static final String GRID_LOCATION_STR = "3,4";
	private static Grid newLocation = new Grid(5,6);
	
	/**
	 * Initializes the car object for testing
	 */
	@BeforeClass
	private void init() {
		Grid carLocation = new Grid(3,4);
		car = new Car(carLocation);
	}

	@Test
	public void testCarObjectNotNull() {
		Assert.assertNotNull(car);
	}

	@Test
	public void testGetCurrentGrid() {
		Assert.assertEquals(car.getCurrentGrid().toString(), GRID_LOCATION_STR);
	}

	@Test
	public void testGetMovingTowards() {
		Assert.assertEquals(car.getMovingTowards(), Direction.NORTH);
	}

	@Test
	public void testSetCurrentGrid() {
		car.setCurrentGrid(newLocation);
		Assert.assertEquals(car.getCurrentGrid().toString(), "5,6");
	}

	@Test
	public void testSetCurrentGridNull() {
		car.setCurrentGrid(newLocation);
		car.setCurrentGrid(null);
		Assert.assertEquals(car.getCurrentGrid().toString(), "5,6");
	}
	
	@Test
	public void testSetMovingTowards() {
		car.setMovingTowards(Direction.SOUTH);
		Assert.assertEquals(car.getMovingTowards(), Direction.SOUTH);
	}
	
	@Test
	public void testSetMovingTowardsNull() {
		car.setMovingTowards(null);
		Assert.assertEquals(car.getMovingTowards(), Direction.SOUTH);
	}
}
