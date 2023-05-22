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
	private JLabel resultsValueLabel1;
	private JLabel playerTeamNameValueLabel;
	private JLabel opponentTeamNameValueLabel;
	private JLabel resultsValueLabel2;
	private Image img;
	private JLabel roundValueLabel;
	private JButton battleButton;
	
	
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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{99, 285, 243, 350, 231, 265, 0};
		gridBagLayout.rowHeights = new int[]{200, 71, 0, 16, 95, 16, 180, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel roundLabel = new JLabel(" Round ");
		roundLabel.setForeground(new Color(255, 255, 255));
		super.setupTitle(roundLabel);
		roundLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.HEADING));
		roundLabel.setPreferredSize(new Dimension(350, 60));
		GridBagConstraints gbc_roundLabel = new GridBagConstraints();
		gbc_roundLabel.anchor = GridBagConstraints.WEST;
		gbc_roundLabel.fill = GridBagConstraints.VERTICAL;
		gbc_roundLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roundLabel.gridx = 3;
		gbc_roundLabel.gridy = 1;
		this.add(roundLabel, gbc_roundLabel);
		
		playerTeamNameValueLabel = new JLabel("Test");
		playerTeamNameValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		playerTeamNameValueLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		playerTeamNameValueLabel.setForeground(new Color(255, 255, 255));
		playerTeamNameValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_playerTeamNameValueLabel = new GridBagConstraints();
		gbc_playerTeamNameValueLabel.anchor = GridBagConstraints.NORTH;
		gbc_playerTeamNameValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_playerTeamNameValueLabel.gridx = 1;
		gbc_playerTeamNameValueLabel.gridy = 2;
		add(playerTeamNameValueLabel, gbc_playerTeamNameValueLabel);
		
		roundValueLabel = new JLabel("1");
		roundValueLabel.setPreferredSize(new Dimension(350, 60));
		roundValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roundValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.HEADING));
		roundValueLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_roundValueLabel = new GridBagConstraints();
		gbc_roundValueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roundValueLabel.gridx = 3;
		gbc_roundValueLabel.gridy = 2;
		add(roundValueLabel, gbc_roundValueLabel);
		
		opponentTeamNameValueLabel = new JLabel("Test");
		opponentTeamNameValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		opponentTeamNameValueLabel.setForeground(new Color(255, 255, 255));
		opponentTeamNameValueLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_opponentTeamNameValueLabel = new GridBagConstraints();
		gbc_opponentTeamNameValueLabel.anchor = GridBagConstraints.NORTH;
		gbc_opponentTeamNameValueLabel.insets = new Insets(0, 0, 5, 0);
		gbc_opponentTeamNameValueLabel.gridx = 5;
		gbc_opponentTeamNameValueLabel.gridy = 2;
		add(opponentTeamNameValueLabel, gbc_opponentTeamNameValueLabel);
		
		resultsValueLabel2 = new JLabel("Battle Stats");
		resultsValueLabel2.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.SMALLERDETAIL));
		resultsValueLabel2.setVerticalAlignment(SwingConstants.BOTTOM);
		resultsValueLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		resultsValueLabel2.setForeground(new Color(255, 255, 255));
		resultsValueLabel2.setEnabled(true);
		GridBagConstraints gbc_resultsValueLabel2 = new GridBagConstraints();
		gbc_resultsValueLabel2.gridwidth = 2;
		gbc_resultsValueLabel2.anchor = GridBagConstraints.NORTH;
		gbc_resultsValueLabel2.fill = GridBagConstraints.HORIZONTAL;
		gbc_resultsValueLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_resultsValueLabel2.gridx = 1;
		gbc_resultsValueLabel2.gridy = 4;
		add(resultsValueLabel2, gbc_resultsValueLabel2);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		resultsValueLabel1 = new JLabel("Battle Stats");
		resultsValueLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		resultsValueLabel1.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.SMALLERDETAIL));
		resultsValueLabel1.setForeground(new Color(255, 255, 255));
		resultsValueLabel1.setEnabled(true);
		GridBagConstraints gbc_resultsValueLabel1 = new GridBagConstraints();
		gbc_resultsValueLabel1.gridwidth = 2;
		gbc_resultsValueLabel1.anchor = GridBagConstraints.NORTH;
		gbc_resultsValueLabel1.fill = GridBagConstraints.HORIZONTAL;
		gbc_resultsValueLabel1.insets = new Insets(0, 0, 5, 0);
		gbc_resultsValueLabel1.gridx = 4;
		gbc_resultsValueLabel1.gridy = 4;
		add(resultsValueLabel1, gbc_resultsValueLabel1);
		
		battleButton = new JButton("BATTLE!");
		battleButton.setVerticalAlignment(SwingConstants.BOTTOM);
		battleButton.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.SUBHEADING));
		battleButton.setOpaque(false);
		battleButton.setForeground(new Color(254, 255, 255));
		battleButton.setFocusPainted(false);
		battleButton.setContentAreaFilled(false);
		battleButton.setBorderPainted(false);
		GridBagConstraints gbc_battleButton = new GridBagConstraints();
		gbc_battleButton.insets = new Insets(0, 0, 0, 5);
		gbc_battleButton.gridx = 3;
		gbc_battleButton.gridy = 7;
		add(battleButton, gbc_battleButton);
      
    }


	/**
	 * @return the battleButton
	 */
	public JButton getBattleButton() {
		return battleButton;
	}


	/**
	 * @return the resultsValueLabel1
	 */
	public JLabel getResultsValueLabel1() {
		return resultsValueLabel1;
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
	 * @return the resultsValueLabel2
	 */
	public JLabel getResultsValueLabel2() {
		return resultsValueLabel2;
	}


	/**
	 * @return the roundValueLabel
	 */
	public JLabel getRoundValueLabel() {
		return roundValueLabel;
	}




}
