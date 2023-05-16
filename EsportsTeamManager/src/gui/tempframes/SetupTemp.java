package gui.tempframes;

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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class SetupTemp {

	private JFrame frame;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupTemp window = new SetupTemp();
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
	public SetupTemp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1080,720));
		frame.setResizable(false);
		frame.setBounds(100, 100, 100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 20);
		UIManager.put("Button.hoverBorderColor", Color.GRAY);
		UIManager.put("TextComponent.arc", 20);
		UIManager.put("Component.focusColor", Color.GRAY);
		UIManager.put("Component.focusedBorderColor", Color.GRAY);
		
		
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 30, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 30, 0, 30, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 5.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		JLabel lblNewLabel = new JLabel("New Game");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		
		JLabel lblTeamName = new JLabel("Team Name:");
		lblTeamName.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_lblTeamName = new GridBagConstraints();
		gbc_lblTeamName.anchor = GridBagConstraints.WEST;
		gbc_lblTeamName.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeamName.gridx = 1;
		gbc_lblTeamName.gridy = 3;
		panel.add(lblTeamName, gbc_lblTeamName);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setPreferredSize(new Dimension(200, 50));
		textField.setMargin(new Insets(5, 10, 2, 10));
		textField.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		
		
		JLabel lblSeasonDuration = new JLabel("Season Duration:");
		lblSeasonDuration.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_lblSeasonDuration = new GridBagConstraints();
		gbc_lblSeasonDuration.anchor = GridBagConstraints.WEST;
		gbc_lblSeasonDuration.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeasonDuration.gridx = 1;
		gbc_lblSeasonDuration.gridy = 5;
		panel.add(lblSeasonDuration, gbc_lblSeasonDuration);
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.GRAY);
		slider.setForeground(Color.BLACK);
		slider.setPreferredSize(new Dimension(200, 50));
		slider.setOpaque(false);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setValue(10);
		slider.setSnapToTicks(true);
		slider.setFont(new Font("Unispace", Font.PLAIN, 20));
		slider.setBorder(null);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridwidth = 3;
		gbc_slider.gridx = 3;
		gbc_slider.gridy = 5;
		panel.add(slider, gbc_slider);
		
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDifficulty = new GridBagConstraints();
		gbc_lblDifficulty.anchor = GridBagConstraints.WEST;
		gbc_lblDifficulty.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifficulty.gridx = 1;
		gbc_lblDifficulty.gridy = 7;
		panel.add(lblDifficulty, gbc_lblDifficulty);
		
		ButtonGroup difficultyGroup = new ButtonGroup();
		
		JToggleButton easyToggleButton = new JToggleButton("Easy");
		difficultyGroup.add(easyToggleButton);
		easyToggleButton.setOpaque(true);
		easyToggleButton.setPreferredSize(new Dimension(200, 50));
		easyToggleButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		easyToggleButton.setBackground(Color.GRAY);
		easyToggleButton.setFocusPainted(false);
		GridBagConstraints gbc_easyToggleButton = new GridBagConstraints();
		gbc_easyToggleButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_easyToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_easyToggleButton.gridx = 3;
		gbc_easyToggleButton.gridy = 7;
		panel.add(easyToggleButton, gbc_easyToggleButton);
		
		JToggleButton hardToggleButton = new JToggleButton("Hard");
		difficultyGroup.add(hardToggleButton);
		hardToggleButton.setOpaque(true);
		hardToggleButton.setPreferredSize(new Dimension(200, 50));
		hardToggleButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		hardToggleButton.setBackground(Color.GRAY);
		hardToggleButton.setFocusPainted(false);
		GridBagConstraints gbc_hardToggleButton = new GridBagConstraints();
		gbc_hardToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_hardToggleButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_hardToggleButton.gridx = 5;
		gbc_hardToggleButton.gridy = 7;
		panel.add(hardToggleButton, gbc_hardToggleButton);
		
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setPreferredSize(new Dimension(200, 50));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(Color.GRAY);
		confirmButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// setup game with options
//				frame.closePanel();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 9;
		panel.add(confirmButton, gbc_btnNewButton);
		
		
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
	}

}
