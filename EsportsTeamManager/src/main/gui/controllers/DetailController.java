package main.gui.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.gui.GUIConstants;
import main.gui.GameFrame;

/**
 * Abstract class for detail panel controllers
 * 
 * @author Jiejun Tan
 *
 */
abstract class DetailController extends Controller {

	/**
	 * Constructor for controller
	 * 
	 * @param frame	game frame to manage navigation
	 */
	public DetailController(GameFrame frame) {
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
			portraitImage = ImageIO.read(new File(getClass()
					.getResource(path)
					.toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		portraitLabel.setIcon(new ImageIcon(portraitImage
				.getScaledInstance(GUIConstants.PORTRAIT_LARGE, GUIConstants.PORTRAIT_LARGE, Image.SCALE_DEFAULT)));
	}

}
