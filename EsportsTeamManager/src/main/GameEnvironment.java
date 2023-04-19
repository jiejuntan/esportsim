package main;

/**
 * Stores state of the game and methods to play it
 */
public final class GameEnvironment {
	/**
	 * Regex pattern for team name validation
	 */
	private static final String VALID_TEAMNAME_PATTERN = "[ a-zA-Z0-9]{3,15}";
	
    /**
     * Name of team
     */
    private String teamName;
    
    /**
     * 
     */
    private int seasonDuration;
    /**
     * 
     */
    private int currentWeek;
<<<<<<< HEAD
    /**
     * 
     */
    private Difficulty difficulty;
    /**
     * 
     */
=======
    private Difficulty difficulty;
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
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
<<<<<<< HEAD
    	NOT_EASY
=======
    	MEDIUM,
    	HARD
    }    
    
    public GameEnvironment(Difficulty difficulty, String teamName) {
    	this.teamName = teamName;
        this.difficulty = difficulty;
        this.seasonDuration = 8;
        this.currentWeek = 1;
        this.money = 0;
        
        this.team = new Team();
    	this.club = new Club();
    	this.stadium = new Stadium();
    	this.market = new Market();
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
    }
<<<<<<< HEAD
    
    /** 
     * Gets difficulty as a string
     * @return selected difficulty or "-"
     */
    public String getDifficultyString() {
    	try {
	    	switch (this.difficulty) {
	    	case EASY:
	    		return "Easy";
	    	case NOT_EASY:
	    		return "Not easy";
	    	default:
	    		return "-";
	    	} 
    	} catch (NullPointerException e) {
    		return "-";
    	}
    }
    
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
    	return this.teamName == null ? "-" : this.teamName;
    }
    
    /**
     * Checks a string entered and sets it as the team name if valid
     * 
     * @param name	team name to set
     * @return		<CODE>true</CODE> if team name was set successfully
     */
    public boolean setTeamName(String name) {
    	if (isValidTeamName(name)) {
    		this.teamName = name;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Checks if team name is between 3-15 characters with no special characters.
     * 
     * @param name	team name to be validated
     * @return 			<CODE>true</CODE> if team name is valid
     */
    private boolean isValidTeamName(String name) {
    	return name.matches(GameEnvironment.VALID_TEAMNAME_PATTERN);
    }
    
    /**
     * Gets season duration
     * @return season duration as string
     */
    public String getSeasonDurationString() {
    	return this.seasonDuration == 0 ? "-" : String.valueOf(this.seasonDuration) + " weeks";
	}
    
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
=======


    public void setupGame() {}
    
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
    
	public void playGame() {}
	

    public void finishGame() {}
    
    
    /********** Simple Getters & Setters **********/
<<<<<<< HEAD
	public int getCurrentWeek() {
		return currentWeek;
	}


	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}

	
=======

    public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public int getSeasonDuration() {
		return seasonDuration;
	}


	public void setSeasonDuration(int seasonDuration) {
		this.seasonDuration = seasonDuration;
	}


	public int getCurrentWeek() {
		return currentWeek;
	}


	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}


	public Difficulty getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}


>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
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
