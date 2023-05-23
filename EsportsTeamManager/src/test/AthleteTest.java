package test;

import main.model.Athlete;
import main.model.Team.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit tests for the Athlete class
 * 
 * @author blake
 *
 */
class AthleteTest {

    /**
     * Athlete Object
     */
    private Athlete athlete;


    /**
     * Setting up for tests
     */
    @BeforeEach
    void setUp() {
        athlete = new Athlete(1);  
    }

    /**
     * Tests getting of name
     */
    @Test
    void testGetName() {
        assertNotNull(athlete.getName());
    }

    /**
     * Tests setting of name
     */
    @Test
    void testSetName() {
        String newName = "New Name";
        athlete.setName(newName);
        assertEquals(newName, athlete.getName());
    }

    /**
     * Tests getting and setting reaction time stat
     */
    @Test
    void testGetSetReactionTime() {
        int reactionTime = 5;
        athlete.setReactionTime(reactionTime);
        assertEquals(reactionTime, athlete.getReactionTime());
    }

    /**
     * Tests getting and setting eyesight
     */
    @Test
    void testGetSetEyeSight() {
        int eyeSight = 5;
        athlete.setEyeSight(eyeSight);
        assertEquals(eyeSight, athlete.getEyeSight());
    }

    /**
     * Tests getting and setting intelligence
     */
    @Test
    void testGetSetIntelligence() {
        int intelligence = 5;
        athlete.setIntelligence(intelligence);
        assertEquals(intelligence, athlete.getIntelligence());
    }

    /**
     * Tests getting and setting stamina
     */
    @Test
    void testGetSetStamina() {
        int stamina = 1;
        athlete.setStamina(stamina);
        assertEquals(stamina, athlete.getStamina());
    }

    /**
     * Tests get and setting of roles
     */
    @Test
    void testGetSetRole() {
        Role role = Role.OFFENSE;
        athlete.setRole(role);
        assertEquals(role, athlete.getRole());
    }
    

    /**
     * Tests calculation of skill levels
     */
    @Test
    void testCalculateSkillLevel() {
        int skillLevel = athlete.getEyeSight() + athlete.getIntelligence() + athlete.getReactionTime();
        assertEquals(skillLevel, athlete.calculateSkillLevel());
    }
}
