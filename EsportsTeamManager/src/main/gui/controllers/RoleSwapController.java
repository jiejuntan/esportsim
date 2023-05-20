/**
 * 
 */
package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import main.gui.GameFrame;
import main.gui.panels.RoleSwapPanel;
import main.model.Athlete;
import main.model.Team;

/**
 * Controller for swapping role of an athlete.
 * 
 * @author Jiejun Tan
 *
 */
public class RoleSwapController extends ThumbnailController {

	/**
	 * Athlete initiating role swap.
	 */ 
	private Athlete athlete;
	
	/**
	 * Constructor when drafting
	 * 
	 * @param frame 	game frame
	 * @param athlete 	Athlete initiating role swap
	 */
	public RoleSwapController(GameFrame frame, Athlete athlete) {
		super(frame);
		this.athlete = athlete;
		initialize();
	}

	/**
	 * Runs initialize methods and launches panel
	 */
	@Override
	protected void initialize() {
		panel = new RoleSwapPanel();
		
		setSwappableAthletes();
		initializeConfirmButton();
		
		launch();
	}
	
	private void setSwappableAthletes() {
		Team team = frame.getGame().getData().getTeam();
		List<Athlete> athletes = team.getMainMembers();
		List<JButton> athleteButtons = ((RoleSwapPanel) panel).getThumbButtons();
		
		for (int i = 0; i < athletes.size(); i++) {
			Athlete outgoingAthlete = athletes.get(i);
			JButton button = athleteButtons.get(i);
			String path = outgoingAthlete.getPortraitPath();
			
			formatButtonIcon(button, path);
			button.setEnabled(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					team.swapRole(athlete, outgoingAthlete);
					toDraftScreen();
				}
			});
		}
	}
	
	private void initializeConfirmButton() {
		// TODO Auto-generated method stub
		
	}

	private void toDraftScreen() {
		close();
		frame.toDraftScreen();
	}

}
