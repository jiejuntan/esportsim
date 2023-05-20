/**
 * 
 */
package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import main.gui.GameFrame;
import main.gui.panels.DraftPanel;
import main.gui.panels.RoleSwapPanel;
import main.model.Athlete;

/**
 * Controller for swapping role of an athlete.
 * 
 * @author Jiejun Tan
 *
 */
public class RoleSwapController extends Controller {

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
		List<Athlete> athletes = frame.getGame().getData().getTeam().getMainMembers();
		List<JButton> athleteButtons = ((DraftPanel) panel).getThumbButtons();
		
		for (int i = 0; i < athletes.size(); i++) {
			Athlete athlete = athletes.get(i);
			JButton button = athleteButtons.get(i);
			String path = athlete.getPortraitPath();
			
			formatButtonIcon(button, path);
			
//			if (!market.isPurchased(athlete)) {
//				button.setEnabled(true);
//				button.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						toAthleteScreen(athlete);
//					}
//				});
//			}
		}
	}
	
	private void initializeConfirmButton() {
		// TODO Auto-generated method stub
		
	}

	

}
