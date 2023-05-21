package main.gui.subclassable;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GUIConstants;
import main.gui.GameFrame;

/**
 * Abstract class for detail panel controllers
 * 
 * @author Jiejun Tan
 *
 */
public abstract class DetailController extends Controller {

	/**
	 * Constructor for controller
	 * 
	 * @param frame	game frame to manage navigation
	 */
	protected DetailController(GameFrame frame) {
		super(frame);
	}

	/**
	 * Sets the portrait for object in view
	 * 
	 * @param portraitLabel label to set icon
	 * @param path 			path of image
	 */
	protected void setPortrait(JLabel portraitLabel, String path) {
		BufferedImage portraitImage = null;
		try {
			portraitImage = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		portraitLabel.setIcon(new ImageIcon(portraitImage
				.getScaledInstance(GUIConstants.PORTRAIT_LARGE, GUIConstants.PORTRAIT_LARGE, Image.SCALE_DEFAULT)));
	}
	
	/**
	 * All detail panels must have a return button, initialize it
	 */
	protected void initializeBackButton() {
		JButton backButton = ((DetailPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Previous screen method can be used by back button or after performing action
	 */
	protected abstract void toPreviousScreen();

}
