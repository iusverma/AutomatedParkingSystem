package com.whiteclark.aps.commands;

import com.whiteclark.aps.ParkingGrid;
import com.whiteclark.aps.enums.Direction;
import com.whiteclark.aps.enums.Status;

/**
 * MoveLeftCommand, this command ensures that the movement is in left direction to current one
 */
public class MoveLeftCommand extends AbstractCommand{

	/**
	 * Check the current direction of movement and turns left.
	 */
	@Override
	public Status execute() {
		ParkingGrid parkingGrid = ParkingGrid.getParkingGrid();
		Direction currentDirection = parkingGrid.getCar().getMovingTowards();
		if(currentDirection == Direction.NORTH) {
			parkingGrid.getCar().setMovingTowards(Direction.WEST);
		}else if(currentDirection == Direction.WEST) {
			parkingGrid.getCar().setMovingTowards(Direction.SOUTH);
		}if(currentDirection == Direction.SOUTH) {
			parkingGrid.getCar().setMovingTowards(Direction.EAST);
		}if(currentDirection == Direction.EAST) {
			parkingGrid.getCar().setMovingTowards(Direction.NORTH);
		}
		return Status.SUCCESS;
	}

}
