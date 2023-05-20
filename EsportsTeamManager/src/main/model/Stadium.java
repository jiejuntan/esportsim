package main.model;

import java.util.ArrayList;
import java.util.List;

import main.model.GameData.Difficulty;

public class Stadium {
	
    private List<Team> matches;
	/**
	 * Maximum number of main members
	 */
	private static final int OPPONENT_LIMIT = 5;
    
    public Stadium(Difficulty difficulty) {
    	matches = new ArrayList<Team>();
    	generateMatches(difficulty);
    }
    
    
    /**
     * The player should be able to choose a match to play.
     * i. Your team can partake in a match only once.
     * ii. If your team is not full you cannot participate in a match.
     * iii. Ifallofaplayer’sathletesareinjuredtheycannolongercompete.
     * iv. If all of a player’s athletes are injured during a match they lose the match and do not receive any money or points
     * v. If a player wins a match (by having the highest score) they are rewarded with money and points
     */

    /**
     * Generantes 5 opponent teams to verse and add them to the matches list
     * 
     * @param difficulty
     */
    public void generateMatches(Difficulty difficulty) {
    	
    	for (int opponentCount = 0; opponentCount < OPPONENT_LIMIT; opponentCount++) {
    		Team opponent = new Team(difficulty.getModifier());
    		matches.add(opponent);
    	}
    }


	/**
	 * @return the matches
	 */
	public List<Team> getMatches() {
		return matches;
	}
    

}
