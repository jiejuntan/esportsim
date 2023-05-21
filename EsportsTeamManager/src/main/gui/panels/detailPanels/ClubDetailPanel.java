/**
 * 
 */
package main.gui.panels.detailPanels;

import main.gui.panels.subclassable.DetailPanel;

/**
 * Detail panel for team athletes.
 * 
 * @author Jiejun Tan
 *
 */
public final class ClubDetailPanel extends DetailPanel {

	/**
	 * Sets components required when viewing team athletes to visible.
	 */
	public ClubDetailPanel() {
		editTipLabel.setVisible(true);

		reactionValueLabel.setVisible(true);
		eyesightValueLabel.setVisible(true);
		intelligenceValueLabel.setVisible(true);
		staminaValueLabel.setVisible(true);
		
		roleLabel.setVisible(true);
		roleComboBox.setVisible(true);
	}

}
