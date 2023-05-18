package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.GameData;
import main.model.Match;
import main.model.Team;

class MatchTests {

	 private Match match;
	    private Team homeTeam;
	    private Team opponentTeam;
	    private GameData gameData;

	    @BeforeEach
	    void setUp() {
	        homeTeam = new Team();

	        opponentTeam = new Team();
	        
	        gameData = new GameData();
	        match = new Match(gameData, opponentTeam);
	    }
	    
	    @Test
	    void playGame() {
	    	match.startMatch();
	    	System.out.println(match.getRoundResults());
	    	
	    	assertTrue(match.getOutcome() == 1 || match.getOutcome() == 0);
	    	
	    }



	    @Test
	    void createIngameCharacters() {
	        // Checks if the ingame Characters got created
	        assertFalse(match.getHomeTeam().isEmpty());
	        assertFalse(match.getOpponentTeam().isEmpty());
	    }

	    @Test
	    void getTeamHealth() {
	        int homeTeamHealth = match.getTeamHealth(match.getHomeTeam());
	        int opponentTeamHealth = match.getTeamHealth(match.getOpponentTeam());

	        // Check if the health of the team is correct
	        assertTrue(homeTeamHealth > 0);
	        assertTrue(opponentTeamHealth > 0);
	    }

}
