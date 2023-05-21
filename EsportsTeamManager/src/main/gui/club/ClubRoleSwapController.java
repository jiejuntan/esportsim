package main.gui.club;

import main.gui.GameFrame;
import main.gui.drafting.RoleSwapController;
import main.model.Athlete;

/**
 * Controller for role swap screen in club
 * 
 * @author Jiejun Tan
 *
 */
public class ClubRoleSwapController extends RoleSwapController {

	/**
	 * Constructor for role swap screen in club.
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param athlete 	Athlete initiating role swap
	 */
	public ClubRoleSwapController(GameFrame frame, Athlete athlete) {
		super(frame, athlete);
	}

	/**
	 * Returns to previous screen.
	 */
	@Override
	protected void toPreviousScreen() {
		frame.toClubScreen();
	}
}
