package cu.cs.cpsc215.project3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ryan on 4/8/2015.
 */
public class GridPanel extends JPanel {

    private GridBagConstraints gbConst;
    private GameState gameState;

    public GridPanel(int width, int height, int cellPixWidth) {
        this.setLayout(new GridBagLayout());
        gbConst = new GridBagConstraints();
        this.setVisible(true);


    }

}
