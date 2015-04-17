package cu.cs.cpsc215.project3;

import java.io.Serializable;

/**
 * Created by Ryan on 4/8/2015.
 * Minimal class to save the data to be serialized.
 * Keeps track of what cells are turned on and off through boolean array.
 */
public class GameState implements Serializable{

	private static final long serialVersionUID = 2410146483192973766L;
	
	/**
	 * Represents the grid of cells which should be alive and dead respectively.
	 */
	private boolean[][] cells;
	/**
	 * width and height
	 */
    private int width, height;
    
    /**
     * Number of generations iterated through.
     */
	private int generation;

	/**
	 * Creates new GameState
	 * @param width of grid, same as corresponding grid panel
	 * @param height of grid, same as corresponding grid panel
	 */
    public GameState(int width, int height) {
    	this.width = width;
    	this.height = height;
		generation = 0;

    	cells = new boolean[width][height];
    }
    
    /**
     * Returns whether the cells is alive or dead at location (c,r)
     * @param c
     * @param r
     * @return if cell is alive or dead (boolean)
     */
    public boolean getCellState(int c, int r) {
    	if(c >= 0 && c < width && r >= 0 && r < height) {
    		return cells[c][r];
    	}
    	return false;
    }
    
    /**
     * Allows user to set state of the cell if it is alive or dead
     * @param c
     * @param r
     * @param state updates cell at (c, r) to this state
     */
    public void setCellState(int c, int r, boolean state) {
    	if(c >= 0 && c < width && r >= 0 && r < height) {
    		cells[c][r] = state;
    	}
    }

    /**
     * Returns generation
     * @return
     */
	public int getGeneration(){
		return generation;
	}

	/**
	 * Sets generation
	 * @param g
	 */
	public void setGeneration(int g){
		generation = g;
	}
}
