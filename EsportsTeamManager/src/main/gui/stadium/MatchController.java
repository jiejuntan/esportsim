package main.gui.stadium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.gui.GameFrame;
import main.gui.subclassable.Controller;
import main.model.GameData;
import main.model.Match;
import main.model.Team;

public final class MatchController extends Controller {
	
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
						nextMatchButton.setVisible(true);
					}
					
			}
		});
		
	}
	
	private void initializeNextMatchButton() {
		
		JButton battleButton = ((MatchPanel) panel).getBattleButton();
		JButton nextMatchButton = ((MatchPanel) panel).getNextMatchButton();
		nextMatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextMatchButton.setVisible(false);
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
		JLabel resultsValueLabel1 = ((MatchPanel) panel).getResultsValueLabel1();
		JLabel resultsValueLabel2 = ((MatchPanel) panel).getResultsValueLabel2();
		resultsValueLabel1.setVisible(true);
		resultsValueLabel2.setVisible(true);
		
		resultsValueLabel1.setText(match.getRoundResults().get(0));
		resultsValueLabel2.setText(match.getRoundResults().get(1));
		
		
	}
	
	private void resetRoundResults() {
		JLabel resultsValueLabel1 = ((MatchPanel) panel).getResultsValueLabel1();
		JLabel resultsValueLabel2 = ((MatchPanel) panel).getResultsValueLabel2();
		resultsValueLabel1.setVisible(false);
		resultsValueLabel2.setVisible(false);		
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
