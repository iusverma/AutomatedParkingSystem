package com.whiteclark.aps;

/**
 * Basic Grid class, contains the locations for car
 */
public class Grid {
	/** Row where in the grid */
	private int row;

	/** Slot where in the row */
	private int slot;
	
	/** Default constructor, set row & slot for grid, 
	 * default is 0, 0
	 */
	public Grid(int row, int slot) {
		if(row>=0 && slot >=0) {
			this.row = row;
			this.slot = slot;
		}
	}
	/** Get grid row */
	public int getRow() {
		return row;
	}

	/** Update grid row */
	public void setRow(int row) {
		if(row > 0) {
			this.row = row;
		}
	}

	/** Get slot in row */
	public int getSlot() {
		return slot;
	}

	/** Update row slot */
	public void setSlot(int slot) {
		if(slot > 0) {
			this.slot = slot;
		}
	}

	 /**
     * Overridden toString method, this prints the registration number
     */
    @Override
    public String toString() {
        return row +","+slot;
    }
}
