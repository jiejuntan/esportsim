/**
 * 
 */
package main.gui.controllers;

import main.gui.GameFrame;
import main.model.Athlete;

/**
 * 
 * 
 * @author Jiejun Tan
 *
 */
public class RoleSwapController extends Controller {

	/**
	 * Athlete initiating role swap.
	 */ 
	private Athlete athlete;
	
	/**
	 * Constructor when drafting
	 * 
	 * @param frame 	game frame
	 * @param athlete 	Athlete initiating role swap
	 */
	public RoleSwapController(GameFrame frame, Athlete athlete) {
		super(frame);
		this.athlete = athlete;
		initialize();
	}

	/**
	 * Runs initialize methods and launches panel
	 */
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

}
