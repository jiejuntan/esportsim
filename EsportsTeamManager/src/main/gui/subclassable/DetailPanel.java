package main.gui.subclassable;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.gui.GUIConstants;
import main.model.Team.Role;

/**
 * Subclassable detail layout for athletes and items.
 * 
 * @author Jiejun Tan
 *
 */
public class DetailPanel extends BasePanel {
	
	// Gettable components for controller manipulation. Protected properties are also exposed to subclasses.
	private JFrame frame;
	private JTextField nameTextField;
	private JButton changeNameButton;
	protected JLabel editTipLabel;
	private JLabel portraitLabel;
	
	private JLabel reactionLabel;
	private JLabel eyesightLabel;
	protected JLabel intelligenceLabel;
	protected JLabel staminaLabel;
	
	protected JLabel reactionValueLabel;
	protected JLabel eyesightValueLabel;
	protected JLabel intelligenceValueLabel;
	protected JLabel staminaValueLabel;
	protected JLabel reactionBonusLabel;
	protected JLabel eyesightBonusLabel;
	protected JLabel intelligenceBonusLabel;
	protected JLabel staminaBonusLabel;
	protected JLabel roleLabel;
	protected JComboBox roleComboBox;
	protected JLabel roleValueLabel;
	protected JLabel priceLabel;
	protected JLabel priceValueLabel;
	
	private JButton backButton;
	protected JButton confirmButton;
	
	// Exposed components to toggle visibility in subclasses	
	
	// Prevent instantiation without subclassing
	@SuppressWarnings("unchecked")
	protected DetailPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 50, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 10, 0, 10, 0, 10, 0, 0, 0, 0, 0, 0, 10, 0, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 0.0, 0.0, 3.0};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 2.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 2.0, 1.0, 3.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		changeNameButton = new JButton("Name");
		changeNameButton.setContentAreaFilled(false);
		changeNameButton.setFocusable(false);
		changeNameButton.setHorizontalAlignment(SwingConstants.CENTER);
		changeNameButton.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.HEADING));
		changeNameButton.setPreferredSize(new Dimension(1000, 85));		
		GridBagConstraints gbc_changeNameButton = new GridBagConstraints();
		gbc_changeNameButton.gridwidth = 10;
		gbc_changeNameButton.insets = new Insets(0, 0, 5, 0);
		gbc_changeNameButton.gridx = 0;
		gbc_changeNameButton.gridy = 1;
		this.add(changeNameButton, gbc_changeNameButton);
		
		nameTextField = new JTextField(changeNameButton.getText());		
		nameTextField.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		nameTextField.setVisible(false);
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setPreferredSize(new Dimension(450, 85));
		nameTextField.setMargin(new Insets(5, 10, 2, 10));
		nameTextField.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.HEADING));
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameTextField.gridwidth = 10;
		gbc_nameTextField.gridx = 0;
		gbc_nameTextField.gridy = 1;
		this.add(nameTextField, gbc_nameTextField);
		
		editTipLabel = new JLabel("(click to edit)");
		editTipLabel.setVisible(false);
		editTipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editTipLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.DETAIL));
		GridBagConstraints gbc_editTipLabel = new GridBagConstraints();
		gbc_editTipLabel.insets = new Insets(0, 0, 5, 0);
		gbc_editTipLabel.gridwidth = 10;
		gbc_editTipLabel.gridx = 0;
		gbc_editTipLabel.gridy = 2;
		this.add(editTipLabel, gbc_editTipLabel);

		portraitLabel = new JLabel();
		portraitLabel.setBackground(GUIConstants.PORTRAIT_BACKGROUND);
		portraitLabel.setOpaque(true);
		portraitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		portraitLabel.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_LARGE, GUIConstants.PORTRAIT_LARGE));
		portraitLabel.setBorder(GUIConstants.PORTRAIT_BORDER_LARGE);
		GridBagConstraints gbc_portraitLabel = new GridBagConstraints();
		gbc_portraitLabel.gridheight = 11;
		gbc_portraitLabel.gridwidth = 3;
		gbc_portraitLabel.insets = new Insets(0, 0, 5, 5);
		gbc_portraitLabel.gridx = 1;
		gbc_portraitLabel.gridy = 3;
		this.add(portraitLabel, gbc_portraitLabel);
		
		
		reactionLabel = new JLabel("Reaction time:");
		reactionLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_reactionLabel = new GridBagConstraints();
		gbc_reactionLabel.anchor = GridBagConstraints.WEST;
		gbc_reactionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reactionLabel.gridx = 5;
		gbc_reactionLabel.gridy = 4;
		this.add(reactionLabel, gbc_reactionLabel);
		
		reactionValueLabel = new JLabel("5");
		reactionValueLabel.setVisible(false);
		reactionValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_reactionValueLabel = new GridBagConstraints();
		gbc_reactionValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reactionValueLabel.gridx = 7;
		gbc_reactionValueLabel.gridy = 4;
		this.add(reactionValueLabel, gbc_reactionValueLabel);
		
		reactionBonusLabel = new JLabel("-");
		reactionBonusLabel.setVisible(false);
		reactionBonusLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_reactionBonusLabel = new GridBagConstraints();
		gbc_reactionBonusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reactionBonusLabel.gridx = 8;
		gbc_reactionBonusLabel.gridy = 4;
		this.add(reactionBonusLabel, gbc_reactionBonusLabel);
		
		eyesightLabel = new JLabel("Eyesight:");
		eyesightLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_eyesightLabel = new GridBagConstraints();
		gbc_eyesightLabel.anchor = GridBagConstraints.WEST;
		gbc_eyesightLabel.insets = new Insets(0, 0, 5, 5);
		gbc_eyesightLabel.gridx = 5;
		gbc_eyesightLabel.gridy = 6;
		this.add(eyesightLabel, gbc_eyesightLabel);
		
		eyesightValueLabel = new JLabel("5");
		eyesightValueLabel.setVisible(false);
		eyesightValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_eyesightValueLabel = new GridBagConstraints();
		gbc_eyesightValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_eyesightValueLabel.gridx = 7;
		gbc_eyesightValueLabel.gridy = 6;
		this.add(eyesightValueLabel, gbc_eyesightValueLabel);
		
		eyesightBonusLabel = new JLabel("-");
		eyesightBonusLabel.setVisible(false);
		eyesightBonusLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_eyesightBonusLabel = new GridBagConstraints();
		gbc_eyesightBonusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_eyesightBonusLabel.gridx = 8;
		gbc_eyesightBonusLabel.gridy = 6;
		this.add(eyesightBonusLabel, gbc_eyesightBonusLabel);
		
		intelligenceLabel = new JLabel("Intelligence:");
		intelligenceLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_intelligenceLabel = new GridBagConstraints();
		gbc_intelligenceLabel.anchor = GridBagConstraints.WEST;
		gbc_intelligenceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intelligenceLabel.gridx = 5;
		gbc_intelligenceLabel.gridy = 8;
		this.add(intelligenceLabel, gbc_intelligenceLabel);
		
		intelligenceValueLabel = new JLabel("5");
		intelligenceValueLabel.setVisible(false);
		intelligenceValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_intelligenceValueLabel = new GridBagConstraints();
		gbc_intelligenceValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intelligenceValueLabel.gridx = 7;
		gbc_intelligenceValueLabel.gridy = 8;
		this.add(intelligenceValueLabel, gbc_intelligenceValueLabel);
		
		intelligenceBonusLabel = new JLabel("-");
		intelligenceBonusLabel.setVisible(false);
		intelligenceBonusLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_intelligenceBonusLabel = new GridBagConstraints();
		gbc_intelligenceBonusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intelligenceBonusLabel.gridx = 8;
		gbc_intelligenceBonusLabel.gridy = 8;
		this.add(intelligenceBonusLabel, gbc_intelligenceBonusLabel);
		
		staminaLabel = new JLabel("Focus:");
		staminaLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_staminaLabel = new GridBagConstraints();
		gbc_staminaLabel.anchor = GridBagConstraints.WEST;
		gbc_staminaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_staminaLabel.gridx = 5;
		gbc_staminaLabel.gridy = 10;
		this.add(staminaLabel, gbc_staminaLabel);
		
		staminaValueLabel = new JLabel("5");
		staminaValueLabel.setVisible(false);
		staminaValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_staminaValueLabel = new GridBagConstraints();
		gbc_staminaValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_staminaValueLabel.gridx = 7;
		gbc_staminaValueLabel.gridy = 10;
		this.add(staminaValueLabel, gbc_staminaValueLabel);
		
		staminaBonusLabel = new JLabel("-");
		staminaBonusLabel.setVisible(false);
		staminaBonusLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_staminaBonusLabel = new GridBagConstraints();
		gbc_staminaBonusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_staminaBonusLabel.gridx = 8;
		gbc_staminaBonusLabel.gridy = 10;
		this.add(staminaBonusLabel, gbc_staminaBonusLabel);
		
		
		roleLabel = new JLabel("Role:");
		roleLabel.setVisible(false);
		roleLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_roleLabel = new GridBagConstraints();
		gbc_roleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roleLabel.anchor = GridBagConstraints.WEST;
		gbc_roleLabel.gridx = 5;
		gbc_roleLabel.gridy = 12;
		this.add(roleLabel, gbc_roleLabel);
		
		roleComboBox = new JComboBox();
		roleComboBox.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		roleComboBox.setVisible(false);
		roleComboBox.setModel(new DefaultComboBoxModel(Role.values()));
		roleComboBox.setPreferredSize(new Dimension(205, 50));
		roleComboBox.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_roleComboBox = new GridBagConstraints();
		gbc_roleComboBox.gridwidth = 3;
		gbc_roleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox.gridx = 6;
		gbc_roleComboBox.gridy = 12;
		this.add(roleComboBox, gbc_roleComboBox);
		
		roleValueLabel = new JLabel();
		roleValueLabel.setVisible(false);
		roleValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_roleValueLabel = new GridBagConstraints();
		gbc_roleValueLabel.gridwidth = 3;
		gbc_roleValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roleValueLabel.gridx = 6;
		gbc_roleValueLabel.gridy = 12;
		this.add(roleValueLabel, gbc_roleValueLabel);
		
		priceLabel = new JLabel("Price:");
		priceLabel.setVisible(false);
		priceLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_contractLabel = new GridBagConstraints();
		gbc_contractLabel.anchor = GridBagConstraints.WEST;
		gbc_contractLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contractLabel.gridx = 5;
		gbc_contractLabel.gridy = 14;
		this.add(priceLabel, gbc_contractLabel);
		
		priceValueLabel = new JLabel();
		priceValueLabel.setVisible(false);
		priceValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_contractValueLabel = new GridBagConstraints();
		gbc_contractValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contractValueLabel.gridx = 7;
		gbc_contractValueLabel.gridy = 14;
		this.add(priceValueLabel, gbc_contractValueLabel);
		
		
		backButton = new JButton("Back");
		super.setupButton(backButton);
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.gridwidth = 3;
		gbc_backButton.insets = new Insets(0, 0, 5, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 16;
		this.add(backButton, gbc_backButton);
		
		confirmButton = new JButton("Confirm");
		super.setupButton(confirmButton);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 16;
		this.add(confirmButton, gbc_btnNewButton);
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
	 * @return the editTipLabel
	 */
	public JLabel getEditTipLabel() {
		return editTipLabel;
	}

	/**
	 * @return the portraitLabel
	 */
	public JLabel getPortraitLabel() {
		return portraitLabel;
	}

	/**
	 * @return the reactionLabel
	 */
	public JLabel getReactionLabel() {
		return reactionLabel;
	}

	/**
	 * @return the eyesightLabel
	 */
	public JLabel getEyesightLabel() {
		return eyesightLabel;
	}

	/**
	 * @return the intelligenceLabel
	 */
	public JLabel getIntelligenceLabel() {
		return intelligenceLabel;
	}

	/**
	 * @return the staminaLabel
	 */
	public JLabel getStaminaLabel() {
		return staminaLabel;
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
	 * @return the roleValueLabel
	 */
	public JLabel getRoleValueLabel() {
		return roleValueLabel;
	}

	/**
	 * @return the priceLabel
	 */
	public JLabel getPriceLabel() {
		return priceLabel;
	}

	/**
	 * @return the priceValueLabel
	 */
	public JLabel getPriceValueLabel() {
		return priceValueLabel;
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
