package main.model;

import java.util.Random;

public class Ingestible extends Equipment {

	private IngestibleItem item;
	
    public Ingestible() {
    	setitem();

    }

	/**
	 * This holds the data of the training items
	 * Item value and the state the items affects
	 */
	public enum IngestibleItem {
	    ENERGY_DRINK(1, "stamina", "Energy Drink"),
	    FOCUS_BOOSTER(1, "intelligence", "Focus Booster"),
	    VITAMIN_SUPPLEMENT(1, "eyeSight", "Vitamin Supplement"),
	    HEALTHY_SNACK(1, "stamina", "Healthy Snack"),
	    RECOVERY_SHAKE(1, "reactionTime", "Recovery Snack");

	    private final int value;
	    private final String affectedStat;
	    private final String name;


	    IngestibleItem(int value, String affectedStat, String name) {
	        this.value = value;
	        this.affectedStat = affectedStat;
	        this.name = name;
	    }

	    /**
	     * @return Ingestible stat value
	     */
	    public int getValue() {
	        return value;
	    }

	    /**
	     * @return Stat which the item affects
	     */
	    public String getAffectedStat() {
	        return affectedStat;
	    }
	}
    
    public void setitem() {
        Random random = new Random();

        // Get the values of the IngestibleItem enum
        IngestibleItem[] ingestibleItems = IngestibleItem.values();

        // Generate a random index within the range of values in IngestibleItems
        int randomItemIndex = random.nextInt(ingestibleItems.length);

        // Set the item to the random enum value
        this.item = ingestibleItems[randomItemIndex];
    	
    }

	/**
	 * Calculates Base Price
	 * Price = Item Stat * 50
	 */
	@Override
	public int getBasePrice() {
		return item.value * 50;
	}


	/**
	 * Sets the Equipments Description
	 */
	@Override
	public void setDescription() {
		super.description = String.format("The %s ingestible increases your athletes %s by %d points}", item.name, item.affectedStat, item.value );
	}


}
