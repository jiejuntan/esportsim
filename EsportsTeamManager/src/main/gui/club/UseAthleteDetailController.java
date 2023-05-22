package main.gui.club;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import main.gui.GUIConstants;
import main.gui.GameFrame;
import main.model.Athlete;
import main.model.Club;
import main.model.Item;

/**
 * Controller for athlete detail panel to confirm item use
 * 
 * @author Jiejun Tan
 *
 */
public class UseAthleteDetailController extends ClubDetailController {

	/**
	 * Item to use.
	 */
	private Item item;
	
	/**
	 * Constructor for athlete detail view to confirm item use
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param athlete	Athlete to use on
	 * @param item		Item to use
	 */
	public UseAthleteDetailController(GameFrame frame, Athlete athlete, Item item) {
		super(frame, athlete);
		this.item = item;
		initializeAdditionalComponents();
	}

	/**
	 * Initializes additional components for this screen and relaunch.
	 */
	protected void initializeAdditionalComponents() {
		hideUnused();
		setBonusStats();
		super.launch();
	}

	/**
	 * Hides unused components from superclass
	 */
	private void hideUnused() {
		JButton nameButton = ((ClubDetailPanel) panel).getChangeNameButton();
		ActionListener[] listeners = nameButton.getActionListeners();
		for (ActionListener listener : listeners) {
			nameButton.removeActionListener(listener);
		}
		JLabel editTipLabel = ((ClubDetailPanel) panel).getEditTipLabel();
		editTipLabel.setVisible(false);
		@SuppressWarnings("rawtypes")
		JComboBox roleComboBox = ((ClubDetailPanel) panel).getRoleComboBox();
		roleComboBox.setVisible(false);
		JLabel roleLabel = ((ClubDetailPanel) panel).getRoleLabel();
		roleLabel.setVisible(false);
	}
	
	/**
	 * Displays bonus stats that item provides
	 */
	private void setBonusStats() {
		JLabel reactionBonusLabel = ((ClubDetailPanel) panel).getReactionBonusLabel();
		reactionBonusLabel.setVisible(true);
		JLabel eyesightBonusLabel = ((ClubDetailPanel) panel).getEyesightBonusLabel();
		eyesightBonusLabel.setVisible(true);
		JLabel intelligenceBonusLabel = ((ClubDetailPanel) panel).getIntelligenceBonusLabel();
		intelligenceBonusLabel.setVisible(true);
		
		String positiveStat = item.getItem().getPositiveStat();
		int positiveValue = item.getItem().getPositiveValue();
		switch (positiveStat) {
		case Item.REACTION_TIME:
			reactionBonusLabel.setText("+" + String.valueOf(positiveValue));
			reactionBonusLabel.setForeground(GUIConstants.BONUS_UP);
			break;
		case Item.EYESIGHT:
			eyesightBonusLabel.setText("+" + String.valueOf(positiveValue));
			eyesightBonusLabel.setForeground(GUIConstants.BONUS_UP);
			break;
		case Item.INTELLIGENCE:
			intelligenceBonusLabel.setText("+" + String.valueOf(positiveValue));
			intelligenceBonusLabel.setForeground(GUIConstants.BONUS_UP);
			break;
		default:
			break;
		}
		String negativeStat = item.getItem().getNegativeStat();
		int negativeValue = item.getItem().getNegativeValue();
		switch (negativeStat) {
		case Item.REACTION_TIME:
			reactionBonusLabel.setText(String.valueOf(negativeValue));
			reactionBonusLabel.setForeground(GUIConstants.BONUS_DOWN);
			break;
		case Item.EYESIGHT:
			eyesightBonusLabel.setText(String.valueOf(negativeValue));
			eyesightBonusLabel.setForeground(GUIConstants.BONUS_DOWN);
			break;
		case Item.INTELLIGENCE:
			intelligenceBonusLabel.setText(String.valueOf(negativeValue));
			intelligenceBonusLabel.setForeground(GUIConstants.BONUS_DOWN);
			break;
		default:
			break;
		}	
	}
	
	/**
	 * Initializes confirm button to use item on athlete.
	 */
	@Override
	protected void initializeConfirmButton() {
		JButton confirmButton = ((ClubDetailPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				Club club = frame.getGame().getData().getClub();
				club.useItem(item, athlete);
				club.getInventory().remove(item);
				toInventoryScreen();
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	@Override
	protected void toPreviousScreen() {
		frame.toUseItemScreen(item);
	}
	
	/**
	 * Launches inventory screen after using item
	 */
	private void toInventoryScreen() {
		frame.toInventoryScreen();
	}
}
