package main.gui.panels.thumbnailPanels;

import main.gui.panels.subclassable.ThumbnailPanel;

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
		subheadingLabel1.setText("Select Your Opponent Team");
	}

}
