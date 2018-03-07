package com.whiteclark.aps.commands;

import com.whiteclark.aps.enums.Status;

/**
 * Invalid command, when user enters an unidentified/empty/null command
 */
public class InvalidCommand extends AbstractCommand{

	@Override
	public Status execute() {
		return Status.INVALID;
	}
}
