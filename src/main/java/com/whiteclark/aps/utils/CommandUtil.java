package com.whiteclark.aps.utils;

import com.whiteclark.aps.commands.AbstractCommand;
import com.whiteclark.aps.commands.InvalidCommand;
import com.whiteclark.aps.commands.MoveForwardCommand;
import com.whiteclark.aps.commands.MoveLeftCommand;
import com.whiteclark.aps.commands.MoveRightCommand;

/**
 * Utility class used for creating the command for execution
 */
public class CommandUtil {

	/** This public method will take a convert it into an executable command */
	public static AbstractCommand prepareCommand(String cmd) {
		AbstractCommand command = null;
		if(cmd != null) {
			if(cmd.toUpperCase().equals("F")) {
				command = new MoveForwardCommand();
			}else if(cmd.toUpperCase().equals("L")) {
				command = new MoveLeftCommand();
			}else if(cmd.toUpperCase().equals("R")) {
				command = new MoveRightCommand();
			}
		}
		if(command == null) {
			command = new InvalidCommand();
		}
		return command;
	}
}
