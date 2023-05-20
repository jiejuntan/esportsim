package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import main.gui.GameFrame;
import main.gui.panels.ClubPanel;
import main.gui.panels.InventoryPanel;
import main.model.Athlete;
import main.model.Equipment;

/**
 * Controller for player inventory.
 * 
 * @author jjt56
 *
 */
public class InventoryController extends ThumbnailController {

	/**
	 * Constructor for inventory controller
	 * 
	 * @param frame	game frame to manage navigation
	 */
	public InventoryController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new InventoryPanel();
		
		setMoney(((InventoryPanel) panel).getMoneyLabel());
		setItems();
		
		initializeBackButton();
		
		launch();
	}
	
	/**
	 * Gets player's inventory and calls the format button method for each item.
	 */
	private void setItems() {
		List<Equipment> items = frame.getGame().getClub().getInventory();
		List<JButton> itemButtons = ((InventoryPanel) panel).getThumbButtons();
		
		for (int i = 0; i < items.size(); i++) {
			Equipment item = items.get(i);
			JButton button = itemButtons.get(i);
			String path = item.getPortraitPath();
			
			formatButtonIcon(button, path);
			
			button.setEnabled(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toItemDetailScreen(item);
				}
			});
		}
	}

	/**
	 * Initializes back button to return.
	 */
	private void initializeBackButton() {
		JButton backButton = ((InventoryPanel) panel).getBackButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	private void toPreviousScreen() {
		close();
		frame.toClubScreen();
	}
	
	/**
	 * Closes current screen and launches item detail screen.
	 * 
	 * @param item	item to view
	 */
	private void toItemDetailScreen(Equipment item) {
		close();
		frame.toItemDetailScreen(item);
	}
	
}