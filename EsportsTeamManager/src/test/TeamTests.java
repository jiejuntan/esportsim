package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.exceptions.TeamLimitException;
import main.model.Athlete;
import main.model.Team;

import static org.junit.jupiter.api.Assertions.*;

class TeamTests {
    private Team team;

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

    @Test
    void testAddAndRemoveAthlete() {
        Athlete athlete = new Athlete(1);
        try {
            team.addAthlete(athlete, Team.Role.OFFENSE);
            assertEquals(Team.MAIN_LIMIT + 1, team.getMainTeamSize());
            assertEquals(athlete, team.getMainMembers().get(Team.MAIN_LIMIT));
            team.removeAthlete(athlete);
            assertEquals(Team.MAIN_LIMIT, team.getMainTeamSize());
        } catch (TeamLimitException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testAddAthleteTeamFull() {
        assertThrows(TeamLimitException.class, () -> team.addAthlete(new Athlete(1), Team.Role.OFFENSE));
    }

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

    @Test
    void testChangeRoleTeamFull() {
        Athlete athlete = new Athlete(1);
        try {
            team.addAthlete(athlete, Team.Role.RESERVE);
            assertThrows(TeamLimitException.class, () -> team.changeRole(athlete, Team.Role.OFFENSE));
        } catch (TeamLimitException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    void testSwapRole() {
        Athlete athlete1 = team.getMainMembers().get(0);
        Athlete athlete2 = new Athlete(1);
        try {
            team.addAthlete(athlete2, Team.Role.RESERVE);
            team.swapRole(athlete1, athlete2);
            assertEquals(Team.Role.RESERVE, athlete1.getRole());
            assertEquals(Team.Role.OFFENSE, athlete2.getRole());
        } catch (TeamLimitException e) {
            fail("Exception should not be thrown");
        }
    }

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


    @Test
    void testSetTeamName() {
        String newName = "New Team Name";
        team.setTeamName(newName);
        assertEquals(newName, team.getName());
    }

    @Test
    void testSetTeamNameInvalid() {
        String invalidName = "Invalid!";
        assertThrows(IllegalArgumentException.class, () -> team.setTeamName(invalidName));
    }

    @Test
    void testAddWin() {
        int initialWins = team.getWins();
        team.addWin(1);
        assertEquals(initialWins + 1, team.getWins());
    }

    @Test
    void testAddLoss() {
        int initialLosses = team.getLosses();
        team.addLoss(1);
        assertEquals(initialLosses + 1, team.getLosses());
    }

    @Test
    void testOpponentTeamConstructor() {
        int currentWeek = 5;
        Team opponentTeam = new Team(currentWeek);
        assertEquals(Team.MAIN_LIMIT, opponentTeam.getMainTeamSize());
        assertTrue(opponentTeam.getWins() <= currentWeek - 1);
        assertTrue(opponentTeam.getLosses() <= currentWeek - 1);
    }
    
    @Test
    void testHasMinimumSize() {
        assertTrue(team.hasMinimumSize());
        team.removeAthlete(team.getMainMembers().get(0));

        assertFalse(team.hasMinimumSize());
    }

    
}
