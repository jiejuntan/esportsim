package main.gui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.GroupLayout.Alignment;

import main.gui.GUIConstants;

public class StartPanel extends BackgroundPanel {

	private JButton newGameButton;
	
	public StartPanel() {
		newGameButton = new JButton("<html><center><span style=\"font-size: 50px\">"
				+ "Esports Simulator"
				+ "<br><br><br></span>"
				+ "<span style=\"font-size: 20px\">"
				+ "Press any button to start"
				+ "</span></center></html>");
		newGameButton.setContentAreaFilled(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setFont(new Font("Unispace", Font.PLAIN, 10));
		
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(newGameButton, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(newGameButton, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addContainerGap())
		);
		this.setLayout(gl_panel);
	}
	
	/**
	 * @return the newGameButton
	 */
	public JButton getNewGameButton() {
		return newGameButton;
	}
}
