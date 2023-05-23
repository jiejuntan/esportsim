package main.gui.stadium;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

import main.gui.GUIConstants;
import main.gui.subclassable.BasePanel;

import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

/**
 * Panel for displaying matches
 * 
 * @author Blake and Jun
 *
 */
public final class MatchPanel extends BasePanel {
	
	/**
	 * Displays match events
	 */
	private JTextArea matchLabel;
	
	/**
	 * Constructor for match panel
	 */
    public MatchPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 0, 200, 0};
		gridBagLayout.rowHeights = new int[]{175, 0, 175, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		matchLabel = new JTextArea();
		matchLabel.setEditable(false);
		matchLabel.setBackground(Color.LIGHT_GRAY);
		matchLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		DefaultCaret caret = (DefaultCaret) matchLabel.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		GridBagConstraints gbc_roundLabel = new GridBagConstraints();
		gbc_roundLabel.fill = GridBagConstraints.BOTH;
		gbc_roundLabel.insets = new Insets(10, 10, 5, 10);
		gbc_roundLabel.gridx = 1;
		gbc_roundLabel.gridy = 1;
		this.add(matchLabel, gbc_roundLabel);
		
		JScrollPane scrollPane = new JScrollPane(matchLabel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().addAdjustmentListener(
				e -> {
				    if ((e.getAdjustable().getValue() - e.getAdjustable().getMaximum()) > -scrollPane.getHeight() - 20){
				        e.getAdjustable().setValue(e.getAdjustable().getMaximum());
				    }   
				});
		this.add(scrollPane, gbc_roundLabel);
    }
    
    //Sets Background Image
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	try {
    		Image img = ImageIO.read(getClass().getResource(
    				GUIConstants.BACKGROUND_BATTLE)).getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
    		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
  	
	/**
	 * @return the matchLabel
	 */
	public JTextArea getMatchLabel() {
		return matchLabel;
	}

}
