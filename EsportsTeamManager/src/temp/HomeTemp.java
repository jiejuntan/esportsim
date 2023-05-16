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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JLabel;

public class HomeTemp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeTemp window = new HomeTemp();
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
	public HomeTemp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1080, 720));
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
		gbl_panel.columnWidths = new int[] { 10, 0, 100, 0, 10, 0 };
		gbl_panel.rowHeights = new int[] { 10, 0, 10, 0, 0, 0, 10, 0, 10, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel welcomeLabel = new JLabel("Esports Simulator");
		welcomeLabel.setFont(new Font("Unispace", Font.PLAIN, 50));
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.gridwidth = 3;
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 1;
		gbc_welcomeLabel.gridy = 1;
		panel.add(welcomeLabel, gbc_welcomeLabel);

		JLabel weekLabel = new JLabel("Week 1 of 10");
		weekLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_weekLabel = new GridBagConstraints();
		gbc_weekLabel.insets = new Insets(0, 0, 5, 5);
		gbc_weekLabel.gridx = 1;
		gbc_weekLabel.gridy = 3;
		panel.add(weekLabel, gbc_weekLabel);

		JLabel moneyLabel = new JLabel("Money: $1000");
		moneyLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyLabel.gridx = 1;
		gbc_moneyLabel.gridy = 4;
		panel.add(moneyLabel, gbc_moneyLabel);

		JButton clubButton = new JButton("Club");
		clubButton.setPreferredSize(new Dimension(200, 50));
		clubButton.setFocusPainted(false);
		clubButton.setBackground(Color.GRAY);
		clubButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		clubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_clubButton = new GridBagConstraints();
		gbc_clubButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_clubButton.insets = new Insets(0, 0, 5, 5);
		gbc_clubButton.gridx = 3;
		gbc_clubButton.gridy = 3;
		panel.add(clubButton, gbc_clubButton);

		JButton btnStadium = new JButton("Stadium");
		btnStadium.setPreferredSize(new Dimension(200, 50));
		btnStadium.setFont(new Font("Unispace", Font.PLAIN, 30));
		btnStadium.setFocusPainted(false);
		btnStadium.setBackground(Color.GRAY);
		GridBagConstraints gbc_btnStadium = new GridBagConstraints();
		gbc_btnStadium.insets = new Insets(0, 0, 5, 5);
		gbc_btnStadium.gridx = 3;
		gbc_btnStadium.gridy = 4;
		panel.add(btnStadium, gbc_btnStadium);

		JButton marketButton = new JButton("Market");
		marketButton.setPreferredSize(new Dimension(200, 50));
		marketButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		marketButton.setFocusPainted(false);
		marketButton.setBackground(Color.GRAY);
		GridBagConstraints gbc_marketButton = new GridBagConstraints();
		gbc_marketButton.insets = new Insets(0, 0, 5, 5);
		gbc_marketButton.gridx = 3;
		gbc_marketButton.gridy = 5;
		panel.add(marketButton, gbc_marketButton);

		JButton endWeekButton = new JButton("End Week");
		endWeekButton.setPreferredSize(new Dimension(200, 50));
		endWeekButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		endWeekButton.setFocusPainted(false);
		endWeekButton.setBackground(Color.GRAY);
		GridBagConstraints gbc_endWeekButton = new GridBagConstraints();
		gbc_endWeekButton.gridwidth = 3;
		gbc_endWeekButton.insets = new Insets(0, 0, 5, 5);
		gbc_endWeekButton.gridx = 1;
		gbc_endWeekButton.gridy = 7;
		panel.add(endWeekButton, gbc_endWeekButton);

		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
	}

}
