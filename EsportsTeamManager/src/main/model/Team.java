package main.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import main.exceptions.TeamMemberLimitException;

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
	private HashMap<Role, List<Athlete>> members;

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
	private static final int RESERVE_LIMIT = 5;

	/**
	 * Maximum number of main members
	 */
	private static final int MAIN_LIMIT = 5;

	/**
	 * Number of total athletes required
	 * 
	 * 5 starting, 1 reserve minimum
	 */
	public static final int MIN_TEAM_SIZE = 6;
	
	/**
	 * Defines the Athletes Roles and the stats of each role
	 */
	public enum Role {

		// Role(Health, Damage, Aggro Priority)
		OFFENSE(50, 50, 2), 
		SUPPORT(25, 10, 3), 
		TANK(100, 25, 1), 
		RESERVE(0, 0, 0);

		private final int health;
		private final int damage;
		private final int aggro;

		Role(int health, int damage, int aggro) {
			this.health = health;
			this.damage = damage;
			this.aggro = aggro;
		}

    	/**
		 * @return <CODE>int</CODE> Role health
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
		this.members = new HashMap<Role, List<Athlete>>();
		for (Role role : Role.values()) {
			members.put(role, new ArrayList<Athlete>());
		}
		this.wins = 0;
		this.losses = 0;
	}

	/**
	 * Constructor for Opponent Team Generation
	 * 
	 * @param difficulty
	 */
	public Team(int skillLevel) {
		this.name = getRandomTeamName();
		this.members = new HashMap<Role, List<Athlete>>();
		
		for (Role role : Role.values()) {
			members.put(role, new ArrayList<Athlete>());
		}
		
		for (int athleteCount = 0; athleteCount < MAIN_LIMIT; athleteCount++) {
			
	        Random random = new Random();
	        
	        // Picks one of the three roles to assign to the Athlete
	        Role[] roles = Role.values();
	        Role randomRole = roles[random.nextInt(3)];
	        
			//Adds athlete to the team
			addAthlete(new Athlete(skillLevel),roles[random.nextInt(3)]);
		}
		
		
		
		this.wins = 0;
		this.losses = 0;
    }

	/**
	 * Adds an new Athlete in a main role or reserve
	 * 
	 * @param athlete 					Athlete to add
	 * @param role 						Role to add Athlete in
	 */
	public void addAthlete(Athlete athlete, Role role) {
		members.get(role).add(athlete);
	}
	
	/**
	 * Removes an Athlete from the Team and returns the role it was in.
	 * 
	 * @param athlete Athlete to remove
	 * 
	 * @return role the athlete was in
	 */
	public Role removeAthlete(Athlete athlete) {
		for (Map.Entry<Role, List<Athlete>> entry : members.entrySet()) {
			List<Athlete> athletesInRole = entry.getValue();
			if (athletesInRole.contains(athlete)) {
				athletesInRole.remove(athlete);
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * Assigns an athlete to a role, swapping roles with the athlete in that role if
	 * one exists.
	 * 
	 * @param athlete Athlete to assign
	 * @param role    Role to assign to
	 */
	public void assignRole(Athlete athlete, Role role) {
		Role previousRole = removeAthlete(athlete);
		
		if (previousRole == null) {
			
		}
		switch (role) {
			
		case RESERVE:
			if (isReserveTeamFull()) {
				
			}
			break;
		default:
			if (isMainTeamFull()) {
				List<Athlete> athletesInRole = members.get(role);
				athletesInRole.add(athlete);
				athletesInRole.remove(0);
			}
			break;
		}
	}
	
	/**
	 * Gets current size of starting team
	 * 
	 * @return number of athletes in main team
	 */
	public int getMainTeamSize() {
		int count = 0;
		for (Role role: Role.values()) {
			if (role != Role.RESERVE) {
				List<Athlete> athletes = members.get(role);
				count += athletes.size();
			}
		}
		return count;
	}
	
	/**
	 * Gets current size of reserve team
	 * 
	 * @return	number of athletes in reserve team
	 */
	public int getReserveTeamSize() {
		return members.get(Role.RESERVE).size();
	}
	
	/**
	 * Checks if main team is full
	 * 
	 * @return	<code>true</code> if full
	 */
	public boolean isMainTeamFull() {
		return getMainTeamSize() >= MAIN_LIMIT;
	}
	
	/**
	 * Checks if reserve team is full
	 * 
	 * @return	<code>true</code> if full
	 */
	public boolean isReserveTeamFull() {
		return getReserveTeamSize() >= RESERVE_LIMIT;
	}
	
	/**
	 * Checks if entire team is full
	 * 
	 * @return	<code>true</code> if full
	 */
	public boolean isTeamFull() {
		return isMainTeamFull() && isReserveTeamFull();
	}
	
	/**
	 * Checks if team has enough members
	 * 
	 * @return	<code>true</code> if minimum team size is met
	 */
	public boolean hasMinimumSize() {
		return (getMainTeamSize() + getReserveTeamSize()) >= MIN_TEAM_SIZE;
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
	 * 
	 * @throws IllegalArgumentException if name is invalid
	 */
	public void setTeamName(String name) {
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


    /********** Simple Getters & Setters **********/
    
    /**
     * Gets the Team Wins
     * 
     * @return <CODE>int</CODE> Wins
     */
    public int getWins() {
		return wins;
	}

	/**
	 * Adds a single Win to the Team
	 * 
	 * @param <CODE>int</CODE> Wins
	 */
	public void addWin(int wins) {
		this.wins++;
	}

	/**
	 * Gets the Team Losses
	 * 
	 * @return <CODE>int</CODE> Losses
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
	 * 
	 * @return <CODE>HashMap<Role, Athlete></CODE> TeamMembers
	 */
	public HashMap<Role, List<Athlete>> getTeamMembers() {
		return members;
	}

	/**
	 * Gets the name of the Team
	 * 
	 * @return <CODE>String</CODE> of Team Name
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
