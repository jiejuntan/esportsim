package main.gui.market;

import main.gui.GameFrame;
import main.gui.drafting.DraftDetailController;
import main.model.Athlete;

/**
 * Controller for detail screen when purchasing athlete in market
 * 
 * @author Jiejun Tan
 *
 */
public class PurchaseAthleteDetailController extends DraftDetailController {

	/**
	 * Constructor for detail view when purchasing athlete in market.
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param athlete 	Athlete to view
	 */
	public PurchaseAthleteDetailController(GameFrame frame, Athlete athlete) {
		super(frame, athlete);
	}
	
	/**
	 * Returns to previous screen
	 */
	@Override
	protected void toPreviousScreen() {
		frame.toMarketScreen(false);
	}
	
	/**
	 * Launches screen to choose athlete in team to swap roles with purchased athlete
	 */
	@Override
	protected void toRoleSwapScreen(Athlete athlete) {
		frame.toMarketRoleSwapScreen(athlete);
	}

}
