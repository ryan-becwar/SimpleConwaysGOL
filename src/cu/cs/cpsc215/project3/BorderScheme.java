package cu.cs.cpsc215.project3;

import javax.swing.border.MatteBorder;
import java.awt.*;


/**
 * Created by Ryan on 4/16/2015.
 * Designed to handle selecting the correct one out of
 * the multiple different border states a user might choose for
 * each cell
 */
public class BorderScheme {

	/**
	 * Array of Borders different schemes can be returned from.
	 */
    private MatteBorder[] directionalBorders;
    
    private static int count;

    /**
     * Private array ensures limited creation of BorderScheme instances.
     */
    private static BorderScheme[] bordersDesigns = new BorderScheme[]{
            new BorderScheme(1, Color.BLACK),
            new BorderScheme(1, Color.GRAY),
            new BorderScheme(1, Color.MAGENTA),
            new BorderScheme(2, Color.GRAY),
            new BorderScheme(1, Color.WHITE),
            new BorderScheme(0, Color.WHITE)
    };

    /**
     * Private constructor ensures limited creation of BorderScheme Instances
     * @param density of the border
     * @param matteColor of the border
     */
    private BorderScheme(int density, Color matteColor) {
        count = 0;
        directionalBorders = new MatteBorder[]{
                new MatteBorder(1 * density, 1 * density, 0 * density, 0 * density, matteColor),
                new MatteBorder(1 * density, 1 * density, 0 * density, 1 * density, matteColor),
                new MatteBorder(1 * density, 1 * density, 1 * density, 0 * density, matteColor),
                new MatteBorder(1 * density, 1 * density, 1 * density, 1 * density, matteColor)
        };
    }

    /**
     * Returns a corrected border based on the coordinates of a given location.
     * @param xCoord coordinate of location
     * @param yCoord coordinate of location
     * @param width of grid
     * @param height of height
     * @return appropriate matte border
     */
    public static MatteBorder getCorrectBorder(int xCoord, int yCoord, int width, int height){
        if(xCoord < (width -1)){
            if(yCoord < (height -1))
                return(bordersDesigns[count % bordersDesigns.length].directionalBorders[0]);
            else
                return(bordersDesigns[count % bordersDesigns.length].directionalBorders[2]);
        } else {
            if(yCoord < (height -1))
                return(bordersDesigns[count % bordersDesigns.length].directionalBorders[1]);
            else
                return(bordersDesigns[count % bordersDesigns.length].directionalBorders[3]);
        }
    }

    /**
     * Increments through given borders.
     */
    public static void stepBorder(){
        count++;
    }
}
