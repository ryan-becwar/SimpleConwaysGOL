package cu.cs.cpsc215.project3;

import javafx.scene.control.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ryan on 4/8/2015.
 */
public class GridPanel extends JPanel {

    private GridBagConstraints gbConst;

    private CellPanel[][] cells;
    //serializing the GridPanel object should be more effective and efficient than
    //maintaining and serializing a gameState object
//    private GameState gameState;

    public GridPanel(int width, int height, int cellPixWidth) {
        this.setLayout(new GridBagLayout());
        gbConst = new GridBagConstraints();
        this.setVisible(true);

        cells = new CellPanel[width][height];

        //step horizontally first, fill a row, and then step vertically
        for(int r=0; r< height; r++) {
            for(int c=0; c<width; c++) {
                cells[c][r] = new CellPanel();

                //Logic to handle cell border thickness

                add(cells[c][r], gbConst);
            }
        }
    }

    public void stepOneGeneration(){

    }

}
