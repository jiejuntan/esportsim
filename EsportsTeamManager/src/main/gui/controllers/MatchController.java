package main.gui.controllers;

import main.gui.GameFrame;
import main.gui.panels.MatchPanel;

public class MatchController extends Controller {

	/**
	 * Constructor for match screen.
	 * 
	 * @param frame game frame to manage navigation
	 */
	public MatchController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
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
