package test;
import main.exceptions.TeamLimitException;
import main.model.Athlete;
import main.model.GameData;
import main.model.Team;
import main.model.Team.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTests {

    private Team team;
    private GameData gameData;

    @BeforeEach
    void setUp() {
    	gameData = new GameData();
        team = new Team();
    }
    
    @Test
    void testOpponentTeamCreation()  {
    	Team opponentTeam = new Team(gameData.getCurrentWeek());
    	assertTrue(opponentTeam.getMainTeamSize() > 0);
    }

    @Test
    void addAthlete() throws TeamLimitException {
        Athlete athlete = new Athlete(gameData.getCurrentWeek());
        team.addAthlete(athlete, Role.OFFENSE);

        assertTrue(team.getTeamMembers().get(Role.OFFENSE).contains(athlete));
    }


    @Test
    void testRemoveAthlete() throws TeamLimitException {
        Athlete athlete = new Athlete(gameData.getCurrentWeek());
        team.addAthlete(athlete, Role.OFFENSE);

        team.removeAthlete(athlete);

        assertFalse(team.getTeamMembers().get(Role.OFFENSE).contains(athlete));
    }

    @Test
    void testChangeRole() throws TeamLimitException {
        Athlete athlete = new Athlete(gameData.getCurrentWeek());
        team.addAthlete(athlete, Role.OFFENSE);

        team.changeRole(athlete, Role.SUPPORT);

        assertTrue(team.getTeamMembers().get(Role.SUPPORT).contains(athlete));
        assertFalse(team.getTeamMembers().get(Role.OFFENSE).contains(athlete));
    }

}
