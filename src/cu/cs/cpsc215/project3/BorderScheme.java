package cu.cs.cpsc215.project3;

import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Created by Ryan on 4/16/2015.
 */
public class BorderScheme extends MatteBorder {

    private static BorderScheme[] borders = {};
    public BorderScheme(int top, int left, int bottom, int right, Color matteColor) {
        super(top, left, bottom, right, matteColor);
    }
}
