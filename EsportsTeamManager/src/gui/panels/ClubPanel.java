package gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Team.Role;

public class ClubPanel extends JPanel {

	private JLabel titleLabel;
	private JButton returnButton;
	private JButton inventoryButton;
	
	public ClubPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 10, 10, 0, 10, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{2.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 2.0, Double.MIN_VALUE};
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
		
		
		JButton tglbtnNewToggleButton = new JButton("<html>\r\n<center>Athlete 1</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>\r\nStamina: 5\r\n</html>");
		tglbtnNewToggleButton.setOpaque(true);
		tglbtnNewToggleButton.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton.setBackground(Color.LIGHT_GRAY);
		tglbtnNewToggleButton.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton = new GridBagConstraints();
		gbc_tglbtnNewToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton.gridx = 1;
		gbc_tglbtnNewToggleButton.gridy = 3;
		this.add(tglbtnNewToggleButton, gbc_tglbtnNewToggleButton);
		
		JButton tglbtnNewToggleButton_1 = new JButton("<html>\r\n<center>Athlete 2</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>Stamina: 5\r\n</html>");
		tglbtnNewToggleButton_1.setOpaque(true);
		tglbtnNewToggleButton_1.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_1.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_1.setBackground(Color.LIGHT_GRAY);
		tglbtnNewToggleButton_1.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_1 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_1.gridx = 3;
		gbc_tglbtnNewToggleButton_1.gridy = 3;
		this.add(tglbtnNewToggleButton_1, gbc_tglbtnNewToggleButton_1);
		
		JButton tglbtnNewToggleButton_2 = new JButton("<html>\r\n<center>Athlete 3</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>Stamina: 5\r\n</html>");
		tglbtnNewToggleButton_2.setOpaque(true);
		tglbtnNewToggleButton_2.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_2.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_2.setBackground(Color.LIGHT_GRAY);
		tglbtnNewToggleButton_2.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_2 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_2.gridx = 5;
		gbc_tglbtnNewToggleButton_2.gridy = 3;
		this.add(tglbtnNewToggleButton_2, gbc_tglbtnNewToggleButton_2);
		
		JButton tglbtnNewToggleButton_3 = new JButton("<html>\r\n<center>Athlete 4</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>Stamina: 5\r\n</html>");
		tglbtnNewToggleButton_3.setOpaque(true);
		tglbtnNewToggleButton_3.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_3.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_3.setBackground(Color.LIGHT_GRAY);
		tglbtnNewToggleButton_3.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_3 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_3.gridx = 7;
		gbc_tglbtnNewToggleButton_3.gridy = 3;
		this.add(tglbtnNewToggleButton_3, gbc_tglbtnNewToggleButton_3);
		
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
		
		JButton tglbtnNewToggleButton_4 = new JButton("<html>\r\n<center>Athlete 5</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>Stamina: 5\r\n</html>");
		tglbtnNewToggleButton_4.setOpaque(true);
		tglbtnNewToggleButton_4.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_4.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_4.setBackground(Color.LIGHT_GRAY);
		tglbtnNewToggleButton_4.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_4 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_4.gridx = 1;
		gbc_tglbtnNewToggleButton_4.gridy = 6;
		this.add(tglbtnNewToggleButton_4, gbc_tglbtnNewToggleButton_4);
		
		JButton tglbtnNewToggleButton_5 = new JButton("<html>\r\n<center>Athlete 6</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>Stamina: 5\r\n</html>");
		tglbtnNewToggleButton_5.setOpaque(true);
		tglbtnNewToggleButton_5.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_5.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_5.setBackground(Color.LIGHT_GRAY);
		tglbtnNewToggleButton_5.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_5 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_5.gridx = 3;
		gbc_tglbtnNewToggleButton_5.gridy = 6;
		this.add(tglbtnNewToggleButton_5, gbc_tglbtnNewToggleButton_5);
		
		JButton tglbtnNewToggleButton_6 = new JButton("<html>\r\n<center>Athlete 7</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>Stamina: 5\r\n</html>");
		tglbtnNewToggleButton_6.setOpaque(true);
		tglbtnNewToggleButton_6.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_6.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_6.setBackground(Color.LIGHT_GRAY);
		tglbtnNewToggleButton_6.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_6 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_6.gridx = 5;
		gbc_tglbtnNewToggleButton_6.gridy = 6;
		this.add(tglbtnNewToggleButton_6, gbc_tglbtnNewToggleButton_6);
			
		JButton tglbtnNewToggleButton_7 = new JButton("<html>\r\n<center>Athlete 8</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>Stamina: 5\r\n</html>");
		tglbtnNewToggleButton_7.setOpaque(true);
		tglbtnNewToggleButton_7.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_7.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_7.setBackground(Color.LIGHT_GRAY);
		tglbtnNewToggleButton_7.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_7 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_7.gridx = 7;
		gbc_tglbtnNewToggleButton_7.gridy = 6;
		this.add(tglbtnNewToggleButton_7, gbc_tglbtnNewToggleButton_7);
		
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
