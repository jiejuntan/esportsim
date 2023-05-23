package main.model;

import main.exceptions.GameOverException;
import main.exceptions.GameOverException.Type;

/**
 * Data transfer object
 * 
 * @author Jiejun Tan
 *
 */
public final class GameData {
	
	/**
     * Enum for difficulty setting
     */
    public enum Difficulty {
    	/**
    	 *  Easy setting
    	 */
    	EASY("Easy", 5000, 1500, 1),
    	/**
    	 *  Hard setting
    	 */
    	HARD("Hard", 5000, 1000, 2);
    	
    	/**
    	 *  Difficulty as string
    	 */
    	public final String asString;
    	/**
    	 *  Starting amount of money
    	 */
    	public final int startingMoney;
    	/**
    	 *  Prize money for winning
    	 */
    	public final int prizeMoney;
    	/**
    	 *  Difficulty modifier for prices
    	 */
    	public final int modifier;
    	
    	/**
    	 *  Constructor for difficulty enum
    	 * @param asString		difficulty string
    	 * @param startingMoney	amount of starting money
    	 * @param prizeMoney	amount of prize money for winning
    	 * @param modifier		modifier for difficulty
    	 */
		private Difficulty(String asString, int startingMoney, int prizeMoney, int modifier) {
    		this.asString = asString;
    		this.startingMoney = startingMoney;
    		this.prizeMoney = prizeMoney;
    		this.modifier = modifier;
    	}
		
    	/**
		 * @return the Difficulty modifier
		 */
		public int getModifier() {
			return modifier;
		}
    } 
    
	/**
     * Difficulty setting
     */
    private Difficulty difficulty;
    /**
     * Season duration setting
     */
    private int seasonDuration;
    /**
     * Current week of season
     */
    private int currentWeek;
    /**
     * Amount of money available
     */
    private int money;
    /**
     * Team instance
     */
    private Team team;
    
    /**
     * Club instance
     */
    private Club club;
    
    /** 
     * Boolean for whether a match has been played that week
     */
    private boolean hasPlayed;
    
   

	/**
     * Constructor for GameData
     */
    public GameData() {
    	this.difficulty = Difficulty.EASY;
    	this.seasonDuration = 10;
    	this.currentWeek = 0;
    	this.money = 0;
    	this.team = new Team();
    	this.club = new Club();
    }
    
    /**
     * Gets difficulty
     * 
     * @return	difficulty setting
     */
    public Difficulty getDifficulty() {
		return this.difficulty;
	}
    
    /**
     * Sets difficulty and allocates starting money if starting a new game
     * 
     * @param difficulty	difficulty setting
     */
    public void setDifficulty(Difficulty difficulty) {
    	this.difficulty = difficulty;
    	if (currentWeek == 0) {
        	setStartingMoney(difficulty);
    	}
    }
	
    /**
     * Gets season duration
     * 
     * @return season duration
     */
    public int getSeasonDuration() {
    	return this.seasonDuration;
	}    

    /**
     * Sets season duration if valid
     * 
     * @param duration					season duration to set
     * @throws IllegalArgumentException	if duration is invalid
     */
	public void setSeasonDuration(int duration) throws IllegalArgumentException {
		if (isValidDuration(duration)) {
			this.seasonDuration = duration;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Checks if duration is valid
	 * 
	 * @param duration	season duration to validate
	 * @return			<CODE>true</CODE> if valid
	 */
	private boolean isValidDuration(int duration) {
		return duration >= 5 && duration <= 15;
	}
	
	/**
     * Gets current week
     * 
     * @return current week
     */
	public int getCurrentWeek() {
		return currentWeek;
	}
	

	/**
	 * Moves current week forward.
	 * 
	 * @throws GameOverException if all weeks have passed
	 */
	public void nextWeek() throws GameOverException {
		if (currentWeek < seasonDuration) {
			currentWeek++;
			hasPlayed = false;
		} else {
			throw new GameOverException(Type.FINISHED);
		}
	}
	
	/**
	 * Gets money available
	 * 
	 * @return money available
	 */
	public int getMoney() {
		return this.money;
	}
	
	/**
	 * Sets starting money based on difficulty
	 * 
	 * @param difficulty	difficulty setting
	 */
	public void setStartingMoney(Difficulty difficulty) {
		this.money = difficulty.startingMoney;
	}
	
	/**
	 * Increases money
	 * 
	 * @param amount					amount to increase
	 * @throws IllegalArgumentException	if amount is negative
	 */
	public void incrementMoney(int amount) throws IllegalArgumentException {
		if (amount > 0) {
			this.money += amount;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Deducts money
	 * 
	 * @param amount					amount to deduct
	 * @throws IllegalArgumentException	if amount is negative or player has insufficient money
	 */
	public void deductMoney(int amount) throws IllegalArgumentException {
		if (amount > 0 && amount <= this.money) {
			this.money -= amount;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @return the hasPlayed
	 */
	public boolean hasPlayed() {
		return hasPlayed;
	}

	/**
	 * @param hasPlayed the hasPlayed to set
	 */
	public void setHasPlayed(boolean hasPlayed) {
		this.hasPlayed = hasPlayed;
	}

    /**
     * Gets team
     * 
     * @return	team
     */
    public Team getTeam() {
		return team;
	}

	/**
	 * @return the club
	 */
	public Club getClub() {
		return club;
	}

	/**
	 * Calculates purchase price with Purchasable object
	 * 
	 * @param market TODO
	 * @param purchase	Purchasable object
	 * @return			purchase price
	 */
	public int getPurchasePrice(Market market, Purchasable purchase) {
		return purchase.getBasePrice() * getDifficulty().modifier;
	}
   
}
