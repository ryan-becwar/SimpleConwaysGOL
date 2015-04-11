package cu.cs.cpsc215.project3;

import javax.swing.*;

/**
 * Created by Ryan on 4/6/2015.
 *
 * Collaboration of Ryan Becwar and Grace Glenn
 */
public class MainDriver {
    public static void main(String args[]){
        GameFrame window = GameFrame.getInstance("Conway's Game of Life");
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
