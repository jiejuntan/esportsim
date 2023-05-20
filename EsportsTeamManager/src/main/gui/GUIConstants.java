package main.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Constant values for UI components to maintain uniformity.
 * @author Jiejun Tan
 *
 */
public class GUIConstants {
	
	// Component colors
	public static final Color COMPONENT = Color.LIGHT_GRAY;
	
	// Fonts
	public static final String FONT = "Unispace";
	public static final int HEADING = 50;
	public static final int SUBHEADING = 40;
	public static final int BODY = 30;
	public static final int DETAIL = 20;
	
	// Backgrounds
	public static final String BACKGROUND_PLACEHOLDER = "/main/Resources/mountains.png";
	
	// Audio
	public static final String BACKGROUND_MUSIC = "/main/Resources/retro-music.wav";
	
	// Athlete portraits
	public static final String PORTRAIT_PLACEHOLDER = "/main/Resources/placeholder_portrait.jpg";
	public static final int PORTRAIT_SMALL = 250;
	public static final RoundClipBorder PORTRAIT_BORDER_SMALL = new RoundClipBorder(Color.BLACK, 2, 20, 0);
	public static final int PORTRAIT_LARGE = 350;
	public static final RoundClipBorder PORTRAIT_BORDER_LARGE = new RoundClipBorder(Color.BLACK, 2, 50, 0);

	public static final Color PORTRAIT_BUTTON_ROLLOVER = new Color(255, 255, 255, 50);
	
	// Color for bonus stats
	public static final Color BONUS_UP = new Color(0, 128, 0);
	public static final Color BONUS_DOWN = new Color(255, 0, 0);

	public static BufferedImage tintImage(BufferedImage image, Color color) {
	    Graphics g = image.getGraphics();
	    g.setColor(color);
	    g.fillRect(0, 0, image.getWidth(), image.getHeight());
	    g.dispose();
	    return image;
	}
}
