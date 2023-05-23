package main.gui.stadium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import main.gui.GameFrame;
import main.gui.subclassable.DetailController;
import main.model.Stadium;
import main.model.Team;

/**
 * Controller for detail screen during opponent team selection
 * 
 * Blake and Jun
 * 
 *
 */
public final class StadiumTeamDetailsController extends DetailController {

	/**
	 * Team currently in view.
	 */ 
	private Team team;
	
	/**
	 * Constructor when drafting
	 * 
	 * @param frame 	game frame
	 * @param team 		team to view
	 */
	public StadiumTeamDetailsController(GameFrame frame, Team team) {
		super(frame);
		this.team = team;
		initialize();
	}

	/**
	 * Runs initialize methods and launches panel
	 */
	@Override
	protected void initialize() {
		panel = new StadiumTeamDetailsPanel();
		super.setPortrait(((StadiumTeamDetailsPanel) panel).getPortraitLabel(), team.getLogoPath());
		
		teamDetailsSetup();
		initializeBackButton();
		initializeConfirmButton();

		super.launch();
	}
	
	/**
	 * Setup additional components
	 */
	private void teamDetailsSetup() {
		Stadium stadium = frame.getGame().getStadium();
		

		JLabel winsLabel = ((StadiumTeamDetailsPanel) panel).getReactionLabel();
		JLabel winsValueLabel = ((StadiumTeamDetailsPanel) panel).getReactionValueLabel();
		winsLabel.setText("Wins: ");
		winsValueLabel.setText(String.valueOf(team.getWins()));
		
		JLabel lossesLabel = ((StadiumTeamDetailsPanel) panel).getEyesightLabel();
		JLabel lossesValueLabel = ((StadiumTeamDetailsPanel) panel).getEyesightValueLabel();
		lossesLabel.setText("Losses: ");
		lossesValueLabel.setText(String.valueOf(team.getLosses()));
		
		
		JLabel difficultyLabel = ((StadiumTeamDetailsPanel) panel).getStaminaLabel();
		JLabel difficultyValueLabel = ((StadiumTeamDetailsPanel) panel).getStaminaValueLabel();
		difficultyLabel.setText("Difficulty:");
		difficultyValueLabel.setText(stadium.getDifficulty(team));
		
		
		JButton changeNameButton = ((StadiumTeamDetailsPanel) panel).getChangeNameButton();
		changeNameButton.setText(team.getName());
	}
	
	/**
	 * Initializes confirm button to purchase athlete and return to draft or show dialog for errors
	 */
	private void initializeConfirmButton() {
		JButton confirmButton = ((StadiumTeamDetailsPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				toMatchScreen(team);
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	protected void toPreviousScreen() {
		frame.toStadiumScreen();
	}
	
	/**
	 * Closes stadium screen and launches the match
	 */
	private void toMatchScreen(Team team) {
		frame.toMatchScreen(team);
	}
	

}

