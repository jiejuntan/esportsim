package main.gui.panels;

import java.awt.GridBagLayout;

import javax.swing.*;

import main.gui.GUIConstants;

import java.awt.Label;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MatchPanel extends JPanel {
	
	protected JLabel playerNameLabel;
	protected JLabel opponentNameLabel;
	protected JButton battleButton;
	protected JLabel resultsLabel;
	protected JButton nextMatchButton;
	
    public MatchPanel() {
    	
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 50, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 10, 0, 10, 0, 10, 0, 0, 0, 0, 0, 0, 10, 0, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 0.0, 0.0, 3.0};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 2.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 2.0, 1.0, 3.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		JLabel titleLabel = new JLabel("Match Battle");
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		titleLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.HEADING));
		titleLabel.setPreferredSize(new Dimension(350, 60));
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 4;
		gbc_titleLabel.gridy = 0;
		this.add(titleLabel, gbc_titleLabel);
		
		
		playerNameLabel = new JLabel("Name: ");
		playerNameLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY - 10));
		GridBagConstraints gbc_playerNameLabel = new GridBagConstraints();
		gbc_playerNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_playerNameLabel.gridx = 0;
		gbc_playerNameLabel.gridy = 4;
		this.add(playerNameLabel, gbc_playerNameLabel);
		
		opponentNameLabel = new JLabel("Name:");
		opponentNameLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY - 10));
		GridBagConstraints gbc_opponentNameLabel = new GridBagConstraints();
		gbc_opponentNameLabel.insets = new Insets(0, 0, 5, 0);
		gbc_opponentNameLabel.gridx = 9;
		gbc_opponentNameLabel.gridy = 4;
		this.add(opponentNameLabel, gbc_opponentNameLabel);
		
		JLabel vsLabel = new JLabel("VS");
		vsLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_vsLabel = new GridBagConstraints();
		gbc_vsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_vsLabel.gridx = 4;
		gbc_vsLabel.gridy = 7;
		this.add(vsLabel, gbc_vsLabel);
		
		resultsLabel = new JLabel("Results");
		resultsLabel.setEnabled(false);
		resultsLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY - 10));
		GridBagConstraints gbc_resultsLabel = new GridBagConstraints();
		gbc_resultsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_resultsLabel.gridx = 4;
		gbc_resultsLabel.gridy = 10;
		this.add(resultsLabel, gbc_resultsLabel);
		
		battleButton = new JButton("BATTLE!");
		battleButton.setFocusPainted(false);
		battleButton.setPreferredSize(new Dimension(200, 50));
		battleButton.setBackground(GUIConstants.COMPONENT);
		battleButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_battleButton = new GridBagConstraints();
		gbc_battleButton.insets = new Insets(0, 0, 5, 5);
		gbc_battleButton.gridx = 4;
		gbc_battleButton.gridy = 16;
		this.add(battleButton, gbc_battleButton);
		
		nextMatchButton = new JButton("Next Match");
		nextMatchButton.setEnabled(false);
		nextMatchButton.setFocusPainted(false);
		nextMatchButton.setPreferredSize(new Dimension(200, 50));
		nextMatchButton.setBackground(GUIConstants.COMPONENT);
		nextMatchButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_nextMatchButton = new GridBagConstraints();
		gbc_nextMatchButton.insets = new Insets(0, 0, 5, 0);
		gbc_nextMatchButton.gridx = 9;
		gbc_nextMatchButton.gridy = 16;
		this.add(nextMatchButton, gbc_nextMatchButton);
      
    }
}
