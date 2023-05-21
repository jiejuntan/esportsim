package main.gui.panels;

import java.awt.GridBagLayout;

import javax.swing.*;

import main.gui.GUIConstants;
import main.gui.panels.subclassable.BasePanel;

import java.awt.Label;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public final class MatchPanel extends BasePanel {
	
	protected JLabel playerNameLabel;
	protected JLabel opponentNameLabel;
	protected JButton battleButton;
	protected JLabel resultsLabel;
	protected JButton nextMatchButton;
	private JLabel resultsValueLabel;
	private JLabel playerTeamLabel;
	private JLabel opponentTeamLabel;
	private JLabel playerHealthLabel;
	private JLabel opponentHealthLabel;
	private JLabel playerHealthValueLabel;
	private JLabel playerTeamNameValueLabel;
	private JLabel opponentTeamNameValueLabel;
	private JLabel OpponentHealthValueLabel;
	
    public MatchPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{231, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 10, 0, 10, 0, 10, 0, 0, 0, 0, 0, 0, 10, 0, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 2.0, 0.0, 3.0};
		gbl_panel.rowWeights = new double[]{3.0, 0.0, 2.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 2.0, 1.0, 3.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);

		JLabel titleLabel = new JLabel("Match Battle");
		super.setupTitle(titleLabel);
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		titleLabel.setPreferredSize(new Dimension(350, 60));
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 2;
		gbc_titleLabel.gridy = 0;
		this.add(titleLabel, gbc_titleLabel);
		
		playerTeamLabel = new JLabel("Team");
		GridBagConstraints gbc_playerTeamLabel = new GridBagConstraints();
		gbc_playerTeamLabel.insets = new Insets(0, 0, 5, 5);
		gbc_playerTeamLabel.gridx = 0;
		gbc_playerTeamLabel.gridy = 2;
		add(playerTeamLabel, gbc_playerTeamLabel);
		
		opponentTeamLabel = new JLabel("Team");
		GridBagConstraints gbc_opponentTeamLabel = new GridBagConstraints();
		gbc_opponentTeamLabel.insets = new Insets(0, 0, 5, 0);
		gbc_opponentTeamLabel.gridx = 4;
		gbc_opponentTeamLabel.gridy = 2;
		add(opponentTeamLabel, gbc_opponentTeamLabel);
		
		playerTeamNameValueLabel = new JLabel("Test");
		GridBagConstraints gbc_playerTeamNameValueLabel = new GridBagConstraints();
		gbc_playerTeamNameValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_playerTeamNameValueLabel.gridx = 0;
		gbc_playerTeamNameValueLabel.gridy = 3;
		add(playerTeamNameValueLabel, gbc_playerTeamNameValueLabel);
		
		opponentTeamNameValueLabel = new JLabel("Test");
		GridBagConstraints gbc_opponentTeamNameValueLabel = new GridBagConstraints();
		gbc_opponentTeamNameValueLabel.insets = new Insets(0, 0, 5, 0);
		gbc_opponentTeamNameValueLabel.gridx = 4;
		gbc_opponentTeamNameValueLabel.gridy = 3;
		add(opponentTeamNameValueLabel, gbc_opponentTeamNameValueLabel);
		
		
		playerNameLabel = new JLabel("Name");
		playerNameLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		GridBagConstraints gbc_playerNameLabel = new GridBagConstraints();
		gbc_playerNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_playerNameLabel.gridx = 1;
		gbc_playerNameLabel.gridy = 7;
		this.add(playerNameLabel, gbc_playerNameLabel);
		
		JLabel vsLabel = new JLabel("VS");
		vsLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_vsLabel = new GridBagConstraints();
		gbc_vsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_vsLabel.gridx = 2;
		gbc_vsLabel.gridy = 7;
		this.add(vsLabel, gbc_vsLabel);
		
		resultsLabel = new JLabel("Results");
		resultsLabel.setVisible(false);
		
		opponentNameLabel = new JLabel("Name");
		opponentNameLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		GridBagConstraints gbc_opponentNameLabel = new GridBagConstraints();
		gbc_opponentNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_opponentNameLabel.gridx = 3;
		gbc_opponentNameLabel.gridy = 7;
		this.add(opponentNameLabel, gbc_opponentNameLabel);
		resultsLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		GridBagConstraints gbc_resultsLabel = new GridBagConstraints();
		gbc_resultsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_resultsLabel.gridx = 2;
		gbc_resultsLabel.gridy = 10;
		this.add(resultsLabel, gbc_resultsLabel);
		
		resultsValueLabel = new JLabel("Battle Stats");
		GridBagConstraints gbc_resultsValueLabel = new GridBagConstraints();
		gbc_resultsValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_resultsValueLabel.gridx = 2;
		gbc_resultsValueLabel.gridy = 12;
		add(resultsValueLabel, gbc_resultsValueLabel);
		
		playerHealthLabel = new JLabel("Health");
		GridBagConstraints gbc_playerHealthLabel = new GridBagConstraints();
		gbc_playerHealthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_playerHealthLabel.gridx = 0;
		gbc_playerHealthLabel.gridy = 13;
		add(playerHealthLabel, gbc_playerHealthLabel);
		
		opponentHealthLabel = new JLabel("Health:");
		GridBagConstraints gbc_opponentHealthLabel = new GridBagConstraints();
		gbc_opponentHealthLabel.insets = new Insets(0, 0, 5, 0);
		gbc_opponentHealthLabel.gridx = 4;
		gbc_opponentHealthLabel.gridy = 13;
		add(opponentHealthLabel, gbc_opponentHealthLabel);
		
		playerHealthValueLabel = new JLabel("0");
		GridBagConstraints gbc_playerHealthValueLabel = new GridBagConstraints();
		gbc_playerHealthValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_playerHealthValueLabel.gridx = 0;
		gbc_playerHealthValueLabel.gridy = 14;
		add(playerHealthValueLabel, gbc_playerHealthValueLabel);
		
		OpponentHealthValueLabel = new JLabel("0");
		GridBagConstraints gbc_OpponentHealthValueLabel = new GridBagConstraints();
		gbc_OpponentHealthValueLabel.insets = new Insets(0, 0, 5, 0);
		gbc_OpponentHealthValueLabel.gridx = 4;
		gbc_OpponentHealthValueLabel.gridy = 14;
		add(OpponentHealthValueLabel, gbc_OpponentHealthValueLabel);
		
		battleButton = new JButton("BATTLE!");
		super.setupButton(battleButton);
		GridBagConstraints gbc_battleButton = new GridBagConstraints();
		gbc_battleButton.insets = new Insets(0, 0, 5, 5);
		gbc_battleButton.gridx = 2;
		gbc_battleButton.gridy = 16;
		this.add(battleButton, gbc_battleButton);
		
		nextMatchButton = new JButton("Next Round");
		super.setupButton(nextMatchButton);
		GridBagConstraints gbc_nextMatchButton = new GridBagConstraints();
		gbc_nextMatchButton.insets = new Insets(0, 0, 5, 0);
		gbc_nextMatchButton.gridx = 4;
		gbc_nextMatchButton.gridy = 16;
		this.add(nextMatchButton, gbc_nextMatchButton);
      
    }

	/**
	 * @return the playerNameLabel
	 */
	public JLabel getPlayerNameLabel() {
		return playerNameLabel;
	}

	/**
	 * @return the opponentNameLabel
	 */
	public JLabel getOpponentNameLabel() {
		return opponentNameLabel;
	}

	/**
	 * @return the battleButton
	 */
	public JButton getBattleButton() {
		return battleButton;
	}

	/**
	 * @return the resultsLabel
	 */
	public JLabel getResultsLabel() {
		return resultsLabel;
	}

	/**
	 * @return the nextMatchButton
	 */
	public JButton getNextMatchButton() {
		return nextMatchButton;
	}

	/**
	 * @return the resultsValueLabel
	 */
	public JLabel getResultsValueLabel() {
		return resultsValueLabel;
	}

	/**
	 * @return the playerHealthValueLabel
	 */
	public JLabel getPlayerHealthValueLabel() {
		return playerHealthValueLabel;
	}

	/**
	 * @return the playerTeamNameValueLabel
	 */
	public JLabel getPlayerTeamNameValueLabel() {
		return playerTeamNameValueLabel;
	}

	/**
	 * @return the opponentTeamNameValueLabel
	 */
	public JLabel getOpponentTeamNameValueLabel() {
		return opponentTeamNameValueLabel;
	}

	/**
	 * @return the opponentHealthValueLabel
	 */
	public JLabel getOpponentHealthValueLabel() {
		return OpponentHealthValueLabel;
	}
    
	
    
}
