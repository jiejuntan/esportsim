package main.gui.club;

import main.gui.subclassable.DetailPanel;

/**
 * Detail panel for items.
 * 
 * @author Jiejun Tan
 *
 */
public final class ItemDetailPanel extends DetailPanel {

	/**
	 * Sets visual only components for item detail view.
	 */
	public ItemDetailPanel() {
		reactionBonusLabel.setVisible(true);
		eyesightBonusLabel.setVisible(true);
		intelligenceBonusLabel.setVisible(true);
		staminaLabel.setVisible(false);
		confirmButton.setText("Use");
	}

}
