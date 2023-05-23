package main.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.exceptions.IllegalFundsException;
import main.exceptions.InventoryLimitException;
import main.exceptions.TeamLimitException;
import main.model.Team.Role;

/**
 * Market class for buying and selling athletes and items.
 * @author Jiejun Tan
 *
 */
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
     * Checks if a legal team can be formed
     * 
     * @return <code>true</code> if full starting team is possible
     */
    public boolean canPurchaseLegalTeam() {
    	int teamSize = data.getTeam().getMainTeamSize() + data.getTeam().getReserveTeamSize();
    	
    	// Checks if team has sufficient members
    	if (teamSize >= Team.MAIN_LIMIT) {
    		return true;
    	}
    	
    	// If not, calculates how much money is required based on how many athletes are needed for a full team
    	int requiredSize = Team.MAIN_LIMIT - teamSize;
		List<Integer> prices = new ArrayList<Integer>();		
		for (Athlete athlete : availableAthletes) {
			prices.add(athlete.calculatePurchasePrice(data.getDifficulty().modifier));
    	}
		Collections.sort(prices);
		
		// If there isn't enough money to purchase the cheapest members to meet minimum team size requirements, end game
		// Prices scale up weekly so unlikely to be able to afford next week
		int moneyRequired = prices.get(0) * requiredSize;
		return moneyRequired <= data.getMoney();
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
