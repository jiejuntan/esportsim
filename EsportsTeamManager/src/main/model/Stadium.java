package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates weekly matches to play
 * 
 * @author Blake and Jun
 *
 */
public final class Stadium {
	
	/**
	 * List of matches
	 */
    private List<Team> matches;
    /**
     * Data transfer object
     */
    private GameData data;
    
	/**
	 * Maximum number of matches to display per week
	 */
	private static final int MATCH_LIMIT = 5;
    
	/**
	 * Constructor for stadium
	 * 
	 * @param data data transfer object
	 */
    public Stadium(GameData data) {
    	this.data = data;
    	this.matches = new ArrayList<Team>();
    }

	/**
     * Generates matches to play
     */
    public void generateMatches() {
    	for (int opponentCount = 0; opponentCount < MATCH_LIMIT; opponentCount++) {
    		matches.add(new Team(data.getCurrentWeek()));
    	}
    }
    
    /**
     * Calculates a difficulty indicator for each match
     * 
     * @param opponentTeam	match opponent
     * @return				difficulty string
     */
    public String getDifficulty(Team opponentTeam) {
    	int playerTeamLevel = data.getTeam().calculateTeamlevel();
    	int opponentTeamLevel = opponentTeam.calculateTeamlevel();
    	
    	double ratio = playerTeamLevel / opponentTeamLevel;
    	return ratio >= 1 ? "Normal" : "Hard";
    }

	/**
	 * @return the matches
	 */
	public List<Team> getMatches() {
		return matches;
	}
	
	/**
	 * Clears match list to be repopulated every week
	 */
	private void clearMatches() {
		matches.clear();
	}
	
	/**
	 * Generates new matches scaling with current week
	 */
	public void updateMatches() {
		clearMatches();
		generateMatches();
	}
    
}
