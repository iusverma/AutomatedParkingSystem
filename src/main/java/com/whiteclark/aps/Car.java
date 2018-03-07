package com.whiteclark.aps;

import com.whiteclark.aps.enums.Direction;

/**
 * Basic car class, this will contain the current location (X,Y)
 * for car and also the direction car headed
 */
public class Car {
	/** Direction in which car is headed, car by default headed to NORTH/UP*/
	private Direction movingTowards = Direction.NORTH;

	/** Current location for car, no location for car initially */
	private Grid currentGrid = new Grid(0,0);

	/** Constructor, with new grid location */
	public Car(Grid grid) {
		this.currentGrid = grid;
	}

	/** Get car's moving direction */
	public Direction getMovingTowards() {
		return movingTowards;
	}

	/** Set car's moving direction */
	public void setMovingTowards(Direction movingTowards) {
		if(movingTowards!=null) {
			this.movingTowards = movingTowards;
		}
	}

	/** Get car's current location */
	public Grid getCurrentGrid() {
		return currentGrid;
	}

	/** Updates car's current location */
	public void setCurrentGrid(Grid newGrid) {
		if(newGrid!=null) {
			this.currentGrid = newGrid;
		}
	}
}
