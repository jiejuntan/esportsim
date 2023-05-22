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
	        homeTeam = new Team(3);
	        opponentTeam = new Team(3);
	        
	        gameData = new GameData();
	        gameData.setTeam(homeTeam);
	        match = new Match(gameData, opponentTeam);
	    }
	    
	    @Test
	    void playGame() {
	    	int outcome = -1;
	    	do {
	    	match.simulateRound();
	    	outcome = match.getOutcome();
	    	System.out.println(match.getRoundResults());
	    	
	    	} while(outcome == -1);
	    	
	    	assertTrue(outcome == 1 || outcome == 0);
	    	
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
