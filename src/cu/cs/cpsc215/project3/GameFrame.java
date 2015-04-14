package cu.cs.cpsc215.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Ryan on 4/6/2015.
 */
public class GameFrame extends JFrame {
    
    private JPanel buttonPanel;
    private JButton stepButton;
    private JButton playButton;
    private JButton resetButton;
    
    private boolean isPlaying = false;
    
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

        gridPanel = new GridPanel(30, 20, 20);
        getContentPane().add(gridPanel, BorderLayout.NORTH);

        buttonSetUp();
        menuSetUp();
    }
    
    public void buttonSetUp() {
    	
        stepButton = new JButton("Step");
        buttonPanel.add(stepButton);

        
        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	gridPanel.stepOneGeneration();
            	//fire changes
            	repaint();
            }
        });  
         
        playButton = new JButton("Play");
        buttonPanel.add(playButton);
        
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if(!isPlaying) {
            		playButton.setText("Pause");
            		isPlaying = true;
            		
            		while(isPlaying) {
            			gridPanel.stepOneGeneration();
            			repaint();
            		}
            	}
            	else {
            		playButton.setText("Play");
            		isPlaying = false;
            	}
            	repaint();
            }
        });
        
        resetButton = new JButton("Reset");
        buttonPanel.add(resetButton);
        
        resetButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gridPanel = new GridPanel(30, 20, 20);
                getContentPane().add(gridPanel, BorderLayout.NORTH);
        		//fire changes
                repaint();
        	}
        });
    }
    
    public void menuSetUp() {
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
