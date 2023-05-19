package main.gui.controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.gui.GUIConstants;
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
public class DraftController extends Controller {
	
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
		setMoney();
		setDraftableAthletes();
		initializeConfirmButton();
		launch();
	}
	
	/**
	 * Visually sets the current money.
	 */
	private void setMoney() {
		int money = frame.getGame().getData().getMoney();
		JLabel moneyValueLabel = ((DraftPanel) panel).getMoneyLabel();
		moneyValueLabel.setText("Money: $" + money);
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
	 * Format button icons for available athletes.
	 * 
	 * @param button		button to format
	 * @param portraitPath 	path of athlete portrait
	 */
	private void formatButtonIcon(JButton button, String portraitPath) {
		button.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		BufferedImage portraitImage = null;
		try {
			portraitImage = ImageIO.read(new File(getClass()
					.getResource(portraitPath)
					.toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		button.setIcon(new ImageIcon(portraitImage
				.getScaledInstance(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL, Image.SCALE_DEFAULT)));
		button.setRolloverIcon(
				new ImageIcon(GUIConstants
						.tintImage(portraitImage, GUIConstants.PORTRAIT_BUTTON_ROLLOVER)
						.getScaledInstance(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL, Image.SCALE_DEFAULT)));
	}
	
	/**
	 * Initialize the confirm button used once drafting is finished.
	 */
	private void initializeConfirmButton() {
		Team team = frame.getGame().getData().getTeam();	
		
		JButton confirmButton = ((DraftPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int teamCount = team.getMainTeamSize() + team.getReserveTeamSize();
				if (teamCount >= Team.MIN_TEAM_SIZE) {
					toHomeScreen();
				} else {
					JOptionPane.showMessageDialog(panel, 
							"You don't have enough athletes to start! Select at least " + Team.MIN_TEAM_SIZE  + ".", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
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
		frame.toAthleteScreen(athlete);
	}
	
}
