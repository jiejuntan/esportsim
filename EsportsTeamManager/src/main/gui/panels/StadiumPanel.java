package main.gui.panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import main.gui.GUIConstants;

/**
 * Stadium Panel for displaying the game matches
 * 
 * @author blake
 *
 */
public class StadiumPanel extends ThumbnailPanel {
	
	protected JButton backButton;
	
	public StadiumPanel() {
		titleLabel.setText("Stadium");
		disableBottomThumbs();
		//subheadingLabel1.setText("Select Your Opponent Team");
		
		
//		confirmButton = new JButton("Back");
//		confirmButton.setPreferredSize(new Dimension(250, 50));
//		confirmButton.setFocusPainted(false);
//		confirmButton.setBackground(GUIConstants.COMPONENT);
//		confirmButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
//		GridBagConstraints gbc_backButton = new GridBagConstraints();
//		gbc_backButton.insets = new Insets(0, 0, 1, 1);
//		gbc_backButton.gridx = 5;
//		gbc_backButton.gridy = 11;
//		this.add(backButton, gbc_backButton);
	}

}
