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
	
	/**
	 * Component colors
	 */
	public static final Color COMPONENT = new Color(203, 224, 255);
	
	/**
	 * Font constant for linux
	 */
	public static final String FONT = "Tlwg Typo";
	/**
	 * Font style
	 */
	public static final int STYLE = Font.BOLD;
	/**
	 * Heading font size
	 */
	public static final int HEADING = 60;
	/**
	 * Subheading font size
	 */
	public static final int SUBHEADING = 35;
	/**
	 * Body font size
	 */
	public static final int BODY = 30;
	/**
	 * Detail text font size
	 */
	public static final int DETAIL = 20;
	/**
	 * Small detail text font size
	 */
	public static final int SMALLERDETAIL = 15;
	
	/**
	 * Background music by Abel Geyskens, obtained from https://freesound.org/s/668879/ under the Attribute 4.0 License
	 */
	public static final String BACKGROUND_MUSIC = "/main/Resources/retro-music.wav";
		
	/**
	 * Background image by Lesiakower via Pixabay under the Content License
	 */
	public static final String BACKGROUND_ANIMATED = "/main/Resources/mountains.png";
	
	/**
	 * Match background
	 */
	public static final String BACKGROUND_BATTLE = "/main/Resources/battle.png";
	/**
	 * Regular background
	 */
	public static final Color BACKGROUND_SOLID = new Color(221, 235, 255);
	
	/**
	 * Athlete names file path
	 */
	public static final String NAME_PATH = "/main/Resources/names.txt";
	/**
	 * Athlete images path
	 */
	public static final String PORTRAIT_PATH = "/main/Resources/athletes/portrait_clear_";
	/**
	 * Team names file path
	 */
	public static final String TEAM_NAME_PATH = "/main/Resources/teamNames.txt";
	/**
	 * Team logo images path
	 */
	public static final String LOGO_PATH = "/main/Resources/logos/";
	/**
	 * Items images path
	 */
	public static final String ITEM_PATH = "/main/Resources/items/";
	
	/**
	 * Number of athlete images
	 */
	public static final int PORTRAIT_COUNT = 24;
	/**
	 * Background color for clear images
	 */
	public static final Color PORTRAIT_BACKGROUND = new Color(203, 224, 255);
	/**
	 * Rollover color for buttons with images
	 */
	public static final Color PORTRAIT_BUTTON_ROLLOVER = new Color(203, 224, 255, 50);
	
	/**
	 * Size of thumbnails
	 */
	public static final int PORTRAIT_SMALL = 250;
	/**
	 * Regular clipped border
	 */
	public static final RoundClipBorder PORTRAIT_BORDER_SMALL = new RoundClipBorder(Color.BLACK, 2, 20);
	/**
	 * Size of detail view images
	 */
	public static final int PORTRAIT_LARGE = 350;
	/**
	 * Thicker clipped border
	 */
	public static final RoundClipBorder PORTRAIT_BORDER_LARGE = new RoundClipBorder(Color.BLACK, 2, 50);
	
	/**
	 * Number of team logos
	 */
	public static final int LOGO_COUNT = 16;
	
	/**
	 * Color for increasing bonus stats
	 */
	public static final Color BONUS_UP = new Color(0, 128, 0);
	/**
	 * Color for decreading bonus stats
	 */
	public static final Color BONUS_DOWN = new Color(255, 0, 0);

	/**
	 * Method to tint images
	 * @param image	image to tint
	 * @param color color to tint
	 * @return		tinted image
	 */
	public static BufferedImage tintImage(BufferedImage image, Color color) {
	    Graphics g = image.getGraphics();
	    g.setColor(color);
	    g.fillRect(0, 0, image.getWidth(), image.getHeight());
	    g.dispose();
	    return image;
	}
}
