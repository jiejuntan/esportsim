package main.gui.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.gui.GUIConstants;
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
	public Controller(GameFrame frame) {
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
	 * Format thumbnail icons.
	 * 
	 * @param button		button to format
	 * @param portraitPath 	path of image
	 */
	protected void formatButtonIcon(JButton button, String portraitPath) {
		button.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		BufferedImage portraitImage = null;
		try {
			portraitImage = ImageIO.read(new File(getClass()
					.getResource(portraitPath)
					.toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		button.setIcon(new ImageIcon(portraitImage
				.getScaledInstance(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL, Image.SCALE_DEFAULT)));
		button.setRolloverIcon(
				new ImageIcon(GUIConstants
						.tintImage(portraitImage, GUIConstants.PORTRAIT_BUTTON_ROLLOVER)
						.getScaledInstance(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL, Image.SCALE_DEFAULT)));
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
