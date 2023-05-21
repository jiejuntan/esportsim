package main.gui.stadium;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;

import main.gui.GUIConstants;
import main.gui.subclassable.BasePanel;

import java.awt.Label;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public final class MatchPanel extends BasePanel {
	
	protected JLabel playerNameLabel;
	protected JLabel opponentNameLabel;
	protected JButton battleButton;
	protected JButton nextMatchButton;
	private JLabel resultsValueLabel1;
	private JLabel playerTeamLabel;
	private JLabel opponentTeamLabel;
	private JLabel playerHealthLabel;
	private JLabel opponentHealthLabel;
	private JLabel playerHealthValueLabel;
	private JLabel playerTeamNameValueLabel;
	private JLabel opponentTeamNameValueLabel;
	private JLabel OpponentHealthValueLabel;
	private JLabel resultsValueLabel2;
	private Image img;
	
	
	//Sets Background Image
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	
	
    public MatchPanel() {
    	
		try {
            img = ImageIO.read(getClass().getResource(
            		GUIConstants.BACKGROUND_BATTLE)).getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        } catch(IOException e) {
            e.printStackTrace();
        }
		setLayout(null);

		JLabel titleLabel = new JLabel("Match Battle");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setBounds(622, 200, 356, 71);
		super.setupTitle(titleLabel);
		titleLabel.setPreferredSize(new Dimension(350, 60));
		this.add(titleLabel);
		
		playerTeamLabel = new JLabel("Team");
		playerTeamLabel.setForeground(new Color(255, 255, 255));
		playerTeamLabel.setBounds(138, 271, 34, 16);
		add(playerTeamLabel);
		
		opponentTeamLabel = new JLabel("Team");
		opponentTeamLabel.setForeground(new Color(255, 255, 255));
		opponentTeamLabel.setBounds(1260, 271, 34, 16);
		add(opponentTeamLabel);
		
		playerTeamNameValueLabel = new JLabel("Test");
		playerTeamNameValueLabel.setForeground(new Color(255, 255, 255));
		playerTeamNameValueLabel.setBounds(248, 271, 27, 16);
		add(playerTeamNameValueLabel);
		
		opponentTeamNameValueLabel = new JLabel("Test");
		opponentTeamNameValueLabel.setForeground(new Color(255, 255, 255));
		opponentTeamNameValueLabel.setBounds(1336, 271, 27, 16);
		add(opponentTeamNameValueLabel);
		
		
		playerNameLabel = new JLabel("Name");
		playerNameLabel.setForeground(new Color(255, 255, 255));
		playerNameLabel.setBounds(632, 304, 138, 25);
		playerNameLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		this.add(playerNameLabel);
		
		JLabel vsLabel = new JLabel("VS");
		vsLabel.setForeground(new Color(255, 255, 255));
		vsLabel.setBounds(782, 295, 36, 36);
		vsLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		this.add(vsLabel);
		
		opponentNameLabel = new JLabel("Name");
		opponentNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		opponentNameLabel.setForeground(new Color(255, 255, 255));
		opponentNameLabel.setBounds(836, 304, 139, 25);
		opponentNameLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		this.add(opponentNameLabel);
		
		resultsValueLabel1 = new JLabel("Battle Stats");
		resultsValueLabel1.setForeground(new Color(255, 255, 255));
		resultsValueLabel1.setBounds(1203, 382, 265, 16);
		resultsValueLabel1.setEnabled(true);
		add(resultsValueLabel1);
		
		resultsValueLabel2 = new JLabel("Battle Stats");
		resultsValueLabel2.setForeground(new Color(255, 255, 255));
		resultsValueLabel2.setBounds(149, 382, 285, 16);
		resultsValueLabel2.setEnabled(true);
		add(resultsValueLabel2);
		
		playerHealthLabel = new JLabel("Health");
		playerHealthLabel.setForeground(new Color(255, 255, 255));
		playerHealthLabel.setBounds(139, 315, 41, 16);
		add(playerHealthLabel);
		
		opponentHealthLabel = new JLabel("Health:");
		opponentHealthLabel.setForeground(new Color(255, 255, 255));
		opponentHealthLabel.setBounds(1270, 299, 45, 16);
		add(opponentHealthLabel);
		
		playerHealthValueLabel = new JLabel("0");
		playerHealthValueLabel.setForeground(new Color(255, 255, 255));
		playerHealthValueLabel.setBounds(248, 315, 34, 16);
		add(playerHealthValueLabel);
		
		OpponentHealthValueLabel = new JLabel("0");
		OpponentHealthValueLabel.setForeground(new Color(255, 255, 255));
		OpponentHealthValueLabel.setBounds(1334, 299, 68, 16);
		add(OpponentHealthValueLabel);
		
		battleButton = new JButton("BATTLE!");
		battleButton.setForeground(new Color(254, 255, 255));
		battleButton.setBounds(730, 619, 139, 40);
		battleButton.setOpaque(false);
		battleButton.setFocusPainted(false);
		battleButton.setBorderPainted(false);
		battleButton.setContentAreaFilled(false);
		super.setupButton(battleButton);
		this.add(battleButton);
		
		nextMatchButton = new JButton("Next Round");
		nextMatchButton.setForeground(new Color(254, 255, 255));
		nextMatchButton.setBounds(704, 683, 193, 40);
		nextMatchButton.setVisible(false);
		nextMatchButton.setOpaque(false);
		nextMatchButton.setFocusPainted(false);
		nextMatchButton.setBorderPainted(false);
		nextMatchButton.setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		super.setupButton(nextMatchButton);
		this.add(nextMatchButton);
      
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
	 * @return the nextMatchButton
	 */
	public JButton getNextMatchButton() {
		return nextMatchButton;
	}

	/**
	 * @return the resultsValueLabel
	 */
	public JLabel getResultsValueLabel1() {
		return resultsValueLabel1;
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

	/**
	 * @return the resultsValueLabel2
	 */
	public JLabel getResultsValueLabel2() {
		return resultsValueLabel2;
	}
    
	
    
}
