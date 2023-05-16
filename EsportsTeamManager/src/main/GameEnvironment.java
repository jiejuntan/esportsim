package main;

/**
 * Model access point
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
     * Construct game environment.
     */
    public GameEnvironment() {
    	this.data = new GameData();
//    	this.club = new Club(data);
//    	this.stadium = new Stadium(data);
    	this.market = new Market(data);
    }
    
    /** 
     * @return the data
     */
    public GameData getData() {
    	return data;
    }

	/**
	 * @return the club
	 */
	public Club getClub() {
		return club;
	}

	/**
	 * @return the stadium
	 */
	public Stadium getStadium() {
		return stadium;
	}

	/**
	 * @return the market
	 */
	public Market getMarket() {
		return market;
	}

}
