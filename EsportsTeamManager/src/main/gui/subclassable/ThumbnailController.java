package main.gui.subclassable;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.gui.GUIConstants;
import main.gui.GameFrame;

/**
 * Abstract class for thumbnail panel controllers
 * 
 * @author Jiejun Tan
 *
 */
public abstract class ThumbnailController extends Controller {

	/**
	 * Constructor for controller
	 * 
	 * @param frame	game frame to manage navigation
	 */
	protected ThumbnailController(GameFrame frame) {
		super(frame);
	}

	/**
	 * Format thumbnail icons.
	 * 
	 * @param button		button to format
	 * @param portraitPath 	path of image
	 */
	protected void formatButtonIcon(JButton button, String portraitPath) {
		button.setVisible(true);
		BufferedImage portraitImage = null;
		try {
			portraitImage = ImageIO.read(getClass().getResource(portraitPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		button.setIcon(new ImageIcon(portraitImage
				.getScaledInstance(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL, Image.SCALE_DEFAULT)));
		button.setRolloverIcon(
				new ImageIcon(GUIConstants
						.tintImage(portraitImage, GUIConstants.PORTRAIT_BUTTON_ROLLOVER)
						.getScaledInstance(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL, Image.SCALE_DEFAULT)));
	}
	
}
