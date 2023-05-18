package temp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import main.model.Team.Role;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class ClubTemp {
	private List<JToggleButton> toggleButtons;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubTemp window = new ClubTemp();
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
	public ClubTemp() {
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
		UIManager.put("Button.hoverBorderColor", Color.GRAY);
		UIManager.put("TextComponent.arc", 20);
		UIManager.put("Component.focusColor", Color.GRAY);
		UIManager.put("Component.focusedBorderColor", Color.GRAY);
//		UIManager.put("Component.arc", 20);
		
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 10, 10, 0, 0, 10, 10, 10, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 2.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, 3.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		JLabel lblNewLabel = new JLabel("Team $ABC Club");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		
		toggleButtons = new ArrayList<JToggleButton>();
		
		JLabel lblStartingMembers = new JLabel("Starting Members:");
		lblStartingMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartingMembers.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStartingMembers = new GridBagConstraints();
		gbc_lblStartingMembers.gridwidth = 3;
		gbc_lblStartingMembers.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartingMembers.gridx = 3;
		gbc_lblStartingMembers.gridy = 3;
		panel.add(lblStartingMembers, gbc_lblStartingMembers);
		
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
		gbc_athleteToggleButton_0.gridy = 5;
		panel.add(athleteToggleButton_0, gbc_athleteToggleButton_0);
		
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
		gbc_athleteToggleButton_1.gridy = 5;
		panel.add(athleteToggleButton_1, gbc_athleteToggleButton_1);
		
		JToggleButton athleteToggleButton_2 = new JToggleButton();
		athleteToggleButton_2.setFocusable(false);
		athleteToggleButton_2.setVerifyInputWhenFocusTarget(false);
		athleteToggleButton_2.setRequestFocusEnabled(false);
		toggleButtons.add(athleteToggleButton_2);
		athleteToggleButton_2.setOpaque(true);
		athleteToggleButton_2.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_2.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_2.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_2.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_2 = new GridBagConstraints();
		gbc_athleteToggleButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_2.gridx = 5;
		gbc_athleteToggleButton_2.gridy = 5;
		panel.add(athleteToggleButton_2, gbc_athleteToggleButton_2);
		
		JLabel athleteToggleButton_3 = new JLabel();
		athleteToggleButton_3.setRequestFocusEnabled(false);
		athleteToggleButton_3.putClientProperty( "Jlabel.border.roundRect", true );
//		toggleButtons.add(athleteToggleButton_3);
		athleteToggleButton_3.setOpaque(true);
		athleteToggleButton_3.setPreferredSize(new Dimension(250, 200));
		athleteToggleButton_3.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_3.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_athleteToggleButton_3 = new GridBagConstraints();
		gbc_athleteToggleButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_3.gridx = 7;
		gbc_athleteToggleButton_3.gridy = 5;
		panel.add(athleteToggleButton_3, gbc_athleteToggleButton_3);
		
		JLabel lblReserves = new JLabel("Reserves:");
		lblReserves.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserves.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_lblReserves = new GridBagConstraints();
		gbc_lblReserves.gridwidth = 3;
		gbc_lblReserves.insets = new Insets(0, 0, 5, 5);
		gbc_lblReserves.gridx = 3;
		gbc_lblReserves.gridy = 8;
		panel.add(lblReserves, gbc_lblReserves);
		
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
		gbc_athleteToggleButton_4.gridy = 10;
		panel.add(athleteToggleButton_4, gbc_athleteToggleButton_4);
		
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
		gbc_athleteToggleButton_5.gridy = 10;
		panel.add(athleteToggleButton_5, gbc_athleteToggleButton_5);
		
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
		gbc_athleteToggleButton_6.gridy = 10;
		panel.add(athleteToggleButton_6, gbc_athleteToggleButton_6);
			
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
		gbc_athleteToggleButton_7.gridy = 10;
		panel.add(athleteToggleButton_7, gbc_athleteToggleButton_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox.setPreferredSize(new Dimension(150, 35));
		comboBox.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		panel.add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setPreferredSize(new Dimension(150, 35));
		comboBox_1.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 6;
		panel.add(comboBox_1, gbc_comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setPreferredSize(new Dimension(150, 35));
		comboBox_2.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_2.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 5;
		gbc_comboBox_2.gridy = 6;
		panel.add(comboBox_2, gbc_comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setPreferredSize(new Dimension(150, 35));
		comboBox_3.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_3.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.gridx = 7;
		gbc_comboBox_3.gridy = 6;
		panel.add(comboBox_3, gbc_comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setPreferredSize(new Dimension(150, 35));
		comboBox_4.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_4.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.gridx = 1;
		gbc_comboBox_4.gridy = 11;
		panel.add(comboBox_4, gbc_comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setPreferredSize(new Dimension(150, 35));
		comboBox_5.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_5.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_5 = new GridBagConstraints();
		gbc_comboBox_5.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_5.gridx = 3;
		gbc_comboBox_5.gridy = 11;
		panel.add(comboBox_5, gbc_comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setPreferredSize(new Dimension(150, 35));
		comboBox_6.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_6.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_6 = new GridBagConstraints();
		gbc_comboBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_6.gridx = 5;
		gbc_comboBox_6.gridy = 11;
		panel.add(comboBox_6, gbc_comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setPreferredSize(new Dimension(150, 35));
		comboBox_7.setFont(new Font("Unispace", Font.PLAIN, 20));
		comboBox_7.setModel(new DefaultComboBoxModel(Role.values()));
		GridBagConstraints gbc_comboBox_7 = new GridBagConstraints();
		gbc_comboBox_7.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_7.gridx = 7;
		gbc_comboBox_7.gridy = 11;
		panel.add(comboBox_7, gbc_comboBox_7);
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setPreferredSize(new Dimension(200, 50));
		btnReturn.setFont(new Font("Unispace", Font.PLAIN, 30));
		btnReturn.setFocusPainted(false);
		btnReturn.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.insets = new Insets(0, 0, 5, 5);
		gbc_btnReturn.gridx = 1;
		gbc_btnReturn.gridy = 13;
		panel.add(btnReturn, gbc_btnReturn);
		
		JButton confirmButton = new JButton("Inventory");
		confirmButton.setPreferredSize(new Dimension(200, 50));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(Color.LIGHT_GRAY);
		confirmButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 13;
		panel.add(confirmButton, gbc_btnNewButton);
		
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
	}

}
