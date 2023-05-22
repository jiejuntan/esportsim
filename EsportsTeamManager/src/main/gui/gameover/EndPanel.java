package main.gui.gameover;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;

import javax.swing.GroupLayout.Alignment;

import main.gui.GUIConstants;
import main.gui.subclassable.BackgroundPanel;

/**
 * Panel for end screen.
 * 
 * @author Jiejun Tan
 *
 */
public final class EndPanel extends BackgroundPanel {

	// Gettable components for controller manipulation. Protected properties are also exposed to subclasses.
	private JButton endGameButton;
	
	/**
	 * Constructor for end panel
	 */
	public EndPanel() {
		endGameButton = new JButton();
		endGameButton.setContentAreaFilled(false);
		endGameButton.setFocusPainted(false);
		endGameButton.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.DETAIL));
		endGameButton.setForeground(Color.WHITE);
		
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(endGameButton, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(endGameButton, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addContainerGap())
		);
		this.setLayout(gl_panel);
	}
	
	/**
	 * @return the endGameButton
	 */
	public JButton getNewGameButton() {
		return endGameButton;
	}
}
