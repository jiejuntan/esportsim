package main.gui.market;

import main.gui.GameFrame;
import main.gui.drafting.RoleSwapController;
import main.model.Athlete;

/**
 * Controller for role swap screen in market
 * 
 * @author Jiejun Tan
 *
 */
public class MarketRoleSwapController extends RoleSwapController {

	/**
	 * Constructor for role swap screen in market.
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param athlete 	Athlete initiating role swap
	 */
	public MarketRoleSwapController(GameFrame frame, Athlete athlete) {
		super(frame, athlete);
	}
	
	/**
	 * Returns to previous screen.
	 */
	@Override
	protected void toPreviousScreen() {
		frame.toMarketScreen(false);
	}

}
