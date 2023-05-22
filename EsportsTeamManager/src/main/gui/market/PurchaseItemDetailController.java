package main.gui.market;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.exceptions.IllegalFundsException;
import main.exceptions.InventoryLimitException;
import main.gui.GameFrame;
import main.gui.club.ItemDetailController;
import main.gui.club.ItemDetailPanel;
import main.model.Item;
import main.model.Market;
import main.model.GameData.Difficulty;

/**
 * 
 * @author Jiejun Tan
 */
public class PurchaseItemDetailController extends ItemDetailController {
	
	/**
	 * Constructor for detail view when purchasing items.
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param item		Item to view
	 */
	public PurchaseItemDetailController(GameFrame frame, Item item) {
		super(frame, item);
		initialize();
	}
	
	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		setPrice();
		
		super.launch();
	}
	
	/**
	 * Sets the purchase price for the item.
	 */
	private void setPrice() {
		Difficulty diff = frame.getGame().getData().getDifficulty();
		int price = item.calculatePurchasePrice(diff.modifier);
		JLabel itemValueLabel = ((ItemDetailPanel) panel).getPriceValueLabel();
		itemValueLabel.setText("$" + String.valueOf(price));
	}
	
	/**
	 * Initializes purchase button.
	 */
	@Override
	protected void initializeConfirmButton() {
		JButton confirmButton = ((ItemDetailPanel) panel).getConfirmButton();
		confirmButton.setText("Purchase");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				Market market = frame.getGame().getMarket();
				try {
					market.purchaseItem(item);
					toPreviousScreen();
				} catch (IllegalFundsException e1) {
					JOptionPane.showMessageDialog(panel, 
							"You don't have enough money.", 
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (InventoryLimitException e1) {
					JOptionPane.showMessageDialog(panel, 
							"Your inventory is full. Please clear your inventory to purchase " + item.getItem().getName() + ".", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Returns to previous screen.
	 */
	@Override
	protected void toPreviousScreen() {
		frame.toMarketScreen(false);
	}

}
