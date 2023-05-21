/**
 * 
 */
package main.gui.controllers.thumbnailControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.controllers.subclassable.ThumbnailController;
import main.gui.panels.thumbnailPanels.MarketPanel;
import main.model.Athlete;
import main.model.Club;
import main.model.Equipment;
import main.model.Market;
import main.model.Team;

/**
 * Controller for market.
 * 
 * @author Jiejun Tan
 *
 */
public class MarketController extends ThumbnailController {

	/**
	 * Whether in buy or sell mode.
	 */
	boolean isSelling;
	
	/**
	 * Constructor for market controller.
	 * 
	 * @param frame game frame to manage navigation
	 */
	public MarketController(GameFrame frame) {
		super(frame);
		isSelling = false;
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new MarketPanel();
		
		setMoney(((MarketPanel) panel).getMoneyLabel());
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
	}
	
	/**
	 * Sets purchasable items in buy more or sellable items in sell mode
	 */
	private void setItems() {
		Club club = frame.getGame().getClub();
		Market market = frame.getGame().getMarket();
		List<Equipment> items = isSelling ? club.getInventory() : market.getAvailableItems();
		
		List<JButton> itemButtons = ((MarketPanel) panel).getThumbButtons();
		for (int i = 0; i < items.size(); i++) {
			Equipment item = items.get(i);
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
		
	}

	/**
	 * Initializes back button to return to home screen.
	 */
	private void initializeBackButton() {
		JButton backButton = ((MarketPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toHomeScreen();
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
	private void toHomeScreen() {
		frame.toHomeScreen();
	}
	
	/**
	 * Closes current screen and launches detailed buy/sell view of selected athlete.
	 */
	private void toAthleteScreen(Athlete athlete) {
		if (isSelling) {
			// TODO Auto-generated method stub
			frame.toClubDetailScreen(athlete);
		} else {
			// TODO Auto-generated method stub
			frame.toClubDetailScreen(athlete);
		}
	}
	
	/**
	 * Closes current screen and launches detailed buy/sell view of selected item.
	 */
	private void toItemScreen(Equipment item) {
		if (isSelling) {
			// TODO Auto-generated method stub
		} else {
			// TODO Auto-generated method stub
		}
	}
	
}
