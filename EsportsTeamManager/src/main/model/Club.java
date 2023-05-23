package main.model;

import java.util.ArrayList;
import java.util.List;

import main.exceptions.InventoryLimitException;

/**
 * Club to store and use items
 * @author Jiejun Tan
 *
 */
public final class Club {
	
	/**
	 * Player inventory
	 */
    private List<Item> inventory;
    
    /**
     * Constructs club and initializes inventory
     */
    public Club() {
    	this.inventory = new ArrayList<Item>();
    }
  
    /**
     * Takes in an item and athlete and applies that items effect to the athlete
     * 
     * @param item		item to use
     * @param athlete	Athlete to use item on
     */
    public void useItem(Item item, Athlete athlete) {
    	String positiveStat = item.getItem().getPositiveStat();
		int positiveValue = item.getItem().getPositiveValue();
		switch (positiveStat) {
		case Item.REACTION_TIME:
	       	 athlete.setReactionTime(Math.min(100, athlete.getReactionTime() + positiveValue));
			break;
		case Item.EYESIGHT:
	       	 athlete.setEyeSight(Math.min(100, athlete.getEyeSight() + positiveValue));
			break;
		case Item.INTELLIGENCE:
	       	 athlete.setIntelligence(Math.min(100, athlete.getIntelligence() + positiveValue));
			break;
		default:
			break;
		}
		String negativeStat = item.getItem().getNegativeStat();
		int negativeValue = item.getItem().getNegativeValue();
		switch (negativeStat) {
		case Item.REACTION_TIME:
	       	 athlete.setReactionTime(Math.min(100, athlete.getReactionTime() + negativeValue));
			break;
		case Item.EYESIGHT:
	       	 athlete.setEyeSight(Math.min(100, athlete.getEyeSight() + negativeValue));
			break;
		case Item.INTELLIGENCE:
	       	 athlete.setIntelligence(Math.min(100, athlete.getIntelligence() + negativeValue));
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
	public List<Item> getInventory() {
		return inventory;
	}

	/**
     * Adds Item to the clubs inventory
     * 
     * @param item item to add
	 * @throws InventoryLimitException if inventory is full
     */
    public void addItem(Item item) throws InventoryLimitException {
    	if (inventory.size() < 5) {
    		inventory.add(item);
    	} else {
    		throw new InventoryLimitException();
    	}
    }
}
