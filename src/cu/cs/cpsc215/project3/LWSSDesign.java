package cu.cs.cpsc215.project3;

/**
 * Created by Ryan on 4/16/2015.
 * LWSS Design that is insert-able into a given grid panel. (explodes)
 * Expands rapidly into an interesting pattern
 */
public class LWSSDesign extends SubDesign {
    public LWSSDesign() {
        height = 5;
        width = 8;
        design = new boolean[][]{
                {false, false, false, false, true, true, true, false},
                {false, false, false, true, false, false, false, false},
                {true, false, false, false, false, false, true, false},
                {false, true, true, false, false, true, false, true},
                {false, true, false, true, false, false, false, false}
        };
    }
}
