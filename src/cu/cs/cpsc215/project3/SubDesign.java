package cu.cs.cpsc215.project3;

/**
 * Created by Ryan on 4/15/2015.
 * Base class for all future sub designs 
 * which can be inserted into an existing grid panel.
 */
public abstract class SubDesign{

	/**
	 * height of the design
	 */
    int height;
    
    /**
     * width of the design
     */
    int width;
    
    /**
     * boolean of arrays that determine what cells should be turned on and off,
     * results in a grid panel configuration of the given subdesign
     */
    boolean[][] design;

    /**
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * @return design as boolean array
     */
    public boolean[][] getDesign() {
        return design;
    }
}
