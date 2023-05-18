/**
 * 
 */
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

import main.gui.GameFrame;
import main.gui.panels.AthletePanel;

/**
 * Controls detail screen for an athlete.
 *
 */
public class AthleteController extends Controller {

	/**
	 * @param frame game frame
	 */
	public AthleteController(GameFrame frame) {
		super(frame);
	}

	@Override
	protected void initialize() {
		panel = new AthletePanel();
		
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
            	changeNameButton.setVisible(true);
				nameTextField.setVisible(false);
				changeNameButton.setText(nameTextField.getText());
            }
        });
		
		
		String portraitPath = ((AthletePanel) panel).getPortraitPath();
		
		
		JLabel reactionValueLabel = ((AthletePanel) panel).getReactionValueLabel();
		JLabel eyesightValueLabel = ((AthletePanel) panel).getEyesightValueLabel();
		JLabel intelligenceValueLabel = ((AthletePanel) panel).getIntelligenceValueLabel();
		JLabel staminaValueLabel = ((AthletePanel) panel).getStaminaValueLabel();
		
		JLabel reactionBonusLabel = ((AthletePanel) panel).getReactionBonusLabel();
		JLabel eyesightBonusLabel = ((AthletePanel) panel).getEyesightBonusLabel();
		JLabel intelligenceBonusLabel = ((AthletePanel) panel).getIntelligenceBonusLabel();
		JLabel staminaBonusLabel = ((AthletePanel) panel).getStaminaBonusLabel();
		
		JLabel roleLabel = ((AthletePanel) panel).getRoleLabel();
		JComboBox roleComboBox = ((AthletePanel) panel).getRoleComboBox();
		
		JLabel contractValueLabel = ((AthletePanel) panel).getContractValueLabel();
		
		
		JButton backButton = ((AthletePanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton confirmButton = ((AthletePanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		launch();
	}
	
	private void toPreviousScreen() {
		close();
		
	}

}
