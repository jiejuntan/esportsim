package main.gui.panels;

/**
 * Stadium Panel for displaying the game matches
 * 
 * @author blake
 *
 */
public class StadiumPanel extends ThumbnailPanel {
	
	
	public StadiumPanel() {
		titleLabel.setText("Stadium");
		disableBottomThumbs();
		backButton.setVisible(true);
		subheadingLabel1.setVisible(true);
		subheadingLabel1.setText("Select Your Opponent Team");
	}

}
