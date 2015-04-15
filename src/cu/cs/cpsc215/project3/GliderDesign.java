package cu.cs.cpsc215.project3;

/**
 * Created by Ryan on 4/15/2015.
 */
public class GliderDesign extends SubDesign {

    public GliderDesign(){
        super("Glider");
        height = 3;
        width = 3;
        design = new boolean[][]{{false, true, true},
                                 {false, false, true},
                                 {true, true, true}};
    }
}
