/**
 * 
 */
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

import main.gui.GUIConstants;
import main.gui.GameFrame;
import main.gui.panels.AthletePanel;
import main.model.Athlete;
import main.model.Equipment;

/**
 * Modular controller for athlete detail screen.
 * 
 * @author Jiejun Tan
 *
 */
public class AthleteController extends Controller {

	/**
	 * Athlete currently in view.
	 */
	private Athlete athlete;
	private String previous;
	
	/**
	 * Constructor when drafting or purchasing
	 * 
	 * @param frame 	game frame
	 * @param athlete 	athlete to view
	 */
	public AthleteController(GameFrame frame, Athlete athlete) {
		super(frame);
		this.athlete = athlete;
		initialize();
	}
	
	/**
	 * Constructor when using items on athlete
	 * 
	 * @param frame
	 * @param athlete
	 * @param item
	 */
	public AthleteController(GameFrame frame, Athlete athlete, Equipment item) {
		super(frame);
		this.athlete = athlete;
	}

	@Override
	protected void initialize() {
		panel = new AthletePanel();
		
		setHeading();
		setPortrait();
		setStats();
		
		if (previous == "Item") {
			setBonusStats();
		}
		
		JLabel roleLabel = ((AthletePanel) panel).getRoleLabel();
		JComboBox roleComboBox = ((AthletePanel) panel).getRoleComboBox();
		
		JLabel contractLabel = ((AthletePanel) panel).getContractLabel();
		JLabel contractValueLabel = ((AthletePanel) panel).getContractValueLabel();
		
		
		initializeBackButton();
		
		initializeConfirmButton();
		
		launch();
	}


	/**
	 * Sets heading to an editable name
	 */
	private void setHeading() {
		JTextField nameTextField = ((AthletePanel) panel).getNameTextField();
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
		JButton changeNameButton = ((AthletePanel) panel).getChangeNameButton();
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
		JLabel portraitLabel = ((AthletePanel) panel).getPortraitLabel();
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
	 * Displays athlete's current stats.
	 */
	private void setStats() {
		JLabel reactionValueLabel = ((AthletePanel) panel).getReactionValueLabel();
		reactionValueLabel.setText(String.valueOf(athlete.getReactionTime()));
		
		JLabel eyesightValueLabel = ((AthletePanel) panel).getEyesightValueLabel();
		eyesightValueLabel.setText(String.valueOf(athlete.getEyeSight()));
		
		JLabel intelligenceValueLabel = ((AthletePanel) panel).getIntelligenceValueLabel();
		intelligenceValueLabel.setText(String.valueOf(athlete.getIntelligence()));
		
		JLabel staminaValueLabel = ((AthletePanel) panel).getStaminaValueLabel();
		staminaValueLabel.setText(String.valueOf(athlete.getStamina()));
	}
	
	/**
	 * Displays bonus stats added when using an item.
	 */
	private void setBonusStats() {
		JLabel reactionBonusLabel = ((AthletePanel) panel).getReactionBonusLabel();
		JLabel eyesightBonusLabel = ((AthletePanel) panel).getEyesightBonusLabel();
		JLabel intelligenceBonusLabel = ((AthletePanel) panel).getIntelligenceBonusLabel();
		JLabel staminaBonusLabel = ((AthletePanel) panel).getStaminaBonusLabel();
	}
	
	/**
	 * Initializes back button based on previous screen
	 */
	private void initializeBackButton() {
		JButton backButton = ((AthletePanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Initializes confirm button based on previous screen
	 */
	private void initializeConfirmButton() {
		JButton confirmButton = ((AthletePanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
