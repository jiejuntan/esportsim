/**
 * 
 */
package main.gui.panels.thumbnailPanels;

import main.gui.panels.subclassable.ThumbnailPanel;

/**
 * Panel for club.
 * 
 * @author Jiejun Tan
 *
 */
public final class ClubPanel extends ThumbnailPanel {

	/**
	 * Constructor for club panel to display team members.
	 */
	public ClubPanel() {
		backButton.setVisible(true);
		confirmButton.setText("Inventory");
		subheadingLabel1.setVisible(true);
		subheadingLabel1.setText("Main Members:");
		subheadingLabel2.setVisible(true);
		subheadingLabel2.setText("Reserve Members:");
	}

}
