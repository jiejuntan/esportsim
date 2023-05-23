package main.gui.market;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.subclassable.ThumbnailController;
import main.model.Athlete;
import main.model.Club;
import main.model.Item;
import main.model.Market;
import main.model.Team;

/**
 * Controller for market.
 * 
 * @author Jiejun Tan
 *
 */
public final class MarketController extends ThumbnailController {

	/**
	 * Whether in buy or sell mode.
	 */
	boolean isSelling;
	
	/**
	 * Constructor for market controller.
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param isSelling buy or sell mode
	 */
	public MarketController(GameFrame frame, boolean isSelling) {
		super(frame);
		this.isSelling = isSelling;
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new MarketPanel();
		
		super.setMoney(((MarketPanel) panel).getMoneyLabel());
		setSubheadings();
		setAthletes();
		setItems();
		
		initializeBackButton();
		initializeSellButton();
		
		super.launch();
	}

	/**
	 * Sets subheadings based on buy/sell mode.
	 */
	private void setSubheadings() {
		JLabel subheadingLabel1 = ((MarketPanel) panel).getSubheadingLabel1();
		JLabel subheadingLabel2 = ((MarketPanel) panel).getSubheadingLabel2();
		subheadingLabel1.setText(isSelling ? "Your reserves:" : "Athletes for hire:");
		subheadingLabel2.setText(isSelling ? "Your items:" : "Items for sale:");
	}

	/**
	 * Sets purchasable athletes in buy mode or reserve athletes in sell mode
	 */
	private void setAthletes() {
		Team team = frame.getGame().getData().getTeam();
		Market market = frame.getGame().getMarket();
		List<Athlete> athletes = isSelling ? team.getReserveMembers() : market.getAvailableAthletes();
		
		List<JButton> athleteButtons = ((MarketPanel) panel).getThumbButtons();
		for (int i = 0; i < athletes.size(); i++) {
			Athlete athlete = athletes.get(i);
			JButton button = athleteButtons.get(i);
			String path = athlete.getPortraitPath();
			
			super.formatButtonIcon(button, path);
			
			if (isSelling || (!isSelling && !market.isPurchased(athlete))) {
				button.setEnabled(true);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						toAthleteScreen(athlete);
					}
				});
			}
		}
		
		if (isSelling && athletes.size() == 0) {
			JLabel subheadingLabel1 = ((MarketPanel) panel).getSubheadingLabel1();
			subheadingLabel1.setText("You don't have any reserves for sale");
		}
	}
	
	/**
	 * Sets purchasable items in buy more or sellable items in sell mode
	 */
	private void setItems() {
		Club club = frame.getGame().getData().getClub();
		Market market = frame.getGame().getMarket();
		List<Item> items = isSelling ? club.getInventory() : market.getAvailableItems();
		
		List<JButton> itemButtons = ((MarketPanel) panel).getThumbButtons();
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			JButton button = itemButtons.get(i + 5);
			String path = item.getPortraitPath();
			
			super.formatButtonIcon(button, path);
			if (isSelling || (!isSelling && !market.isPurchased(item))) {
				button.setEnabled(true);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						toItemScreen(item);
					}
				});
			}
		}
		if (isSelling && items.size() == 0) {
			JLabel subheadingLabel2 = ((MarketPanel) panel).getSubheadingLabel2();
			subheadingLabel2.setText("You don't have any items for sale");
		}
	}

	/**
	 * Initializes back button
	 */
	private void initializeBackButton() {
		JButton backButton = ((MarketPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Initializes sell button to toggle sell/buy mode
	 */
	private void initializeSellButton() {
		JButton toggleSellButton = ((MarketPanel) panel).getConfirmButton();
		toggleSellButton.setText(isSelling ? "Mode: Sell" : "Mode: Buy");
		toggleSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSelling = isSelling ? false : true;
				initialize();
			}
		});
	}
	
	/**
	 * Closes club screen and launches home screen.
	 */
	protected void toPreviousScreen() {
		frame.toHomeScreen();
	}
	
	/**
	 * Closes current screen and launches detailed buy/sell view of selected athlete.
	 * @param athlete to view
	 */
	private void toAthleteScreen(Athlete athlete) {
		if (isSelling) {
			frame.toSellAthleteDetailScreen(athlete);
		} else {
			frame.toPurchaseAthleteDetailScreen(athlete);
		}
	}
	
	/**
	 * Closes current screen and launches detailed buy/sell view of selected item.
	 * @param item item to view
	 */
	private void toItemScreen(Item item) {
		if (isSelling) {
			frame.toSellItemDetailScreen(item);
		} else {
			frame.toPurchaseItemDetailScreen(item);
		}
	}
	
}
