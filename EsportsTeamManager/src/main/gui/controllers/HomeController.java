package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.panels.HomePanel;

public class HomeController extends Controller {

	public HomeController(GameFrame frame) {
		super(frame);
		initialize();
	}

	@Override
	protected void initialize() {
		panel = new HomePanel();
		
		JLabel weekLabel = ((HomePanel) panel).getWeekLabel();
		weekLabel.setText(String.format("Week %d of %d", 
				frame.getGame().getData().getCurrentWeek(),
				frame.getGame().getData().getSeasonDuration()));
		
		JLabel moneyLabel = ((HomePanel) panel).getMoneyLabel();
		moneyLabel.setText("Money: $" + frame.getGame().getData().getMoney());
		
		JButton clubButton = ((HomePanel) panel).getClubButton();
		clubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toClubScreen();
			}
		});
		launch();
	}
	
	private void toClubScreen() {
		close();
		frame.toClubScreen();
	}
}
