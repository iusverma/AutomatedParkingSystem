package com.whiteclark.aps.commands;

import com.whiteclark.aps.enums.Status;

/**
 * AbstractCommand, super class for all commands in system
 */
public abstract class AbstractCommand {
	public abstract Status execute();
}
