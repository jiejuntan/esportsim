package main.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import main.model.Team.Role;

public class ClubPanel extends JPanel {

	private JLabel titleLabel;
	private List<JToggleButton> toggleButtons;
	private JButton returnButton;
	private JButton inventoryButton;
	
	public ClubPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 0, 10, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{2.0, 0.0, 2.0, 0.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, 3.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		
		titleLabel = new JLabel("Team $ABC Club");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Unispace", Font.PLAIN, 50));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridwidth = 5;
		gbc_titleLabel.gridx = 2;
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox.setPreferredSize(new Dimension(150, 35));
		comboBox.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		this.add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setPreferredSize(new Dimension(150, 35));
		comboBox_1.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 4;
		this.add(comboBox_1, gbc_comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setPreferredSize(new Dimension(150, 35));
		comboBox_2.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_2.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 5;
		gbc_comboBox_2.gridy = 4;
		this.add(comboBox_2, gbc_comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setPreferredSize(new Dimension(150, 35));
		comboBox_3.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_3.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.gridx = 7;
		gbc_comboBox_3.gridy = 4;
		this.add(comboBox_3, gbc_comboBox_3);
		
	
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setPreferredSize(new Dimension(150, 35));
		comboBox_4.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_4.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.gridx = 1;
		gbc_comboBox_4.gridy = 7;
		this.add(comboBox_4, gbc_comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setPreferredSize(new Dimension(150, 35));
		comboBox_5.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_5.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_5 = new GridBagConstraints();
		gbc_comboBox_5.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_5.gridx = 3;
		gbc_comboBox_5.gridy = 7;
		this.add(comboBox_5, gbc_comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setPreferredSize(new Dimension(150, 35));
		comboBox_6.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_6.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_6 = new GridBagConstraints();
		gbc_comboBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_6.gridx = 5;
		gbc_comboBox_6.gridy = 7;
		this.add(comboBox_6, gbc_comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setPreferredSize(new Dimension(150, 35));
		comboBox_7.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_7.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_7 = new GridBagConstraints();
		gbc_comboBox_7.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_7.gridx = 7;
		gbc_comboBox_7.gridy = 7;
		this.add(comboBox_7, gbc_comboBox_7);
		
		
		returnButton = new JButton("Return");
		returnButton.setPreferredSize(new Dimension(200, 50));
		returnButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		returnButton.setFocusPainted(false);
		returnButton.setBackground(Color.LIGHT_GRAY);
		
		GridBagConstraints gbc_returnButton = new GridBagConstraints();
		gbc_returnButton.insets = new Insets(0, 0, 5, 5);
		gbc_returnButton.gridx = 1;
		gbc_returnButton.gridy = 9;
		this.add(returnButton, gbc_returnButton);
		
		inventoryButton = new JButton("Inventory");
		inventoryButton.setPreferredSize(new Dimension(200, 50));
		inventoryButton.setFocusPainted(false);
		inventoryButton.setBackground(Color.LIGHT_GRAY);
		inventoryButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_inventoryButton = new GridBagConstraints();
		gbc_inventoryButton.gridwidth = 3;
		gbc_inventoryButton.insets = new Insets(0, 0, 5, 5);
		gbc_inventoryButton.gridx = 3;
		gbc_inventoryButton.gridy = 9;
		this.add(inventoryButton, gbc_inventoryButton);
	}

	/**
	 * @return the titleLabel
	 */
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	/**
	 * @return the returnButton
	 */
	public JButton getReturnButton() {
		return returnButton;
	}

	/**
	 * @return the inventoryButton
	 */
	public JButton getInventoryButton() {
		return inventoryButton;
	}

}
