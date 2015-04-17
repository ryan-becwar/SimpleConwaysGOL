package cu.cs.cpsc215.project3;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Timer;

/**
 * Created by Ryan on 4/6/2015.
 * GameFrame handles the entire graphical interface of the application.
 * Implements Singleton so there is only one gameFrame at a time. It contains
 * a GridPanel holding all cells and allows multiple GameState instances to be saved
 * and loaded
 */
public class GameFrame extends JFrame {
    
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JPanel buttonPanel;
    private JButton stepButton;
    private JButton playButton;
    private JButton resetButton;
    private JButton colorButton;
    private JButton borderButton;
    
    private GridPanel gridPanel = null;
    private static GameFrame gameFrameInstance;
    
    private boolean isPlaying = false;
    private Timer playTimer = new Timer( );
    private RunningGridPanel runningGP;

    /**
     * Constructor that takes in a string as its name.
     * @param name String of the game frame
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
     * Implements and adds all buttons to button panel with appropriate functionality.
     */
    public void buttonSetUp() {
    	
    	//Implement STEP Button
        stepButton = new JButton("Step");
        buttonPanel.add(stepButton);

        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            		runningGP = new RunningGridPanel(gridPanel);
            		playTimer.schedule(runningGP, 0, 50);
            	}
            	else {
            		isPlaying = false;
            		playButton.setText("Play");
            		runningGP.cancel();
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

        //Implement BORDER Button
        borderButton = new JButton("Change Border");
        buttonPanel.add(borderButton);
        borderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridPanel.updateBorder();
            }
        });
    }
    
    /**
     * Implements menu and adds functionality to tabs.
     */
    public void menuSetUp() {
    	gridPanel = new GridPanel(135, 70, 2);
    	getContentPane().add(gridPanel, BorderLayout.NORTH);
    	
    	menuBar = new JMenuBar();
    	
    	JMenu fileMenu = new JMenu("File");
    	JMenu helpMenu = new JMenu("Help");
    	JMenu subDesignMenu = new JMenu("Sub-Designs");

    	JMenuItem open = new JMenuItem("Open");
    	JMenuItem saveAs = new JMenuItem("Save As");
    	
    	helpMenu.add(new JMenuItem("Sorry, this is life, you get no help!"));
    	fileMenu.add(open);
    	fileMenu.add(saveAs);

        final JMenuItem gliderItem = new JMenuItem("Glider");
        final JMenuItem gliderGunItem = new JMenuItem("Glider Gun");
        final JMenuItem fastSpaceshipItem = new JMenuItem("Fast Spaceship");
        final JMenuItem lwssItem = new JMenuItem("LWSS");
        
        subDesignMenu.add(gliderItem);
        subDesignMenu.add(gliderGunItem);
        subDesignMenu.add(fastSpaceshipItem);
        subDesignMenu.add(lwssItem);

        gliderItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertSubDesign(new GliderDesign());
            }
        });

        gliderGunItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertSubDesign(new GliderGunDesign());
            }
        });

        fastSpaceshipItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertSubDesign(new FastSpaceshipDesign());
            }
        });

        lwssItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertSubDesign(new LWSSDesign());
            }
        });

        open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadGridPanel();
			}	
    	});
    	
    	saveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveGridPanel();
			}	
    	});
    	
    	menuBar.add(fileMenu);
    	menuBar.add(helpMenu);
        menuBar.add(subDesignMenu);
    	
    	setJMenuBar(menuBar);
    }

    /**
     * Handles the frame side of inserting a specified subdesign
     * @param design
     */
    private void insertSubDesign(SubDesign design){
        int xCoord = 0;
        int yCoord = 0;
        try {
            xCoord = Integer.parseInt(JOptionPane.showInputDialog("Enter the x coordinate to insert at:"));
            yCoord = Integer.parseInt(JOptionPane.showInputDialog("Enter the y coordinate to insert at:"));
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            System.out.println("User entered something besides a bounded integer!");
        }
        gridPanel.insertSubDesign(xCoord, yCoord, design.getWidth(), design.getHeight(), design.getDesign());
    }
    /**
     * Saves grid panel by serializing the gameState.
     */
    private void saveGridPanel() {
    	String fileName = (String)JOptionPane.showInputDialog("Enter name of file to save it.");
        String filePathway = System.getProperty("user.dir") + "/src/cu/cs/cpsc215/project3/savedGameStates/";
        if(!new File(filePathway).exists())
            filePathway = System.getProperty("user.dir") + "/cu/cs/cpsc215/project3/savedGameStates/";
        filePathway += fileName + ".ser";
    	
        try
        {
           FileOutputStream fileOut = new FileOutputStream(filePathway);
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
            gridPanel.preserveGameState();
           out.writeObject(gridPanel.getGameState());
           out.close();
           fileOut.close();
           System.out.printf("Serialized data is saved in " + filePathway);
           
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
    
    /**
     * Attempts to load gridPane by opening a serialized gameState.
     */
    private void loadGridPanel() {
    	String fileName = JOptionPane.showInputDialog("Enter name of file to upload it!");
        String filePathway = System.getProperty("user.dir") + "/src/cu/cs/cpsc215/project3/savedGameStates/";
        if(!new File(filePathway).exists())
            filePathway = System.getProperty("user.dir") + "/cu/cs/cpsc215/project3/savedGameStates/";
        filePathway += fileName + ".ser";
        System.out.println(filePathway);
    	try
        {
           FileInputStream fileIn = new FileInputStream(filePathway);
           ObjectInputStream in = new ObjectInputStream(fileIn);
           gridPanel.setGameState((GameState) in.readObject());
           gridPanel.rebuildFromGameState();
           in.close();
           fileIn.close();
        } catch(FileNotFoundException f){
            System.out.println("User entered an invalid file name!");
            return;
        } catch(IOException i)
        {
           i.printStackTrace();
           return;
        }
    	catch(ClassNotFoundException c)
        {
           System.out.println("GameState class not found");
           c.printStackTrace();
           return;
        }
    }
    
    
    /**
     * Made a singleton to ensure only one instance of the gameframe is running.
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
