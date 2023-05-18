package main.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Resources.RoundClipBorder;

public class AthletePanel extends JPanel {
	
	private JFrame frame;
	private JTextField nameTextField;
	private JButton changeNameButton;
	private String portraitPath;
	private JLabel reactionValueLabel;
	private JLabel eyesightValueLabel;
	private JLabel intelligenceValueLabel;
	private JLabel staminaValueLabel;
	private JLabel contractValueLabel;
	private JButton backButton;
	private JButton confirmButton;
	
	public AthletePanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 10, 0, 10, 0, 10, 0, 0, 0, 0, 0, 10, 0, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 3.0};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 2.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 2.0, 1.0, 3.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		
		this.addMouseListener(new MouseAdapter() {
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
		changeNameButton.setFont(new Font("Unispace", Font.PLAIN, 40));
		changeNameButton.setPreferredSize(new Dimension(500, 50));		
		GridBagConstraints gbc_changeNameButton = new GridBagConstraints();
		gbc_changeNameButton.gridwidth = 9;
		gbc_changeNameButton.insets = new Insets(0, 0, 5, 5);
		gbc_changeNameButton.gridx = 0;
		gbc_changeNameButton.gridy = 1;
		this.add(changeNameButton, gbc_changeNameButton);
		
		nameTextField = new JTextField(changeNameButton.getText());		
		nameTextField.setVisible(false);
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setPreferredSize(new Dimension(350, 50));
		nameTextField.setMargin(new Insets(5, 10, 2, 10));
		nameTextField.setFont(new Font("Unispace", Font.PLAIN, 40));
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameTextField.gridwidth = 9;
		gbc_nameTextField.gridx = 0;
		gbc_nameTextField.gridy = 1;
		this.add(nameTextField, gbc_nameTextField);
		
		JLabel editTipLabel = new JLabel("(click to edit)");
		editTipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editTipLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_editTipLabel = new GridBagConstraints();
		gbc_editTipLabel.insets = new Insets(0, 0, 5, 0);
		gbc_editTipLabel.gridwidth = 9;
		gbc_editTipLabel.gridx = 0;
		gbc_editTipLabel.gridy = 2;
		this.add(editTipLabel, gbc_editTipLabel);
		
		
		int portraitSize = 300;
		portraitPath = "/main/Resources/placeholder_portrait.jpg";
		ImageIcon portraitIcon = new ImageIcon(AthletePanel.class.getResource(portraitPath));
		Image portraitImage = portraitIcon.getImage().getScaledInstance(portraitSize, portraitSize, Image.SCALE_DEFAULT);
		JLabel portraitLabel = new JLabel();
		portraitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		portraitLabel.setIcon(new ImageIcon(portraitImage));
		portraitLabel.setPreferredSize(new Dimension(portraitSize, portraitSize));
		portraitLabel.setBorder(new RoundClipBorder(Color.BLACK, 2, 50, 0));
		GridBagConstraints gbc_lblImg = new GridBagConstraints();
		gbc_lblImg.gridheight = 11;
		gbc_lblImg.gridwidth = 3;
		gbc_lblImg.insets = new Insets(0, 0, 5, 5);
		gbc_lblImg.gridx = 1;
		gbc_lblImg.gridy = 3;
		this.add(portraitLabel, gbc_lblImg);
		
		
		JLabel reactionLabel = new JLabel("Reaction time:");
		reactionLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_reactionLabel = new GridBagConstraints();
		gbc_reactionLabel.anchor = GridBagConstraints.WEST;
		gbc_reactionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reactionLabel.gridx = 5;
		gbc_reactionLabel.gridy = 4;
		this.add(reactionLabel, gbc_reactionLabel);
		
		reactionValueLabel = new JLabel("5");
		reactionValueLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_reactionValueLabel = new GridBagConstraints();
		gbc_reactionValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reactionValueLabel.gridx = 7;
		gbc_reactionValueLabel.gridy = 4;
		this.add(reactionValueLabel, gbc_reactionValueLabel);
		
		JLabel eyesightLabel = new JLabel("Eyesight:");
		eyesightLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_eyesightLabel = new GridBagConstraints();
		gbc_eyesightLabel.anchor = GridBagConstraints.WEST;
		gbc_eyesightLabel.insets = new Insets(0, 0, 5, 5);
		gbc_eyesightLabel.gridx = 5;
		gbc_eyesightLabel.gridy = 6;
		this.add(eyesightLabel, gbc_eyesightLabel);
		
		eyesightValueLabel = new JLabel("5");
		eyesightValueLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_eyesightValueLabel = new GridBagConstraints();
		gbc_eyesightValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_eyesightValueLabel.gridx = 7;
		gbc_eyesightValueLabel.gridy = 6;
		this.add(eyesightValueLabel, gbc_eyesightValueLabel);
		
		JLabel intelligenceLabel = new JLabel("Intelligence:");
		intelligenceLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_intelligenceLabel = new GridBagConstraints();
		gbc_intelligenceLabel.anchor = GridBagConstraints.WEST;
		gbc_intelligenceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intelligenceLabel.gridx = 5;
		gbc_intelligenceLabel.gridy = 8;
		this.add(intelligenceLabel, gbc_intelligenceLabel);
		
		intelligenceValueLabel = new JLabel("5");
		intelligenceValueLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_intelligenceValueLabel = new GridBagConstraints();
		gbc_intelligenceValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_intelligenceValueLabel.gridx = 7;
		gbc_intelligenceValueLabel.gridy = 8;
		this.add(intelligenceValueLabel, gbc_intelligenceValueLabel);
		
		JLabel staminaLabel = new JLabel("Stamina:");
		staminaLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_staminaLabel = new GridBagConstraints();
		gbc_staminaLabel.anchor = GridBagConstraints.WEST;
		gbc_staminaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_staminaLabel.gridx = 5;
		gbc_staminaLabel.gridy = 10;
		this.add(staminaLabel, gbc_staminaLabel);
		
		staminaValueLabel = new JLabel("5");
		staminaValueLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_staminaValueLabel = new GridBagConstraints();
		gbc_staminaValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_staminaValueLabel.gridx = 7;
		gbc_staminaValueLabel.gridy = 10;
		this.add(staminaValueLabel, gbc_staminaValueLabel);
		
		JLabel contractLabel = new JLabel("Contract price:");
		contractLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_contractLabel = new GridBagConstraints();
		gbc_contractLabel.anchor = GridBagConstraints.WEST;
		gbc_contractLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contractLabel.gridx = 5;
		gbc_contractLabel.gridy = 12;
		this.add(contractLabel, gbc_contractLabel);
		
		contractValueLabel = new JLabel("$200");
		contractValueLabel.setFont(new Font("Unispace", Font.PLAIN, 20));
		GridBagConstraints gbc_contractValueLabel = new GridBagConstraints();
		gbc_contractValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contractValueLabel.gridx = 7;
		gbc_contractValueLabel.gridy = 12;
		this.add(contractValueLabel, gbc_contractValueLabel);
		
		
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(200, 50));
		backButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		backButton.setFocusPainted(false);
		backButton.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.gridwidth = 3;
		gbc_backButton.insets = new Insets(0, 0, 5, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 15;
		this.add(backButton, gbc_backButton);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setFocusPainted(false);
		confirmButton.setPreferredSize(new Dimension(200, 50));
		confirmButton.setBackground(Color.LIGHT_GRAY);
		confirmButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 15;
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
	 * @return the portraitPath
	 */
	public String getPortraitPath() {
		return portraitPath;
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
