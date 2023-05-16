package main.model;

import java.util.Random;

public class TrainingEquipment extends Equipment {

	private TrainingItem item;
	
    public TrainingEquipment() {
    	setitem();
	}
	
	/**m,
	 * This holds the data of the training items
	 * Item value and the state the items affects
	 */
	public enum TrainingItem {
	    GAMING_CHAIR(1, "stamina", "Gaming Chair"),
	    GAMING_KEYBOARD(1, "reactionTime", "Gaming Keyboard"),
	    GAMING_MOUSE(1, "intelligence", "Gaming Mouse"),
	    GAMING_HEADSET(1, "eyeSight", "Gaming Headset"),
	    HIGH_PERFORMANCE_MONITOR(1, "reactionTime", "High Refresh Rate Monitor");

	    private final int value;
	    private final String affectedStat;
	    private final String name;

	    TrainingItem(int value, String affectedStat, String name) {
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

        // Get the values of the TrainingItem enum
        TrainingItem[] trainingItems = TrainingItem.values();

        // Generate a random index within the range of values in IngestibleItems
        int randomItemIndex = random.nextInt(trainingItems.length);

        // Set the item to the random enum value
        this.item = trainingItems[randomItemIndex];
    	
    }
    
    public TrainingItem getItem() {
    	return item;
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
		super.description = String.format("The %s training equipment increases your athletes %s by %d points}", item.name, item.affectedStat, item.value );
	}


}
