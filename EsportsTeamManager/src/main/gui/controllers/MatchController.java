package main.gui.controllers;

import main.gui.GameFrame;
import main.gui.panels.StadiumPanel;

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
		panel = new StadiumPanel();
		launch();
	}
	

}
