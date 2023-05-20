package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.gui.GameFrame;
import main.gui.panels.DraftPanel;
import main.model.Athlete;
import main.model.Market;
import main.model.Team;

/**
 * Controls drafting screen
 * 
 * @author Jiejun Tan
 *
 */
public class DraftController extends ThumbnailController {
	
	/**
	 * @param frame	game frame
	 */
	public DraftController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes screen
	 */
	@Override
	protected void initialize() {
		panel = new DraftPanel();
		setMoney(((DraftPanel) panel).getMoneyLabel());
		setDraftableAthletes();
		initializeConfirmButton();
		launch();
	}
	
	/**
	 * Gets draftable athletes and calls the format button method for each.
	 */
	private void setDraftableAthletes() {
		Market market = frame.getGame().getMarket();
		List<Athlete> athletes = market.getAvailableAthletes();
		List<JButton> athleteButtons = ((DraftPanel) panel).getThumbButtons();
		
		for (int i = 0; i < athletes.size(); i++) {
			Athlete athlete = athletes.get(i);
			JButton button = athleteButtons.get(i);
			String path = athlete.getPortraitPath();
			
			formatButtonIcon(button, path);
			
			if (!market.isPurchased(athlete)) {
				button.setEnabled(true);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						toAthleteScreen(athlete);
					}
				});
			}
		}
	}
	
	/**
	 * Initialize the confirm button used once drafting is finished.
	 */
	private void initializeConfirmButton() {
		Team team = frame.getGame().getData().getTeam();	
		
		JButton confirmButton = ((DraftPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.hasMinimumSize()) {
					startGame();
				} else {
					JOptionPane.showMessageDialog(panel, 
							"You don't have enough athletes to start! Select at least " + Team.MIN_TEAM_SIZE  + ".", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Starts the game.
	 */
	public void startGame() {
		frame.getGame().getData().nextWeek();
		toHomeScreen();
	}
	
	/**
	 * Closes current screen and launches home screen.
	 */
	private void toHomeScreen() {
		close();
		frame.toHomeScreen();
	}
	
	/**
	 * Closes current screen and launches detailed view of selected athlete.
	 */
	private void toAthleteScreen(Athlete athlete) {
		close();
		frame.toDraftDetailScreen(athlete);
	}
	
}
