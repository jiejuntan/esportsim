package main.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class DraftPanel extends JPanel {
	
	private List<JToggleButton> toggleButtons;	
	private List<JTextField> textFields;
	private JLabel moneyLabel;
	private JButton confirmButton;

	public DraftPanel() {	
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 0, 10, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{2.0, 0.0, 2.0, 0.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, 3.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);


		JLabel titleLabel = new JLabel("Draft Team");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Unispace", Font.PLAIN, 50));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridwidth = 3;
		gbc_titleLabel.gridx = 3;
		gbc_titleLabel.gridy = 1;
		this.add(titleLabel, gbc_titleLabel);
		
		
		toggleButtons = new ArrayList<JToggleButton>();
		
		JToggleButton athleteToggleButton_0 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_0);
		athleteToggleButton_0.setOpaque(true);
		athleteToggleButton_0.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_0.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_0.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_0.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_0 = new GridBagConstraints();
		gbc_athleteToggleButton_0.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_0.gridx = 1;
		gbc_athleteToggleButton_0.gridy = 4;
		this.add(athleteToggleButton_0, gbc_athleteToggleButton_0);
		
		JToggleButton athleteToggleButton_1 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_1);
		athleteToggleButton_1.setOpaque(true);
		athleteToggleButton_1.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_1.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_1.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_1.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_1 = new GridBagConstraints();
		gbc_athleteToggleButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_1.gridx = 3;
		gbc_athleteToggleButton_1.gridy = 4;
		this.add(athleteToggleButton_1, gbc_athleteToggleButton_1);
		
		JToggleButton athleteToggleButton_2 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_2);
		athleteToggleButton_2.setOpaque(true);
		athleteToggleButton_2.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_2.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_2.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_2.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_2 = new GridBagConstraints();
		gbc_athleteToggleButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_2.gridx = 5;
		gbc_athleteToggleButton_2.gridy = 4;
		this.add(athleteToggleButton_2, gbc_athleteToggleButton_2);
		
		JToggleButton athleteToggleButton_3 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_3);
		athleteToggleButton_3.setOpaque(true);
		athleteToggleButton_3.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_3.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_3.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_3.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_3 = new GridBagConstraints();
		gbc_athleteToggleButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_3.gridx = 7;
		gbc_athleteToggleButton_3.gridy = 4;
		this.add(athleteToggleButton_3, gbc_athleteToggleButton_3);
		
		JToggleButton athleteToggleButton_4 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_4);
		athleteToggleButton_4.setOpaque(true);
		athleteToggleButton_4.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_4.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_4.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_4.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_4 = new GridBagConstraints();
		gbc_athleteToggleButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_4.gridx = 1;
		gbc_athleteToggleButton_4.gridy = 7;
		this.add(athleteToggleButton_4, gbc_athleteToggleButton_4);
		
		JToggleButton athleteToggleButton_5 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_5);
		athleteToggleButton_5.setOpaque(true);
		athleteToggleButton_5.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_5.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_5.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_5.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_5 = new GridBagConstraints();
		gbc_athleteToggleButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_5.gridx = 3;
		gbc_athleteToggleButton_5.gridy = 7;
		this.add(athleteToggleButton_5, gbc_athleteToggleButton_5);
		
		JToggleButton athleteToggleButton_6 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_6);
		athleteToggleButton_6.setOpaque(true);
		athleteToggleButton_6.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_6.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_6.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_6.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_6 = new GridBagConstraints();
		gbc_athleteToggleButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_6.gridx = 5;
		gbc_athleteToggleButton_6.gridy = 7;
		this.add(athleteToggleButton_6, gbc_athleteToggleButton_6);
			
		JToggleButton athleteToggleButton_7 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_7);
		athleteToggleButton_7.setOpaque(true);
		athleteToggleButton_7.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_7.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_7.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_7.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_7 = new GridBagConstraints();
		gbc_athleteToggleButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_7.gridx = 7;
		gbc_athleteToggleButton_7.gridy = 7;
		this.add(athleteToggleButton_7, gbc_athleteToggleButton_7);
		
		textFields = new ArrayList<JTextField>();
		
		JTextField athleteTextField_0 = new JTextField();
		textFields.add(athleteTextField_0);
		athleteTextField_0.setPreferredSize(new Dimension(250, 35));
		athleteTextField_0.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_0.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_0.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteTextField_0.setColumns(10);
		athleteTextField_0.setBackground(Color.WHITE);
		athleteTextField_0.setEditable(false);
		athleteTextField_0.setFocusable(false);
		GridBagConstraints gbc_athleteTextField_0 = new GridBagConstraints();
		gbc_athleteTextField_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_0.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_0.gridx = 1;
		gbc_athleteTextField_0.gridy = 3;
		this.add(athleteTextField_0, gbc_athleteTextField_0);
		
		JTextField athleteTextField_1 = new JTextField();
		textFields.add(athleteTextField_1);
		athleteTextField_1.setPreferredSize(new Dimension(250, 35));
		athleteTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_1.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_1.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteTextField_1.setColumns(10);
		athleteTextField_1.setBackground(Color.WHITE);
		athleteTextField_1.setEditable(false);
		athleteTextField_1.setFocusable(false);
		GridBagConstraints gbc_athleteTextField_1 = new GridBagConstraints();
		gbc_athleteTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_1.gridx = 3;
		gbc_athleteTextField_1.gridy = 3;
		this.add(athleteTextField_1, gbc_athleteTextField_1);
		
		JTextField athleteTextField_2 = new JTextField();
		textFields.add(athleteTextField_2);
		athleteTextField_2.setPreferredSize(new Dimension(250, 35));
		athleteTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_2.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_2.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteTextField_2.setColumns(10);
		athleteTextField_2.setBackground(Color.WHITE);
		athleteTextField_2.setEditable(false);
		athleteTextField_2.setFocusable(false);
		GridBagConstraints gbc_athleteTextField_2 = new GridBagConstraints();
		gbc_athleteTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_2.gridx = 5;
		gbc_athleteTextField_2.gridy = 3;
		this.add(athleteTextField_2, gbc_athleteTextField_2);
		
		JTextField athleteTextField_3 = new JTextField();
		textFields.add(athleteTextField_3);
		athleteTextField_3.setPreferredSize(new Dimension(250, 35));
		athleteTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_3.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_3.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteTextField_3.setColumns(10);
		athleteTextField_3.setBackground(Color.WHITE);
		athleteTextField_3.setEditable(false);
		athleteTextField_3.setFocusable(false);
		GridBagConstraints gbc_athleteTextField_3 = new GridBagConstraints();
		gbc_athleteTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_3.gridx = 7;
		gbc_athleteTextField_3.gridy = 3;
		this.add(athleteTextField_3, gbc_athleteTextField_3);
		
		JTextField athleteTextField_4 = new JTextField();
		textFields.add(athleteTextField_4);
		athleteTextField_4.setPreferredSize(new Dimension(250, 35));
		athleteTextField_4.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_4.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_4.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteTextField_4.setColumns(10);
		athleteTextField_4.setBackground(Color.WHITE);
		athleteTextField_4.setEditable(false);
		athleteTextField_4.setFocusable(false);
		GridBagConstraints gbc_athleteTextField_4 = new GridBagConstraints();
		gbc_athleteTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_4.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_4.gridx = 1;
		gbc_athleteTextField_4.gridy = 6;
		this.add(athleteTextField_4, gbc_athleteTextField_4);
		
		JTextField athleteTextField_5 = new JTextField();
		textFields.add(athleteTextField_5);
		athleteTextField_5.setPreferredSize(new Dimension(250, 35));
		athleteTextField_5.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_5.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_5.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteTextField_5.setColumns(10);
		athleteTextField_5.setBackground(Color.WHITE);
		athleteTextField_5.setEditable(false);
		athleteTextField_5.setFocusable(false);
		GridBagConstraints gbc_athleteTextField_5 = new GridBagConstraints();
		gbc_athleteTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_5.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_5.gridx = 3;
		gbc_athleteTextField_5.gridy = 6;
		this.add(athleteTextField_5, gbc_athleteTextField_5);
		
		JTextField athleteTextField_6 = new JTextField();
		textFields.add(athleteTextField_6);
		athleteTextField_6.setPreferredSize(new Dimension(250, 35));
		athleteTextField_6.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_6.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_6.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteTextField_6.setColumns(10);
		athleteTextField_6.setBackground(Color.WHITE);
		athleteTextField_6.setEditable(false);
		athleteTextField_6.setFocusable(false);
		GridBagConstraints gbc_athleteTextField_6 = new GridBagConstraints();
		gbc_athleteTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_6.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_6.gridx = 5;
		gbc_athleteTextField_6.gridy = 6;
		this.add(athleteTextField_6, gbc_athleteTextField_6);
		
		JTextField athleteTextField_7 = new JTextField();
		textFields.add(athleteTextField_7);
		athleteTextField_7.setPreferredSize(new Dimension(250, 35));
		athleteTextField_7.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_7.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_7.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteTextField_7.setColumns(10);
		athleteTextField_7.setBackground(Color.WHITE);
		athleteTextField_7.setEditable(false);
		athleteTextField_7.setFocusable(false);
		GridBagConstraints gbc_athleteTextField_7 = new GridBagConstraints();
		gbc_athleteTextField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_7.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_7.gridx = 7;
		gbc_athleteTextField_7.gridy = 6;
		this.add(athleteTextField_7, gbc_athleteTextField_7);
		
		
		moneyLabel = new JLabel();
		moneyLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.gridwidth = 3;
		gbc_moneyLabel.fill = GridBagConstraints.VERTICAL;
		gbc_moneyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyLabel.gridx = 1;
		gbc_moneyLabel.gridy = 9;
		this.add(moneyLabel, gbc_moneyLabel);
		
		
		confirmButton = new JButton("Confirm");
		confirmButton.setPreferredSize(new Dimension(250, 50));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(Color.LIGHT_GRAY);
		confirmButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.gridwidth = 3;
		gbc_confirmButton.insets = new Insets(0, 0, 5, 5);
		gbc_confirmButton.gridx = 3;
		gbc_confirmButton.gridy = 9;
		this.add(confirmButton, gbc_confirmButton);
	}

	/**
	 * @return the toggleButtons
	 */
	public List<JToggleButton> getToggleButtons() {
		return toggleButtons;
	}

	/**
	 * @return the textFields
	 */
	public List<JTextField> getTextFields() {
		return textFields;
	}

	/**
	 * @return the moneyLabel
	 */
	public JLabel getMoneyLabel() {
		return moneyLabel;
	}

	/**
	 * @return the confirmButton
	 */
	public JButton getConfirmButton() {
		return confirmButton;
	}
	
}
