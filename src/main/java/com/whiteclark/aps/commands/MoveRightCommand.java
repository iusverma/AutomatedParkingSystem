package com.whiteclark.aps.commands;

import com.whiteclark.aps.ParkingGrid;
import com.whiteclark.aps.enums.Direction;
import com.whiteclark.aps.enums.Status;

/**
 * MoveRightCommand, this command ensures that the movement is in right direction to current one
 */
public class MoveRightCommand extends AbstractCommand{

	/**
	 * Check the current direction of movement and turns right.
	 */
	@Override
	public Status execute() {
		ParkingGrid parkingGrid = ParkingGrid.getParkingGrid();
		Direction currentDirection = parkingGrid.getCar().getMovingTowards();
		if(currentDirection == Direction.NORTH) {
			parkingGrid.getCar().setMovingTowards(Direction.EAST);
			return Status.SUCCESS;
		}else if(currentDirection == Direction.EAST) {
			parkingGrid.getCar().setMovingTowards(Direction.SOUTH);
			return Status.SUCCESS;
		}if(currentDirection == Direction.SOUTH) {
			parkingGrid.getCar().setMovingTowards(Direction.WEST);
			return Status.SUCCESS;
		}if(currentDirection == Direction.WEST) {
			parkingGrid.getCar().setMovingTowards(Direction.NORTH);
			return Status.SUCCESS;
		}
		return Status.FAILED;
	}

}
