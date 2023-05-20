package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.panels.ClubPanel;
import main.model.Athlete;
import main.model.Team;

public class ClubController extends ThumbnailController {

	/**
	 * Constructor for club controller
	 * 
	 * @param frame game frame to manage navigation
	 */
	public ClubController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new ClubPanel();
		
		setTitle();
		setMoney(((ClubPanel) panel).getMoneyLabel());
		setAthletes();
		initializeBackButton();
		initializeInventoryButton();
		
		
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
		List<Athlete> athletes = new ArrayList<Athlete>();
		athletes.addAll(team.getMainMembers());
		athletes.addAll(team.getReserveMembers());
		List<JButton> athleteButtons = ((ClubPanel) panel).getThumbButtons();
		
		for (int i = 0; i < athletes.size(); i++) {
			Athlete athlete = athletes.get(i);
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
	}
	
	/**
	 * Initializes back button to return.
	 */
	private void initializeBackButton() {
		JButton backButton = ((ClubPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toHomeScreen();
			}
		});
	}
	
	/**
	 * Initializes inventory button to view inventory.
	 */
	private void initializeInventoryButton() {
		JButton inventoryButton = ((ClubPanel) panel).getConfirmButton();
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toInventoryScreen();
			}
		});
	}
	
	/**
	 * Closes club screen and launches home screen.
	 */
	private void toHomeScreen() {
		close();
		frame.toHomeScreen();
	}
	
	/**
	 * Closes club screen and launches inventory screen.
	 */
	private void toInventoryScreen() {
		close();
		frame.toInventoryScreen();
	}
	
	/**
	 * Closes current screen and launches detailed view of selected athlete.
	 */
	private void toAthleteScreen(Athlete athlete) {
		close();
		frame.toClubDetailScreen(athlete);
	}
}
