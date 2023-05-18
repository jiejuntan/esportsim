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
import javax.swing.SwingConstants;

public class DraftPanel extends JPanel {
	
	private List<JButton> athleteButtons;	
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
		
		
		athleteButtons = new ArrayList<JButton>();
		
		JButton athleteButton0 = new JButton("Athlete");
		athleteButtons.add(athleteButton0);
		athleteButton0.setOpaque(true);
		athleteButton0.setPreferredSize(new Dimension(250, 200));
		athleteButton0.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteButton0.setBackground(Color.LIGHT_GRAY);
		athleteButton0.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton0 = new GridBagConstraints();
		gbc_athleteButton0.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton0.gridx = 1;
		gbc_athleteButton0.gridy = 4;
		this.add(athleteButton0, gbc_athleteButton0);
		
		JButton athleteButton1 = new JButton("Athlete");
		athleteButtons.add(athleteButton1);
		athleteButton1.setOpaque(true);
		athleteButton1.setPreferredSize(new Dimension(250, 200));
		athleteButton1.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteButton1.setBackground(Color.LIGHT_GRAY);
		athleteButton1.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton1 = new GridBagConstraints();
		gbc_athleteButton1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton1.gridx = 3;
		gbc_athleteButton1.gridy = 4;
		this.add(athleteButton1, gbc_athleteButton1);
		
		JButton athleteButton2 = new JButton("Athlete");
		athleteButtons.add(athleteButton2);
		athleteButton2.setOpaque(true);
		athleteButton2.setPreferredSize(new Dimension(250, 200));
		athleteButton2.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteButton2.setBackground(Color.LIGHT_GRAY);
		athleteButton2.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton2 = new GridBagConstraints();
		gbc_athleteButton2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton2.gridx = 5;
		gbc_athleteButton2.gridy = 4;
		this.add(athleteButton2, gbc_athleteButton2);
		
		JButton athleteButton3 = new JButton("Athlete");
		athleteButtons.add(athleteButton3);
		athleteButton3.setOpaque(true);
		athleteButton3.setPreferredSize(new Dimension(250, 200));
		athleteButton3.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteButton3.setBackground(Color.LIGHT_GRAY);
		athleteButton3.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton3 = new GridBagConstraints();
		gbc_athleteButton3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton3.gridx = 7;
		gbc_athleteButton3.gridy = 4;
		this.add(athleteButton3, gbc_athleteButton3);
		
		JButton athleteButton4 = new JButton("Athlete");
		athleteButtons.add(athleteButton4);
		athleteButton4.setOpaque(true);
		athleteButton4.setPreferredSize(new Dimension(250, 200));
		athleteButton4.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteButton4.setBackground(Color.LIGHT_GRAY);
		athleteButton4.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton4 = new GridBagConstraints();
		gbc_athleteButton4.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton4.gridx = 1;
		gbc_athleteButton4.gridy = 7;
		this.add(athleteButton4, gbc_athleteButton4);
		
		JButton athleteButton5 = new JButton("Athlete");
		athleteButtons.add(athleteButton5);
		athleteButton5.setOpaque(true);
		athleteButton5.setPreferredSize(new Dimension(250, 200));
		athleteButton5.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteButton5.setBackground(Color.LIGHT_GRAY);
		athleteButton5.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton5 = new GridBagConstraints();
		gbc_athleteButton5.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton5.gridx = 3;
		gbc_athleteButton5.gridy = 7;
		this.add(athleteButton5, gbc_athleteButton5);
		
		JButton athleteButton6 = new JButton("Athlete");
		athleteButtons.add(athleteButton6);
		athleteButton6.setOpaque(true);
		athleteButton6.setPreferredSize(new Dimension(250, 200));
		athleteButton6.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteButton6.setBackground(Color.LIGHT_GRAY);
		athleteButton6.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton6 = new GridBagConstraints();
		gbc_athleteButton6.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton6.gridx = 5;
		gbc_athleteButton6.gridy = 7;
		this.add(athleteButton6, gbc_athleteButton6);
			
		JButton athleteButton7 = new JButton("Athlete");
		athleteButtons.add(athleteButton7);
		athleteButton7.setOpaque(true);
		athleteButton7.setPreferredSize(new Dimension(250, 200));
		athleteButton7.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteButton7.setBackground(Color.LIGHT_GRAY);
		athleteButton7.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton7 = new GridBagConstraints();
		gbc_athleteButton7.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton7.gridx = 7;
		gbc_athleteButton7.gridy = 7;
		this.add(athleteButton7, gbc_athleteButton7);
				
		
		moneyLabel = new JLabel("$9999");
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
	 * @return the athleteButtons
	 */
	public List<JButton> getAthleteButtons() {
		return athleteButtons;
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
