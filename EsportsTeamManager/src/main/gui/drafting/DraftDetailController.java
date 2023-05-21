package main.gui.drafting;

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
import main.gui.subclassable.DetailController;
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
public final class DraftDetailController extends DetailController {

	/**
	 * Athlete currently in view.
	 */ 
	private Athlete athlete;
	
	/**
	 * Constructor for detail view when drafting.
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param athlete 	Athlete to view
	 */
	public DraftDetailController(GameFrame frame, Athlete athlete) {
		super(frame);
		this.athlete = athlete;
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new DraftDetailPanel();
		
		setHeading();
		super.setPortrait(((DraftDetailPanel) panel).getPortraitLabel(), athlete.getPortraitPath());
		setStats();
		
		initializeBackButton();
		initializeConfirmButton();

		super.launch();
	}

	/**
	 * Sets heading to an editable name
	 */
	private void setHeading() {
		JTextField nameTextField = ((DraftDetailPanel) panel).getNameTextField();
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
		JButton changeNameButton = ((DraftDetailPanel) panel).getChangeNameButton();
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
	 * Displays athlete's current stats and contract price
	 */
	private void setStats() {
		JLabel reactionValueLabel = ((DraftDetailPanel) panel).getReactionValueLabel();
		reactionValueLabel.setText(String.valueOf(athlete.getReactionTime()));
		
		JLabel eyesightValueLabel = ((DraftDetailPanel) panel).getEyesightValueLabel();
		eyesightValueLabel.setText(String.valueOf(athlete.getEyeSight()));
		
		JLabel intelligenceValueLabel = ((DraftDetailPanel) panel).getIntelligenceValueLabel();
		intelligenceValueLabel.setText(String.valueOf(athlete.getIntelligence()));
		
		JLabel staminaValueLabel = ((DraftDetailPanel) panel).getStaminaValueLabel();
		staminaValueLabel.setText(String.valueOf(athlete.getStamina()));
		
		JComboBox roleComboBox = ((DraftDetailPanel) panel).getRoleComboBox();
		roleComboBox.setSelectedItem(athlete.getRole());
		
		Difficulty diff = frame.getGame().getData().getDifficulty();
		int price = athlete.calculatePurchasePrice(diff.modifier);
		JLabel contractValueLabel = ((DraftDetailPanel) panel).getPriceValueLabel();
		contractValueLabel.setText("$" + String.valueOf(price));
	}
	
	/**
	 * Initializes back button to return to draft
	 */
	private void initializeBackButton() {
		JButton backButton = ((DraftDetailPanel) panel).getBackButton();
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
		JButton confirmButton = ((DraftDetailPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				JComboBox roleComboBox = ((DraftDetailPanel) panel).getRoleComboBox();
				Role role = (Role) roleComboBox.getSelectedItem();
				
				JTextField nameTextField = ((DraftDetailPanel) panel).getNameTextField();
				String newName = nameTextField.getText();
				
				
				Market market = frame.getGame().getMarket();
				Team team = frame.getGame().getData().getTeam();
				try {
					market.purchaseAthlete(athlete, role, newName);
					toPreviousScreen();
				} catch (IllegalFundsException e1) {
					JOptionPane.showMessageDialog(panel, 
							"You don't have enough money.", 
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalTeamException e2) {
					JOptionPane.showMessageDialog(panel, 
							"You need to have a full starting team of " + Team.MAIN_LIMIT + " before assigning reserves.", 
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (TeamLimitException e3) {
					switch 	(e3.getType()) {
					case WHOLE:
						JOptionPane.showMessageDialog(panel, 
								"Your team is full.", 
								"Error", JOptionPane.ERROR_MESSAGE);
						break;
					case MAIN:
						int shouldSwap = JOptionPane.showConfirmDialog(panel, 
								"Your main team is full.\nDo you want to replace a current starting member?\n\nYou may also return and assign the new member as a reserve.", 
								"Error", JOptionPane.ERROR_MESSAGE);
						if (shouldSwap == JOptionPane.YES_OPTION) {
							try {
								market.purchaseAthlete(athlete, Role.RESERVE, newName);
								toRoleSwapScreen(athlete);
							} catch (IllegalFundsException | TeamLimitException | IllegalTeamException e1) {
								e1.printStackTrace();
							}
						}
						break;
					default:
						break;
					}
				}
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	private void toPreviousScreen() {
		frame.toDraftScreen();
	}
	
	/**
	 * Launches screen to choose athlete in team to swap roles with drafted athlete
	 */
	private void toRoleSwapScreen(Athlete athlete) {
		frame.toRoleSwapScreen(athlete);
	}

}
