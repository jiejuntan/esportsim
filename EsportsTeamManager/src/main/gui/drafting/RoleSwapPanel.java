/**
 * 
 */
package main.gui.drafting;

import main.gui.subclassable.ThumbnailPanel;

/**
 * Panel to display available athletes to swap.
 * 
 * @author Jiejun Tan
 *
 */
public final class RoleSwapPanel extends ThumbnailPanel {

	/**
	 * 
	 */
	public RoleSwapPanel() {
		titleLabel.setText("Select member to swap:");
		disableBottomThumbs();
		confirmButton.setVisible(false);
	}

}
