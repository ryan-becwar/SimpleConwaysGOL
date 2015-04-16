package cu.cs.cpsc215.project3;

/**
 * Created by Ryan on 4/8/2015.
 */
public class GameState {

    private boolean[][] cells;
    private int width, height;

    public GameState(int width, int height) {
    	this.width = width;
    	this.height = height;
    	
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
}
