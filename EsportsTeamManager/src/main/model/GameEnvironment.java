package main.model;

import main.exceptions.GameOverException;
import main.exceptions.GameOverException.Type;
import main.exceptions.RandomEventException;
import main.exceptions.RandomEventException.Event;

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
     * 
     * @throws GameOverException 	if all weeks have passed
     * @throws RandomEventException if random event occurs
     */
    public void advanceWeek() throws GameOverException, RandomEventException {
    	data.nextWeek();
    	data.getTeam().resetStaminaAll();
    	stadium.updateMatches();
    	market.updateMarket(false);
    	
    	RandomEvent randomEvent = new RandomEvent(data);
    	int result = randomEvent.triggerEvent();
    	switch (result) {	
    	case 1:
    		throw new RandomEventException(Event.ADD);
    	case 2:
    		throw new RandomEventException(Event.REMOVE);
    	case 3:
    		throw new RandomEventException(Event.STAT);
		default:
			break;
    	}    	
    	
    	// If team has insufficient players, check if there are any available athletes the player can afford, otherwise end game
    	if (!market.canPurchaseLegalTeam()) {
    		throw new GameOverException(Type.NO_TEAM_NO_MONEY);
    	}
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
