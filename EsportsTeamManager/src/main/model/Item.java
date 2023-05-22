package main.model;

import java.util.Random;

import main.gui.GUIConstants;

/**
 * Represents the items in the game.
 * 
 * @author Blake and Jun
 *
 */
public final class Item extends Purchasable { 

private TrainingItem equipment;
	
    /**
     * Construct a random item
     */
    public Item() {
        Random random = new Random();
        TrainingItem[] trainingItems = TrainingItem.values();
        int randomItemIndex = random.nextInt(trainingItems.length);
        this.equipment = trainingItems[randomItemIndex];
        this.portraitPath = GUIConstants.ITEM_PLACEHOLDER;
	}
	
	/**
	 * This holds the data of the training items
	 */
	public enum TrainingItem {
	    GAMING_CHAIR("Gaming Chair", "reactionTime", 1, "intelligence", -5),
	    GAMING_KEYBOARD("Gaming Keyboard", "reactionTime", 1, "intelligence", -5),
	    GAMING_MOUSE("Gaming Mouse", "intelligence", 1, "intelligence", -5),
	    GAMING_HEADSET("Gaming Headset", "eyeSight", 1, "intelligence", -5),
	    HIGH_PERFORMANCE_MONITOR("High Refresh Rate Monitor", "reactionTime", 1, "intelligence", -5),
	    ENERGY_DRINK("Energy Drink", "stamina", 1, "intelligence", -5),
	    FOCUS_BOOSTER("Focus Booster", "intelligence", 1, "intelligence", -5),
	    VITAMIN_SUPPLEMENT("Vitamin Supplement", "eyeSight", 1, "intelligence", -5),
	    HEALTHY_SNACK("Healthy Snack", "stamina", 1, "intelligence", -5),
	    RECOVERY_SHAKE("Recovery Snack", "reactionTime", 1, "intelligence", -5);

		private final String name;
	    private final String positiveStat;
	    private final int positiveValue;
	    private final String negativeStat;
	    private final int negativeValue;

	    TrainingItem(String name, String positiveStat, int positiveValue, String negativeStat, int negativeValue) {
	    	this.name = name;
	        this.positiveStat = positiveStat;
	    	this.positiveValue = positiveValue;
	        this.negativeStat = negativeStat;
	        this.negativeValue = negativeValue;
	    }
	    
	    /**
	     * @return item name
	     */
	    public String getName() {
	        return name;
	    }

		/**
		 * @return the positiveStat
		 */
		public String getPositiveStat() {
			return positiveStat;
		}

		/**
		 * @return the positiveValue
		 */
		public int getPositiveValue() {
			return positiveValue;
		}

		/**
		 * @return the negativeStat
		 */
		public String getNegativeStat() {
			return negativeStat;
		}

		/**
		 * @return the negativeValue
		 */
		public int getNegativeValue() {
			return negativeValue;
		}
	}
	

    /**
     * Returns the item
     * 
     * @return <CODE>TrainingItem</CODE> item
     */
    public TrainingItem getItem() {
    	return equipment;
    }
        
	/**
	 * Calculates Base Price of the equipment
	 * 
	 * @return <CODE>int</CODE> base price
	 */
	@Override
	public int getBasePrice() {
		return (equipment.positiveValue + equipment.negativeValue) * 5;
	}

	/**
	 * Sets the Equipments Description
	 */
	@Override
	public void setDescription() {
		super.description = String.format("The %s training equipment increases your athletes %s by %d points}", 
										equipment.name, 
										equipment.positiveStat, 
										equipment.positiveValue );
	}

}
