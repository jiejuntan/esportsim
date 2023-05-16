package gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui.GameFrame;
import gui.panels.ClubPanel;

public class ClubController extends Controller {

	public ClubController(GameFrame frame) {
		super(frame);
	}

	@Override
	protected void initialize() {
		panel = new ClubPanel();

		JLabel titleLabel = ((ClubPanel) panel).getTitleLabel();
		titleLabel.setText(String.format("Club of the %s", frame.getGame().getData().getTeam().getName()));
		
		JButton returnButton = ((ClubPanel) panel).getReturnButton();
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toHomeScreen();
			}
		});

		JButton inventoryButton = ((ClubPanel) panel).getInventoryButton();
		
		launch();
	}
	
	private void toHomeScreen() {
		close();
		frame.toHomeScreen();
	}
}
