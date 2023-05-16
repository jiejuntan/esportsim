package main;

import java.util.ArrayList;
import java.util.List;

public class Market {
	
	/**
	 * Data transfer object
	 */
	private GameData data;
	
	/**
	 * List of available athletes for purchase
	 */
    private List<Athlete> availableAthletes;
    
    /**
     * List of available equipment for purchase
     */
    private List<Equipment> availableEquipment;
    
    
    /**
     * Constructor for Market. Initializes properties and updates the market
     * 
     * @param data injects data object
     */
    public Market(GameData data) {
    	this.data = data;
    	this.availableAthletes = new ArrayList<Athlete>();
    	this.availableEquipment = new ArrayList<Equipment>();
    	updateMarket(8);
    }

    
    /**
     * Clears the list: (availableAthletes, availableEquipment) and adds new Equipment and Athletes
     * @param maxCount maximum number of athlete/items to list
     */
    public void updateMarket(int maxCount) {
    	clearMarket();
    	
    	for (int count=0; count < maxCount; count++) {
    		Athlete athlete = new Athlete(3);
    		// implement difficulty + weekly scalings for athlete stats
    		
    		availableAthletes.add(athlete);
    	}
    	
    	for (int equipmentCount = 20; equipmentCount > 0; equipmentCount--) {
    		
    		
    		Ingestible ingestible = new Ingestible();
    		TrainingEquipment trainingEquipment = new TrainingEquipment();
    		
    		availableEquipment.add(ingestible);
    		availableEquipment.add(trainingEquipment);
    	}
    }
    
    
    /**
     * Removes athlete from market and adds to player's team with the option of updating market
     * 
     * @param atIndex						index of Athlete to purchase
     * @param withUpdate					option to update purchasable Athletes in Market
     * @throws IndexOutOfBoundsException 	if index is out of range
     * @throws IllegalArgumentException		if insufficient money to purchase
     * @throws TeamMemberLimitException		if team has reached the member limit
     */
    public void purchaseAthlete(int atIndex, boolean withUpdate) throws IndexOutOfBoundsException, IllegalArgumentException, TeamMemberLimitException {
    	if (atIndex < availableAthletes.size()) {
    		Athlete athlete = availableAthletes.get(atIndex);
    		
    		int price = calculatePurchasePriceAt(atIndex);
    		
    		try {
    			data.deductMoney(price);
    			data.getTeam().addAthlete(athlete);
            	availableAthletes.remove(atIndex);
    		} catch (IllegalArgumentException e) {
    			throw e;
    		} catch (TeamMemberLimitException e) {
    			data.incrementMoney(price); // recovers lost money when unable to purchase due to member limit
    			throw e;
    		}
    	} else {
    		throw new IndexOutOfBoundsException();
    	}
    	
    	if (withUpdate) {
    		updateMarket(5);
    	}
    }
    
    
    /**
     * Sells an athlete from the player's team
     * 
     * @param athlete	Athlete to sell
     */
    public void sellAthlete(Athlete athlete) {
		int price = calculateSalePrice(athlete);
		
		try {
			data.incrementMoney(price);
			data.getTeam().removeAthlete(athlete);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
    
    /**
     * Format a purchasable athlete into a string
     * 
     * @param 	index 	index of athlete in market
     * 
     * @return			string description of athlete
     */
	public String athleteDescriptionAt(int index) {
		Athlete athlete = getAvailableAthletes().get(index);
		return String.format("<html>%s<br><br>Contract: $%s</html>", athlete, calculatePurchasePriceAt(index));
	}
	
    /**
     * Calculates purchase price
     * 
     * @param 	index	index of athlete in market
     * 
     * @return			purchase price
     */
    public int calculatePurchasePriceAt(int index) {
    	Athlete athlete = getAvailableAthletes().get(index);
    	return athlete.getBasePrice() * data.getDifficulty().modifier;
    }
    
    
    /**
     * Calculates sale price
     * 
     * @param sale	Purchasable object
     * @return		sale price
     */
    public int calculateSalePrice(Purchasable sale) {
    	return sale.getBasePrice() / data.getDifficulty().modifier;
    }
    
    
    /**
     * Views available athletes for purchase
     * 
     * @return	available Athletes list
     */
    public List<Athlete> getAvailableAthletes() {
		return availableAthletes;
	}
    
    
    public List<Equipment> viewStoresItems() {
		return availableEquipment;}

    public void purchaseItem(Equipment item) {}

    public void sellItem(Purchasable item) {}
    
    /**
     * Clears list of available athletes and equipment in market
     */
    public void clearMarket() {
    	availableAthletes.clear();
    	availableEquipment.clear();
    }
    
}
