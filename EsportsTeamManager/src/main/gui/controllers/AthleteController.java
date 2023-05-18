/**
 * 
 */
package main.gui.controllers;

import main.gui.GameFrame;
import main.gui.panels.AthletePanel;

/**
 * Controls detail screen for an athlete.
 *
 */
public class AthleteController extends Controller {

	/**
	 * @param frame game frame
	 */
	public AthleteController(GameFrame frame) {
		super(frame);
	}

	@Override
	protected void initialize() {
		panel = new AthletePanel();
		
		launch();
	}
	
	private void toPreviousScreen() {
		close();
		
	}

}
