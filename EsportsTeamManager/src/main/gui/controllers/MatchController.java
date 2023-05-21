package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.gui.GameFrame;
import main.gui.controllers.subclassable.Controller;
import main.gui.panels.MatchPanel;
import main.model.GameData;
import main.model.Match;
import main.model.Team;

public class MatchController extends Controller {
	
	Match match;
	Team opponent;
	
	/**
	 * Constructor for match screen.
	 * 
	 * @param frame game frame to manage navigation
	 */
	public MatchController(GameFrame frame, Team opponent) {
		super(frame);
		this.opponent = opponent;
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		GameData gameData = frame.getGame().getData();
		match = new Match(gameData, opponent);
		panel = new MatchPanel();

		resetRoundResults();
		updateHealth();
		initializeBattleButton();
		initializeNextMatchButton();
		displayPlayers();
		
		super.launch();
	}
	
	
	private void initializeBattleButton() {
		
		
		
		//Get the buttons
		JButton battleButton = ((MatchPanel) panel).getBattleButton();
		JButton nextMatchButton = ((MatchPanel) panel).getNextMatchButton();
		
		//Button action
		battleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//Do the battle Manouvers
					match.simulateMatchup();
					updateHealth();

					if (isBattleover()) {
						matchOver();
					} else {
						displayRoundResults();
						battleButton.setVisible(false);
						nextMatchButton.setEnabled(true);
					}
					
			}
		});
		
	}
	
	private void initializeNextMatchButton() {
		
		JButton battleButton = ((MatchPanel) panel).getBattleButton();
		JButton nextMatchButton = ((MatchPanel) panel).getNextMatchButton();
		nextMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextMatchButton.setEnabled(false);
				battleButton.setVisible(true);
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
	
	private void updateHealth() {
		JLabel opponentHealthValueLabel = ((MatchPanel) panel).getOpponentHealthValueLabel();
		JLabel PlayerHealthValueLabel = ((MatchPanel) panel).getPlayerHealthValueLabel();
		opponentHealthValueLabel.setText(String.valueOf(match.getTeamHealth(match.getOpponentTeam())));
		PlayerHealthValueLabel.setText(String.valueOf(match.getTeamHealth(match.getHomeTeam())));
	}
	
	private void displayRoundResults() {
		JLabel resultsValueLabel = ((MatchPanel) panel).getResultsValueLabel();
		JLabel resultsLabel = ((MatchPanel) panel).getResultsLabel();
		resultsLabel.setVisible(true);
		resultsValueLabel.setVisible(true);
		
		resultsValueLabel.setText("Results will go here");
		
		
	}
	
	private void resetRoundResults() {
		JLabel resultsValueLabel = ((MatchPanel) panel).getResultsValueLabel();
		JLabel resultsLabel = ((MatchPanel) panel).getResultsLabel();
		resultsLabel.setVisible(false);
		resultsValueLabel.setVisible(false);
		
	}
	
	private void matchOver() {
		
		if (match.getOutcome() == 1) {
			JOptionPane.showMessageDialog(panel, 
					"You have won the battle!", 
					"MATCH OVER!", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(panel, 
					"You have lost the battle!", 
					"MATCH OVER!", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	private void displayPlayers() {
		JLabel playerNameLabel = ((MatchPanel) panel).getPlayerNameLabel();
		JLabel opponentNameLabel = ((MatchPanel) panel).getOpponentNameLabel();
		playerNameLabel.setText(match.getHomeTeam().get(match.getHomeTurn()).getName());
		opponentNameLabel.setText(match.getOpponentTeam().get(match.getOpponentTurn()).getName());
		
	}
	
	

}
