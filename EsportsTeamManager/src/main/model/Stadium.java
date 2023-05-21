package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.model.GameData.Difficulty;

public final class Stadium {
	
    private List<Team> matches;
    private Team opponent;
    private GameData gameData;
    
	/**
	 * Maximum number of main members
	 */
	private static final int OPPONENT_LIMIT = 5;
    
    public Stadium(GameData gameData) {
    	this.gameData = gameData;
    	this.matches = new ArrayList<Team>();
    	generateMatches(gameData.getDifficulty());
    	this.opponent = new Team();
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
    	Random random = new Random();
    	
    	//Increases the opponent team difficulty based on the week
    	int randomSkillIncrease = random.nextInt(0, 2 + gameData.getCurrentWeek());
    	
    	for (int opponentCount = 0; opponentCount < OPPONENT_LIMIT; opponentCount++) {
    		Team opponent = new Team(difficulty.getModifier() + randomSkillIncrease);
    		matches.add(opponent);
    	}
    }
    
    public String getDifficulty(Team opponentTeam) {
    	int playerTeamLevel = gameData.getTeam().calculateTeamlevel();
    	int opponentTeamLevel = opponentTeam.calculateTeamlevel();
    	
    	System.out.println(playerTeamLevel);
    	
    	int levelDifference = Math.abs(playerTeamLevel - opponentTeamLevel);
    	
    	
    	if (levelDifference < 5) {
    		return "Easy";
    	} else if (levelDifference > 5 && levelDifference < 15) {
    		return "Medium";
    	} else {
    		return "Hard";
    	}
    }


	/**
	 * @return the matches
	 */
	public List<Team> getMatches() {
		return matches;
	}
	
	/**
	 * Return where an opponent has been selected
	 * @return <CODE>boolean</CODE> 
	 */
	public boolean isOpponentSelected() {
		return opponent.isTeamFull();
	}



    

}
