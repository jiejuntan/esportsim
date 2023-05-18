package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import main.model.Athlete;
import main.model.Team;

import static org.junit.jupiter.api.Assertions.*;

class TeamTests {

<<<<<<< HEAD
    @BeforeEach
    void setUp() {
        team = new Team("Test Team");
    }

    @Test
    void addAthleteTest() {
        Athlete athlete = new Athlete(false);
        team.addAthlete(athlete, RESERVE);
        assertTrue(team.getTeamMembers().contains(athlete));
    }

    @Test
    void removeAthleteTest() {
        Athlete athlete = new Athlete(false);
        team.addAthlete(athlete, RESERVE);
        team.removeAthlete(athlete);
        assertFalse(team.getTeamMembers().contains(athlete));
    }

    @Test
    void getRandomTeamNameTest() {
        assertNotNull(team.getRandomTeamName());
    }

    @Test
    void generateTeamTest() {
        ArrayList<Athlete> generatedTeam = team.generateTeam(false);
        assertEquals(generatedTeam.size(), 5);
    }

    @Test
    void testGettersAndSetters() {
        team.addWin(1);
        assertEquals(team.getWins(), 1);

        team.addLoss(1);
        assertEquals(team.getLosses(), 1);

        assertNotNull(team.getTeamMembers());
        assertNotNull(team.getReserveMembers());
        assertEquals(team.getName(), "Test Team");
    }

    @Test
    void testToString() {
        assertNotNull(team.toString());
    }
=======
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
}
