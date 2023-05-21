package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.exceptions.IllegalFundsException;
import main.exceptions.IllegalTeamException;
import main.exceptions.TeamLimitException;
import main.gui.GameFrame;
import main.gui.panels.DetailPanel;
import main.gui.panels.DraftDetailPanel;
import main.model.Team.Role;
import main.model.Athlete;
import main.model.GameData.Difficulty;
import main.model.Market;
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

		launch();
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
		
		//Hide unnecessary labels for this panel
		JLabel editLabel = ((DetailPanel) panel).getEditTipLabel();
		editLabel.setVisible(false);
		JLabel roleLabel = ((DetailPanel) panel).getRoleLabel();
		roleLabel.setVisible(false);
		JLabel priceLabel = ((DetailPanel) panel).getPriceLabel();
		priceLabel.setVisible(false);
		JComboBox roleComboBox = ((DetailPanel) panel).getRoleComboBox();
		roleComboBox.setVisible(false);
		
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
		close();
		frame.toStadiumScreen();
	}
	
	/**
	 * Closes stadium screen and launches the match
	 */
	private void toMatchScreen(Team team) {
		close();
		frame.toMatchScreen(team);
	}
	

}

