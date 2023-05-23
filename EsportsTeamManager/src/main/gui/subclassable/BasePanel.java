package main.gui.subclassable;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.gui.GUIConstants;

/**
 * Basic panel that subclasses all other panels, contains common setup methods
 * 
 * @author Jiejun Tan
 */
public class BasePanel extends JPanel {

	/**
	 * Constructor for base panel.
	 */
	protected BasePanel() {
		this.setBackground(GUIConstants.BACKGROUND_SOLID);
	}
	
	/**
	 * Performs common setup methods for titles
	 * @param title	title to setup
	 */
	protected void setupTitle(JLabel title) {
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.HEADING));
	}
	
	/**
	 * Performs common setup methods for subheadings
	 * @param subheading	subheading to setup
	 */
	protected void setupSubheading(JLabel subheading) {
		subheading.setHorizontalAlignment(SwingConstants.CENTER);
		subheading.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.SUBHEADING));
	}
	
	/**
	 * Performs common setup methods for buttons
	 * @param button	button to setup
	 */
	protected void setupButton(JButton button) {
		button.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		button.setPreferredSize(new Dimension(250, 50));
		button.setFocusPainted(false);
		button.setBackground(GUIConstants.COMPONENT);
		button.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
	}
	
	/**Performs common setup methods for thumbnails
	 * @param button	thumbnail to setup
	 */
	protected void setupThumbnail(JButton button) {
		button.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		button.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		button.setBackground(GUIConstants.PORTRAIT_BACKGROUND);
		button.setEnabled(false);
		button.setVisible(false);
	}

}
