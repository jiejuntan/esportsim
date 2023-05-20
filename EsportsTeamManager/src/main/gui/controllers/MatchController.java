package main.gui.controllers;

import main.gui.GameFrame;
import main.gui.panels.MatchPanel;

public class MatchController extends Controller {

	/**
	 * @param frame
	 */
	public MatchController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes screen
	 */
	@Override
	protected void initialize() {
		panel = new MatchPanel();
		launch();
	}
	
	
	private void startBattle() {
		
	}
	
	private void displayRoundResults() {
		
	}
	

}
