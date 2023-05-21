package main.gui.stadium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.gui.GameFrame;
import main.gui.subclassable.DetailController;
import main.model.Team;

/**
 * Controller for detail screen during draft
 * 
 * @author Jiejun Tan
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
	 * @param athlete 	Athlete to view
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
		
		teamDetailsSetup();
		
		initializeBackButton();
		initializeConfirmButton();

		super.launch();
	}
	
	private void teamDetailsSetup() {
		JLabel winsLabel = ((StadiumTeamDetailsPanel) panel).getReactionLabel();
		JLabel winsValueLabel = ((StadiumTeamDetailsPanel) panel).getReactionValueLabel();
		winsLabel.setText("Wins: ");
		winsValueLabel.setText(String.valueOf(team.getWins()));
		
		JLabel lossesLabel = ((StadiumTeamDetailsPanel) panel).getEyesightLabel();
		JLabel lossesValueLabel = ((StadiumTeamDetailsPanel) panel).getEyesightValueLabel();
		lossesLabel.setText("Losses: ");
		lossesValueLabel.setText(String.valueOf(team.getLosses()));
		
		JLabel skillLevelLabel = ((StadiumTeamDetailsPanel) panel).getIntelligenceLabel();
		JLabel skillLevelValueLabel = ((StadiumTeamDetailsPanel) panel).getIntelligenceValueLabel();
		skillLevelLabel.setText("Total Skill Level: ");
		skillLevelValueLabel.setText(String.valueOf(team.calculateTeamlevel()));
		
		JLabel difficultyLabel = ((StadiumTeamDetailsPanel) panel).getStaminaLabel();
		JLabel difficultyValueLabel = ((StadiumTeamDetailsPanel) panel).getStaminaValueLabel();
		difficultyLabel.setText("Difficulty:");
		difficultyValueLabel.setText("***");
		
		JTextField nameTextField = ((StadiumTeamDetailsPanel) panel).getNameTextField();
		nameTextField.setText(team.getName()+"blblb");
	}


	/**
	 * Initializes back button to return to draft
	 */
	private void initializeBackButton() {
		JButton backButton = ((StadiumTeamDetailsPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toPreviousScreen();
			}
		});
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
	private void toPreviousScreen() {
		frame.toStadiumScreen();
	}
	
	/**
	 * Closes stadium screen and launches the match
	 */
	private void toMatchScreen(Team team) {
		frame.toMatchScreen(team);
	}
	

}

