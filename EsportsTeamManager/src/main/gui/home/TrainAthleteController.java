package main.gui.home;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.club.ClubController;
import main.gui.club.ClubPanel;
import main.model.Athlete;
import main.model.Item;

/**
 * Controller for training an athlete.
 * 
 * @author Jiejun Tan
 */
public class TrainAthleteController extends ClubController {

	/**
	 * Item to use to train
	 */
	private Item item;
	
	/**
	 * Constructor for training athlete panel
	 * 
	 * @param frame	game frame to manage navigation
	 */
	public TrainAthleteController(GameFrame frame) {
		super(frame);
		this.item = new Item();
		initializeAdditionalComponents();
	}

	/**
	 * Initializes additional components for this screen and relaunch.
	 */
	private void initializeAdditionalComponents() {
		hideUnused();
		super.launch();
	}

	/**
	 * Sets title and subheadings of the screen based on team name.
	 */
	@Override
	protected void setTitle() {
		JLabel titleLabel = ((ClubPanel) panel).getTitleLabel();
		titleLabel.setText("Train an athlete:");
	}
	
	/**
	 * Hides unused components from superclass
	 */
	private void hideUnused() {
		JButton inventoryButton = ((ClubPanel) panel).getConfirmButton();
		inventoryButton.setVisible(false);
		JLabel moneyLabel = ((ClubPanel) panel).getMoneyLabel();
		moneyLabel.setVisible(false);
	}
	
	/**
	 * Returns to previous screen.
	 */
	@Override
	protected void toPreviousScreen() {
		frame.toHomeScreen();
	}
	
	/**
	 * Closes current screen and launches detailed view of selected athlete.
	 */
	@Override
	protected void toAthleteScreen(Athlete athlete) {
		frame.toTrainAthleteDetailController(athlete, item);
	}

}
