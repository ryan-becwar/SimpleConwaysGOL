package cu.cs.cpsc215.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Ryan on 4/8/2015.
 * Represents a cell in the grid panel. 
 */
public class CellPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Boolean that monitors if mouse is dragging.
	 * If mouse is dragging then a cell panel entered into it will turn on.
	 * Otherwise a cell is turned on by click.
	 */
	private static boolean mouseIsDragging = false;
	
	/**
	 * ColorScheme shared by all cells; can be changed.
	 */
	private static ColorScheme currentScheme = ColorScheme.getNextScheme();

	/**
	 * Boolean that keeps track of whether the cell is "alive" or "dead."
	 */
	private boolean isAlive;
	
	/**
	 * Boolean to monitor if cell has ever been alive; this dictates color later on.
	 */
    private boolean wasAlive;
    
    /**
     * current color of the cell.
     */
    private Color currentColor;    

    /**
     * Default constructor, begins turned off with a white background.
     */
    public CellPanel() {
        currentColor = Color.WHITE;
        setBackground(currentColor);
        isAlive = false;
        wasAlive = false;

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(currentScheme.getLiveColor());
                if(mouseIsDragging) updateState();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(currentColor);
                repaint();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            	updateState();
            	mouseIsDragging = true;
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
            	mouseIsDragging = false;
            }
        });
    }
    
    /**
     * Implemented by Grace. 
     * Resets the cell's information as if it were brand new.
     */
    public void clear() {
    	currentColor = Color.WHITE;
    	setBackground(currentColor);
    	isAlive = false;
    	wasAlive = false;
    }

    /**
     * Updates color appropriately. 
     */
    public void updateState() {
        if(!isAlive){
            isAlive = true;
            wasAlive = true;
        } 
        else {
        	isAlive = false;
        }
        updateColor();
    }

    /**
     * Updates color based on state the cell is in.
     */
    public void updateColor(){
        if(isAlive){
            currentColor = currentScheme.getLiveColor();
        }
        else {
            if(wasAlive) {
                currentColor = currentScheme.getDeadColor();
            }
            else {
                currentColor = Color.WHITE;
            }
        }
        setBackground(currentColor);
        this.repaint();
    }

    /**
     * Returns if the cell is alive or not
     * @return isAlive
     */
    public boolean getState(){
        return isAlive;
    }

    /**
     * sets state with new boolean
     * @param s
     */
    public void setState(boolean s){
        if(isAlive) {
            wasAlive = true;
        }
        isAlive = s;
        updateColor();
    }
    
    /**
     * Changes to next scheme.
     */
	public static void changeColorScheme() {
		currentScheme = ColorScheme.getNextScheme();
	}
}
