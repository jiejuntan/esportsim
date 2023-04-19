package main;

import java.util.ArrayList;
import java.util.List;

public class Market {
	
    private List<Athlete> availableAthletes = new ArrayList<Athlete>();
    private List<Equipment> availableEquipment = new ArrayList<Equipment>();
    
    public Market() {
    	updateMarket();
    }

    /**
     * Clears the list: (availableAthletes, availableEquipment) and adds new Equipment and Athletes
     */
    public void updateMarket() {
    	
//    	clearMarket();
    	
    	for (Athlete.AthleteRole role : Athlete.AthleteRole.values()) {
    		Athlete athlete = new Athlete(0);
    		availableAthletes.add(athlete);
    	}
    	
    	//Adds equipmentCount of Equipment to the equipmentCount list
    	for (int equipmentCount = 20; equipmentCount > 0; equipmentCount--) {
    		
    		
    		Ingestible ingestible = new Ingestible();
    		TrainingEquipment trainingEquipment = new TrainingEquipment();
    		
    		availableEquipment.add(ingestible);
    		availableEquipment.add(trainingEquipment);
    	}
    	
    	
    }

    public void draftAthlete(Athlete athlete) {
    	
    	
    }
    
    public void sellAthlete(Athlete athlete) {
    	int price = athlete.getSellBackPrice();
    }
    
    public List<Athlete> viewStoresAthlete() {
		return availableAthletes;}
    
    public List<Equipment> viewStoresItems() {
		return availableEquipment;}

    public void purchaseItem(Equipment item) {}

    public void sellItem(Purchasable item) {}
    
    public void clearMarket() {
    	availableAthletes.clear();
    	availableEquipment.clear();
    }
    
    

}
