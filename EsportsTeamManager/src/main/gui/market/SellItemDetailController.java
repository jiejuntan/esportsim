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

public class SellItemDetailController extends ItemDetailController {

	public SellItemDetailController(GameFrame frame, Item item) {
		super(frame, item);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		setPrice();
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
