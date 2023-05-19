/**
 * 
 */
package main.gui.panels;

/**
 * Detail panel for drafting athletes
 * 
 * @author Jiejun Tan
 *
 */
public class DraftDetailPanel extends DetailPanel {

	/**
	 * Sets components required during draft to visible.
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
