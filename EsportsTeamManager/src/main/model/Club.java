package main.model;

import java.util.ArrayList;
import java.util.List;

public final class Club {
	
	/**
	 * Data transfer object
	 */
	private GameData data;
	
	/**
	 * Player inventory
	 */
    private List<Equipment> inventory;
    
    public Club(GameData data) {
    	this.data = data;
    	this.inventory = new ArrayList<Equipment>();
    }
  
    /**
     * Takes in an item and athlete and applies that items effect to the athlete
     * 
     * @param item		item to use
     * @param athlete	Athlete to use item on
     */
    public void useItem(Equipment equipment, Athlete athlete) {
    	String AffectedStat = equipment.getEquipment().getAffectedStat();
    	int itemStatValue = equipment.getEquipment().getValue();
    	
    	 switch (AffectedStat) {
         case "reactionTime":
        	 athlete.setReactionTime(athlete.getReactionTime() + itemStatValue);
             break;
         case "eyeSight":
        	 athlete.setEyeSight(athlete.getEyeSight() + itemStatValue);
             break;
         case "intelligence":
        	 athlete.setIntelligence(athlete.getIntelligence() + itemStatValue);
             break;
         case "stamina":
        	 athlete.setStamina(athlete.getStamina() + itemStatValue);
             break;
         default:
             break;
    	 }
    }
    
    /**
     * Gets the Club inventory
     * 
	 * @return Club inventory
	 */
	public List<Equipment> getInventory() {
		return inventory;
	}

	/**
     * Adds Equipment to the clubs inventory
     * 
     * @param equipment equipment to add
     */
    public void addToInventory(Equipment equipment) {
    	inventory.add(equipment);
    }

}
