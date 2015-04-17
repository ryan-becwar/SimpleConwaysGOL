package cu.cs.cpsc215.project3;

/**
 * Created by Ryan on 4/15/2015.
 */
public class GliderDesign extends SubDesign {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GliderDesign(String name){
        super(name);
        height = 3;
        width = 3;
        design = new boolean[][]{{false, true, false},
                                 {false, false, true},
                                 {true, true, true}};
    }
}
