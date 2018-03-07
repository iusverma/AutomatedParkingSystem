package com.whiteclark.aps;

/**
 * Class representing the parking GRID, this will remain as a singleton
 * object in the application
 * 
 */
public class ParkingGrid {
	/** Static instance to parking grid object */
	private static ParkingGrid parkingGrid = new ParkingGrid();
	
	/** Initial number of rows in parking grid */
	private static final int NUM_OF_ROWS = 15;
	
	/** Initial number of slots in each row */
	private static final int NUM_OF_SLOTS = 15;

	/** Actual parking grid */
	private static int [][] parkingSlots;

	/** Car assigned to the grid location */
	private Car car = null;
	
	/** Initialize parking grid and set all location as empty i.e. -1 */
    private ParkingGrid(){
        parkingSlots = new int[NUM_OF_ROWS][NUM_OF_SLOTS];
        for (int i = 0; i < NUM_OF_ROWS; i++) {
        		for (int j = 0; j < NUM_OF_SLOTS; j++) {
        			parkingSlots[i][j] = -1;
        		}
        }
    }

    /** Public access for paring grid object */
    public static ParkingGrid getParkingGrid() {	
		return parkingGrid;
    }

    /** Getter for parking slots */
	public int[][] getParkingSlots() {
		return parkingSlots;
	}

    /** Returns car which we are moving in grid */
	public Car getCar() {
		return car;
	}

	/**
	 * Set car to be moved
	 * Also blocks gird location for the car
	 */
	public void setCar(Car car) {
		if(car != null) {
			this.car = car;
			if(car.getCurrentGrid().getRow()>0 && car.getCurrentGrid().getSlot()>0) {
				parkingSlots[car.getCurrentGrid().getRow()-1][car.getCurrentGrid().getSlot()-1] = 1;
			}
		}else {
			this.car = null;
		}
	}
}
