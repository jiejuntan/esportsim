package main.gui.club;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.subclassable.DetailController;
import main.model.Equipment;
import main.model.GameData.Difficulty;

/**
 * Controller for item detail view.
 * 
 * @author Jiejun Tan
 *
 */
public final class ItemDetailController extends DetailController {
	
	/**
	 * Item currently in view.
	 */
	private Equipment item;
	
	/**
	 * Constructor for item detail controller
	 * 
	 * @param frame game frame to manage navigation
	 * @param item	item to view
	 */
	public ItemDetailController(GameFrame frame, Equipment item) {
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
		initializeUseButton();
		
		super.launch();
	}

	/**
	 * Sets item name.
	 */
	private void setTitle() {
		JButton titleButton = ((ItemDetailPanel) panel).getChangeNameButton();
		titleButton.setText(item.getEquipment().getName());
	}
	
	/**
	 * Displays item's bonus stats and price
	 */
	private void setStats() {
		JLabel reactionBonusLabel = ((ItemDetailPanel) panel).getReactionBonusLabel();
		reactionBonusLabel.setText(String.valueOf(item.getEquipment().getValue()));
		
		JLabel eyesightBonusLabel = ((ItemDetailPanel) panel).getEyesightBonusLabel();
		eyesightBonusLabel.setText(String.valueOf(item.getEquipment().getValue()));
		
		JLabel intelligenceBonusLabel = ((ItemDetailPanel) panel).getIntelligenceBonusLabel();
		intelligenceBonusLabel.setText(String.valueOf(item.getEquipment().getValue()));
		
		JLabel staminaBonusLabel = ((ItemDetailPanel) panel).getStaminaBonusLabel();
		staminaBonusLabel.setText(String.valueOf(item.getEquipment().getValue()));
		
		Difficulty diff = frame.getGame().getData().getDifficulty();
		int price = item.calculatePurchasePrice(diff.modifier);
		JLabel itemValueLabel = ((ItemDetailPanel) panel).getPriceValueLabel();
		itemValueLabel.setText("$" + String.valueOf(price));
	}
	
	/**
	 * Initializes use button to choose an athlete to use item on.
	 */
	private void initializeUseButton() {
		JButton confirmButton = ((ItemDetailPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	protected void toPreviousScreen() {
		frame.toClubScreen();
	}
}
