package main;

import java.util.List;

import main.GameData.Difficulty;

/**
 * Stores game state and UI methods
 */
public final class GameEnvironment {
	
	/**
	 * GameData instance
	 */
	private GameData data;
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
     * Constructor method to initialize data
     */
    public GameEnvironment() {
    	this.data = new GameData();
//    	this.club = new Club(data);
//    	this.stadium = new Stadium(data);
    	this.market = new Market(data);
    }
    
    /********** UI Methods **********/
    
    /** 
     * Formats a list of athletes into a string
     * 
     * @param athletes	list of athletes
     * @return			string formatted list of athletes
     */
    public String formatAthleteList(List<Athlete> athletes) {
    	String result = "";
    	for (int i=0; i < athletes.size(); i++) {
    		result += String.format("%s. %s\n", i + 1, athletes.get(i));
    	}
    	return result;
    }
    
    /**
     * Formats list of purchasable athletes into a string
     * 
     * @return	string formatted list of purchasable athletes
     */
	public String purchasableAthletes() {
		return formatAthleteList(getMarket().viewStoresAthlete());	
	}
	
	public String currentAthletes() {
		String result = formatAthleteList(data.getTeam().getTeamMembers());
		return result == "" ? "Your team is empty!\n" : result;
	}
	
	public void purchaseAthlete(int i) throws IllegalArgumentException {
		try {
			getMarket().draftAthlete(i);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
	/********** UI Methods **********/
	
	
    /********** Simple Getters & Setters **********/
    
    /** 
     * Gets difficulty
     * 
     * @return difficulty as string
     */
    public String getDifficultyString() {
    	return this.data.getDifficulty().asString;
    }
    
    /**
     * Wrapper for GameData method setDifficulty
     * 
     * @param difficulty	difficulty setting
     */
    public void setDifficulty(Difficulty difficulty) {
    	this.data.setDifficulty(difficulty);
    }
    
    /**
     * Wrapper for GameData method getSeasonDuration
     * 
     * @return season duration
     */
    public int getSeasonDuration() {
    	return this.data.getSeasonDuration();
	}
    
    /**
     * Wrapper for GameData method setSeasonDuration
     * 
     * @param duration					season duration to set
     * @throws IllegalArgumentException	if duration is invalid
     */
	public void setSeasonDuration(int duration) throws IllegalArgumentException{
		try {
			this.data.setSeasonDuration(duration);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
    /**
     * Wrapper for GameData method getCurrentWeek
     * 
     * @return current week
     */
	public int getCurrentWeek() {
		return this.data.getCurrentWeek();
	}
	
	/**
	 * Wrapper for GameData method getMoney
	 * 
	 * @return money available
	 */
	public int getMoney() {
		return this.data.getMoney();
	}

    /**
     * Wrapper for Team method getName
     * 
     * @return team name
     */
    public String getTeamName() {
    	return this.data.getTeam().getName();
    }
    
    /**
     * Wrapper for Team method setTeamName
     * 
     * @param name						name to set
     * @throws IllegalArgumentException	if name is invalid
     */
    
    public void setTeamName(String name) throws IllegalArgumentException {
    	try {
    		this.data.getTeam().setTeamName(name);
    	} catch (IllegalArgumentException e) {
    		throw e;
    	}
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
