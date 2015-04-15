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
                updateColor();
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
    public void updateColor() {
        if(!isAlive){
            currentColor = currentScheme.getLiveColor();
            isAlive = true;
            wasAlive = true;
        } 
        else {
        	isAlive = false;
        	if(wasAlive) {
        		currentColor = currentSceheme.getDeadColor();
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
     * Changes to next scheme.
     */
	public static void changeColorScheme() {
		currentScheme = ColorScheme.getNextScheme();
	}
}
