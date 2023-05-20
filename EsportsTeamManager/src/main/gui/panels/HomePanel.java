package main.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	
	private JLabel weekLabel;
	private JLabel moneyLabel;
	private JButton clubButton;
	private JButton stadiumButton;
	
	public HomePanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 100, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		
		JLabel titleLabel = new JLabel("Esports Simulator");
		titleLabel.setFont(new Font("Unispace", Font.PLAIN, 50));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.gridwidth = 3;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 1;
		this.add(titleLabel, gbc_titleLabel);
		
		
		weekLabel = new JLabel();
		weekLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_weekLabel = new GridBagConstraints();
		gbc_weekLabel.insets = new Insets(0, 0, 5, 5);
		gbc_weekLabel.gridx = 1;
		gbc_weekLabel.gridy = 3;
		this.add(weekLabel, gbc_weekLabel);
		
		moneyLabel = new JLabel();
		moneyLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyLabel.gridx = 1;
		gbc_moneyLabel.gridy = 4;
		this.add(moneyLabel, gbc_moneyLabel);
		
		
		clubButton = new JButton("Club");
		clubButton.setPreferredSize(new Dimension(200, 50));
		clubButton.setFocusPainted(false);
		clubButton.setBackground(Color.LIGHT_GRAY);
		clubButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_clubButton = new GridBagConstraints();
		gbc_clubButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_clubButton.insets = new Insets(0, 0, 5, 5);
		gbc_clubButton.gridx = 3;
		gbc_clubButton.gridy = 3;
		this.add(clubButton, gbc_clubButton);
		
		stadiumButton = new JButton("Stadium");
		stadiumButton.setPreferredSize(new Dimension(200, 50));
		stadiumButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		stadiumButton.setFocusPainted(false);
		stadiumButton.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnStadium = new GridBagConstraints();
		gbc_btnStadium.insets = new Insets(0, 0, 5, 5);
		gbc_btnStadium.gridx = 3;
		gbc_btnStadium.gridy = 4;
		this.add(stadiumButton, gbc_btnStadium);
		
		JButton marketButton = new JButton("Market");
		marketButton.setPreferredSize(new Dimension(200, 50));
		marketButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		marketButton.setFocusPainted(false);
		marketButton.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_marketButton = new GridBagConstraints();
		gbc_marketButton.insets = new Insets(0, 0, 5, 5);
		gbc_marketButton.gridx = 3;
		gbc_marketButton.gridy = 5;
		this.add(marketButton, gbc_marketButton);
		
		
		JButton endWeekButton = new JButton("End Week");
		endWeekButton.setPreferredSize(new Dimension(200, 50));
		endWeekButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		endWeekButton.setFocusPainted(false);
		endWeekButton.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_endWeekButton = new GridBagConstraints();
		gbc_endWeekButton.gridwidth = 3;
		gbc_endWeekButton.insets = new Insets(0, 0, 5, 5);
		gbc_endWeekButton.gridx = 1;
		gbc_endWeekButton.gridy = 7;
		this.add(endWeekButton, gbc_endWeekButton);
	}

	/**
	 * @return the weekLabel
	 */
	public JLabel getWeekLabel() {
		return weekLabel;
	}

	/**
	 * @return the moneyLabel
	 */
	public JLabel getMoneyLabel() {
		return moneyLabel;
	}

	/**
	 * @return the clubButton
	 */
	public JButton getClubButton() {
		return clubButton;
	}
	
	/**
	 * @return the clubButton
	 */
	public JButton getStadiumButton() {
		return stadiumButton;
	}
	

}
