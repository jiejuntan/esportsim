package test;

import main.model.GameData;
import main.model.GameData.Difficulty;
import main.model.Team;
import main.model.Club;
import main.exceptions.GameOverException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameDataTest {
    private GameData gameData;

    @BeforeEach
    public void setUp() {
        gameData = new GameData();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(Difficulty.EASY, gameData.getDifficulty());
        assertEquals(10, gameData.getSeasonDuration());
        assertEquals(0, gameData.getCurrentWeek());
        assertEquals(0, gameData.getMoney());
        assertTrue(gameData.getTeam() instanceof Team);
        assertTrue(gameData.getClub() instanceof Club);
    }

    @Test
    public void testSetDifficulty() {
        gameData.setDifficulty(Difficulty.HARD);
        assertEquals(Difficulty.HARD, gameData.getDifficulty());
        assertEquals(5000, gameData.getMoney());
    }

    @Test
    public void testSetSeasonDuration() {
        gameData.setSeasonDuration(12);
        assertEquals(12, gameData.getSeasonDuration());
    }

    @Test
    public void testSetSeasonDurationInvalid() {
        assertThrows(IllegalArgumentException.class, () -> gameData.setSeasonDuration(20));
    }

    @Test
    public void testNextWeek() throws GameOverException {
        gameData.nextWeek();
        assertEquals(1, gameData.getCurrentWeek());
    }

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

    @Test
    public void testIncrementMoney() {
        gameData.incrementMoney(1000);
        assertEquals(1000, gameData.getMoney());
    }

    @Test
    public void testIncrementMoneyInvalid() {
        assertThrows(IllegalArgumentException.class, () -> gameData.incrementMoney(-1000));
    }

    @Test
    public void testDeductMoney() {
        gameData.incrementMoney(1000);
        gameData.deductMoney(500);
        assertEquals(500, gameData.getMoney());
    }

    @Test
    public void testDeductMoneyInvalid() {
        gameData.incrementMoney(1000);
        assertThrows(IllegalArgumentException.class, () -> gameData.deductMoney(1500));
    }
}
