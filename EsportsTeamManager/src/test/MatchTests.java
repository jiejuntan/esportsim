package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.exceptions.TeamLimitException;
import main.model.Athlete;
import main.model.GameData;
import main.model.Match;
import main.model.Team;
import main.model.Team.Role;

class MatchTests {

    private Match match;
    private Team homeTeam;
    private Team opponentTeam;
    private GameData gameData;

    @BeforeEach
    void setUp() {
    	gameData = new GameData();
        homeTeam = new Team();
        opponentTeam = new Team();
        match = new Match(gameData, opponentTeam);
        
        // Add athletes to the home team
        for (int i = 0; i < Team.MAIN_LIMIT; i++) {
            try {
            	if(i< 2) {
            		 homeTeam.addAthlete(new Athlete(gameData.getCurrentWeek()), Role.OFFENSE);
            	} else if (i >= 2 && i < 4) {
            		 homeTeam.addAthlete(new Athlete(gameData.getCurrentWeek()), Role.TANK);
            	} else {
            		 homeTeam.addAthlete(new Athlete(gameData.getCurrentWeek()), Role.SUPPORT);
            	}
               
            } catch (TeamLimitException e) {
                e.printStackTrace();
            }
        }
        // Add athletes to the opponent team
        for (int i = 0; i < Team.MAIN_LIMIT; i++) {
            try {
            if(i< 2) {
            	opponentTeam.addAthlete(new Athlete(gameData.getCurrentWeek()), Role.OFFENSE);
           	} else if (i >= 2 && i < 4) {
           		opponentTeam.addAthlete(new Athlete(gameData.getCurrentWeek()), Role.TANK);
           	} else {
           		opponentTeam.addAthlete(new Athlete(gameData.getCurrentWeek()), Role.SUPPORT);
           	}
              
            } catch (TeamLimitException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void testCreateIngameCharacters() {
        match.createIngameCharacters();
<<<<<<< HEAD
        assertEquals(Team.MAIN_LIMIT, match.getHomeTeam().size());
=======
        assertEquals(Team.MAIN_LIMIT, match.getPlayerTeam().size());
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
        assertEquals(Team.MAIN_LIMIT, match.getOpponentTeam().size());
    }

    @Test
    void testSimulateRound() {

        match.createIngameCharacters();
        match.simulateRound();
        assertTrue(match.getRound() > 0);
    }

    @Test
    void testIsMatchOver() {

        match.createIngameCharacters();
        match.simulateRound();
        match.simulateRound();
        match.simulateRound();
        assertNotEquals(-1, match.isMatchOver());
    }

}
