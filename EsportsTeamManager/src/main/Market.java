package main;

import java.util.List;

public class Market {
	
    private List<Athlete> availableAthletes;
    private List<Equipment> availableEquipment;
    
    public Market() {
    	updateMarket();
    }

    /**
     * Clears the list: (availableAthletes, availableEquipment) and adds new Equipment and Athletes
     */
    public void updateMarket() {
    	
    	//If the the Athlete and Equipment lists are not null then clear them before update
    	if (availableAthletes != null && availableEquipment != null) {
        	availableAthletes.clear();
        	availableEquipment.clear();
    	}

    	//Adds athleteCount of Athlete to the availableAthletes list
    	for (int athleteCount = 20; athleteCount > 0; athleteCount--) {
    		Athlete athlete = new Athlete(false);
    		
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
    
    public void sellAthlete() {}
    
    public List<Athlete> viewStoreAthlete() {
		return availableAthletes;}
    
    public List<Equipment> viewStoreItems() {
		return availableEquipment;}

    public void purchaseItem(Equipment item) {}

    public void sellItem(Purchasable item) {}
    
    public void clearMarket() {
    	availableAthletes.clear();
    	availableEquipment.clear();
    }
    
    

}
