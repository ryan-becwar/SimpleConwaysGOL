import javax.swing.*;

/**
 * Created by Ryan on 4/6/2015.
 */
public class MainDriver {
    public static void main(String args[]){
        GameFrame window = GameFrame.getInstance("Conway's Game of Life");
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
