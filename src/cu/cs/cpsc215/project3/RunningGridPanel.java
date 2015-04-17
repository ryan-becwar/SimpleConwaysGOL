package cu.cs.cpsc215.project3;

import java.util.TimerTask;

/**
 * Running grid panel that extends TimerTask. This takes in a grid panel and runs it conitnously 
 * when it is set on a timer.
 */
public class RunningGridPanel extends TimerTask {
	
	/**
	 * 
	 */
	private GridPanel gridPanel;
	
	/**
	 * Constructor that takes in a given grid panel.
	 * @param gp
	 */
	public RunningGridPanel(GridPanel gp) {
		gridPanel = gp;
	}

	/**
	 * Runs grid panel through continual generations.
	 */
	@Override
	public void run() {
		gridPanel.stepOneGeneration();
	}
}
