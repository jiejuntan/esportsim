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

	/**
	 * Item enum representing item
	 */
	private TrainingItem equipment;
	
	/**
	 *  Reaction time as a constant string
	 */
	public static final String REACTION_TIME = "reactionTime";
	/**
	 *  Eyesight as a constant string
	 */
	public static final String EYESIGHT = "eyeSight";
	/**
	 *  Intelligence as a constant string
	 */
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
		/**
		 *  Vitamins details
		 */
		VITAMINS("\"Vitamins\"", REACTION_TIME, 15, INTELLIGENCE, -5, "vitamins.png"),
		/**
		 *  Gaming headset details
		 */
		GAMING_HEADSET("Gaming Headset", EYESIGHT, 15, INTELLIGENCE, -5, "headset.png"),
		/**
		 *  Gaming chair details
		 */
		GAMING_CHAIR("Gaming Chair", EYESIGHT, 15, REACTION_TIME, -5, "chair.png"),
		/**
		 *  Healthy snack details
		 */
		HEALTHY_SNACK("Healthy Snack", INTELLIGENCE, 15, REACTION_TIME, -5, "snack.png"),
		/**
		 *  Performance monitor details
		 */
		PERFORMANCE_MONITOR("Performance Monitor", REACTION_TIME, 15, EYESIGHT, -5, "monitor.png"),
		/**
		 *  Gaming keyboard details
		 */
		GAMING_KEYBOARD("Gaming Keyboard", INTELLIGENCE, 15, EYESIGHT, -5, "keyboard.png"),;
		
		/**
		 *  Name of item
		 */
		private final String name;
		/**
		 *  Stat item increases
		 */
	    private final String positiveStat;
	    /**
	     *  Value of increase
	     */
	    private final int positiveValue;
	    /**
	     *  Stat item decreases
	     */
	    private final String negativeStat;
	    /**
	     *  Value of decrease
	     */
	    private final int negativeValue;
	    /**
	     *  Path of item image
	     */
	    private final String imgPath;
	    
	    /**
	     *  Constructor for item enums
	     * @param name			item name as string
	     * @param positiveStat	stat the item increases
	     * @param positiveValue	value of increase
	     * @param negativeStat	stat the item decreases
	     * @param negativeValue	value of decrease
	     * @param imgPath		path of item image
	     */
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
     * @return item
     */
    public TrainingItem getItem() {
    	return equipment;
    }
        
	/**
	 * Calculates Base Price of the equipment
	 * 
	 * @return base price
	 */
	@Override
	public int getBasePrice() {
		return (equipment.positiveValue + equipment.negativeValue) * 5;
	}

}
