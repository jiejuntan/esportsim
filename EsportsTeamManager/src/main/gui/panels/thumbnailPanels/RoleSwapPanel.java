/**
 * 
 */
package main.gui.panels.thumbnailPanels;

import main.gui.panels.subclassable.ThumbnailPanel;

/**
 * Panel to display available athletes to swap.
 * 
 * @author Jiejun Tan
 *
 */
public class RoleSwapPanel extends ThumbnailPanel {

	/**
	 * 
	 */
	public RoleSwapPanel() {
		titleLabel.setText("Select member to swap:");
		disableBottomThumbs();
		confirmButton.setVisible(false);
	}

}
