package cu.cs.cpsc215.project3;

/**
 * Created by Ryan on 4/15/2015.
 * GliderDesign that is insert-able into a given grid panel.
 */
public class GliderDesign extends SubDesign {

	/**
	 * Default constructor
	 */
	public GliderDesign(){
        height = 3;
        width = 3;
        design = new boolean[][]{{false, true, false},
                                 {false, false, true},
                                 {true, true, true}};
    }
}
