package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.exceptions.TeamLimitException;
import main.model.Athlete;
import main.model.Team;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * Junit tests for Team Class
 * @author blake
 *
 */
class TeamTests {
    /**
     * Team Object
     */
    private Team team;

    /**
     * Setup for team tests
     */
    @BeforeEach
    void setUp() {
        team = new Team();
        try {
            for (int i = 0; i < Team.MAIN_LIMIT; i++) {
                team.addAthlete(new Athlete(1), Team.Role.OFFENSE);
            }
            for (int i = 0; i < Team.RESERVE_LIMIT; i++) {
                team.addAthlete(new Athlete(1), Team.Role.RESERVE);
            }
        } catch (TeamLimitException e) {
            fail("Exception should not be thrown");
        }
    }

    
    /**
     * Tests adding and removing of athletes
     */
    @Test
    void testAddAndRemoveAthlete() {
        Athlete athlete = new Athlete(1);
        int sizeBefore = 0;
        int sizeAfter = 0;
        try {
        	sizeBefore = team.getMainTeamSize();
        	
        	team.removeAthlete(team.getMainMembers().get(0));
        	sizeAfter = team.getMainTeamSize();
        	
        	//Test if team size was reduced
        	assertTrue(sizeBefore - 1 == sizeAfter);
        	
        	
            team.addAthlete(athlete, Team.Role.OFFENSE);
        	sizeAfter = team.getMainTeamSize();

            assertTrue(sizeBefore == sizeAfter);
            
        } catch (TeamLimitException e) {
            fail("Exception should not be thrown");
        }
    }

    /**
     * Tests adding athletes when team full
     */
    @Test
    void testAddAthleteTeamFull() {
        assertThrows(TeamLimitException.class, () -> team.addAthlete(new Athlete(1), Team.Role.OFFENSE));
    }

    /**
     * Tests changing of role
     */
    @Test
    void testChangeRole() {
        Athlete athlete = team.getMainMembers().get(0);
        try {
            team.changeRole(athlete, Team.Role.SUPPORT);
            assertEquals(Team.Role.SUPPORT, athlete.getRole());
        } catch (TeamLimitException e) {
            fail("Exception should not be thrown");
        }
    }

    /**
     * Tests reseting the stamina
     */
    @Test
    void testResetStaminaAll() {
        for (Athlete athlete : team.getMainMembers()) {
            athlete.setStamina(0);
        }
        team.resetStaminaAll();
        for (Athlete athlete : team.getMainMembers()) {
            assertEquals(2, athlete.getStamina()); // Assuming 2 is the max stamina
        }
    }


    /**
     * Tests setting of team name
     */
    @Test
    void testSetTeamName() {
        String newName = "New Team Name";
        team.setTeamName(newName);
        assertEquals(newName, team.getName());
    }
    
    /**
     * Tests if setname is invalid
     */
    @Test
    void testSetTeamNameInvalid() {
        String invalidName = "Invalid!";
        assertThrows(IllegalArgumentException.class, () -> team.setTeamName(invalidName));
    }

    /**
     * Tests adding a win
     */
    @Test
    void testAddWin() {
        int initialWins = team.getWins();
        team.addWin(1);
        assertEquals(initialWins + 1, team.getWins());
    }

    /**
     * Tests adding a loss
     */
    @Test
    void testAddLoss() {
        int initialLosses = team.getLosses();
        team.addLoss(1);
        assertEquals(initialLosses + 1, team.getLosses());
    }


    /**
     * Tests the constructor of oppponent teams
     */
    @Test
    void testOpponentTeamConstructor() {
        int currentWeek = 5;
        Team opponentTeam = new Team(currentWeek);
        assertEquals(Team.MAIN_LIMIT, opponentTeam.getMainTeamSize());
        assertTrue(opponentTeam.getWins() <= currentWeek - 1);
        assertTrue(opponentTeam.getLosses() <= currentWeek - 1);
    }
    
    
}
