package main.gui.controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.exceptions.IllegalFundsException;
import main.exceptions.IllegalTeamException;
import main.exceptions.TeamLimitException;
import main.gui.GUIConstants;
import main.gui.GameFrame;
import main.gui.panels.ClubDetailPanel;
import main.gui.panels.DetailPanel;
import main.gui.panels.DraftDetailPanel;
import main.model.Team.Role;
import main.model.Athlete;
import main.model.GameData.Difficulty;
import main.model.Market;
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
	private Athlete athlete;
	
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
		setPortrait();
		setStats();
		
		initializeBackButton();
		initializeConfirmButton();

		launch();
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
	 * Sets the athlete's portrait
	 */
	private void setPortrait() {
		JLabel portraitLabel = ((DetailPanel) panel).getPortraitLabel();
		String portraitPath = athlete.getPortraitPath();
		BufferedImage portraitImage = null;
		try {
			portraitImage = ImageIO.read(new File(getClass()
					.getResource(portraitPath)
					.toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		portraitLabel.setIcon(new ImageIcon(portraitImage
				.getScaledInstance(GUIConstants.PORTRAIT_LARGE, GUIConstants.PORTRAIT_LARGE, Image.SCALE_DEFAULT)));
	}
	
	/**
	 * Displays athlete's current stats
	 */
	private void setStats() {
		JLabel reactionValueLabel = ((DetailPanel) panel).getReactionValueLabel();
		reactionValueLabel.setText(String.valueOf(athlete.getReactionTime()));
		
		JLabel eyesightValueLabel = ((DetailPanel) panel).getEyesightValueLabel();
		eyesightValueLabel.setText(String.valueOf(athlete.getEyeSight()));
		
		JLabel intelligenceValueLabel = ((DetailPanel) panel).getIntelligenceValueLabel();
		intelligenceValueLabel.setText(String.valueOf(athlete.getIntelligence()));
		
		JLabel staminaValueLabel = ((DetailPanel) panel).getStaminaValueLabel();
		staminaValueLabel.setText(String.valueOf(athlete.getStamina()));
		
		JComboBox roleComboBox = ((DetailPanel) panel).getRoleComboBox();
		roleComboBox.setSelectedItem(athlete.getRole());
	}
	
	/**
	 * Initializes back button to return to club
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
	 * Initializes confirm button to confirm changes or show dialog for errors
	 */
	private void initializeConfirmButton() {
		JButton confirmButton = ((DetailPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				JComboBox roleComboBox = ((DetailPanel) panel).getRoleComboBox();
				Role role = (Role) roleComboBox.getSelectedItem();
				
				JTextField nameTextField = ((DetailPanel) panel).getNameTextField();
				String newName = nameTextField.getText();
			
				Team team = frame.getGame().getData().getTeam();
				try {
					athlete.setName(newName);
					team.changeRole(athlete, role);
					toPreviousScreen();
				} catch (IllegalTeamException e1) {
					int shouldSwap = JOptionPane.showConfirmDialog(panel, 
							"Choose a member to swap with or cancel.", 
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
	private void toPreviousScreen() {
		close();
		frame.toClubScreen();
	}
	
	/**
	 * Launches screen to choose athlete in team to swap roles with current athlete
	 */
	private void toRoleSwapScreen(Athlete athlete) {
		close();
		frame.toRoleSwapScreen(athlete);
	}

}
