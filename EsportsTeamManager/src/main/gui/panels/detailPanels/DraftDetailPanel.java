/**
 * 
 */
package main.gui.panels.detailPanels;

import main.gui.panels.subclassable.DetailPanel;

/**
 * Detail panel for drafting athletes
 * 
 * @author Jiejun Tan
 *
 */
public class DraftDetailPanel extends DetailPanel {

	/**
	 * Sets visual only components for draft detail view.
	 */
	public DraftDetailPanel() {
		editTipLabel.setVisible(true);

		reactionValueLabel.setVisible(true);
		eyesightValueLabel.setVisible(true);
		intelligenceValueLabel.setVisible(true);
		staminaValueLabel.setVisible(true);
		
		roleLabel.setVisible(true);
		roleComboBox.setVisible(true);

		priceLabel.setVisible(true);
		priceValueLabel.setVisible(true);
	}

}
