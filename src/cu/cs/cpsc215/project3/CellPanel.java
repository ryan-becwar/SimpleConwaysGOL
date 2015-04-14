package cu.cs.cpsc215.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Ryan on 4/8/2015.
 */
public class CellPanel extends JPanel {
    private Boolean curState;
    private Boolean updatedState;
    private Color currentColor;

    public CellPanel(){
        curState = false;
        updatedState = false;
        currentColor = Color.WHITE;
        setBackground(currentColor);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                curState = !curState;
                updatedState = curState;
                updateColor();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.BLUE);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(currentColor);
                repaint();
            }
        });

    }


    private void updateColor() {
        if(curState){
            currentColor = Color.WHITE;
            setBackground(currentColor);
        } else {
            currentColor = Color.BLACK;
        }
        this.repaint();
    }

    public void stepGeneration(){
        curState = updatedState;
    }

    public void updateState(boolean newState){
        updatedState = newState;
    }

    public boolean getState(){
        return curState;
    }
}
