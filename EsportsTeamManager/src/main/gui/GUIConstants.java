package main.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Constant values for UI components to maintain uniformity.
 * @author Jiejun Tan
 *
 */
public final class GUIConstants {
	
	// Component colors
	public static final Color COMPONENT = new Color(203, 224, 255);
	
	// Fonts
	public static final String FONT = "Tlwg Typo";
	public static final int STYLE = Font.BOLD;
	public static final int HEADING = 60;
	public static final int SUBHEADING = 35;
	public static final int BODY = 30;
	public static final int DETAIL = 20;
	public static final int SMALLERDETAIL = 15;
	
	// Background music by Abel Geyskens, obtained from https://freesound.org/s/668879/ under the Attribute 4.0 License
	public static final String BACKGROUND_MUSIC = "/main/resources/retro-music.wav";
		
	// Backgrounds
	// Background image by Lesiakower via Pixabay under the Content License
	public static final String BACKGROUND_ANIMATED = "/main/resources/mountains.png";
	public static final String BACKGROUND_BATTLE = "/main/resources/battle.png";
	public static final Color BACKGROUND_SOLID = new Color(221, 235, 255);
	
	// Athlete portraits
	public static final int PORTRAIT_COUNT = 24;
	
	public static final Color PORTRAIT_BACKGROUND = new Color(203, 224, 255);
	public static final Color PORTRAIT_BUTTON_ROLLOVER = new Color(203, 224, 255, 50);
	
	public static final int PORTRAIT_SMALL = 250;
	public static final RoundClipBorder PORTRAIT_BORDER_SMALL = new RoundClipBorder(Color.BLACK, 2, 20);
	
	public static final int PORTRAIT_LARGE = 350;
	public static final RoundClipBorder PORTRAIT_BORDER_LARGE = new RoundClipBorder(Color.BLACK, 2, 50);
	
	// Team Logos
	public static final int LOGO_COUNT = 16;
	
	// Color for bonus stats
	public static final Color BONUS_UP = new Color(0, 128, 0);
	public static final Color BONUS_DOWN = new Color(255, 0, 0);

	// Tints images
	public static BufferedImage tintImage(BufferedImage image, Color color) {
	    Graphics g = image.getGraphics();
	    g.setColor(color);
	    g.fillRect(0, 0, image.getWidth(), image.getHeight());
	    g.dispose();
	    return image;
	}
}
