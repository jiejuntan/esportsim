package main.model;

import java.util.ArrayList;
import java.util.List;

import main.exceptions.IllegalFundsException;
import main.exceptions.TeamMemberLimitException;
import main.model.GameData.Difficulty;
import main.model.Team.Role;

public class Market {
	
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
    private List<Equipment> availableEquipment;
    
    /**
     * List of purchased equipment for bookkeeping
     */
    private List<Equipment> purchasedEquipment;
    
    
    /**
     * Constructor for Market. Initializes properties and updates the market
     * 
     * @param data injects data object
     */
    public Market(GameData data) {
    	this.data = data;
    	this.availableAthletes = new ArrayList<Athlete>();
    	this.purchasedAthletes = new ArrayList<Athlete>();
    	this.availableEquipment = new ArrayList<Equipment>();
    	this.purchasedEquipment = new ArrayList<Equipment>();
    	
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
    		
    		
    		Equipment trainingEquipment = new Equipment();
    		
    		availableEquipment.add(trainingEquipment);
    	}
    }
    
    /**
     * Purchases an athlete from market
     * 
     * @param athlete	Athlete to purchase
     * @param role		role to assign Athlete
     * @param newName	new name for Athlete
     */
    public void purchaseAthlete(Athlete athlete, Role role, String newName) {
    	Difficulty diff = data.getDifficulty();
		int price = athlete.calculatePurchasePrice(diff.modifier);
    	
    	try {
    		athlete.changeName(newName);
    		data.deductMoney(price);
			data.getTeam().addAthlete(athlete, role);
			purchasedAthletes.add(athlete);
		} catch (TeamMemberLimitException | IllegalFundsException e1) {
			e1.printStackTrace();
		}
    }
    
    /**
     * Checks if the selected Athlete has already been purchased.
     * 
     * @param athlete	Athlete to check
     * @return			<code>true</code> if purchased
     */
    public boolean isPurchased(Athlete athlete) {
    	return purchasedAthletes.contains(athlete);
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
			throw e;
		}
	}
    
//    /**
//     * Format a purchasable athlete into a string
//     * 
//     * @param 	index 	index of athlete in market
//     * 
//     * @return			string description of athlete
//     */
//	public String athleteDescriptionAt(int index) {
//		Athlete athlete = getAvailableAthletes().get(index);
//		return String.format("<html>%s<br><br>Contract: $%s</html>", athlete, calculatePurchasePrice(index));
//	}
    
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
