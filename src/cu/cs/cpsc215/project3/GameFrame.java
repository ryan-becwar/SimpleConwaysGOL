package cu.cs.cpsc215.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Ryan on 4/6/2015.
 */
public class GameFrame extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
    private JButton stepButton;
    private JButton playButton;
    private JButton resetButton;
    private JButton colorButton;
    
    private boolean isPlaying = false;
    
    private JMenuBar menuBar;

    private GridPanel gridPanel;
    private static GameFrame gameFrameInstance;

    /**
     * 
     * @param name
     */
    private GameFrame(String name) {
        super(name);

        setSize(1800, 1000);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        buttonPanel = new JPanel();
        add(buttonPanel);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        buttonSetUp();
        menuSetUp();
    }
    
    /**
     * Implements and adds all buttons to button panel.
     */
    public void buttonSetUp() {
    	
    	//Implement STEP Button
        stepButton = new JButton("Step");
        buttonPanel.add(stepButton);

        
        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Step pressed!");
            	gridPanel.stepOneGeneration();
            }
        });  
         
        //Implement PLAY Button
        playButton = new JButton("Play");
        buttonPanel.add(playButton);
        
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(!isPlaying) {
            		isPlaying = true;
            		playButton.setText("Pause");
            	}
            	else {
            		isPlaying = false;
            		playButton.setText("Play");
            	}
            	buttonPanel.repaint();
            }
        });
        
        //Implement RESET Button
        resetButton = new JButton("Reset");
        buttonPanel.add(resetButton);
        
        resetButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gridPanel.reset();
        		gridPanel.reset();
        	}
        });
        
        //Implement COLOR Button
        colorButton = new JButton("Change Color Scheme");
        buttonPanel.add(colorButton);
        
        colorButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CellPanel.changeColorScheme();
                gridPanel.updateColorChange();
        	}
        });
    }
    
    /**
     * 
     */
    public void menuSetUp() {
        gridPanel = new GridPanel(135, 70, 2);
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

    /**
     * made a singleton to ensure only one instance of the gameframe is running.
     * 
     * @param name
     * @return
     */
    public static GameFrame getInstance(String name) {
        if(gameFrameInstance == null)
           gameFrameInstance = new GameFrame(name);
        return gameFrameInstance;
    }
}
