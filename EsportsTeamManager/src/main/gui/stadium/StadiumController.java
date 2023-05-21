
package main.gui.stadium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import main.gui.GameFrame;
import main.gui.subclassable.ThumbnailController;
import main.model.Stadium;
import main.model.Team;

/**
 * Handles the Stadium menu
 * 
 * @author blake
 *
 */
public final class StadiumController extends ThumbnailController {
	
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
		opponentTeamButtons();
		initializeConfirmButton();
		initializeBackButton();
		super.launch();
	}
	
	/**
	 * Gets the opponent teams and displays them on the panel
	 */
	private void opponentTeamButtons() {
		 Stadium stadium = frame.getGame().getStadium();
		 opponentTeams = stadium.getMatches();
		 List<JButton> teamButtons = ((StadiumPanel) panel).getThumbButtons();
		
		for (int i = 0; i < opponentTeams.size(); i++) {
			Team team = opponentTeams.get(i);
			JButton button = teamButtons.get(i);
			String path = team.getLogoPath();
			
			super.formatButtonIcon(button, path);
			
			if (!stadium.isOpponentSelected()) {
				button.setEnabled(true);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						toTeamDetailsScreen(team);
					}
				});
			}
		}
	}
	
	/**
	 * Hide unused button
	 */
	private void initializeConfirmButton() {
		JButton confirmButton = ((StadiumPanel) panel).getConfirmButton();
		confirmButton.setVisible(false);
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
	 * Closes stadium screen and launches the team details Screen
	 */
	private void toTeamDetailsScreen(Team team) {
		frame.toTeamDetailsScreen(team);
	}
	
	/**
	 * Closes stadium screen and goes back to home screen
	 */
	private void toHomeScreen() {
		frame.toHomeScreen();
	}
}
