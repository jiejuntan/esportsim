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
	
	// Storing enum strings as constants to avoid typos
	public static final String REACTION_TIME = "reactionTime";
	public static final String EYESIGHT = "eyeSight";
	public static final String INTELLIGENCE = "intelligence";
	
    /**
     * Construct a random item
     */
    public Item() {
        Random random = new Random();
        TrainingItem[] trainingItems = TrainingItem.values();
        int randomItemIndex = random.nextInt(trainingItems.length);
        this.equipment = trainingItems[randomItemIndex];
        this.portraitPath = GUIConstants.ITEM_PATH + equipment.getImgPath();
	}
	
	/**
	 * This holds the data of the training items
	 */
	public enum TrainingItem {
		VITAMINS("\"Vitamins\"", REACTION_TIME, 15, INTELLIGENCE, -5, "vitamins.png"),
		GAMING_HEADSET("Gaming Headset", EYESIGHT, 15, INTELLIGENCE, -5, "headset.png"),

		GAMING_CHAIR("Gaming Chair", EYESIGHT, 15, REACTION_TIME, -5, "chair.png"),
		HEALTHY_SNACK("Healthy Snack", INTELLIGENCE, 15, REACTION_TIME, -5, "snack.png"),
		
		PERFORMANCE_MONITOR("Performance Monitor", REACTION_TIME, 15, EYESIGHT, -5, "monitor.png"),
		GAMING_KEYBOARD("Gaming Keyboard", INTELLIGENCE, 15, EYESIGHT, -5, "keyboard.png"),;
		
		private final String name;
	    private final String positiveStat;
	    private final int positiveValue;
	    private final String negativeStat;
	    private final int negativeValue;
	    private final String imgPath;

	    TrainingItem(String name, String positiveStat, int positiveValue, String negativeStat, int negativeValue, String imgPath) {
	    	this.name = name;
	        this.positiveStat = positiveStat;
	    	this.positiveValue = positiveValue;
	        this.negativeStat = negativeStat;
	        this.negativeValue = negativeValue;
	        this.imgPath = imgPath;
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

		/**
		 * @return the imgPath
		 */
		public String getImgPath() {
			return imgPath;
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

}
