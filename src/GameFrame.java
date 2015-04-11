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
    
    private JMenuBar menuBar;

    private GridPanel gridPanel;
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

        gridPanel = new GridPanel(600, 400, 20);
        getContentPane().add(gridPanel, BorderLayout.NORTH);
        
        menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View"); 
        JMenu helpMenu = new JMenu("Help");
        
        helpMenu.add(new JMenuItem("Sorry, this is life, you get no help!"));
        fileMenu.add(new JMenuItem("Open..."));
        fileMenu.add(new JMenuItem("Save As..."));
        viewMenu.add(new JMenuItem("More to come"));
        
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
    }

    //made a singleton to ensure only one instance of the gameframe is running.
    public static GameFrame getInstance(String name) {
        if(gameFrameInstance == null)
           gameFrameInstance = new GameFrame(name);
        return gameFrameInstance;
    }

}
