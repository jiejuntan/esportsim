package main.gui.stadium;

import main.gui.subclassable.DetailPanel;

/**
 * Stadium Team detials view panel
 * 
 * @author blake
 *
 */
public final class StadiumTeamDetailsPanel extends DetailPanel{
	
	public StadiumTeamDetailsPanel() {
		reactionValueLabel.setVisible(true);
		eyesightValueLabel.setVisible(true);
		staminaValueLabel.setVisible(true);
		intelligenceLabel.setVisible(false);
	}

}
