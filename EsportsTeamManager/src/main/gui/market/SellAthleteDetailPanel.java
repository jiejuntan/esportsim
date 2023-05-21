package main.gui.market;

import main.gui.subclassable.DetailPanel;

/**
 * Panel for selling athlete
 * 
 * @author Jiejun Tan
 *
 */
public class SellAthleteDetailPanel extends DetailPanel {

	/**
	 * Sets components required when selling team athletes to visible.
	 */
	public SellAthleteDetailPanel() {
		reactionValueLabel.setVisible(true);
		eyesightValueLabel.setVisible(true);
		intelligenceValueLabel.setVisible(true);
		staminaValueLabel.setVisible(true);

		priceLabel.setVisible(true);
		priceValueLabel.setVisible(true);
		
		confirmButton.setText("Sell");
	}

}
