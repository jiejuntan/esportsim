package main;

public class GameData {
	/**
     * Enum for difficulty setting
     */
    public enum Difficulty {
    	EASY("Easy", 1000),
    	HARD("Hard", 500);
    	
    	public final String asString;
    	public final int startingMoney;
    	
    	private Difficulty(String asString, int startingMoney) {
    		this.asString = asString;
    		this.startingMoney = startingMoney;
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
     * Constructor for GameData
     */
    public GameData() {
    	this.difficulty = Difficulty.EASY;
    	this.seasonDuration = 10;
    	this.currentWeek = 0;
    	this.money = Difficulty.EASY.startingMoney;
    	this.team = new Team();
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
     * Sets difficulty
     * 
     * @param difficulty	difficulty setting
     */
    public void setDifficulty(Difficulty difficulty) {
    	this.difficulty = difficulty;
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
		return this.currentWeek;
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
     * Gets team
     * 
     * @return	team
     */
    public Team getTeam() {
		return this.team;
	}
    
}
