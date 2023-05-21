package main.gui.club;

import main.gui.subclassable.ThumbnailPanel;

/**
 * Panel for player inventory.
 * 
 * @author Jiejun Tan
 *
 */
public final class InventoryPanel extends ThumbnailPanel {

	/**
	 * Constructor for inventory panel to display items.
	 */
	public InventoryPanel() {
		titleLabel.setText("Inventory");
		backButton.setVisible(true);
		confirmButton.setVisible(false);
	}

}
