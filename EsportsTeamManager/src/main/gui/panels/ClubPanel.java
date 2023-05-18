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
	private List<JToggleButton> mainAthleteToggles;
	private List<JToggleButton> reserveAthleteToggles;
	private List<JComboBox> roleComboBoxes;
	private JButton returnButton;
	private JButton inventoryButton;
	
	/**
	 * 
	 */
	public ClubPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 10, 10, 0, 0, 10, 10, 10, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 2.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, 3.0, Double.MIN_VALUE};
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
		
		JLabel startingMembersLabel = new JLabel("Starting Members:");
		startingMembersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startingMembersLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_startingMembersLabel = new GridBagConstraints();
		gbc_startingMembersLabel.fill = GridBagConstraints.BOTH;
		gbc_startingMembersLabel.gridwidth = 3;
		gbc_startingMembersLabel.insets = new Insets(0, 0, 5, 5);
		gbc_startingMembersLabel.gridx = 3;
		gbc_startingMembersLabel.gridy = 3;
		this.add(startingMembersLabel, gbc_startingMembersLabel);
		
		
		mainAthleteToggles = new ArrayList<JToggleButton>();
		
		JToggleButton athleteToggle0 = new JToggleButton();
		mainAthleteToggles.add(athleteToggle0);
		athleteToggle0.setOpaque(true);
		athleteToggle0.setPreferredSize(new Dimension(250, 200));
		athleteToggle0.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggle0.setBackground(Color.LIGHT_GRAY);
		athleteToggle0.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggle0 = new GridBagConstraints();
		gbc_athleteToggle0.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggle0.gridx = 1;
		gbc_athleteToggle0.gridy = 5;
		this.add(athleteToggle0, gbc_athleteToggle0);
		
		JToggleButton athleteToggle1 = new JToggleButton();
		mainAthleteToggles.add(athleteToggle1);
		athleteToggle1.setOpaque(true);
		athleteToggle1.setPreferredSize(new Dimension(250, 200));
		athleteToggle1.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggle1.setBackground(Color.LIGHT_GRAY);
		athleteToggle1.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggle1 = new GridBagConstraints();
		gbc_athleteToggle1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggle1.gridx = 3;
		gbc_athleteToggle1.gridy = 5;
		this.add(athleteToggle1, gbc_athleteToggle1);
		
		JToggleButton athleteToggle2 = new JToggleButton();
		mainAthleteToggles.add(athleteToggle2);
		athleteToggle2.setOpaque(true);
		athleteToggle2.setPreferredSize(new Dimension(250, 200));
		athleteToggle2.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggle2.setBackground(Color.LIGHT_GRAY);
		athleteToggle2.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggle2 = new GridBagConstraints();
		gbc_athleteToggle2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggle2.gridx = 5;
		gbc_athleteToggle2.gridy = 5;
		this.add(athleteToggle2, gbc_athleteToggle2);
		
		JToggleButton athleteToggle3 = new JToggleButton();
		mainAthleteToggles.add(athleteToggle3);
		athleteToggle3.setOpaque(true);
		athleteToggle3.setPreferredSize(new Dimension(250, 200));
		athleteToggle3.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggle3.setBackground(Color.LIGHT_GRAY);
		athleteToggle3.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggle3 = new GridBagConstraints();
		gbc_athleteToggle3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggle3.gridx = 7;
		gbc_athleteToggle3.gridy = 5;
		this.add(athleteToggle3, gbc_athleteToggle3);
		
		
		JLabel reservesLabel = new JLabel("Reserves:");
		reservesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reservesLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_reservesLabel = new GridBagConstraints();
		gbc_reservesLabel.fill = GridBagConstraints.BOTH;
		gbc_reservesLabel.gridwidth = 3;
		gbc_reservesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reservesLabel.gridx = 3;
		gbc_reservesLabel.gridy = 8;
		this.add(reservesLabel, gbc_reservesLabel);
		
		reserveAthleteToggles = new ArrayList<JToggleButton>();
		
		JToggleButton athleteToggle4 = new JToggleButton();
		reserveAthleteToggles.add(athleteToggle4);
		athleteToggle4.setOpaque(true);
		athleteToggle4.setPreferredSize(new Dimension(250, 200));
		athleteToggle4.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggle4.setBackground(Color.LIGHT_GRAY);
		athleteToggle4.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggle4 = new GridBagConstraints();
		gbc_athleteToggle4.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggle4.gridx = 1;
		gbc_athleteToggle4.gridy = 10;
		this.add(athleteToggle4, gbc_athleteToggle4);
		
		JToggleButton athleteToggle5 = new JToggleButton();
		reserveAthleteToggles.add(athleteToggle5);
		athleteToggle5.setOpaque(true);
		athleteToggle5.setPreferredSize(new Dimension(250, 200));
		athleteToggle5.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggle5.setBackground(Color.LIGHT_GRAY);
		athleteToggle5.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggle5 = new GridBagConstraints();
		gbc_athleteToggle5.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggle5.gridx = 3;
		gbc_athleteToggle5.gridy = 10;
		this.add(athleteToggle5, gbc_athleteToggle5);
		
		JToggleButton athleteToggle6 = new JToggleButton();
		reserveAthleteToggles.add(athleteToggle6);
		athleteToggle6.setOpaque(true);
		athleteToggle6.setPreferredSize(new Dimension(250, 200));
		athleteToggle6.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggle6.setBackground(Color.LIGHT_GRAY);
		athleteToggle6.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggle6 = new GridBagConstraints();
		gbc_athleteToggle6.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggle6.gridx = 5;
		gbc_athleteToggle6.gridy = 10;
		this.add(athleteToggle6, gbc_athleteToggle6);
			
		JToggleButton athleteToggle7 = new JToggleButton();
		reserveAthleteToggles.add(athleteToggle7);
		athleteToggle7.setOpaque(true);
		athleteToggle7.setPreferredSize(new Dimension(250, 200));
		athleteToggle7.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggle7.setBackground(Color.LIGHT_GRAY);
		athleteToggle7.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggle7 = new GridBagConstraints();
		gbc_athleteToggle7.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggle7.gridx = 7;
		gbc_athleteToggle7.gridy = 10;
		this.add(athleteToggle7, gbc_athleteToggle7);
		
		
		roleComboBoxes = new ArrayList<JComboBox>();
		
		JComboBox roleComboBox0 = new JComboBox();
		roleComboBoxes.add(roleComboBox0);
		roleComboBox0.setFont(new Font("Unispace", Font.PLAIN, 20));
		roleComboBox0.setPreferredSize(new Dimension(150, 35));
		roleComboBox0.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_roleComboBox0 = new GridBagConstraints();
		gbc_roleComboBox0.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox0.gridx = 1;
		gbc_roleComboBox0.gridy = 6;
		this.add(roleComboBox0, gbc_roleComboBox0);
		
		JComboBox roleComboBox1 = new JComboBox();
		roleComboBoxes.add(roleComboBox1);
		roleComboBox1.setPreferredSize(new Dimension(150, 35));
		roleComboBox1.setFont(new Font("Unispace", Font.PLAIN, 20));
		roleComboBox1.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_roleComboBox1 = new GridBagConstraints();
		gbc_roleComboBox1.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox1.gridx = 3;
		gbc_roleComboBox1.gridy = 6;
		this.add(roleComboBox1, gbc_roleComboBox1);
		
		JComboBox roleComboBox2 = new JComboBox();
		roleComboBoxes.add(roleComboBox2);
		roleComboBox2.setPreferredSize(new Dimension(150, 35));
		roleComboBox2.setFont(new Font("Unispace", Font.PLAIN, 20));
		roleComboBox2.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_roleComboBox2 = new GridBagConstraints();
		gbc_roleComboBox2.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox2.gridx = 5;
		gbc_roleComboBox2.gridy = 6;
		this.add(roleComboBox2, gbc_roleComboBox2);
		
		JComboBox roleComboBox3 = new JComboBox();
		roleComboBoxes.add(roleComboBox3);
		roleComboBox3.setPreferredSize(new Dimension(150, 35));
		roleComboBox3.setFont(new Font("Unispace", Font.PLAIN, 20));
		roleComboBox3.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_roleComboBox3 = new GridBagConstraints();
		gbc_roleComboBox3.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox3.gridx = 7;
		gbc_roleComboBox3.gridy = 6;
		this.add(roleComboBox3, gbc_roleComboBox3);
		
		JComboBox roleComboBox4 = new JComboBox();
		roleComboBoxes.add(roleComboBox4);
		roleComboBox4.setPreferredSize(new Dimension(150, 35));
		roleComboBox4.setFont(new Font("Unispace", Font.PLAIN, 20));
		roleComboBox4.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_roleComboBox4 = new GridBagConstraints();
		gbc_roleComboBox4.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox4.gridx = 1;
		gbc_roleComboBox4.gridy = 11;
		this.add(roleComboBox4, gbc_roleComboBox4);
		
		JComboBox roleComboBox5 = new JComboBox();
		roleComboBoxes.add(roleComboBox5);
		roleComboBox5.setPreferredSize(new Dimension(150, 35));
		roleComboBox5.setFont(new Font("Unispace", Font.PLAIN, 20));
		roleComboBox5.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_roleComboBox5 = new GridBagConstraints();
		gbc_roleComboBox5.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox5.gridx = 3;
		gbc_roleComboBox5.gridy = 11;
		this.add(roleComboBox5, gbc_roleComboBox5);
		
		JComboBox roleComboBox6 = new JComboBox();
		roleComboBoxes.add(roleComboBox6);
		roleComboBox6.setPreferredSize(new Dimension(150, 35));
		roleComboBox6.setFont(new Font("Unispace", Font.PLAIN, 20));
		roleComboBox6.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_roleComboBox6 = new GridBagConstraints();
		gbc_roleComboBox6.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox6.gridx = 5;
		gbc_roleComboBox6.gridy = 11;
		this.add(roleComboBox6, gbc_roleComboBox6);
		
		JComboBox roleComboBox7 = new JComboBox();
		roleComboBoxes.add(roleComboBox7);
		roleComboBox7.setPreferredSize(new Dimension(150, 35));
		roleComboBox7.setFont(new Font("Unispace", Font.PLAIN, 20));
		roleComboBox7.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_roleComboBox7 = new GridBagConstraints();
		gbc_roleComboBox7.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox7.gridx = 7;
		gbc_roleComboBox7.gridy = 11;
		this.add(roleComboBox7, gbc_roleComboBox7);
		
		
		returnButton = new JButton("Return");
		returnButton.setPreferredSize(new Dimension(200, 50));
		returnButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		returnButton.setFocusPainted(false);
		returnButton.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_returnButton = new GridBagConstraints();
		gbc_returnButton.insets = new Insets(0, 0, 5, 5);
		gbc_returnButton.gridx = 1;
		gbc_returnButton.gridy = 13;
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
		gbc_inventoryButton.gridy = 13;
		this.add(inventoryButton, gbc_inventoryButton);
	}

	/**
	 * @return the titleLabel
	 */
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	/**
	 * @return the mainAthleteToggles
	 */
	public List<JToggleButton> getMainAthleteToggles() {
		return mainAthleteToggles;
	}

	/**
	 * @return the reserveAthleteToggles
	 */
	public List<JToggleButton> getReserveAthleteToggles() {
		return reserveAthleteToggles;
	}

	/**
	 * @return the roleComboBoxes
	 */
	public List<JComboBox> getRoleComboBoxes() {
		return roleComboBoxes;
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
