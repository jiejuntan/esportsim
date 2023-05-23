package test;

import main.model.GameData;
import main.model.GameData.Difficulty;
import main.model.Team;
import main.model.Club;
import main.exceptions.GameOverException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit tests for GameData Class
 * 
 * @author blake
 *
 */
public class GameDataTest {
    /**
     * GameData Object
     */
    private GameData gameData;

    /**
     * Setup for tests 
     */
    @BeforeEach
    public void setUp() {
        gameData = new GameData();
    }

    /**
     * Tests the default constructor
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals(Difficulty.EASY, gameData.getDifficulty());
        assertEquals(10, gameData.getSeasonDuration());
        assertEquals(0, gameData.getCurrentWeek());
        assertEquals(0, gameData.getMoney());
        assertTrue(gameData.getTeam() instanceof Team);
        assertTrue(gameData.getClub() instanceof Club);
    }

    /**
     * Tests setting of difficulty
     */
    @Test
    public void testSetDifficulty() {
        gameData.setDifficulty(Difficulty.HARD);
        assertEquals(Difficulty.HARD, gameData.getDifficulty());
        assertEquals(5000, gameData.getMoney());
    }

    /**
     * Tests setting the season duration
     */
    @Test
    public void testSetSeasonDuration() {
        gameData.setSeasonDuration(12);
        assertEquals(12, gameData.getSeasonDuration());
    }

    @Test
    public void testSetSeasonDurationInvalid() {
        assertThrows(IllegalArgumentException.class, () -> gameData.setSeasonDuration(20));
    }

    /**
     * Tests incrementing the next week
     */
    @Test
    public void testNextWeek() throws GameOverException {
        gameData.nextWeek();
        assertEquals(1, gameData.getCurrentWeek());
    }

    /**
     * Tests incrementing the week past the season duration 
     */
    @Test
    public void testNextWeekGameOver() throws GameOverException {
        gameData.setSeasonDuration(5);
        gameData.nextWeek();
        gameData.nextWeek();
        gameData.nextWeek();
        gameData.nextWeek();
        gameData.nextWeek();
 
        assertThrows(GameOverException.class, () -> gameData.nextWeek());
    }

    /**
     * Tests increasing the money
     */
    @Test
    public void testIncrementMoney() {
        gameData.incrementMoney(1000);
        assertEquals(1000, gameData.getMoney());
    }


    /**
     * Tests reducing the money
     */
    @Test
    public void testDeductMoney() {
        gameData.incrementMoney(1000);
        gameData.deductMoney(500);
        assertEquals(500, gameData.getMoney());
    }

    /**
     * Tests reducing money by invalid amount
     */
    @Test
    public void testDeductMoneyInvalid() {
        gameData.incrementMoney(1000);
        assertThrows(IllegalArgumentException.class, () -> gameData.deductMoney(1500));
    }
}
