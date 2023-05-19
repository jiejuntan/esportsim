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
import main.exceptions.TeamMemberLimitException;
import main.gui.GUIConstants;
import main.gui.GameFrame;
import main.gui.panels.DetailPanel;
import main.gui.panels.DraftDetailPanel;
import main.model.Team.Role;
import main.model.Athlete;
import main.model.GameData.Difficulty;
import main.model.Market;

/**
 * Controller for detail screen during draft
 * 
 * @author Jiejun Tan
 *
 */
public class DraftDetailController extends Controller {

	/**
	 * Athlete currently in view.
	 */ 
	private Athlete athlete;
	
	/**
	 * Constructor when drafting
	 * 
	 * @param frame 	game frame
	 * @param athlete 	athlete to view
	 */
	public DraftDetailController(GameFrame frame, Athlete athlete) {
		super(frame);
		this.athlete = athlete;
		initialize();
	}

	/**
	 * Runs initialize methods and launches panel
	 */
	@Override
	protected void initialize() {
		panel = new DraftDetailPanel();
		
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
	 * Displays athlete's current stats and contract price
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
		
		
		Difficulty diff = frame.getGame().getData().getDifficulty();
		int price = athlete.calculatePurchasePrice(diff.modifier);
		JLabel contractValueLabel = ((DetailPanel) panel).getPriceValueLabel();
		contractValueLabel.setText("$" + String.valueOf(price));
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
				JComboBox roleComboBox = ((DetailPanel) panel).getRoleComboBox();
				Role role = (Role) roleComboBox.getSelectedItem();
				
				JTextField nameTextField = ((DetailPanel) panel).getNameTextField();
				String newName = nameTextField.getText();
				
				
				Market market = frame.getGame().getMarket();
				try {
					market.purchaseAthlete(athlete, role, newName);
					toPreviousScreen();
				} catch (IllegalFundsException e1) {
					JOptionPane.showMessageDialog(panel, 
							"You don't have enough money.", 
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (TeamMemberLimitException e2) {
					switch (e2.getType()) {
					case WHOLE:
						JOptionPane.showMessageDialog(panel, 
								"Your team is full.", 
								"Error", JOptionPane.ERROR_MESSAGE);
						break;
					case MAIN:
						JOptionPane.showMessageDialog(panel, 
								"Your main team is full.", 
								"Error", JOptionPane.ERROR_MESSAGE);
						break;
					case RESERVE:
						JOptionPane.showMessageDialog(panel, 
								"Your reserve team is full.", 
								"Error", JOptionPane.ERROR_MESSAGE);
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
		close();
		
		frame.toDraftScreen();
	}

}
