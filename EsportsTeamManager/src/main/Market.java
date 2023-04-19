package main;

import java.util.ArrayList;
import java.util.List;

public class Market {
	
	private GameData data;
	
    private List<Athlete> availableAthletes;
    private List<Equipment> availableEquipment;
    
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
    		Athlete athlete = new Athlete(0);
    		this.availableAthletes.add(athlete);
    	}
    	
    	//Adds equipmentCount of Equipment to the equipmentCount list
    	for (int equipmentCount = 20; equipmentCount > 0; equipmentCount--) {
    		
    		
    		Ingestible ingestible = new Ingestible();
    		TrainingEquipment trainingEquipment = new TrainingEquipment();
    		
    		availableEquipment.add(ingestible);
    		availableEquipment.add(trainingEquipment);
    	}
    	
    	
    }

    public void draftAthlete(int i) throws IllegalArgumentException {
    	List<Athlete> athletes = viewStoresAthlete();
    	
    	if (i < athletes.size()) {
    		this.data.getTeam().addAthlete(athletes.get(i));
        	athletes.remove(i);
    	} else {
    		throw new IllegalArgumentException();
    	}
    	
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
    	this.availableAthletes.clear();
    	this.availableEquipment.clear();
    }
    
    

}
