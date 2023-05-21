
package main.gui.controllers.thumbnailControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import main.gui.GameFrame;
import main.gui.controllers.subclassable.ThumbnailController;
import main.gui.panels.thumbnailPanels.ClubPanel;
import main.gui.panels.thumbnailPanels.StadiumPanel;
import main.model.GameData;
import main.model.Match;
import main.model.Stadium;
import main.model.Team;

/**
 * Handles the Stadium menu
 * 
 * @author blake
 *
 */
public class StadiumController extends ThumbnailController {
	
	List<Team> opponentTeams;

	/**
	 * Constructor for stadium screen
	 * 
	 * @param frame game frame to manage navigation
	 */
	public StadiumController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new StadiumPanel();
		getMatches();
		initializeConfirmButton();
		initializeBackButton();
		super.launch();
	}
	
	/**
	 * Gets the opponent teams and displays them on the panel
	 */
	private void getMatches() {

	    Stadium stadium = frame.getGame().getStadium();
	    opponentTeams = stadium.getMatches();
	    List<JButton> teamButtons = ((StadiumPanel) panel).getThumbButtons();

	    for(int i = 0; i < opponentTeams.size(); i++) {

	        Team team = opponentTeams.get(i);
	        JButton thumbButton = teamButtons.get(i);
	        String path = team.getLogoPath();

	        super.formatButtonIcon(thumbButton, path);

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
		GameData gameData = frame.getGame().getData();
		List<JButton> thumbButton = ((StadiumPanel) panel).getThumbButtons();
		
		
		JButton confirmButton = ((StadiumPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOpponentSelected()) {
					
					//Add the selected team to gameData
					for (JButton button : thumbButton) {
				        if (button.isEnabled()) {
				        	int teamIndex = thumbButton.indexOf(button);
							gameData.setOpponent(frame.getGame().getStadium().getMatches().get(teamIndex));
							toMatchScreen(); 
					}}
					
				} else {
					JOptionPane.showMessageDialog(panel, 
							"You need to select an Opponent!.", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	

	private void initializeBackButton() {
		JButton backButton = ((StadiumPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toHomeScreen();
			}
		});
	}
	
	/**
	 * Checks the opponent team button to see if any is selected
	 * 
	 * @return <CODE>boolean</CODE> isOpponentSelected?
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
	private void toMatchScreen() {
		frame.toMatchScreen();
	}
	
	/**
	 * Closes stadium screen and goes back to home screen
	 */
	private void toHomeScreen() {
		frame.toHomeScreen();
	}
}
