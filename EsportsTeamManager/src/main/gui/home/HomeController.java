package main.gui.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.subclassable.Controller;

public final class HomeController extends Controller {

	/**
	 * Constructor for home screen.
	 * 
	 * @param frame game frame to manage navigation.
	 */
	public HomeController(GameFrame frame) {
		super(frame);
		initialize();
	}
	
	/**
	 * Initializes panel and components then launches panel.
	 */
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
		
		JButton stadiumButton = ((HomePanel) panel).getStadiumButton();
		stadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toStadiumScreen();
			}
		});
		
		JButton marketButton = ((HomePanel) panel).getMarketButton();
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toMarketScreen();
			}
		});
		
		JButton endWeekButton = ((HomePanel) panel).getEndWeekButton();
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// do something to advance week
			}
		});
		
		super.launch();
	}
	
	private void toClubScreen() {
		frame.toClubScreen();
	}
	
	private void toStadiumScreen() {
		frame.toStadiumScreen();
	}
	
	private void toMarketScreen() {
		frame.toMarketScreen();
	}
}
