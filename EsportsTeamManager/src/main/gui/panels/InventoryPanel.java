package main.gui.panels;

/**
 * Panel for player inventory.
 * 
 * @author Jiejun Tan
 *
 */
public class InventoryPanel extends ThumbnailPanel {

	/**
	 * Constructor for inventory panel to display items.
	 */
	public InventoryPanel() {
		titleLabel.setText("Inventory");
		backButton.setVisible(true);
		confirmButton.setVisible(false);
	}

}
