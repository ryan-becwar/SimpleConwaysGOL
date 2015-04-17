package cu.cs.cpsc215.project3;

/**
 * Created by Ryan on 4/16/2015.
 * This is an insert-able design into a grid panel that creates a Fast Spaceship.
 */
public class FastSpaceshipDesign extends SubDesign {
    public FastSpaceshipDesign() {
        height = 4;
        width = 5;
        design = new boolean[][] {
                {false, false, false, true, false},
                {false, false, false, false, true},
                {true, false, false, false, true,},
                {false, true, true, true, true}
        };
    }
}
