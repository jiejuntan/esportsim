package main.gui.market;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.club.ItemDetailController;
import main.gui.club.ItemDetailPanel;
import main.model.Item;
import main.model.Market;
import main.model.GameData.Difficulty;

/**
 * Controller for selling items.
 * 
 * @author Jiejun Tan
 *
 */
public class SellItemDetailController extends ItemDetailController {

	/**
	 * Constructor for detail view when selling items.
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param item		Item to view
	 */
	public SellItemDetailController(GameFrame frame, Item item) {
		super(frame, item);
		initializeAdditionalComponents();
	}

	/**
	 * Initializes additional components for this screen and relaunch.
	 */
	protected void initializeAdditionalComponents() {
		setPrice();		
		super.launch();
	}
	
	/**
	 * Sets the purchase price for the item.
	 */
	private void setPrice() {
		JLabel priceLabel = ((ItemDetailPanel) panel).getPriceLabel();
		priceLabel.setVisible(true);
		Difficulty diff = frame.getGame().getData().getDifficulty();
		int price = item.calculatePurchasePrice(diff.modifier);
		JLabel itemValueLabel = ((ItemDetailPanel) panel).getPriceValueLabel();
		itemValueLabel.setText("$" + String.valueOf(price));
		itemValueLabel.setVisible(true);
	}	
	
	/**
	 * Initializes sell button.
	 */
	@Override
	protected void initializeConfirmButton() {
		JButton confirmButton = ((ItemDetailPanel) panel).getConfirmButton();
		confirmButton.setText("Sell");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				Market market = frame.getGame().getMarket();
				market.sellItem(item);
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Returns to previous screen.
	 */
	@Override
	protected void toPreviousScreen() {
		frame.toMarketScreen(true);
	}

}
