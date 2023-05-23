package test;

import main.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit tests for Stadium
 * 
 * @author blake
 *
 */
class StadiumTest {

    /**
     * GameData Object
     */
    private GameData gameData;
    /**
     * Stadium Object
     */
    private Stadium stadium;

    /**
     * Setup for Stadium Tests
     */
    @BeforeEach
    void setUp() {
        gameData = new GameData();
        stadium = new Stadium(gameData);
    }

    /**
     * Tests generation of matches
     */
    @Test
    void generateMatchesTest() {
        stadium.generateMatches();
        assertEquals(Stadium.MATCH_LIMIT, stadium.getMatches().size());
    }

    /**
     * Tests the get difficulty function
     */
    @Test
    void getDifficultyNormalTest() {
        Team opponentTeam = new Team(gameData.getCurrentWeek()); // Set up opponent Team
        String difficulty = stadium.getDifficulty(opponentTeam);
        assertTrue(difficulty.equals("Normal") || difficulty.equals("Hard"));
    }
    
    
}
