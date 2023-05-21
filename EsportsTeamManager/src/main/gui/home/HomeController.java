package main.gui.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.subclassable.Controller;

/**
 * Controller for home screen.
 * 
 * @author Jiejun Tan
 *
 */
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

		super.setMoney(((HomePanel) panel).getMoneyLabel());

		JLabel weekLabel = ((HomePanel) panel).getWeekLabel();
		weekLabel.setText(String.format("Week %d of %d", 
				frame.getGame().getData().getCurrentWeek(),
				frame.getGame().getData().getSeasonDuration()));
		
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
	
	/**
	 * Launches club screen
	 */
	private void toClubScreen() {
		frame.toClubScreen();
	}
	
	/**
	 * Launches stadium screen
	 */
	private void toStadiumScreen() {
		frame.toStadiumScreen();
	}
	
	/**
	 * Launches market screen
	 */
	private void toMarketScreen() {
		frame.toMarketScreen();
	}
}
