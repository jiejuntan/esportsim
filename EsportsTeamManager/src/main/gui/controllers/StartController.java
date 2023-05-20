package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import main.gui.GameFrame;
import main.gui.panels.StartPanel;

public class StartController extends Controller {
	
	/**
	 * Constructor for start screen
	 * 
	 * @param frame game frame to manage navigation
	 */
	public StartController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new StartPanel();
		
		JButton newGameButton = ((StartPanel) panel).getNewGameButton();
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toSetupScreen();
			}
		});
		newGameButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				toSetupScreen();
			}
		});
		launch();
	}
	
	private void toSetupScreen() {
		close();
		frame.toSetupScreen();
	}
	
}
