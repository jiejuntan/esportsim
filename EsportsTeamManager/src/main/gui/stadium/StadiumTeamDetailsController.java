package main.gui.stadium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.gui.GameFrame;
import main.gui.subclassable.DetailController;
import main.gui.subclassable.DetailPanel;
import main.model.Stadium;
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
	
	
	/**
	 * Sets heading to an editable name
	 */
	private void setHeading() {
		JTextField nameTextField = ((DetailPanel) panel).getNameTextField();
		nameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (String.valueOf(e.getKeyChar()).matches("[ a-zA-Z]")
						&& nameTextField.getText().length() >= 10
						|| String.valueOf(e.getKeyChar()).matches("[0-9!@#$%^&*()-_=+|\\\\:;\"',.<>?/{}\\[\\]]")) {
					e.consume();
					JOptionPane.showMessageDialog(panel, 
							"Your desired name must be under 10 characters long and only contain letters.", 
							"Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		JButton changeNameButton = ((DetailPanel) panel).getChangeNameButton();
		changeNameButton.setText("waaa");
		nameTextField.setText("chur");
		changeNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeNameButton.setVisible(false);
				nameTextField.setVisible(true);
				nameTextField.requestFocusInWindow();
			}
		});
		panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	String tempName = nameTextField.getText();
            	changeNameButton.setText(tempName);
            	changeNameButton.setVisible(true);
				nameTextField.setVisible(false);
				
            }
        });
	}
	
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
		
		JLabel skillLevelLabel = ((StadiumTeamDetailsPanel) panel).getIntelligenceLabel();
		JLabel skillLevelValueLabel = ((StadiumTeamDetailsPanel) panel).getIntelligenceValueLabel();
		skillLevelLabel.setText("Total Skill Level: ");
		skillLevelValueLabel.setText(String.valueOf(team.calculateTeamlevel()));
		
		JLabel difficultyLabel = ((StadiumTeamDetailsPanel) panel).getStaminaLabel();
		JLabel difficultyValueLabel = ((StadiumTeamDetailsPanel) panel).getStaminaValueLabel();
		difficultyLabel.setText("Difficulty:");
		difficultyValueLabel.setText(stadium.getDifficulty(team));
		
		JTextField nameTextField = ((StadiumTeamDetailsPanel) panel).getNameTextField();
		nameTextField.setText(team.getName()+"blblb");
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

