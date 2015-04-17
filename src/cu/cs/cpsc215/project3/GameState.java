package cu.cs.cpsc215.project3;

import java.io.Serializable;

/**
 * Created by Ryan on 4/8/2015.
 * Minimal class to save the data to be serialized
 */
public class GameState implements Serializable{

	private static final long serialVersionUID = 2410146483192973766L;
	private boolean[][] cells;
    private int width, height;
	private int generation;

    public GameState(int width, int height) {
    	this.width = width;
    	this.height = height;
		generation = 0;

    	cells = new boolean[width][height];
    }
    
    public boolean getCellState(int c, int r) {
    	if(c >= 0 && c < width && r >= 0 && r < height) {
    		return cells[c][r];
    	}
    	return false;
    }
    
    public void setCellState(int c, int r, boolean state) {
    	if(c >= 0 && c < width && r >= 0 && r < height) {
    		cells[c][r] = state;
    	}
    }

	public int getGeneration(){
		return generation;
	}

	public void setGeneration(int g){
		generation = g;
	}
}
