package com.whiteclark.aps.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.whiteclark.aps.commands.InvalidCommand;
import com.whiteclark.aps.commands.MoveForwardCommand;
import com.whiteclark.aps.commands.MoveLeftCommand;
import com.whiteclark.aps.commands.MoveRightCommand;

/** 
 * Test CommandUtil class
 */
public class CommandUtilTest {
	private static final String UNKNOWN = "UNKNOWN";

	/** Test if null is passed as command */
	@Test
	public void testNullCommand() {
		Assert.assertEquals(InvalidCommand.class,CommandUtil.prepareCommand(null).getClass());
	}

	/** Test if unsupported characters are passed as command */
	@Test
	public void testUnknownCommand() {
		Assert.assertEquals(InvalidCommand.class,CommandUtil.prepareCommand(UNKNOWN).getClass());
	}

	/** Test if empty characters/string is passed as command */
	@Test
	public void testEmptyCommand() {
		Assert.assertEquals(InvalidCommand.class,CommandUtil.prepareCommand("").getClass());
	}

	/** Test MoveLeftCommand creation */
	@Test
	public void testMoveLeftCommand() {
		Assert.assertEquals(MoveLeftCommand.class,CommandUtil.prepareCommand("L").getClass());
	}

	/** Test MoveLeftCommand creation in lower case */
	@Test
	public void testMoveLeftCommandLowerCase() {
		Assert.assertEquals(MoveLeftCommand.class,CommandUtil.prepareCommand("l").getClass());
	}

	/** Test MoveRightCommand creation */
	@Test
	public void testMoveRightCommand() {
		Assert.assertEquals(MoveRightCommand.class,CommandUtil.prepareCommand("R").getClass());
	}

	/** Test MoveRightCommand creation in lower case */
	@Test
	public void testMoveRightCommandLowerCase() {
		Assert.assertEquals(MoveRightCommand.class,CommandUtil.prepareCommand("r").getClass());
	}

	/** Test MoveForwardCommand creation*/
	@Test
	public void testMoveForwardCommand() {
		Assert.assertEquals(MoveForwardCommand.class,CommandUtil.prepareCommand("F").getClass());
	}

	/** Test MoveForwardCommand creation in lower case */
	@Test
	public void testMoveForwardCommandLowerCase() {
		Assert.assertEquals(MoveForwardCommand.class,CommandUtil.prepareCommand("f").getClass());
	}	
}
