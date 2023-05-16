package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import main.gui.GameFrame;
import main.gui.panels.SetupPanel;
import main.model.GameData.Difficulty;

public class SetupController extends Controller {

	public SetupController(GameFrame frame) {
		super(frame);
	}

	@Override
	protected void initialize() {
		panel = new SetupPanel();
		
		JTextField teamNameTextField = ((SetupPanel) panel).getTeamNameTextField();
		teamNameTextField.setText(frame.getGame().getData().getTeam().getName());

		JSlider durationSlider = ((SetupPanel) panel).getDurationSlider();
		durationSlider.setValue(frame.getGame().getData().getSeasonDuration());
		
		JToggleButton easyToggleButton = ((SetupPanel) panel).getEasyToggleButton();
		easyToggleButton.setSelected(frame.getGame().getData().getDifficulty() == Difficulty.EASY);
		
		JToggleButton hardToggleButton = ((SetupPanel) panel).getHardToggleButton();
		hardToggleButton.setSelected(frame.getGame().getData().getDifficulty() == Difficulty.HARD);
		
		JButton confirmButton = ((SetupPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					frame.getGame().getData().getTeam().setTeamName(teamNameTextField.getText());
					frame.getGame().getData().setSeasonDuration(durationSlider.getValue());
					frame.getGame().getData().setDifficulty(easyToggleButton.isSelected() ? Difficulty.EASY : Difficulty.HARD);
					toDraftScreen();
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(panel, "Team name must be between 3-15 characters, with no special characters.", "Error", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		launch();
	}
	
	private void toDraftScreen() {
		close();
		frame.toDraftScreen();
	}
}
