package main.gui.starting;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;

import javax.swing.GroupLayout.Alignment;

import main.gui.GUIConstants;
import main.gui.subclassable.BackgroundPanel;

/**
 * Panel for start screen.
 * 
 * @author Jiejun Tan
 *
 */
public final class StartPanel extends BackgroundPanel {

	// Gettable components for controller manipulation. Protected properties are also exposed to subclasses.
	private JButton newGameButton;
	
	/**
	 * Constructor for start panel
	 */
	public StartPanel() {
		newGameButton = new JButton("<html><center><span style=\"font-size: 70px\">"
				+ "Esports Simulator"
				+ "<br><br><br></span>"
				+ "<span style=\"font-size: 20px\">"
				+ "Press any button to start"
				+ "<br><br>"
				+ "</span></center></html>");
		newGameButton.setContentAreaFilled(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.DETAIL));
		newGameButton.setForeground(Color.WHITE);
		
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
