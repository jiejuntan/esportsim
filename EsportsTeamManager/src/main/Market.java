package main;

import java.util.List;

public class Market {
	
    private List<Athlete> availableAthletes;
    private List<Equipment> availableEquipment;

    /**
     * Clears the list: (availableAthletes, availableEquipment) and adds new Equipment and Athletes
     */
    public void updateMarket() {
    	
    	availableAthletes.clear();
    	availableEquipment.clear();
    	
    	for (int athleteCount = 20; athleteCount > 0; athleteCount--) {
    		Athlete athlete = new Athlete(false);
    		
    		availableAthletes.add(athlete);
    	}
    	
    	for (int itemCount = 20; itemCount > 0; itemCount--) {
    		
    		
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
    
    

}
