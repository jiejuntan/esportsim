package main;

/**
 * Stores state of the game and methods to play it
 */
public final class GameEnvironment {
    /**
     * 
     */
    private int seasonDuration;
    /**
     * 
     */
    private int currentWeek;
    /**
     * 
     */
    private Difficulty difficulty;
    /**
     * 
     */
    private int money;
    /**
     * 
     */
    private Team team;
    /**
     * 
     */
    private Club club;
    /**
     * 
     */
    private Stadium stadium;
    /**
     * 
     */
    private Market market;
    
    /**
     * 
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
	    	switch (this.difficulty) {
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
    	if (this.team == null) {
    		return "-";
    	} else {
    		return this.team.getName();
    	}
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
    	return this.seasonDuration == 0 ? "-" : String.valueOf(this.seasonDuration) + " weeks";
	}
    
    /**
     * Gets season duration
     * @return season duration as int
     */
    public int getSeasonDuration() {
		return seasonDuration;
	}
    
	public boolean setSeasonDuration(int duration) {
		if (isValidDuration(duration)) {
			this.seasonDuration = duration;
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isValidDuration(int duration) {
		return duration >= 5 && duration <= 15;
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
