/**
 * 
 */
package main.gui.panels.detailPanels;

import main.gui.panels.subclassable.DetailPanel;

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
		staminaBonusLabel.setVisible(true);
		
		priceLabel.setVisible(true);
		priceValueLabel.setVisible(true);
	}

}
