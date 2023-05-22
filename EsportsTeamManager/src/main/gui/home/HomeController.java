package main.gui.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.exceptions.GameOverException;
import main.gui.GameFrame;
import main.gui.subclassable.Controller;
import main.model.GameData;

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

		GameData data = frame.getGame().getData();

		JLabel weekLabel = ((HomePanel) panel).getWeekLabel();
		weekLabel.setText(String.format("Week %d of %d", 
				data.getCurrentWeek(),
				data.getSeasonDuration()));
		
		JLabel winsLabel = ((HomePanel) panel).getWinsLabel();
		winsLabel.setText(String.format("Wins: %d", 
				data.getTeam().getWins()));
		
		JLabel lossesLabel = ((HomePanel) panel).getLossesLabel();
		lossesLabel.setText(String.format("Losses: %d", 
				data.getTeam().getLosses()));
		
		JButton clubButton = ((HomePanel) panel).getClubButton();
		clubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toClubScreen();
			}
		});
		
		JButton stadiumButton = ((HomePanel) panel).getStadiumButton();
		if ((data.getTeam().getWins() + data.getTeam().getLosses()) < data.getCurrentWeek()) {
			stadiumButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (data.getTeam().isMainTeamFull()) {
						toStadiumScreen();
					} else {
						JOptionPane.showMessageDialog(panel, 
								"You don't have a full starting team to play.", 
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		} else {
			stadiumButton.setEnabled(false);
		}
		
		
		JButton marketButton = ((HomePanel) panel).getMarketButton();
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toMarketScreen();
			}
		});
		
		JButton endWeekButton = ((HomePanel) panel).getEndWeekButton();
		endWeekButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.getGame().advanceWeek();
					initialize();
					int shouldTrain = JOptionPane.showConfirmDialog(panel, 
							"Do you want to train an athlete?", 
							"Training available", JOptionPane.ERROR_MESSAGE);
					if (shouldTrain == JOptionPane.YES_OPTION) {
						toTrainAthleteScreen();
					}
				} catch (GameOverException e1) {
					toGameOverScreen();
				}
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
		frame.toMarketScreen(false);
	}
	
	/** 
	 * Launches the training screen
	 */
	private void toTrainAthleteScreen() {
		frame.toTrainAthleteScreen();
	}
	
	private void toGameOverScreen() {
		frame.toGameOverScreen();
	}
}
