package cu.cs.cpsc215.project3;

import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Created by Ryan on 4/16/2015.
 */

public class BorderScheme {

    private MatteBorder[] directionalBorders;
    private static int count;

    private static BorderScheme[] bordersDesigns = new BorderScheme[]{
            new BorderScheme(1, Color.BLACK),
            new BorderScheme(1, Color.DARK_GRAY),
            new BorderScheme(1, Color.PINK),
            new BorderScheme(0, Color.WHITE)
    };

    private BorderScheme(int density, Color matteColor) {
        count = 0;
        directionalBorders = new MatteBorder[]{
                new MatteBorder(1 * density, 1 * density, 0 * density, 0 * density, matteColor),
                new MatteBorder(1 * density, 1 * density, 0 * density, 1 * density, matteColor),
                new MatteBorder(1 * density, 1 * density, 1 * density, 0 * density, matteColor),
                new MatteBorder(1 * density, 1 * density, 1 * density, 1 * density, matteColor)
        };

    }

    public static MatteBorder getCorrectBorder(int xCoord, int yCoord, int width, int height){
        if(xCoord < (width -1)){
            if(yCoord < (height -1))
                return(bordersDesigns[count % bordersDesigns.length].directionalBorders[0]);
            else
                return(bordersDesigns[count % bordersDesigns.length].directionalBorders[1]);
        } else {
            if(yCoord < (height -1))
                return(bordersDesigns[count % bordersDesigns.length].directionalBorders[2]);
            else
                return(bordersDesigns[count % bordersDesigns.length].directionalBorders[3]);
        }
    }

    public static void stepBorder(){
        count++;
    }
}
