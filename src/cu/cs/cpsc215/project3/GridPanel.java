package cu.cs.cpsc215.project3;


import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Ryan on 4/8/2015
 * This class represents the grid that will graphically display all cell activity.
 * The gameState which is a grid of booleans representing what cells are alive and dead
 * will be serialized.
 */
public class GridPanel extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private GameState gameState;

	private GridBagConstraints gbConst;
    private CellPanel[][] cells;
	private MatteBorder b;

    /**
     * Constructs a new gridPanel.
     * @param width to be set to for the grid panel
     * @param height to be set to for the grid panel
     * @param cellPixWidth
     */
    public GridPanel(int width, int height, int cellPixWidth) {
    	
    	this.width = width;
    	this.height = height;
    	gameState = new GameState(width, height);
    	
        this.setLayout(new GridBagLayout());
        gbConst = new GridBagConstraints();
        this.setVisible(true);

        cells = new CellPanel[width][height];

        //step horizontally first, fill a row, and then step vertically
        for(int r=0; r< height; r++) {
            for(int c=0; c<width; c++) {
                gbConst.gridx = c;
                gbConst.gridy = r;

                cells[c][r] = new CellPanel();


                //Logic to handle cell border thickness
				b = BorderScheme.getCorrectBorder(c, r, width, height);
                cells[c][r].setBorder(b);

                add(cells[c][r], gbConst);
            }
        }
		BorderScheme.stepBorder();
    }
    
    /**
     * Sets cell state based off of game state.
     */
    public void rebuildFromGameState(){
    	reset();
    	
       	for(int r =0; r <  height; r++) {
    		for(int c = 0; c < width; c++) {
    			cells[c][r].setState(gameState.getCellState(c, r));
    			} 
    		}
       	updateColorChange();
    }
    
    /**
     * Resets all cells as if they are new.
     */
    public void reset() {
    	
    	for(int r =0; r <  height; r++) {
    		for(int c = 0; c < width; c++) {
    			cells[c][r].clear();
    			} 
    		}
    }
    
    /**
     * Calculates the number of live neighbors the cell at column c and
     * row r has.
     * @param c
     * @param r
     * @return
     */
    public int getCellNeighbors(int c, int r) {
    	int n = 0;
    	
    	for(int i = c - 1; i <= c +1; i++) {
    		for(int j = r - 1; j <= r + 1; j++) {
    			if(i >= 0 && i < width && j >= 0 && j < height) {
    					if(cells[i][j].getState()){
    						n++;
    					}
    			}
    		}
    	}
    	
    	if(cells[c][r].getState()) n--; //discounts itself if was turned on
    		return n;
    }

    /**
     * Iterates cells through one generation
     */
    public void stepOneGeneration(){
    	
    	boolean[][] toChange = new boolean[width][height]; //Initialized to all false
    	
    	for(int r = 0; r <  height; r++) {
    		for(int c = 0; c < width; c++) {
    			CellPanel currentCell = cells[c][r];
    			int liveNeighbors = getCellNeighbors(c,r);
    			
    			if(currentCell.getState()) {
    				if(liveNeighbors < 2 || liveNeighbors > 3) {
    					//cell must die
    					toChange[c][r] = true;
    					gameState.setCellState(c, r, false);
    				}
    				else {
    					gameState.setCellState(c, r, true);
    				}
    			}
    			else {
    				//cell will be revived
    				if(liveNeighbors == 3) {
    					toChange[c][r] = true;
    					gameState.setCellState(c, r, true);
    				}
    				else {
    					gameState.setCellState(c, r, false);
    				}
    			} 
    		}
    	}
    	
    	for(int r =0; r <  height; r++) {
    		for(int c = 0; c < width; c++) {
    			if(toChange[c][r]) cells[c][r].updateState();
    		}
    	}
    }

	/**
	 * Inserts the specified subdesign at the given coordinates, with the top left corner of the subdesign
	 * starting at the given coordinate
	 * @param xCoord
	 * @param yCoord
	 * @param width
	 * @param height
	 * @param design
	 */
	public void insertSubDesign(int xCoord, int yCoord, int width, int height, boolean[][] design){
			for( int r = yCoord; r < yCoord + height; r++){
				for(int c = xCoord; c < xCoord + width; c++){
					if(r < this.height) {
						if(c < this.width) {
							cells[c][r].setState(design[r - yCoord][c - xCoord]);
						}
					}
				}
			}
	}

	/*
	 * Updates colors of all cells in the grid panel.
	 */
	public void updateColorChange() {
		for(int r=0; r <height; r++){
			for(int c=0; c<width; c++){
				cells[c][r].updateColor();
			}
		}
	}

	/**
	 * updates the border of the grid panel
	 */
	public void updateBorder() {
		for(int r=0; r< height; r++){
			for(int c=0; c<width; c++){
				b = BorderScheme.getCorrectBorder(c, r, width, height);
				cells[c][r].setBorder(b);
			}
		}
		BorderScheme.stepBorder();
	}

	/**
	 * Sets game state
	 * @param readObject
	 */
	public void setGameState(GameState readObject) {
		gameState = readObject;
	}

	/**
	 * Ensures that the gamestate is equivalent to the current grid
	 *
	 * To be called immediately before saving the game
	 */
	public void preserveGameState(){
		for(int r=0; r< height; r++){
			for(int c=0; c<width; c++){
				gameState.setCellState(c, r, cells[c][r].getState());
			}
		}
	}
	
	/**
	 * Returns game state
	 * @return
	 */
	public GameState getGameState() {
		return gameState;
	}

}
