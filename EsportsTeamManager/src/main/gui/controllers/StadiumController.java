
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

public class StadiumController extends ThumbnailController {

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
		initializeConfirmButton();
		launch();
	}
	
	/**
	 * Gets the opponent teams and displays them on the panel
	 */
	private void getMatches() {

	    Stadium stadium = frame.getGame().getStadium();
	    List<Team> opponentTeams = stadium.getMatches();
	    List<JButton> teamButtons = ((StadiumPanel) panel).getThumbButtons();

	    for(int i = 0; i < opponentTeams.size(); i++) {

	        Team team = opponentTeams.get(i);
	        JButton thumbButton = teamButtons.get(i);
	        String path = team.getLogoPath();

	        formatButtonIcon(thumbButton, path);

	        thumbButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // If button is already enabled, disable it and enable all others
	                if (thumbButton.isEnabled()) {
	                    thumbButton.setEnabled(false);
	                    for (JButton otherButton : teamButtons) {
	                        if (otherButton != thumbButton) {
	                            otherButton.setEnabled(true);
	                        }
	                    }
	                }
	                // If button is disabled, enable it and disable all others
	                else {
	                    thumbButton.setEnabled(true);
	                    for (JButton otherButton : teamButtons) {
	                        if (otherButton != thumbButton) {
	                            otherButton.setEnabled(false);
	                        }
	                    }
	                }
	            }
	        });
	        
	        thumbButton.setEnabled(true); // Enable the button by default

	    }
	}

	


	
	/**
	 * If an opponent is selected then a match will be started
	 */
	private void initializeConfirmButton() {
		Stadium stadium = frame.getGame().getStadium();	
		
		JButton confirmButton = ((StadiumPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOpponentSelected()) {
					toMatchScreen(stadium.getSelectedOpponent());
				} else {
					JOptionPane.showMessageDialog(panel, 
							"You need to select an Opponent!.", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Checkds the opponent team button to see if any is selected
	 * 
	 * @return
	 */
	private boolean isOpponentSelected() {
	    List<JButton> thumbButton = ((StadiumPanel) panel).getThumbButtons();

	    // Check each button in the list to see if any is selected
	    for (JButton button : thumbButton) {
	        if (button.isEnabled()) {
	            return true;  // An opponent (button) is selected
	        }
	    }

	    return false;  // No opponent (button) is selected
	}
	
	/**
	 * Closes stadium screen and launches the match
	 */
	private void toMatchScreen(Team team) {
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
