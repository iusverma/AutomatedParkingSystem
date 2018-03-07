package com.whiteclark.aps.commands;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.whiteclark.aps.enums.Status;

/**
 * Test class for InvalidCommand
 */
public class InvalidCommandTest {

	@Test
	public void execute() {
		InvalidCommand invalidCommand = new InvalidCommand();
		Assert.assertEquals(invalidCommand.execute(), Status.INVALID);
	}
}
