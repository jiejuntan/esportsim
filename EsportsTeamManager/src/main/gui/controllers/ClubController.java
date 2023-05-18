package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import main.gui.GameFrame;
import main.gui.panels.ClubPanel;

import main.model.Team.Role;

public class ClubController extends Controller {

	public ClubController(GameFrame frame) {
		super(frame);
	}

	@Override
	protected void initialize() {
		panel = new ClubPanel();
		
		JLabel titleLabel = ((ClubPanel) panel).getTitleLabel();
		titleLabel.setText(String.format("Club of the %s", frame.getGame().getData().getTeam().getName()));

		List<JComboBox> roleComboBoxes = ((ClubPanel) panel).getRoleComboBoxes();

		List<JToggleButton> mainAthleteToggles = ((ClubPanel) panel).getMainAthleteToggles();
		
		int currentIndex = 0;
		for (Role role : Role.values()) {
			String description = frame.getGame().getClub().athleteDescriptionAt(role);
			mainAthleteToggles.get(currentIndex).setText(description);
			roleComboBoxes.get(currentIndex).setSelectedItem(role);
			currentIndex++;
		}
				
		JButton returnButton = ((ClubPanel) panel).getReturnButton();
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toHomeScreen();
			}
		});
		
		List<JToggleButton> reserveAthleteToggles = ((ClubPanel) panel).getReserveAthleteToggles();
		JButton inventoryButton = ((ClubPanel) panel).getInventoryButton();
		
		launch();
	}
	
	private void toHomeScreen() {
		close();
		frame.toHomeScreen();
	}
}
