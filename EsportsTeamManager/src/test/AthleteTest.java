package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Athlete;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {
    private Athlete athlete;

    @BeforeEach
    void setUp() {
//        athlete = new Athlete(false, 3);
    }

    @Test
    void getRandomNameTest() {
        assertNotNull(athlete.getRandomName());
    }

    @Test
    void generateAthleteStatsTest() {
        athlete.generateAthleteStats(3);
        assertTrue(athlete.getReactionTime() > 0);
        assertTrue(athlete.getEyeSight() > 0);
        assertTrue(athlete.getIntelligence() > 0);
    }

    @Test
    void calculateSkillLevelTest() {
        int skillLevel = athlete.calculateSkillLevel();
        assertEquals(skillLevel, athlete.getReactionTime() + athlete.getEyeSight() + athlete.getIntelligence());
    }

    @Test
    void setPurchasePriceTest() {
        athlete.getBasePrice();
        assertEquals(athlete.getBasePrice(), 100 * athlete.calculateSkillLevel());

        athlete.getBasePrice();
        assertEquals(athlete.getBasePrice(), 1000 * athlete.calculateSkillLevel());
    }

    @Test
    void setDescriptionTest() {
        athlete.setDescription();
        assertEquals(athlete.getDescription(), String.format("Name: %s \nReaction Time: %d \nEye Sight: %d \nIntelligence: %d \n", athlete.getName(), athlete.getReactionTime(), athlete.getEyeSight(), athlete.getIntelligence()));
    }

    @Test
    void testToString() {
        assertEquals(athlete.toString(), athlete.getDescription());
    }


    
}
