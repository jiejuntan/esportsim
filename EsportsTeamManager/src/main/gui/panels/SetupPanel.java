package main.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import main.gui.GUIConstants;
import main.gui.panels.subclassable.BasePanel;

public class SetupPanel extends BasePanel {
	
	private JTextField teamNameTextField;
	private JSlider durationSlider;
	private JToggleButton easyToggleButton;
	private JToggleButton hardToggleButton;
	private JButton confirmButton;
	
	public SetupPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 30, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 30, 0, 30, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 5.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
				
		JLabel titleLabel = new JLabel("New Game");
		super.setupTitle(titleLabel);
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridwidth = 5;
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 1;
		this.add(titleLabel, gbc_titleLabel);
		
		
		JLabel teamNameLabel = new JLabel("Team Name:");
		teamNameLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_teamNameLabel = new GridBagConstraints();
		gbc_teamNameLabel.anchor = GridBagConstraints.WEST;
		gbc_teamNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_teamNameLabel.gridx = 1;
		gbc_teamNameLabel.gridy = 3;
		this.add(teamNameLabel, gbc_teamNameLabel);
		
		teamNameTextField = new JTextField();
		teamNameTextField.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		teamNameTextField.setBackground(Color.WHITE);
		teamNameTextField.setPreferredSize(new Dimension(200, 50));
		teamNameTextField.setMargin(new Insets(5, 10, 2, 10));
		teamNameTextField.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_teamNameTextField = new GridBagConstraints();
		gbc_teamNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_teamNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_teamNameTextField.gridwidth = 3;
		gbc_teamNameTextField.gridx = 3;
		gbc_teamNameTextField.gridy = 3;
		this.add(teamNameTextField, gbc_teamNameTextField);
		
		
		JLabel durationLabel = new JLabel("Season Duration:");
		durationLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_durationLabel = new GridBagConstraints();
		gbc_durationLabel.anchor = GridBagConstraints.WEST;
		gbc_durationLabel.insets = new Insets(0, 0, 5, 5);
		gbc_durationLabel.gridx = 1;
		gbc_durationLabel.gridy = 5;
		this.add(durationLabel, gbc_durationLabel);
		
		durationSlider = new JSlider();
		durationSlider.setBackground(Color.BLACK);
		durationSlider.setForeground(Color.BLACK);
		durationSlider.setPreferredSize(new Dimension(200, 50));
		durationSlider.setOpaque(false);
		durationSlider.setMajorTickSpacing(1);
		durationSlider.setPaintLabels(true);
		durationSlider.setMinimum(5);
		durationSlider.setMaximum(15);
		durationSlider.setSnapToTicks(true);
		durationSlider.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		durationSlider.setBorder(null);
		GridBagConstraints gbc_durationSlider = new GridBagConstraints();
		gbc_durationSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_durationSlider.insets = new Insets(0, 0, 5, 5);
		gbc_durationSlider.gridwidth = 3;
		gbc_durationSlider.gridx = 3;
		gbc_durationSlider.gridy = 5;
		this.add(durationSlider, gbc_durationSlider);
		
		
		JLabel difficultyLabel = new JLabel("Difficulty:");
		difficultyLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_difficultyLabel = new GridBagConstraints();
		gbc_difficultyLabel.anchor = GridBagConstraints.WEST;
		gbc_difficultyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_difficultyLabel.gridx = 1;
		gbc_difficultyLabel.gridy = 7;
		this.add(difficultyLabel, gbc_difficultyLabel);
		
		ButtonGroup difficultyGroup = new ButtonGroup();
		
		easyToggleButton = new JToggleButton("Easy");
		difficultyGroup.add(easyToggleButton);
		easyToggleButton.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		easyToggleButton.setPreferredSize(new Dimension(200, 50));
		easyToggleButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		easyToggleButton.setBackground(GUIConstants.COMPONENT);
		easyToggleButton.setFocusPainted(false);
		GridBagConstraints gbc_easyToggleButton = new GridBagConstraints();
		gbc_easyToggleButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_easyToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_easyToggleButton.gridx = 3;
		gbc_easyToggleButton.gridy = 7;
		this.add(easyToggleButton, gbc_easyToggleButton);
		
		hardToggleButton = new JToggleButton("Hard");
		difficultyGroup.add(hardToggleButton);
		hardToggleButton.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		hardToggleButton.setPreferredSize(new Dimension(200, 50));
		hardToggleButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		hardToggleButton.setBackground(GUIConstants.COMPONENT);
		hardToggleButton.setFocusPainted(false);
		GridBagConstraints gbc_hardToggleButton = new GridBagConstraints();
		gbc_hardToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_hardToggleButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_hardToggleButton.gridx = 5;
		gbc_hardToggleButton.gridy = 7;
		this.add(hardToggleButton, gbc_hardToggleButton);
		
		
		confirmButton = new JButton("Confirm");
		super.setupButton(confirmButton);
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_confirmButton.gridwidth = 3;
		gbc_confirmButton.insets = new Insets(0, 0, 5, 5);
		gbc_confirmButton.gridx = 3;
		gbc_confirmButton.gridy = 9;
		this.add(confirmButton, gbc_confirmButton);	
	}

	/**
	 * @return the teamNameTextField
	 */
	public JTextField getTeamNameTextField() {
		return teamNameTextField;
	}

	/**
	 * @return the durationSlider
	 */
	public JSlider getDurationSlider() {
		return durationSlider;
	}

	/**
	 * @return the easyToggleButton
	 */
	public JToggleButton getEasyToggleButton() {
		return easyToggleButton;
	}

	/**
	 * @return the hardToggleButton
	 */
	public JToggleButton getHardToggleButton() {
		return hardToggleButton;
	}

	/**
	 * @return the confirmButton
	 */
	public JButton getConfirmButton() {
		return confirmButton;
	}
}
