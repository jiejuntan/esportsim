package gui.panels;

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
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class DraftPanel extends JPanel {
	
	private List<JToggleButton> toggleButtons;	
	private JLabel moneyValueLabel;
	private JButton confirmButton;

	public DraftPanel() {	
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{2.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 2.0, Double.MIN_VALUE};
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
		athleteToggleButton_0.setPreferredSize(new Dimension(200, 200));
		athleteToggleButton_0.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_0.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_0.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_0 = new GridBagConstraints();
		gbc_athleteToggleButton_0.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_0.gridx = 1;
		gbc_athleteToggleButton_0.gridy = 3;
		this.add(athleteToggleButton_0, gbc_athleteToggleButton_0);
		
		JToggleButton athleteToggleButton_1 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_1);
		athleteToggleButton_1.setOpaque(true);
		athleteToggleButton_1.setPreferredSize(new Dimension(200, 200));
		athleteToggleButton_1.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_1.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_1.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_1 = new GridBagConstraints();
		gbc_athleteToggleButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_1.gridx = 3;
		gbc_athleteToggleButton_1.gridy = 3;
		this.add(athleteToggleButton_1, gbc_athleteToggleButton_1);
		
		JToggleButton athleteToggleButton_2 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_2);
		athleteToggleButton_2.setOpaque(true);
		athleteToggleButton_2.setPreferredSize(new Dimension(200, 200));
		athleteToggleButton_2.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_2.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_2.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_2 = new GridBagConstraints();
		gbc_athleteToggleButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_2.gridx = 5;
		gbc_athleteToggleButton_2.gridy = 3;
		this.add(athleteToggleButton_2, gbc_athleteToggleButton_2);
		
		JToggleButton athleteToggleButton_3 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_3);
		athleteToggleButton_3.setOpaque(true);
		athleteToggleButton_3.setPreferredSize(new Dimension(200, 200));
		athleteToggleButton_3.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_3.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_3.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_3 = new GridBagConstraints();
		gbc_athleteToggleButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_3.gridx = 7;
		gbc_athleteToggleButton_3.gridy = 3;
		this.add(athleteToggleButton_3, gbc_athleteToggleButton_3);
		
		JToggleButton athleteToggleButton_4 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_4);
		athleteToggleButton_4.setOpaque(true);
		athleteToggleButton_4.setPreferredSize(new Dimension(200, 200));
		athleteToggleButton_4.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_4.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_4.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_4 = new GridBagConstraints();
		gbc_athleteToggleButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_4.gridx = 1;
		gbc_athleteToggleButton_4.gridy = 5;
		this.add(athleteToggleButton_4, gbc_athleteToggleButton_4);
		
		JToggleButton athleteToggleButton_5 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_5);
		athleteToggleButton_5.setOpaque(true);
		athleteToggleButton_5.setPreferredSize(new Dimension(200, 200));
		athleteToggleButton_5.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_5.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_5.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_5 = new GridBagConstraints();
		gbc_athleteToggleButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_5.gridx = 3;
		gbc_athleteToggleButton_5.gridy = 5;
		this.add(athleteToggleButton_5, gbc_athleteToggleButton_5);
		
		JToggleButton athleteToggleButton_6 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_6);
		athleteToggleButton_6.setOpaque(true);
		athleteToggleButton_6.setPreferredSize(new Dimension(200, 200));
		athleteToggleButton_6.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_6.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_6.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_6 = new GridBagConstraints();
		gbc_athleteToggleButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_6.gridx = 5;
		gbc_athleteToggleButton_6.gridy = 5;
		this.add(athleteToggleButton_6, gbc_athleteToggleButton_6);
			
		JToggleButton athleteToggleButton_7 = new JToggleButton();
		toggleButtons.add(athleteToggleButton_7);
		athleteToggleButton_7.setOpaque(true);
		athleteToggleButton_7.setPreferredSize(new Dimension(200, 200));
		athleteToggleButton_7.setFont(new Font("Unispace", Font.PLAIN, 20));
		athleteToggleButton_7.setBackground(Color.LIGHT_GRAY);
		athleteToggleButton_7.setFocusPainted(false);
		GridBagConstraints gbc_athleteToggleButton_7 = new GridBagConstraints();
		gbc_athleteToggleButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_athleteToggleButton_7.gridx = 7;
		gbc_athleteToggleButton_7.gridy = 5;
		this.add(athleteToggleButton_7, gbc_athleteToggleButton_7);
		
		
		JLabel moneyLabel = new JLabel("Money:");
		moneyLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.fill = GridBagConstraints.VERTICAL;
		gbc_moneyLabel.anchor = GridBagConstraints.EAST;
		gbc_moneyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyLabel.gridx = 1;
		gbc_moneyLabel.gridy = 7;
		this.add(moneyLabel, gbc_moneyLabel);
		
		moneyValueLabel = new JLabel();
		moneyValueLabel.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_moneyValueLabel = new GridBagConstraints();
		gbc_moneyValueLabel.fill = GridBagConstraints.VERTICAL;
		gbc_moneyValueLabel.anchor = GridBagConstraints.WEST;
		gbc_moneyValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyValueLabel.gridx = 3;
		gbc_moneyValueLabel.gridy = 7;
		this.add(moneyValueLabel, gbc_moneyValueLabel);
		
		
		confirmButton = new JButton("Confirm");
		confirmButton.setPreferredSize(new Dimension(200, 50));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(Color.LIGHT_GRAY);
		confirmButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_confirmButton.gridwidth = 3;
		gbc_confirmButton.insets = new Insets(0, 0, 5, 5);
		gbc_confirmButton.gridx = 5;
		gbc_confirmButton.gridy = 7;
		this.add(confirmButton, gbc_confirmButton);
	}

	/**
	 * @return the toggleButtons
	 */
	public List<JToggleButton> getToggleButtons() {
		return toggleButtons;
	}

	/**
	 * @return the moneyValueLabel
	 */
	public JLabel getMoneyValueLabel() {
		return moneyValueLabel;
	}

	/**
	 * @return the confirmButton
	 */
	public JButton getConfirmButton() {
		return confirmButton;
	}
	
}
