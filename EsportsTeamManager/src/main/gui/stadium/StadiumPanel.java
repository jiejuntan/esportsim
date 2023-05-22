package main.gui.stadium;

import main.gui.subclassable.ThumbnailPanel;

/**
 * Stadium Panel for displaying the game matches
 * 
 * @author blake
 *
 */
public final class StadiumPanel extends ThumbnailPanel {
	
	
	public StadiumPanel() {
		titleLabel.setText("Stadium");
		disableBottomThumbs();
		backButton.setVisible(true);
		subheadingLabel1.setVisible(true);
		subheadingLabel1.setText("Select Your Opponent");
	}

}
