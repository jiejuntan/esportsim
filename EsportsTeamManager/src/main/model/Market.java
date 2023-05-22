package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import main.exceptions.IllegalFundsException;
import main.exceptions.IllegalTeamException;
import main.exceptions.InventoryLimitException;
import main.exceptions.TeamLimitException;
import main.model.Team.Role;

public final class Market {
	
	/**
	 * Data transfer object
	 */
	GameData data;
	
	/**
	 * List of available athletes for purchase
	 */
    private List<Athlete> availableAthletes;
    
    /**
     * List of purchased athletes for bookkeeping
     */
    private List<Athlete> purchasedAthletes;
    
    /**
     * List of available equipment for purchase
     */
    private List<Item> availableItems;
    
    /**
     * List of purchased equipment for bookkeeping
     */
    private List<Item> purchasedItems;
    
    
    /**
     * Constructor for Market. Initializes properties and updates the market
     * 
     * @param data injects data object
     */
    public Market(GameData data) {
    	this.data = data;
    	this.availableAthletes = new ArrayList<Athlete>();
    	this.purchasedAthletes = new ArrayList<Athlete>();
    	this.availableItems = new ArrayList<Item>();
    	this.purchasedItems = new ArrayList<Item>();
    	
    	updateMarket(true);
    }

    
    /**
     * Clears the market and adds new Item and Athletes
     * 
     * @param isDrafting is in draft phase or in market
     */
    public void updateMarket(boolean isDrafting) {
    	clearMarket();
 
		Random random = new Random();
    	int maxCount = isDrafting ? 10 : 3 + random.nextInt(3);
    	for (int count=0; count < maxCount; count++) {
    		Athlete athlete = new Athlete(data.getCurrentWeek());
    		athlete.setRole(Team.getRandomRole(false));    		
    		availableAthletes.add(athlete);
    	}
    	if (!isDrafting) {
    		maxCount = 3 + random.nextInt(3);
	    	for (int count=0; count < maxCount; count++) {
	    		Item trainingItem = new Item();
	    		
	    		availableItems.add(trainingItem);
	    	}
    	}
    }
    
    /**
     * Purchases an athlete from market
     * 
     * @param athlete	Athlete to purchase
     * @param role		role to assign Athlete
     * @param newName	new name for Athlete
     * 
     * @throws IllegalFundsException 	if insufficient money
     * @throws TeamLimitException 		if whole team or main team is full
     * @throws IllegalTeamException 	if adding as reserve while main team is not full
     */
    public void purchaseAthlete(Athlete athlete, Role role, String newName) throws IllegalFundsException, TeamLimitException {
    	int money = data.getMoney();
		int price = athlete.calculatePurchasePrice(data.getDifficulty().modifier);
		// Check money first then check team
		if (money < price) {
			throw new IllegalFundsException();
		}
		athlete.setName(newName);
		data.getTeam().addAthlete(athlete, role);
		data.deductMoney(price);
		purchasedAthletes.add(athlete);
    }
    
    /**
     * Checks if the selected Athlete has already been purchased.
     * 
     * @param purchase	purchasable to check
     * @return			<code>true</code> if purchased
     */
    public boolean isPurchased(Purchasable purchase) {
    	return purchasedAthletes.contains(purchase) || purchasedItems.contains(purchase);
    }
    
    /**
     * Sells an athlete from the player's team
     * 
     * @param athlete	Athlete to sell
     */
    public void sellAthlete(Athlete athlete) {
		int price = athlete.calculateSalePrice(data.getDifficulty().modifier);
		
		try {
			data.incrementMoney(price);
			data.getTeam().removeAthlete(athlete);
		} catch (IllegalArgumentException e) {
			// Price is negative, unrecoverable exception
			e.printStackTrace();
		}
	}
    
    /**
     * Gets the price cheapest athlete available
     * 
     * @return price of cheapest athlete
     */
    public int getCheapestAthlete() {
    	int cheapest = 0;
    	for (Athlete athlete : availableAthletes) {
    		if (!isPurchased(athlete)) {
    			int price = athlete.calculatePurchasePrice(data.getDifficulty().modifier);
        		if (cheapest == 0) {
        			cheapest = price;
        		} else if (price < cheapest) {
        			cheapest = price;
        		}
    		}
    	}
    	return cheapest;
    }
    
    /**
     * Views available athletes for purchase
     * 
     * @return	available Athletes list
     */
    public List<Athlete> getAvailableAthletes() {
		return availableAthletes;
	}
    
    /**
     * Views available items for purchase
     * 
     * @return available items list
     */
    public List<Item> getAvailableItems() {
		return availableItems;
	}

    /**
     * Purchases an item from the market.
     * 
     * @param item	item to purchase
     * 
     * @throws IllegalFundsException	if insufficient money
     * @throws InventoryLimitException	if inventory is full
     */
    public void purchaseItem(Item item) throws IllegalFundsException, InventoryLimitException {
    	int money = data.getMoney();
		int price = item.calculatePurchasePrice(data.getDifficulty().modifier);
		// Check money first then check inventory
		if (money < price) {
			throw new IllegalFundsException();
		}
		data.getClub().addItem(item);
		data.deductMoney(price);
		purchasedItems.add(item);
    }

    /**
     * Sells an item from the player's inventory.
     * 
     * @param item item to sell
     */
    public void sellItem(Purchasable item) {
		int price = item.calculateSalePrice(data.getDifficulty().modifier);
		
		try {
			data.incrementMoney(price);
			data.getClub().getInventory().remove(item);
		} catch (IllegalArgumentException e) {
			// Price is negative, unrecoverable exception
			e.printStackTrace();
		}
    }
    
    /**
     * Clears list of available athletes and equipment in market
     */
    public void clearMarket() {
    	availableAthletes.clear();
    	purchasedAthletes.clear();
    	availableItems.clear();
    	purchasedItems.clear();
    }
    
}
