package main.gui.club;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GUIConstants;
import main.gui.GameFrame;
import main.gui.subclassable.DetailController;
import main.model.Item;

/**
 * Controller for item detail view.
 * 
 * @author Jiejun Tan
 *
 */
public class ItemDetailController extends DetailController {
	
	/**
	 * Item currently in view.
	 */
	protected Item item;
	
	/**
	 * Constructor for item detail controller
	 * 
	 * @param frame game frame to manage navigation
	 * @param item	item to view
	 */
	public ItemDetailController(GameFrame frame, Item item) {
		super(frame);
		this.item = item;
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new ItemDetailPanel();
		
		setTitle();
		super.setPortrait(((ItemDetailPanel) panel).getPortraitLabel(), item.getPortraitPath());
		setStats();
		
		super.initializeBackButton();
		initializeConfirmButton();
		
		super.launch();
	}

	/**
	 * Sets item name.
	 */
	private void setTitle() {
		JButton titleButton = ((ItemDetailPanel) panel).getChangeNameButton();
		titleButton.setText(item.getItem().getName());
	}
	
	/**
	 * Displays item's bonus stats
	 */
	private void setStats() {
		JLabel reactionBonusLabel = ((ItemDetailPanel) panel).getReactionBonusLabel();
		JLabel eyesightBonusLabel = ((ItemDetailPanel) panel).getEyesightBonusLabel();
		JLabel intelligenceBonusLabel = ((ItemDetailPanel) panel).getIntelligenceBonusLabel();

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
	 * Initializes use button to choose an athlete to use item on.
	 */
	protected void initializeConfirmButton() {
		JButton confirmButton = ((ItemDetailPanel) panel).getConfirmButton();
		confirmButton.setText("Use");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				toUseItemScreen();
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	protected void toPreviousScreen() {
		frame.toInventoryScreen();
	}
	
	/**
	 * Launches screen to pick an athlete to use item on
	 */
	private void toUseItemScreen() {
		frame.toUseItemScreen(item);
	}
}
