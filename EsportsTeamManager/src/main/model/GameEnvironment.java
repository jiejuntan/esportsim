package main.model;

import main.exceptions.GameOverException;
import main.exceptions.GameOverException.Type;

/**
 * Model access point
 */
public final class GameEnvironment {
	
	/**
	 * GameData instance
	 */
	private GameData data;
    
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
    	this.stadium = new Stadium(data);
    	this.market = new Market(data);
    }
    
    /**
     * Advances to next week in season and calls update methods.
     * @throws GameOverException if all weeks have passed
     */
    public void advanceWeek() throws GameOverException {
    	data.nextWeek();
    	data.getTeam().resetStaminaAll();
    	stadium.updateMatches();
    	market.updateMarket(false);
    	
    	// IMPLEMENT RANDOM EVENTS THROW EXCEPTION IF OCCURS
    	
    	// If team has insufficient players, check if there are any available athletes the player can afford, otherwise end game
    	if (data.getTeam().getMainTeamSize() < Team.MAIN_LIMIT) {
    		if (market.getCheapestAthlete() == 0 || market.getCheapestAthlete() > data.getMoney()) {
    			throw new GameOverException(Type.NO_TEAM_NO_MONEY);
    		}
    	}
    	
    	//testing stamina and removing athletes
//    	if (data.getCurrentWeek() % 2 == 1) {
//    		data.getTeam().dropStaminaAll();
//    		data.getTeam().removeAthlete(data.getTeam().getMainMembers().get(0));
//    	}
    	
    }
    
    /** 
     * @return the data
     */
    public GameData getData() {
    	return data;
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
