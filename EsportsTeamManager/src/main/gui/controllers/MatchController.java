package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.gui.GameFrame;
import main.gui.panels.MatchPanel;
import main.gui.panels.StadiumPanel;
import main.model.GameData;
import main.model.Match;
import main.model.Stadium;
import main.model.Team;

public class MatchController extends Controller {
	
	Match match;
	
	/**
	 * @param frame
	 */
	public MatchController(GameFrame frame, Team  team) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes screen
	 */
	@Override
	protected void initialize() {
		GameData gameData = frame.getGame().getData();
		match = new Match(gameData);
		
		panel = new MatchPanel();

		
		initializeBattleButton();
		initializeNextMatchButton();
		displayPlayers();
		
		launch();
	}
	
	
	private void initializeBattleButton() {
		
		
		
		//Get the buttons
		JButton battleButton = ((MatchPanel) panel).getBattleButton();
		JButton nextMatchButton = ((MatchPanel) panel).getNextMatchButton();
		
		//Button action
		battleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					match.simulateMatchup();
					displayRoundResults();
					battleButton.setVisible(false);
			}
		});
		
	}
	
	private void initializeNextMatchButton() {
		
		JButton nextMatchButton = ((MatchPanel) panel).getNextMatchButton();
		nextMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPlayers();
				resetRoundResults();

			}
		});
		
	}
	
	private boolean isBattleover() {
		if (match.getOutcome() == -1) {
			return false;
		} else {
			return true;
		}
		
	}
	
	private void displayRoundResults() {
		
	}
	
	private void resetRoundResults() {
		
	}
	
	private void displayPlayers() {
		
	}
	
	

}
