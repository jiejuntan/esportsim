package main.model;

import java.util.Random;

import main.gui.GUIConstants;

/**
 * Represents the characters in the game.
 * 
 * @author Blake and Jun
 *
 */
public final class Equipment extends Purchasable { 

private TrainingItem equipment;
	
    /**
     * When the Equipment class is initialized, the class chooses a random piece of equpiment to be stored
     */
    public Equipment() {
        Random random = new Random();

        // Get the values of the TrainingItem enum
        TrainingItem[] trainingItems = TrainingItem.values();

        // Generate a random index within the range of values in IngestibleItems
        int randomItemIndex = random.nextInt(trainingItems.length);

        // Set the item to the random enum value
        this.equipment = trainingItems[randomItemIndex];
        this.portraitPath = GUIConstants.PORTRAIT_PLACEHOLDER;
	}
	
	/**
	 * This holds the data of the training items
	 * Item value and the skill the items affects
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
	     * Returns the name of item
	     * 
	     * @return <CODE>String</CODE> item name
	     */
	    public String getName() {
	        return name;
	    }
	    
	    /**
	     * Returns the amount of skill value that the Training Item affects
	     * 
	     * @return <CODE>int</CODE> Ingestible stat value
	     */
	    public int getValue() {
	        return value;
	    }
	    
	    /**
	     * Returns the skill which the Training Item affects
	     * 
	     * @return <CODE>String</CODE> Stat which the item affects
	     */
	    public String getAffectedStat() {
	        return affectedStat;
	    }
	}
	

    /**
     * Returns the training equipment that is currently in the object
     * 
     * @return <CODE>TrainingItem</CODE> training equipment
     */
    public TrainingItem getEquipment() {
    	return equipment;
    }
        
    
	/**
	 * Calculates Base Price of the equipment
	 * Price = Item Stat * 50
	 * 
	 * @return <CODE>int</CODE> Equipment Price
	 */
	@Override
	public int getBasePrice() {
		return equipment.value * 50;
	}

	/**
	 * Sets the Equipments Description
	 */
	@Override
	public void setDescription() {
		super.description = String.format("The %s training equipment increases your athletes %s by %d points}", 
										equipment.name, 
										equipment.affectedStat, 
										equipment.value );
	}
	

//	/**
//	 * This holds the data of the training items
//	 * Item value and the state the items affects
//	 */
//	public enum IngestibleItem {
//	    ENERGY_DRINK(1, "stamina", "Energy Drink"),
//	    FOCUS_BOOSTER(1, "intelligence", "Focus Booster"),
//	    VITAMIN_SUPPLEMENT(1, "eyeSight", "Vitamin Supplement"),
//	    HEALTHY_SNACK(1, "stamina", "Healthy Snack"),
//	    RECOVERY_SHAKE(1, "reactionTime", "Recovery Snack");
//
//	    private final int value;
//	    private final String affectedStat;
//	    private final String name;
//
//
//	    IngestibleItem(int value, String affectedStat, String name) {
//	        this.value = value;
//	        this.affectedStat = affectedStat;
//	        this.name = name;
//	    }
//
//	    /**
//	     * @return Ingestible stat value
//	     */
//	    public int getValue() {
//	        return value;
//	    }
//
//	    /**
//	     * @return Stat which the item affects
//	     */
//	    public String getAffectedStat() {
//	        return affectedStat;
//	    }
//	}
//    

}
