package com.whiteclark.aps.service;

import org.apache.log4j.Logger;

import com.whiteclark.aps.Car;
import com.whiteclark.aps.Grid;
import com.whiteclark.aps.ParkingGrid;
import com.whiteclark.aps.enums.Status;
import com.whiteclark.aps.utils.CommandUtil;
import com.whiteclark.aps.utils.InputValidator;

public class AutomatedParkingHandler {
	/** Error message to be generated if there is any error */
	private static final String ERR_MSG = "Please enter command as [row,slot:list of commands]. Example: '0,0:LLFFRR'.";
	private static final String INVALID_LOCATION_ERR_MSG = ERR_MSG +" Invalid grid to start.";
	private final Logger logger = Logger.getLogger(AutomatedParkingHandler.class);

	/**
	 * Entry point for the string containing location & sequence of command
	 * @param cmd
	 * @return
	 */
	public String execute(String cmd) {
		logger.info("execute");

		if(InputValidator.validate(cmd) != Status.SUCCESS) {
			logger.debug(ERR_MSG);
			return ERR_MSG;
		}
		String [] inputDetails = cmd.split(":");
		String [] startLocation = inputDetails[0].split(",");
		if(setStartLocation(startLocation) != Status.SUCCESS) {
			logger.debug(INVALID_LOCATION_ERR_MSG);
			return INVALID_LOCATION_ERR_MSG;
		}
		String movementInstructions = inputDetails[1];
		for(int i=0;i<movementInstructions.length();i++) {
			if(CommandUtil.prepareCommand(Character.toString(movementInstructions.charAt(i))).execute() == Status.FAILED) {
				// Since command didn't execute successfully, setting location to original
				ParkingGrid.getParkingGrid().getCar().getCurrentGrid().setRow(Integer.parseInt(startLocation[0]));
				ParkingGrid.getParkingGrid().getCar().getCurrentGrid().setSlot(Integer.parseInt(startLocation[1]));
				break;
			}
		}
		return ParkingGrid.getParkingGrid().getCar().getCurrentGrid().toString();
	}
	
	/**
	 * This method sets the start location for car OR in other
	 * words send signal to car at grid specified as X,Y
	 */
	private Status setStartLocation(String [] startLocation) {
		logger.debug("setStartLocation");
		ParkingGrid pGrid = ParkingGrid.getParkingGrid();
		if(Integer.parseInt(startLocation[0]) >0 && Integer.parseInt(startLocation[1]) > 0) {
			Grid grid = new Grid(Integer.parseInt(startLocation[0]),Integer.parseInt(startLocation[1]));
			Car car = new Car(grid);
			pGrid.setCar(car);
			return Status.SUCCESS;
		}
		return Status.FAILED;
	}
}
