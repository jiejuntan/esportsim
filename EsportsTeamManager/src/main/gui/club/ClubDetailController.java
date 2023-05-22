package main.gui.club;

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

import main.exceptions.TeamLimitException;
import main.exceptions.TeamLimitException.Type;
import main.gui.GameFrame;
import main.gui.subclassable.DetailController;
import main.model.Team.Role;
import main.model.Athlete;
import main.model.Team;

/**
 * Controller for detail screen when visiting club
 * 
 * @author Jiejun Tan
 *
 */
public class ClubDetailController extends DetailController {

	/**
	 * Athlete currently in view.
	 */ 
	protected Athlete athlete;
	
	/**
	 * Constructor when viewing team athlete
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param athlete 	Athlete to view
	 */
	public ClubDetailController(GameFrame frame, Athlete athlete) {
		super(frame);
		this.athlete = athlete;
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new ClubDetailPanel();
		
		setHeading();
		super.setPortrait(((ClubDetailPanel) panel).getPortraitLabel(), athlete.getPortraitPath());
		setStats();
		
		super.initializeBackButton();
		initializeConfirmButton();

		super.launch();
	}

	
	/**
	 * Sets heading to an editable name
	 */
	private void setHeading() {
		JTextField nameTextField = ((ClubDetailPanel) panel).getNameTextField();
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
		JButton changeNameButton = ((ClubDetailPanel) panel).getChangeNameButton();
		changeNameButton.setText(athlete.getName());
		nameTextField.setText(athlete.getName());
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
	
	/**
	 * Displays athlete's current stats
	 */
	private void setStats() {
		JLabel reactionValueLabel = ((ClubDetailPanel) panel).getReactionValueLabel();
		reactionValueLabel.setText(String.valueOf(athlete.getReactionTime()));
		
		JLabel eyesightValueLabel = ((ClubDetailPanel) panel).getEyesightValueLabel();
		eyesightValueLabel.setText(String.valueOf(athlete.getEyeSight()));
		
		JLabel intelligenceValueLabel = ((ClubDetailPanel) panel).getIntelligenceValueLabel();
		intelligenceValueLabel.setText(String.valueOf(athlete.getIntelligence()));
		
		JLabel staminaValueLabel = ((ClubDetailPanel) panel).getStaminaValueLabel();
		int stamina = athlete.getStamina();
		staminaValueLabel.setText(Athlete.STAMINA_LEVELS[stamina]);
		
		JComboBox roleComboBox = ((ClubDetailPanel) panel).getRoleComboBox();
		roleComboBox.setSelectedItem(athlete.getRole());
	}
	
	/**
	 * Initializes confirm button to confirm changes or show dialog for errors
	 */
	protected void initializeConfirmButton() {
		JButton confirmButton = ((ClubDetailPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				JComboBox roleComboBox = ((ClubDetailPanel) panel).getRoleComboBox();
				Role role = (Role) roleComboBox.getSelectedItem();
				
				JTextField nameTextField = ((ClubDetailPanel) panel).getNameTextField();
				String newName = nameTextField.getText();
			
				Team team = frame.getGame().getData().getTeam();
				try {
					athlete.setName(newName);
					team.changeRole(athlete, role);
					toPreviousScreen();
				} catch (TeamLimitException e1) {
					String targetRole = e1.getType() == Type.MAIN ? "main" : "reserve";
					int shouldSwap = JOptionPane.showConfirmDialog(panel, 
							"Your " + targetRole + " team is full. Choose a member to swap with or cancel.", 
							"Error", JOptionPane.ERROR_MESSAGE);
					if (shouldSwap == JOptionPane.YES_OPTION) {
						toRoleSwapScreen(athlete);
					}
				}
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	protected void toPreviousScreen() {
		frame.toClubScreen();
	}
	
	/**
	 * Launches screen to choose athlete in team to swap roles with current athlete
	 */
	private void toRoleSwapScreen(Athlete athlete) {
		frame.toClubRoleSwapScreen(athlete);
	}

}
