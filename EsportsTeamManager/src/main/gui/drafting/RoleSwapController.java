package main.gui.drafting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import main.gui.GameFrame;
import main.gui.subclassable.ThumbnailController;
import main.model.Athlete;
import main.model.Team;
import main.model.Team.Role;

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
	 * Constructor for role swap screen.
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param athlete 	Athlete initiating role swap
	 */
	public RoleSwapController(GameFrame frame, Athlete athlete) {
		super(frame);
		this.athlete = athlete;
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new RoleSwapPanel();
		
		setSwappableAthletes();
		
		super.launch();
	}
	
	/**
	 * Displays the available athletes to swap
	 */
	private void setSwappableAthletes() {
		Team team = frame.getGame().getData().getTeam();
		
		List<Athlete> athletes = new ArrayList<Athlete>();
		if (athlete.getRole() == Role.RESERVE) {
			athletes = team.getMainMembers();
		} else {
			athletes = team.getReserveMembers();
		}
		List<JButton> athleteButtons = ((RoleSwapPanel) panel).getThumbButtons();
		
		for (int i = 0; i < athletes.size(); i++) {
			Athlete outgoingAthlete = athletes.get(i);
			JButton button = athleteButtons.get(i);
			String path = outgoingAthlete.getPortraitPath();
			
			super.formatButtonIcon(button, path);
			button.setEnabled(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					team.swapRole(athlete, outgoingAthlete);
					toPreviousScreen();
				}
			});
		}
	}

	/**
	 * Returns to previous screen.
	 */
	protected void toPreviousScreen() {
		frame.toDraftScreen();
	}

}
