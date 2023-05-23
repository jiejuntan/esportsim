package test;

import main.model.Athlete;
import main.model.Team.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    private Athlete athlete;

    @BeforeEach
    void setUp() {
        athlete = new Athlete(1);  
    }

    @Test
    void testGetName() {
        assertNotNull(athlete.getName());
    }

    @Test
    void testSetName() {
        String newName = "New Name";
        athlete.setName(newName);
        assertEquals(newName, athlete.getName());
    }

    @Test
    void testGetSetReactionTime() {
        int reactionTime = 5;
        athlete.setReactionTime(reactionTime);
        assertEquals(reactionTime, athlete.getReactionTime());
    }

    @Test
    void testGetSetEyeSight() {
        int eyeSight = 5;
        athlete.setEyeSight(eyeSight);
        assertEquals(eyeSight, athlete.getEyeSight());
    }

    @Test
    void testGetSetIntelligence() {
        int intelligence = 5;
        athlete.setIntelligence(intelligence);
        assertEquals(intelligence, athlete.getIntelligence());
    }

    @Test
    void testGetSetStamina() {
        int stamina = 1;
        athlete.setStamina(stamina);
        assertEquals(stamina, athlete.getStamina());
    }

    @Test
    void testGetSetRole() {
        Role role = Role.OFFENSE;
        athlete.setRole(role);
        assertEquals(role, athlete.getRole());
    }

    @Test
    void testCalculateSkillLevel() {
        int skillLevel = athlete.getEyeSight() + athlete.getIntelligence() + athlete.getReactionTime();
        assertEquals(skillLevel, athlete.calculateSkillLevel());
    }
}
