package com.whiteclark.aps.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomatedParkingHandlerTest {
	private static final String ERROR_MSG = "Please enter command as [row,slot:list of commands]. Example: '0,0:LLFFRR'.";
	private static final String ERROR_MSG_INVALID_LOC = ERROR_MSG + " Invalid grid to start.";

	@Test
	public void testInvalidCommand() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("skjdfh"),ERROR_MSG);
	}
	
	@Test
	public void testNoSequenceOfCommands() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("1,1:"),ERROR_MSG);
	}
	
	@Test
	public void testZeroLocationToStart() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("0,0:FLR"),ERROR_MSG_INVALID_LOC);
	}
	
	@Test
	public void testNegativeLocationToStart() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("-1,-1:LEF"),ERROR_MSG_INVALID_LOC);
	}
	
	@Test
	public void testMovement() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("1,1:FLR"),"2,1");
	}

	@Test
	public void testMovementInNegativeLeftDirection() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("2,2:LFFF"),"2,2");
	}
	
	@Test
	public void testMovementInNegativeDownDirection() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("2,2:RRFFF"),"2,2");
	}

	@Test
	public void testMovementBeyondRightSideOfGrid() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("13,13:RFFF"),"13,13");
	}
	
	@Test
	public void testMovementBeyondAboveGrid() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("13,13:FFF"),"13,13");
	}

	@Test
	public void testScenario1() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("5,5:RFLFRFLF"),"7,7");
	}

	@Test
	public void testScenario2() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("6,6:FFLFFLFFLFF"),"6,6");
	}
	
	@Test
	public void testScenario3() {
		AutomatedParkingHandler handler = new AutomatedParkingHandler();
		Assert.assertEquals(handler.execute("5,5:FLFLFFRFFF"),"4,1");
	}
}