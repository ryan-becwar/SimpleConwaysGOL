package cu.cs.cpsc215.project3;

/**
 * Created by Ryan on 4/15/2015.
 * GliderGunDesign that is insert-able into a given grid panel.
 */
public class GliderGunDesign extends SubDesign {
    public GliderGunDesign() {
        height = 9;
        width = 36;
        design = new boolean[][] {
                {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false ,false, true, false, false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true ,false, true, false, false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, true, true, false ,false, false, false, false, false, false, false, false, false, false, false, true, true},
                {false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false, true, true, false ,false, false, false, false, false, false, false, false, false, false, false, true, true},
                {true, true, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, true, true, false ,false, false, false, false, false, false, false, false, false, false, false, false, false},
                {true, true, false, false, false, false, false, false, false, false, true, false, false, false, true, false, true, true, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false ,false, true, false, false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false ,false, false, false, false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false ,false, false, false, false, false, false, false, false, false, false, false, false, false}
        };
    }
}
