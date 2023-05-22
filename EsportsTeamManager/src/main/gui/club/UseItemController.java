package main.gui.club;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.model.Athlete;
import main.model.Item;

/**
 * Controller for using an item on an athlete.
 * 
 * @author Jiejun Tan
 */
public class UseItemController extends ClubController {

	/**
	 * Item to use.
	 */
	private Item item;
	
	/**
	 * Constructor for item use panel
	 * 
	 * @param frame	game frame to manage navigation
	 */
	public UseItemController(GameFrame frame, Item item) {
		super(frame);
		this.item = item;
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
		titleLabel.setText("Give your item to:");
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
		frame.toItemDetailScreen(item);
	}
	
	/**
	 * Closes current screen and launches detailed view of selected athlete.
	 */
	@Override
	protected void toAthleteScreen(Athlete athlete) {
		frame.toUseAthleteDetailController(athlete, item);
	}

}
