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
    	updateMarket();
    }

    
    /**
     * Clears the list: (availableAthletes, availableEquipment) and adds new Equipment and Athletes
     */
    public void updateMarket() {
    	clearMarket();
    	
    	for (int count=0; count < 5; count++) {
    		Athlete athlete = new Athlete(3);
    		// implement difficulty + weekly scalings for athlete stats
    		
    		this.availableAthletes.add(athlete);
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
    	List<Athlete> athletes = viewAvailableAthletes();
    	
    	if (atIndex < athletes.size()) {
    		Athlete athlete = athletes.get(atIndex);
    		
    		int price = calculatePurchasePrice(athlete);
    		
    		try {
    			this.data.deductMoney(price);
    			this.data.getTeam().addAthlete(athlete);
            	athletes.remove(atIndex);
    		} catch (IllegalArgumentException e) {
    			throw e;
    		} catch (TeamMemberLimitException e) {
    			this.data.incrementMoney(price); // recovers lost money when unable to purchase due to member limit
    			throw e;
    		}
    	} else {
    		throw new IndexOutOfBoundsException();
    	}
    	
    	if (withUpdate) {
    		updateMarket();
    	}
    }
    
    
    public void sellAthlete(Athlete athlete) {
		int price = calculateSalePrice(athlete);
		// money methods
	}
    
    
    /**
     * Calculates purchase price
     * 
     * @param purchase	Purchasable object
     * @return			purchase price
     */
    public int calculatePurchasePrice(Purchasable purchase) {
    	return purchase.getBasePrice() * this.data.getDifficulty().modifier;
    }
    
    
    /**
     * Calculates sale price
     * 
     * @param sale	Purchasable object
     * @return		sale price
     */
    public int calculateSalePrice(Purchasable sale) {
    	return sale.getBasePrice() / this.data.getDifficulty().modifier;
    }
    
    
    /**
     * Views available athletes for purchase
     * 
     * @return	available Athletes list
     */
    public List<Athlete> viewAvailableAthletes() {
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
    	this.availableAthletes.clear();
    	this.availableEquipment.clear();
    }
    
}
