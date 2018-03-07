package com.whiteclark.aps.commands;

import com.whiteclark.aps.Car;
import com.whiteclark.aps.ParkingGrid;
import com.whiteclark.aps.enums.Direction;
import com.whiteclark.aps.enums.Status;

/**
 * MoveForwardCommand, this command ensures forward movement based in direction of movements
 */
public class MoveForwardCommand extends AbstractCommand{

	/**
	 * Successfully move forward if there is space in GRID
	 * Fails other wise
	 * Irrespective of direction forward can not for beyond
	 * (15,1)(1,15)(1,1)(15,15)
	 */
	@Override
	public Status execute() {
		ParkingGrid parkingGrid = ParkingGrid.getParkingGrid();
		Car car = parkingGrid.getCar();
		if(car.getMovingTowards() == Direction.NORTH) {
			if(car.getCurrentGrid().getRow() == 15) {
				return Status.FAILED;
			}
			car.getCurrentGrid().setRow(car.getCurrentGrid().getRow()+1);
		}else if(car.getMovingTowards() == Direction.SOUTH) {
			if(car.getCurrentGrid().getRow() == 1) {
				return Status.FAILED;
			}
			car.getCurrentGrid().setRow(car.getCurrentGrid().getRow()-1);
		}else if(car.getMovingTowards() == Direction.EAST) {
			if(car.getCurrentGrid().getSlot() == 15) {
				return Status.FAILED;
			}
			car.getCurrentGrid().setSlot(car.getCurrentGrid().getSlot()+1);
		}else if(car.getMovingTowards() == Direction.WEST) {
			if(car.getCurrentGrid().getSlot() == 1) {
				return Status.FAILED;
			}
			car.getCurrentGrid().setSlot(car.getCurrentGrid().getSlot()-1);
		}
		return Status.SUCCESS;
	}
}
