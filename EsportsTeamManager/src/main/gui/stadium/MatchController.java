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
	GameData gameData;
	
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
		gameData = frame.getGame().getData();
		match = new Match(gameData, opponent);
		panel = new MatchPanel();
		displays();
		resetRoundResults();
		updateDisplays();
		initializeBattleButton();

		
		super.launch();
	}
	
	
	private void initializeBattleButton() {
		
		
		
		//Get the buttons
		JButton battleButton = ((MatchPanel) panel).getBattleButton();
		
		//Button action
		battleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//Do the battle Manouvers
					match.simulateRound();
					updateDisplays();

					if (isBattleover()) {
						matchOver();
					} 
					
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
	
	
	private void updateDisplays() {
		JLabel resultsValueLabel1 = ((MatchPanel) panel).getResultsValueLabel1();
		JLabel resultsValueLabel2 = ((MatchPanel) panel).getResultsValueLabel2();
		JLabel roundValueLabel = ((MatchPanel) panel).getRoundValueLabel();

		resultsValueLabel1.setVisible(true);
		resultsValueLabel2.setVisible(true);
		roundValueLabel.setText(String.valueOf(match.getRound()));
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
	                "MATCH OVER!", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(panel, 
	                "You have lost the battle!", 
	                "MATCH OVER!", JOptionPane.INFORMATION_MESSAGE);
	    }
	    
	    toHomeScreen();
	}

	
	private void displays() {
		JLabel playerTeamNameLabel = ((MatchPanel) panel).getPlayerTeamNameValueLabel();
		JLabel opponentTeamNameLabel = ((MatchPanel) panel).getOpponentTeamNameValueLabel();
		playerTeamNameLabel.setText(gameData.getTeam().getName());
		opponentTeamNameLabel.setText(opponent.getName());
		
	}
	
	/**
	 * Closes stadium screen and goes back to home screen
	 */
	private void toHomeScreen() {
		frame.toHomeScreen();
	} 
	
	

}
