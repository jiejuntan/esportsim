/**
 * 
 */
package main.gui.controllers.detailControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.controllers.subclassable.DetailController;
import main.gui.panels.detailPanels.ItemDetailPanel;
import main.gui.panels.subclassable.DetailPanel;
import main.model.Equipment;
import main.model.GameData.Difficulty;

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
		super.setPortrait(((DetailPanel) panel).getPortraitLabel(), item.getPortraitPath());
		setStats();
		
		initializeBackButton();
		initializeUseButton();
		
		super.launch();
	}

	/**
	 * Sets item name.
	 */
	private void setTitle() {
		JButton titleButton = ((DetailPanel) panel).getChangeNameButton();
		titleButton.setText(item.getEquipment().getName());
	}
	
	/**
	 * Displays item's bonus stats and price
	 */
	private void setStats() {
		JLabel reactionBonusLabel = ((DetailPanel) panel).getReactionBonusLabel();
		reactionBonusLabel.setText(String.valueOf(item.getEquipment().getValue()));
		
		JLabel eyesightBonusLabel = ((DetailPanel) panel).getEyesightBonusLabel();
		eyesightBonusLabel.setText(String.valueOf(item.getEquipment().getValue()));
		
		JLabel intelligenceBonusLabel = ((DetailPanel) panel).getIntelligenceBonusLabel();
		intelligenceBonusLabel.setText(String.valueOf(item.getEquipment().getValue()));
		
		JLabel staminaBonusLabel = ((DetailPanel) panel).getStaminaBonusLabel();
		staminaBonusLabel.setText(String.valueOf(item.getEquipment().getValue()));
		
		Difficulty diff = frame.getGame().getData().getDifficulty();
		int price = item.calculatePurchasePrice(diff.modifier);
		JLabel itemValueLabel = ((DetailPanel) panel).getPriceValueLabel();
		itemValueLabel.setText("$" + String.valueOf(price));
	}

	/**
	 * Initializes back button to return to club
	 */
	private void initializeBackButton() {
		JButton backButton = ((DetailPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Initializes use button to choose an athlete to use item on.
	 */
	private void initializeUseButton() {
		JButton confirmButton = ((DetailPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	private void toPreviousScreen() {
		frame.toClubScreen();
	}
}
