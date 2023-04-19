package main;

import java.util.List;

/**
 * Stores state of the game and methods to play it
 */
public final class GameEnvironment {
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
     * Stadium instance
     */
    private Stadium stadium;
    /**
     * Market instance
     */
    private Market market;
    
    /**
     * Enum for difficulty setting
     */
    public enum Difficulty {
    	EASY,
    	HARD
    }    
    
    /** 
     * Gets difficulty
     * @return difficulty as string or "-"
     */
    public String getDifficultyString() {
    	try {
	    	switch (getDifficulty()) {
	    	case EASY:
	    		return "Easy";
	    	case HARD:
	    		return "Not easy";
	    	default:
	    		return "-";
	    	} 
    	} catch (NullPointerException e) {
    		return "-";
    	}
    }
    
    /**
     * Gets difficulty
     * @return	difficulty as enum Difficulty
     */
    public Difficulty getDifficulty() {
		return difficulty;
	}
    
    /**
     * Sets difficulty property
     * @param difficulty	enum for difficulty
     */
    public void setDifficulty(Difficulty difficulty) {
    	this.difficulty = difficulty;
    }
    
    /**
     * Gets team name
     * @return team name as string or "-"
     */
    public String getTeamName() {
    	Team team = getTeam();
    	
    	return team == null ? "-" : team.getName();
    }
    
    /**
     * Creates a team with proposed name and hand
     * @param name	proposed name of team
     * @return		<CODE>true</CODE> if team creation was successful
     */
    public boolean createTeam(String name) {
    	try {
    		setTeam(new Team(name));
    		return true;
    	} catch (IllegalArgumentException e) {
    		return false;
    	}
    }
    
    /**
     * Gets season duration
     * @return season duration as formatted string
     */
    public String getSeasonDurationString() {
    	int duration = getSeasonDuration();
    	return duration == 0 ? "-" : String.valueOf(duration) + " weeks";
	}
    
    /**
     * Gets season duration
     * @return season duration as int
     */
    public int getSeasonDuration() {
		return seasonDuration;
	}
    
    /**
     * Sets season duration
     * @param duration	duration of season
     * @return			<CODE>true</CODE> if successful
     */
	public boolean setSeasonDuration(int duration) {
		if (isValidDuration(duration)) {
			this.seasonDuration = duration;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if duration is valid
	 * @param duration	duration of season
	 * @return			<CODE>true</CODE> if valid
	 */
	private boolean isValidDuration(int duration) {
		return duration >= 5 && duration <= 15;
	}
	
	public boolean readyToDraft() {
		return getDifficulty() != null && getTeam() != null && getSeasonDuration() != 0;
	}
	
	public void assignStartingMoney() {
		setMoney(500);
	}
	
	public List<Athlete> purchasePlayers() {
		setMarket(new Market(getMoney()));
		return getMarket().viewStoresAthlete();	
	}
	
    public void setupGame() {}
    
    
	public void playGame() {}
	

    public void finishGame() {}
    
    
    /********** Simple Getters & Setters **********/
	public int getCurrentWeek() {
		return currentWeek;
	}


	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}

	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}


	public Stadium getStadium() {
		return stadium;
	}


	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}


	public Market getMarket() {
		return market;
	}


	public void setMarket(Market market) {
		this.market = market;
	}

	/********** Simple Getters & Setters **********/

}
