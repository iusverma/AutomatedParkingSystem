package com.whiteclark.aps;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests the overall functionality for Grid class
 */
public class GridTest {
	private static Grid grid = new Grid(0,0);
	private static final String GRID_LOCATION_STR = "5,3";

	@Test
	public void testGridObject() {
		Assert.assertNotNull(grid);
	}

	@Test
	public void testGetRow() {
		Assert.assertEquals(grid.getRow(),0);
	}

	@Test
	public void testGetSlot() {
		Assert.assertEquals(grid.getSlot(),0);
	}

	@Test
	public void testSetRow() {
		grid.setRow(5);
		Assert.assertEquals(grid.getRow(),5);
	}

	/** Try setting row to 0 */
	@Test
	public void testSetRowToZero() {
		grid.setRow(0);
		Assert.assertEquals(grid.getRow(),5);
	}

	/** Try setting row to negative  */
	@Test
	public void testSetRowNegatice() {
		grid.setRow(-1);
		Assert.assertEquals(grid.getRow(),5);
	}

	@Test
	public void testSetSlot() {
		grid.setSlot(3);
		Assert.assertEquals(grid.getSlot(),3);
	}

	/** Try setting slot to 0 */
	@Test
	public void testSetSlotToZero() {
		grid.setSlot(0);
		Assert.assertEquals(grid.getSlot(),3);
	}
	
	/** Try setting slot to negative */
	@Test
	public void testSetSlotNegative() {
		grid.setSlot(0);
		Assert.assertEquals(grid.getSlot(),3);
	}

	/** Test the toString method for Grid*/
	@Test
	public void testToString() {
		Assert.assertEquals(grid.toString(),GRID_LOCATION_STR);
	}
	
	/**
	 * This test cases tries to set grid location as -1, -1, since this
	 * is an invalid grid, default grid location 0, 0 should be set.
	 */
	@Test
	public void testInvalidGrid() {
		Grid invalidGrid = new Grid(-1,-1);
		Assert.assertEquals(invalidGrid.toString(),"0,0");
	}
}
