package cu.cs.cpsc215.project3;

import javax.swing.*;

/**
 * Created by Ryan on 4/15/2015.
 */
public abstract class SubDesign extends JMenuItem{

    int height;
    int width;
    boolean[][] design;

    public SubDesign(String name){
        super(name);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean[][] getDesign() {
        return design;
    }
}
