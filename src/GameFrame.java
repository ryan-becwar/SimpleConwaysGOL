import javax.swing.*;
import java.awt.*;

/**
 * Created by Ryan on 4/6/2015.
 */
public class GameFrame extends JFrame {

    private JPanel buttonPanel;
    private JButton stepButton;
    private JButton playButton;
    private JButton resetButton;
    private static GameFrame gameFrameInstance;

    private GameFrame(String name) {
        super(name);

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        buttonPanel = new JPanel();
        add(buttonPanel);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        stepButton = new JButton("Step");
        playButton = new JButton("Play");
        resetButton = new JButton("Reset");
        
        buttonPanel.add(stepButton);
        buttonPanel.add(playButton);
        buttonPanel.add(resetButton);
    }

    public static GameFrame getInstance(String name) {
        if(gameFrameInstance == null)
           gameFrameInstance = new GameFrame(name);
        return gameFrameInstance;
    }

}
