package main.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * Represents the player's and opponents' teams.
 * 
 * @author Blake and Jun
 *
 */
public class Team {

	/**
	 * Team name
	 */
	private String name;

	/**
	 * Starting team members and their roles
	 */
	private HashMap<Role, List<Athlete>> mainMembers;

	/**
	 * Reserve team members
	 */
	private List<Athlete> reserveMembers;

	/**
	 * Number of wins
	 */
	private int wins;

	/**
	 * Number of losses
	 */
	private int losses;

	/**
	 * Regex pattern for team name validation
	 */
	private static final String VALID_NAME_PATTERN = "[ a-zA-Z0-9]{3,15}";

	/**
	 * Maximum number of reserves
	 */
	private static final int RESERVE_LIMIT = 4;

	/**
	 * Maximum number of main members
	 */
	private static final int MAIN_LIMIT = 4;

	/**
	 * Number of total athletes required
	 * 
	 * 4 starting, 1 reserve minimum
	 */
	public static final int MIN_TEAM_SIZE = 5;

	/**
	 * Defines the Athletes Roles and the stats of each role
	 */
	public enum Role {

		// Role(Health, Damage, Aggro Priority)
		OFFENSE(50, 100, 2), SUPPORT(25, 0, 3), TANK(100, 50, 1), RESERVE(0, 0, 0);

		private final int health;
		private final int damage;
		private final int aggro;

		Role(int health, int damage, int aggro) {
			this.health = health;
			this.damage = damage;
			this.aggro = aggro;
		}
<<<<<<< HEAD

		/**
		 * @return the health
=======
		
    	/**
		 * @return <CODE>int</CODE> Role health
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
		 */
		public int getHealth() {
			return health;
		}

		/**
		 * @return <CODE>int</CODE> Role damage
		 */
		public int getDamage() {
			return damage;
		}

		/**
		 * 
		 * @return <CODE>int</CODE> Role Aggro
		 */
		public int getAggro() {
			return aggro;
		}
	}

	/**
	 * Constructor for the player's Team
	 */
	public Team() {
		this.name = getRandomTeamName();
		this.mainMembers = new HashMap<Role, List<Athlete>>();
		this.reserveMembers = new ArrayList<Athlete>();

		this.wins = 0;
		this.losses = 0;
	}

	/**
	 * Constructor for Opponent Team Generation
	 * 
	 * @param difficulty
	 */
//	public Team() {
//    	this.name = getRandomTeamName();
//    	this.wins = 0;
//    	this.losses = 0;
//    	this.teamMembers = generateTeam(false);
//    	this.reserveMembers = generateTeam(true);
//    }

	/**
	 * Adds an Athlete to the team as a reserve
	 * 
	 * @param athlete Athlete to add
	 * @throws TeamMemberLimitException if reserves are full
	 */
	public void addAthlete(Athlete athlete) throws TeamMemberLimitException {
		if (reserveMembers.size() < MAIN_LIMIT + RESERVE_LIMIT) {
			reserveMembers.add(athlete);
		} else {
			throw new TeamMemberLimitException();
		}
	}

	/**
	 * Removes an Athlete from the Team
	 * 
	 * @param athlete Athlete to remove
	 * @return TODO
	 */
	public Role removeAthlete(Athlete athlete) {
		if (reserveMembers.contains(athlete)) {
			reserveMembers.remove(athlete);
			return Role.RESERVE;
		} else {
			for (Map.Entry<Role, List<Athlete>> entry : mainMembers.entrySet()) {
				List<Athlete> athletesInRole = entry.getValue();
				if (athletesInRole.contains(athlete)) {
					athletesInRole.remove(athlete);
				}
			}
		}
	}

	/**
	 * Assigns an athlete to a role, swapping roles with the athlete in that role if
	 * one exists.
	 * 
	 * @param athlete Athlete to assign
	 * @param role    Role to assign to
	 */
	public void assignRole(Athlete athlete, Role role) {
		removeAthlete(athlete);
		
		switch (role) {
		case RESERVE:
			if (getReserveTeamSize() >= RESERVE_LIMIT) {
				
			}
			break;
		default:
			if (getMainTeamSize() >= MAIN_LIMIT) {
				List<Athlete> athletesInRole = mainMembers.get(role);
				athletesInRole.add(athlete);
				athletesInRole.remove(0);
			}
			break;
		}
		

//
//		
//		
//		Athlete toReplace = mainMembers.get(role);
//
//		if (reserveMembers.contains(athlete)) {
//			reserveMembers.remove(athlete);
//			mainMembers.put(role, athlete);
//
//			if (toReplace != null) {
//				reserveMembers.add(toReplace);
//			}
//		} else {
//			for (Map.Entry<Role, Athlete> entry : mainMembers.entrySet()) {
//				if (Objects.equals(athlete, entry.getValue())) {
//					Role previousRole = entry.getKey();
//					mainMembers.remove(previousRole);
//					mainMembers.put(role, athlete);
//
//					if (toReplace != null) {
//						mainMembers.put(previousRole, toReplace);
//					}
//				}
//			}
//		}
	}
	
	
	public int getMainTeamSize() {
		int count = 0;
		for (Role role: Role.values()) {
			if (role != Role.RESERVE) {
				List<Athlete> athletes = mainMembers.get(role);
				count += athletes.size();
			}
		}
		return count;
	}
	
	public int getReserveTeamSize() {
		return mainMembers.get(Role.RESERVE).size();
	}
	
	/**
	 * Picks a random Team name from an inputed name list
	 * 
	 * @return Random Team Name
	 */
	public String getRandomTeamName() {

		// Grabs a list of names
		String[] namesList = null;
		try {
			namesList = IO.getTextFromFile("src/main/Resources/TeamNames");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Picks a random number
		Random random = new Random();
		int randomNumber = random.nextInt(namesList.length);

		// Uses random number to pick a name out of the nameList
		return namesList[randomNumber];
	}

	/**
	 * Sets team name if valid
	 * 
	 * @param name name to set
	 * @throws IllegalArgumentException if name is invalid
	 */
	public void setTeamName(String name) throws IllegalArgumentException {
		if (isValidTeamName(name)) {
			this.name = name;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Checks if team name matches pattern
	 * 
	 * @param name team name to validate
	 * @return <CODE>true</CODE> if team name is valid
	 */
	private boolean isValidTeamName(String name) {
		return name.matches(VALID_NAME_PATTERN);
	}

	/**
	 * Generates a random team full of Athletes
	 * 
	 * @return Randomly Generated Team
	 */
	public ArrayList<Athlete> generateTeam(boolean isReserve) {

		ArrayList<Athlete> generatedTeam = new ArrayList<Athlete>();

		for (int teamRosterLimit = 5; teamRosterLimit > 0; teamRosterLimit--) {

//    		Athlete randomAthlete = new Athlete(isReserve);
//    		generatedTeam.add(randomAthlete);
<<<<<<< HEAD
		}

		return generatedTeam;
	}

	/********** Simple Getters & Setters **********/

	/**
	 * Gets the Team Wins
	 * 
	 * @return
	 */
	public int getWins() {
=======
    	}
    	
    	return generatedTeam;
    }
    
    /********** Simple Getters & Setters **********/
    
    /**
     * Gets the Team Wins
     * @return <CODE>int</CODE> Wins
     */
    public int getWins() {
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
		return wins;
	}

	/**
	 * Adds a single Win to the Team
<<<<<<< HEAD
	 * 
	 * @param wins
=======
	 * @param <CODE>int</CODE> Wins
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
	 */
	public void addWin(int wins) {
		this.wins++;
	}

	/**
	 * Gets the Team Losses
<<<<<<< HEAD
	 * 
	 * @return
=======
	 * @return <CODE>int</CODE> Losses
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
	 */
	public int getLosses() {
		return losses;
	}

	/**
	 * Adds a loss to the players team
	 * 
	 * @param <CODE>int</CODE> losses
	 */
	public void addLoss(int losses) {
		this.losses++;
	}

	/**
	 * Gets the Team main Athletes
<<<<<<< HEAD
	 * 
	 * @return
=======
	 * @return <CODE>HashMap<Role, Athlete></CODE> TeamMembers
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
	 */
	public HashMap<Role, List<Athlete>> getTeamMembers() {
		return mainMembers;
	}

	/**
	 * Gets the Team reserve Athletes
<<<<<<< HEAD
	 * 
	 * @return
=======
	 * @return <CODE>List<Athlete></CODE> reserveMembers
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
	 */
	public List<Athlete> getReserveMembers() {
		return reserveMembers;
	}

//	/**
//	 * Sets the main Team members
//	 * @param teamMembers
//	 */
//	public void setTeamMembers(List<Athlete> teamMembers) {
//		this.teamMembers = teamMembers;
//	}
//
//	/**
//	 * Sets the Team reserve members
//	 * @param reserveMembers
//	 */
//	public void setReserveMembers(List<Athlete> reserveMembers) {
//		this.reserveMembers = reserveMembers;
//	}

	/**
	 * Gets the name of the Team
<<<<<<< HEAD
	 * 
	 * @return
=======
	 * @return <CODE>String</CODE> of Team Name
>>>>>>> branch 'main' of https://eng-git.canterbury.ac.nz/bsm79/esportsteammananger.git
	 */
	public String getName() {
		return name;
	}

	/********** Simple Getters and Setters **********/

	@Override
	public String toString() {
		return String.format("Team Name: %s \nWins: %d \nLosses: %d \n", name, wins, losses);
	}
}
