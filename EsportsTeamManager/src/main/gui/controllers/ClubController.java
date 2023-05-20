package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.panels.ClubPanel;
import main.model.Athlete;
import main.model.Team;

public class ClubController extends ThumbnailController {

	public ClubController(GameFrame frame) {
		super(frame);
		initialize();
	}

	@Override
	protected void initialize() {
		panel = new ClubPanel();
		
		setTitle();
		setMoney(((ClubPanel) panel).getMoneyLabel());
		setAthletes();
		
		initializeBackButton();
		
//		JButton inventoryButton = ((ClubPanel) panel).getInventoryButton();
		
		launch();
	}
	
	

	/**
	 * Sets title and subheadings of the screen based on team name.
	 */
	private void setTitle() {
		JLabel titleLabel = ((ClubPanel) panel).getTitleLabel();
		titleLabel.setText(String.format("Club of the %s", frame.getGame().getData().getTeam().getName()));
	}
	
	/**
	 * Gets team athletes and calls the format button method for each.
	 */
	private void setAthletes() {
		Team team = frame.getGame().getData().getTeam();
		List<Athlete> mainAthletes = team.getMainMembers();
		List<Athlete> reserveAthletes = team.getReserveMembers();
		List<JButton> athleteButtons = ((ClubPanel) panel).getThumbButtons();
		
		for (int i = 0; i < mainAthletes.size(); i++) {
			Athlete athlete = mainAthletes.get(i);
			JButton button = athleteButtons.get(i);
			String path = athlete.getPortraitPath();
			
			formatButtonIcon(button, path);
			
			button.setEnabled(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toAthleteScreen(athlete);
				}
			});
		}
		for (int i = 0; i < reserveAthletes.size(); i++) {
			Athlete athlete = reserveAthletes.get(i);
			JButton button = athleteButtons.get(i + Team.MAIN_LIMIT);
			String path = athlete.getPortraitPath();
			
			formatButtonIcon(button, path);
			
			button.setEnabled(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toAthleteScreen(athlete);
				}
			});
		}
	}
	
	private void initializeBackButton() {
		JButton backButton = ((ClubPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toHomeScreen();
			}
		});
	}
	
	private void toHomeScreen() {
		close();
		frame.toHomeScreen();
	}
	
	/**
	 * Closes current screen and launches detailed view of selected athlete.
	 */
	private void toAthleteScreen(Athlete athlete) {
		close();
		frame.toClubDetailScreen(athlete);
	}
}
