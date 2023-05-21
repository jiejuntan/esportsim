package main.gui.controllers.detailControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.gui.GameFrame;
import main.gui.controllers.subclassable.DetailController;
import main.gui.panels.detailPanels.DraftDetailPanel;
import main.gui.panels.subclassable.DetailPanel;
import main.model.Team;

/**
 * Controller for detail screen during draft
 * 
 * @author Jiejun Tan
 *
 */
public class StadiumTeamDetailsController extends DetailController {

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
		panel = new DraftDetailPanel();
		
		teamDetailsSetup();
		
		initializeBackButton();
		initializeConfirmButton();

		super.launch();
	}
	
	private void teamDetailsSetup() {
		JLabel winsLabel = ((DetailPanel) panel).getReactionLabel();
		JLabel winsValueLabel = ((DetailPanel) panel).getReactionValueLabel();
		winsLabel.setText("Wins: ");
		winsValueLabel.setText(String.valueOf(team.getWins()));
		
		JLabel lossesLabel = ((DetailPanel) panel).getEyesightLabel();
		JLabel lossesValueLabel = ((DetailPanel) panel).getEyesightValueLabel();
		lossesLabel.setText("Losses: ");
		lossesValueLabel.setText(String.valueOf(team.getLosses()));
		
		JLabel skillLevelLabel = ((DetailPanel) panel).getIntelligenceLabel();
		JLabel skillLevelValueLabel = ((DetailPanel) panel).getIntelligenceValueLabel();
		skillLevelLabel.setText("Total Skill Level: ");
		skillLevelValueLabel.setText(String.valueOf(team.calculateTeamlevel()));
		
		JLabel difficultyLabel = ((DetailPanel) panel).getStaminaLabel();
		JLabel difficultyValueLabel = ((DetailPanel) panel).getStaminaValueLabel();
		difficultyLabel.setText("Difficulty:");
		difficultyValueLabel.setText("***");
		
		JTextField nameTextField = ((DetailPanel) panel).getNameTextField();
		nameTextField.setText(team.getName()+"blblb");
	}


	/**
	 * Initializes back button to return to draft
	 */
	private void initializeBackButton() {
		JButton backButton = ((DetailPanel) panel).getBackButton();
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
		JButton confirmButton = ((DetailPanel) panel).getConfirmButton();
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

