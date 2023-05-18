package main.gui;

import java.awt.Color;

import main.Resources.RoundClipBorder;

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
	
	// Athlete portraits
	public static final int PORTRAIT_SMALL = 200;
	public static final int PORTRAIT_LARGE = 350;
	public static final RoundClipBorder PORTRAIT_BORDER = new RoundClipBorder(Color.BLACK, 2, 50, 0);
	public static final String PORTRAIT_PLACEHOLDER = "/main/Resources/placeholder_portrait.jpg";
	
	// Color for bonus stats
	public static final Color BONUS_UP = new Color(0, 128, 0);
	public static final Color BONUS_DOWN = new Color(255, 0, 0);

}
