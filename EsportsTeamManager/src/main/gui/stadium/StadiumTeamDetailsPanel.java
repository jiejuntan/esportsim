package main.gui.stadium;

import main.gui.subclassable.DetailPanel;

/**
 * Stadium Team detials view panel
 * 
 * @author blake
 *
 */
public final class StadiumTeamDetailsPanel extends DetailPanel{
	
	/**
	 * Constructor for viewing opponent team details
	 */
	public StadiumTeamDetailsPanel() {
		reactionValueLabel.setVisible(true);
		eyesightValueLabel.setVisible(true);
		staminaValueLabel.setVisible(true);
		intelligenceLabel.setVisible(false);
	}

}
