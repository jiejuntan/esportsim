package test;

import main.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StadiumTest {

    private GameData gameData;
    private Stadium stadium;
    
    @BeforeEach
    void setUp() {
        gameData = new GameData();
        stadium = new Stadium(gameData);
    }
    
    @Test
    void generateMatchesTest() {
        stadium.generateMatches();
        assertEquals(Stadium.MATCH_LIMIT, stadium.getMatches().size());
    }
    
    @Test
    void getDifficultyNormalTest() {
        Team opponentTeam = new Team(gameData.getCurrentWeek()); // Set up opponent Team
        String difficulty = stadium.getDifficulty(opponentTeam);
        assertTrue(difficulty.equals("Normal") || difficulty.equals("Hard"));
    }
    
    
}
