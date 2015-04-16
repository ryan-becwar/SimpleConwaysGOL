package cu.cs.cpsc215.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Ryan on 4/8/2015.
 */
public class CellPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean isAlive;
    private boolean wasAlive;
    private static ColorScheme currentScheme = ColorScheme.getNextScheme();
    
    private Color currentColor;

    public CellPanel(){
        currentColor = Color.WHITE;
        setBackground(currentColor);
        isAlive = false;
        wasAlive = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateState();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(currentScheme.getLiveColor());
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(currentColor);
                repaint();
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
        isAlive = s;
    }
    
    /**
     * Changes to next scheme.
     */
	public static void changeColorScheme() {
		currentScheme = ColorScheme.getNextScheme();
	}
}
