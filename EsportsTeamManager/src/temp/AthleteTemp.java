package temp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import main.gui.GUIConstants;
import main.gui.RoundClipBorder;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import main.model.Team.Role;

public class AthleteTemp {

	private JFrame frame;
	private JTextField nameTextField;
	private JButton changeNameButton;
	private JLabel portraitLabel;
	private JLabel reactionValueLabel;
	private JLabel eyesightValueLabel;
	private JLabel intelligenceValueLabel;
	private JLabel staminaValueLabel;
	private JLabel reactionBonusLabel;
	private JLabel eyesightBonusLabel;
	private JLabel intelligenceBonusLabel;
	private JLabel staminaBonusLabel;
	private JLabel roleLabel;
	private JComboBox roleComboBox;
	private JLabel contractValueLabel;
	private JButton backButton;
	private JButton confirmButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AthleteTemp window = new AthleteTemp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AthleteTemp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1600,900));
		frame.setResizable(false);
		frame.setBounds(100, 100, 100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 20);
		UIManager.put("Button.hoverBorderColor", Color.LIGHT_GRAY);
		UIManager.put("TextComponent.arc", 20);
		UIManager.put("Component.focusColor", Color.LIGHT_GRAY);
		UIManager.put("Component.focusedBorderColor", Color.LIGHT_GRAY);
		
		
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 50, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 10, 0, 10, 0, 10, 0, 0, 0, 0, 0, 0, 10, 0, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 0.0, 0.0, 3.0};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 2.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 2.0, 1.0, 3.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	changeNameButton.setVisible(true);
				nameTextField.setVisible(false);
				changeNameButton.setText(nameTextField.getText());
            }
        });
		
		
		changeNameButton = new JButton("Name");
		changeNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeNameButton.setVisible(false);
				nameTextField.setVisible(true);
				nameTextField.requestFocusInWindow();
			}
		});
		changeNameButton.setContentAreaFilled(false);
		changeNameButton.setFocusable(false);
		changeNameButton.setHorizontalAlignment(SwingConstants.CENTER);
		changeNameButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.HEADING));
		changeNameButton.setPreferredSize(new Dimension(500, 60));		
		GridBagConstraints gbc_changeNameButton = new GridBagConstraints();
		gbc_changeNameButton.gridwidth = 10;
		gbc_changeNameButton.insets = new Insets(0, 0, 5, 0);
		gbc_changeNameButton.gridx = 0;
		gbc_changeNameButton.gridy = 1;
		panel.add(changeNameButton, gbc_changeNameButton);
		
		nameTextField = new JTextField(changeNameButton.getText());		
		nameTextField.setVisible(false);
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setPreferredSize(new Dimension(350, 60));
		nameTextField.setMargin(new Insets(5, 10, 2, 10));
		nameTextField.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.HEADING));
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameTextField.gridwidth = 10;
		gbc_nameTextField.gridx = 0;
		gbc_nameTextField.gridy = 1;
		panel.add(nameTextField, gbc_nameTextField);
		
		JLabel editTipLabel = new JLabel("(click to edit)");
		editTipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editTipLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		GridBagConstraints gbc_editTipLabel = new GridBagConstraints();
		gbc_editTipLabel.insets = new Insets(0, 0, 5, 0);
		gbc_editTipLabel.gridwidth = 10;
		gbc_editTipLabel.gridx = 0;
		gbc_editTipLabel.gridy = 2;
		panel.add(editTipLabel, gbc_editTipLabel);
		
		
		portraitLabel = new JLabel();
		ImageIcon portraitIcon = new ImageIcon(getClass().getResource(GUIConstants.PORTRAIT_PLACEHOLDER));
		Image portraitImage = portraitIcon.getImage().getScaledInstance(GUIConstants.PORTRAIT_LARGE, GUIConstants.PORTRAIT_LARGE, Image.SCALE_DEFAULT);
		portraitLabel.setIcon(new ImageIcon(portraitImage));
		portraitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		portraitLabel.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_LARGE, GUIConstants.PORTRAIT_LARGE));
		portraitLabel.setBorder(GUIConstants.PORTRAIT_BORDER_LARGE);
		GridBagConstraints gbc_portraitLabel = new GridBagConstraints();
		gbc_portraitLabel.gridheight = 11;
		gbc_portraitLabel.gridwidth = 3;
		gbc_portraitLabel.insets = new Insets(0, 0, 5, 5);
		gbc_portraitLabel.gridx = 1;
		gbc_portraitLabel.gridy = 3;
		panel.add(portraitLabel, gbc_portraitLabel);
		
		
		JLabel reactionLabel = new JLabel("Reaction time:");
		reactionLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_reactionLabel = new GridBagConstraints();
		gbc_reactionLabel.anchor = GridBagConstraints.WEST;
		gbc_reactionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reactionLabel.gridx = 5;
		gbc_reactionLabel.gridy = 4;
		panel.add(reactionLabel, gbc_reactionLabel);
		
		reactionValueLabel = new JLabel("5");
		reactionValueLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_reactionValueLabel = new GridBagConstraints();
		gbc_reactionValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reactionValueLabel.gridx = 7;
		gbc_reactionValueLabel.gridy = 4;
		panel.add(reactionValueLabel, gbc_reactionValueLabel);
		
		reactionBonusLabel = new JLabel("+5");
		reactionBonusLabel.setForeground(GUIConstants.BONUS_UP);
		reactionBonusLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_reactionBonusLabel = new GridBagConstraints();
		gbc_reactionBonusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reactionBonusLabel.gridx = 8;
		gbc_reactionBonusLabel.gridy = 4;
		panel.add(reactionBonusLabel, gbc_reactionBonusLabel);
		
		JLabel eyesightLabel = new JLabel("Eyesight:");
		eyesightLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_eyesightLabel = new GridBagConstraints();
		gbc_eyesightLabel.anchor = GridBagConstraints.WEST;
		gbc_eyesightLabel.insets = new Insets(0, 0, 5, 5);
		gbc_eyesightLabel.gridx = 5;
		gbc_eyesightLabel.gridy = 6;
		panel.add(eyesightLabel, gbc_eyesightLabel);
		
		eyesightValueLabel = new JLabel("5");
		eyesightValueLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_eyesightValueLabel = new GridBagConstraints();
		gbc_eyesightValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_eyesightValueLabel.gridx = 7;
		gbc_eyesightValueLabel.gridy = 6;
		panel.add(eyesightValueLabel, gbc_eyesightValueLabel);
		
		eyesightBonusLabel = new JLabel("+5");
		eyesightBonusLabel.setForeground(GUIConstants.BONUS_UP);
		eyesightBonusLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_eyesightBonusLabel = new GridBagConstraints();
		gbc_eyesightBonusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_eyesightBonusLabel.gridx = 8;
		gbc_eyesightBonusLabel.gridy = 6;
		panel.add(eyesightBonusLabel, gbc_eyesightBonusLabel);
		
		JLabel intelligenceLabel = new JLabel("Intelligence:");
		intelligenceLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_intelligenceLabel = new GridBagConstraints();
		gbc_intelligenceLabel.anchor = GridBagConstraints.WEST;
		gbc_intelligenceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intelligenceLabel.gridx = 5;
		gbc_intelligenceLabel.gridy = 8;
		panel.add(intelligenceLabel, gbc_intelligenceLabel);
		
		intelligenceValueLabel = new JLabel("5");
		intelligenceValueLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_intelligenceValueLabel = new GridBagConstraints();
		gbc_intelligenceValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intelligenceValueLabel.gridx = 7;
		gbc_intelligenceValueLabel.gridy = 8;
		panel.add(intelligenceValueLabel, gbc_intelligenceValueLabel);
		
		intelligenceBonusLabel = new JLabel("-5");
		intelligenceBonusLabel.setForeground(GUIConstants.BONUS_DOWN);
		intelligenceBonusLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_intelligenceBonusLabel = new GridBagConstraints();
		gbc_intelligenceBonusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intelligenceBonusLabel.gridx = 8;
		gbc_intelligenceBonusLabel.gridy = 8;
		panel.add(intelligenceBonusLabel, gbc_intelligenceBonusLabel);
		
		JLabel staminaLabel = new JLabel("Stamina:");
		staminaLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_staminaLabel = new GridBagConstraints();
		gbc_staminaLabel.anchor = GridBagConstraints.WEST;
		gbc_staminaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_staminaLabel.gridx = 5;
		gbc_staminaLabel.gridy = 10;
		panel.add(staminaLabel, gbc_staminaLabel);
		
		staminaValueLabel = new JLabel("5");
		staminaValueLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_staminaValueLabel = new GridBagConstraints();
		gbc_staminaValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_staminaValueLabel.gridx = 7;
		gbc_staminaValueLabel.gridy = 10;
		panel.add(staminaValueLabel, gbc_staminaValueLabel);
		
		staminaBonusLabel = new JLabel("+5");
		staminaBonusLabel.setForeground(GUIConstants.BONUS_UP);
		staminaBonusLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_staminaBonusLabel = new GridBagConstraints();
		gbc_staminaBonusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_staminaBonusLabel.gridx = 8;
		gbc_staminaBonusLabel.gridy = 10;
		panel.add(staminaBonusLabel, gbc_staminaBonusLabel);
		
		
		roleLabel = new JLabel("Role:");
		roleLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_roleLabel = new GridBagConstraints();
		gbc_roleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roleLabel.anchor = GridBagConstraints.WEST;
		gbc_roleLabel.gridx = 5;
		gbc_roleLabel.gridy = 12;
		panel.add(roleLabel, gbc_roleLabel);
		
		roleComboBox = new JComboBox();
		roleComboBox.setModel(new DefaultComboBoxModel(Role.values()));
		roleComboBox.setPreferredSize(new Dimension(200, 50));
		roleComboBox.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_roleComboBox = new GridBagConstraints();
		gbc_roleComboBox.gridwidth = 3;
		gbc_roleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox.gridx = 6;
		gbc_roleComboBox.gridy = 12;
		panel.add(roleComboBox, gbc_roleComboBox);
		
		
		JLabel contractLabel = new JLabel("Contract:");
		contractLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_contractLabel = new GridBagConstraints();
		gbc_contractLabel.anchor = GridBagConstraints.WEST;
		gbc_contractLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contractLabel.gridx = 5;
		gbc_contractLabel.gridy = 14;
		panel.add(contractLabel, gbc_contractLabel);
		
		contractValueLabel = new JLabel("$200");
		contractValueLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_contractValueLabel = new GridBagConstraints();
		gbc_contractValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contractValueLabel.gridx = 7;
		gbc_contractValueLabel.gridy = 14;
		panel.add(contractValueLabel, gbc_contractValueLabel);
		
		
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(200, 50));
		backButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.gridwidth = 3;
		gbc_backButton.insets = new Insets(0, 0, 5, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 16;
		panel.add(backButton, gbc_backButton);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setFocusPainted(false);
		confirmButton.setPreferredSize(new Dimension(200, 50));
		confirmButton.setBackground(Color.LIGHT_GRAY);
		confirmButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 16;
		panel.add(confirmButton, gbc_btnNewButton);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the nameTextField
	 */
	public JTextField getNameTextField() {
		return nameTextField;
	}

	/**
	 * @return the changeNameButton
	 */
	public JButton getChangeNameButton() {
		return changeNameButton;
	}

	/**
	 * @return the portraitLabel
	 */
	public JLabel getPortraitLabel() {
		return portraitLabel;
	}

	/**
	 * @return the reactionValueLabel
	 */
	public JLabel getReactionValueLabel() {
		return reactionValueLabel;
	}

	/**
	 * @return the eyesightValueLabel
	 */
	public JLabel getEyesightValueLabel() {
		return eyesightValueLabel;
	}

	/**
	 * @return the intelligenceValueLabel
	 */
	public JLabel getIntelligenceValueLabel() {
		return intelligenceValueLabel;
	}

	/**
	 * @return the staminaValueLabel
	 */
	public JLabel getStaminaValueLabel() {
		return staminaValueLabel;
	}

	/**
	 * @return the reactionBonusLabel
	 */
	public JLabel getReactionBonusLabel() {
		return reactionBonusLabel;
	}

	/**
	 * @return the eyesightBonusLabel
	 */
	public JLabel getEyesightBonusLabel() {
		return eyesightBonusLabel;
	}

	/**
	 * @return the intelligenceBonusLabel
	 */
	public JLabel getIntelligenceBonusLabel() {
		return intelligenceBonusLabel;
	}

	/**
	 * @return the staminaBonusLabel
	 */
	public JLabel getStaminaBonusLabel() {
		return staminaBonusLabel;
	}

	/**
	 * @return the roleLabel
	 */
	public JLabel getRoleLabel() {
		return roleLabel;
	}

	/**
	 * @return the roleComboBox
	 */
	public JComboBox getRoleComboBox() {
		return roleComboBox;
	}

	/**
	 * @return the contractValueLabel
	 */
	public JLabel getContractValueLabel() {
		return contractValueLabel;
	}

	/**
	 * @return the backButton
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * @return the confirmButton
	 */
	public JButton getConfirmButton() {
		return confirmButton;
	}

}
