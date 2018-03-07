package com.whiteclark.aps.utils;

import com.whiteclark.aps.enums.Status;

/**
 * This util class validates the input string.
 */
public class InputValidator {
	/**
	 * Checks whether input string forms a valid command or not
	 * Format: Location:Sequence_Of_Commands
	 * Example: X,Y:ABCDEF
	 * X & Y being number to respective grids
	 */
	public static Status validate(String cmd) {
		if(cmd == null || cmd.isEmpty()) {
			return Status.FAILED;
		}
		String [] inputDetails = cmd.split(":");
		if(inputDetails.length == 2 && 
				inputDetails[0].split(",").length==2 &&
				inputDetails[1].length()>0 
					) {
				try {
					Integer.parseInt(inputDetails[0].split(",")[0]);
					Integer.parseInt(inputDetails[0].split(",")[1]);
				}catch(NumberFormatException e) {
					return Status.FAILED;
				}
				return Status.SUCCESS;
		}
		return Status.FAILED;
	}
}
