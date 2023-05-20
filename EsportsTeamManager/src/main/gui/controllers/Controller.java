package main.gui.controllers;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.gui.GameFrame;
import main.model.GameEnvironment;

/**
 * Abstract class for panel controllers
 * 
 * @author Jiejun Tan
 *
 */
abstract class Controller {

	/**
	 * Game frame
	 */
	protected GameFrame frame;
	
	/**
	 * Game environment
	 */
	protected GameEnvironment game;
	
	/**
	 * Panel under control
	 */
	protected JPanel panel;
	
	/**
	 * Constructor for controller
	 * 
	 * @param frame	game frame to manage navigation
	 */
	protected Controller(GameFrame frame) {
		this.frame = frame;
		this.game = frame.getGame();
	}
	
	/**
	 * Initialize abstract method to implement UI/model interaction
	 */
	abstract protected void initialize();
	
	/**
	 * Wrapper to launch panel
	 */
	protected void launch() {
		frame.launchPanel(panel);
	}
	
	/**
	 * Wrapper to close panel
	 */
	protected void close() {
		frame.closePanel();
	}

	/**
	 * Visually sets the current money.
	 * 
	 * @param moneyLabel label to display
	 */
	protected void setMoney(JLabel moneyLabel) {
		int money = frame.getGame().getData().getMoney();
		moneyLabel.setText("Money: $" + money);
		moneyLabel.setVisible(true);
	}
}
