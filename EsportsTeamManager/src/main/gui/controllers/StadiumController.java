
package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.gui.GameFrame;
import main.gui.panels.ClubPanel;
import main.gui.panels.DraftPanel;
import main.gui.panels.StadiumPanel;
import main.model.Athlete;
import main.model.Stadium;
import main.model.Team;

public class StadiumController extends Controller {

	/**
	 * @param frame
	 */
	public StadiumController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes screen
	 */
	@Override
	protected void initialize() {
		panel = new StadiumPanel();
		getMatches();
		launch();
	}
	
	/**
	 * Gets the opponent teams and displays them on the panel
	 */
	private void getMatches() {
		
		Stadium stadium = frame.getGame().getStadium();
		List<Team> opponentTeams = stadium.getMatches();
		List<JButton> teamButtons = ((DraftPanel) panel).getThumbButtons();
		
		for(int i = 0; i < opponentTeams.size(); i++) {
			
			Team team = opponentTeams.get(i);
			JButton button = teamButtons.get(i);
			
		}
		
	}
	
	private void chooseOpponentButton() {
		List<JButton> thumbButton = ((StadiumPanel) panel).getThumbButtons();
		//Button 0
		thumbButton.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(thumbButton.get(1).isEnabled() || thumbButton.get(2).isEnabled()) {
					
				}
			}
		});
		
		//Button 1
		thumbButton.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//Button 2
		thumbButton.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private void initializeConfirmButton() {
		Team team = frame.getGame().getData().getTeam();	
		
		JButton confirmButton = ((DraftPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.hasMinimumSize()) {
					toHomeScreen();
				} else {
					JOptionPane.showMessageDialog(panel, 
							"You don't have enough athletes to start! Select at least " + Team.MIN_TEAM_SIZE  + ".", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Closes stadium screen and launches the match
	 */
	private void toAthleteScreen(Team team) {
		close();
		frame.toMatchScreen(team);
	}
	
	/**
	 * Closes stadium screen and goes back to home screen
	 */
	private void toHomeScreen() {
		close();
		frame.toHomeScreen();
	}
}
