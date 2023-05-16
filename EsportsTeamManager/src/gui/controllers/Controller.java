package gui.controllers;

import javax.swing.JPanel;

import gui.GameFrame;
import main.GameEnvironment;

abstract class Controller {

	protected GameFrame frame;
	protected GameEnvironment game;
	protected JPanel panel;
	
	public Controller(GameFrame frame) {
		this.frame = frame;
		this.game = frame.getGame();
		initialize();
	}
	
	abstract protected void initialize();
	
	protected void launch() {
		frame.launchPanel(panel);
	}
	
	protected void close() {
		frame.closePanel();
	}
}
