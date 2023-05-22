package main.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import main.exceptions.IllegalTeamException;
import main.exceptions.TeamLimitException;
import main.gui.GUIConstants;
import main.exceptions.TeamLimitException.Type;

/**
 * Represents the player's and opponents' teams.
 * 
 * @author Blake and Jun
 *
 */
public final class Team {

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
	public static final int MAIN_LIMIT = 5;

	/**
	 * Number of total athletes required
	 * 
	 * 5 starting, 1 reserve minimum
	 */
	public static final int MIN_TEAM_SIZE = 6;
	
	/**
	 * Team logo image path
	 */
	private String logoPath;
	
	/** 
	 * Static property storing unused portrait indexes
	 */
	private static List<Integer> availableLogos = IntStream.range(0, GUIConstants.LOGO_COUNT).boxed().collect(Collectors.toCollection(ArrayList::new));
	
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
            try {
                addAthlete(new Athlete(skillLevel),getRandomRole(false));
            } catch (IllegalTeamException | TeamLimitException e) {
                // Exception is unrecoverable
                e.printStackTrace();
            }
        }

        setLogo();

        // Generate random wins and losses.
        Random rand = new Random();
        this.wins = rand.nextInt(10); // Random wins from 0 to 9
        this.losses = rand.nextInt(10); // Random losses from 0 to 9
    }
    
	/**
	 * Returns a randomly picked role
	 * 
	 * @return Role
	 */
	static public Role getRandomRole(boolean includeReserve) {
		Random random = new Random();
	        
        // Picks one of the three roles to assign to the Athlete
        Role[] roles = Role.values();
        
        // if includeReserve is true then the reserve role is added 
        // to the list of possible return values
        if (includeReserve) {
        	return roles[random.nextInt(4)];
        } else {
        	return roles[random.nextInt(3)];
        }
	}
	
	/**
	 * Returns the total skill level of the team
	 * 
	 * @return <CODE>int</CODE> totalSkillLevel
	 */
	public int calculateTeamlevel() {
		int totalSkillLevel = 0;
		 
		for (Athlete athlete : getMainMembers()) {
			totalSkillLevel += athlete.calculateSkillLevel();
		}
		return totalSkillLevel;
	}
	
	/**
	 * Adds an new Athlete in a main role or reserve
	 * 
	 * @param athlete 					Athlete to add
	 * @param role 						Role to add Athlete in
	 * @throws TeamLimitException 		if whole, main, or reserve team is full
	 */
	public void addAthlete(Athlete athlete, Role role) throws IllegalTeamException, TeamLimitException {
		if (isTeamFull()) {
			throw new TeamLimitException(Type.WHOLE);
		}
		switch (role) {
		case RESERVE:
			if (isReserveTeamFull()) {
				throw new TeamLimitException(Type.RESERVE);
			}
			break;
		default:
			if (isMainTeamFull()) {
				throw new TeamLimitException(Type.MAIN);
			}
			break;
		}
		members.get(role).add(athlete);
		athlete.setRole(role);	
	}
	
	/**
	 * Removes an Athlete from the Team
	 * 
	 * @param athlete Athlete to remove
	 */
	public void removeAthlete(Athlete athlete) {
		for (Map.Entry<Role, List<Athlete>> entry : members.entrySet()) {
			List<Athlete> athletesInRole = entry.getValue();
			if (athletesInRole.contains(athlete)) {
				athletesInRole.remove(athlete);
				athlete.setRole(null);
			}
		}
	}

	/**
	 * Changes a current member's role
	 * 
	 * @param athlete 				Athlete to assign
	 * @param role    				Role to assign to
	 * @throws IllegalTeamException if swapping between main and reserve
	 */
	public void changeRole(Athlete athlete, Role role) throws IllegalTeamException {
		// Do nothing if same role
		if (athlete.getRole() == role) {
			return;
		} 
		// Throw exception to prompt swap if swapping between main and reserve
		if (athlete.getRole() == Role.RESERVE || role == Role.RESERVE) {
			throw new IllegalTeamException();
		}
		// Swapping between main roles should be legal
		try {
			removeAthlete(athlete);
			addAthlete(athlete, role);
		} catch (IllegalTeamException | TeamLimitException e) {
			// Unrecoverable exception
			e.printStackTrace();
		}
	}
	
	/**
	 * Swaps two athletes between main team and reserve team
	 * 
	 * @param incoming	Athlete triggering role swap
	 * @param outgoing	target Athlete to swap
	 */
	public void swapRole(Athlete incoming, Athlete outgoing) {
		Role incomingRole = incoming.getRole();
		Role outgoingRole = outgoing.getRole();
		
		removeAthlete(incoming);
		removeAthlete(outgoing);
		
		try {
			addAthlete(incoming, outgoingRole);
			addAthlete(outgoing, incomingRole);
		} catch (TeamLimitException | IllegalTeamException e1) {
			// Exception is unrecoverable
			e1.printStackTrace();
		}
	}

	/**
	 * Resets the stamina of all athletes
	 */
	public void resetStaminaAll() {
		for (Map.Entry<Role, List<Athlete>> entry : members.entrySet()) {
			List<Athlete> athletesInRole = entry.getValue();
			for (Athlete athlete : athletesInRole) {
				athlete.resetStamina();
			}
		}
	}
	
	//testing
	public void dropStaminaAll() {
		for (Map.Entry<Role, List<Athlete>> entry : members.entrySet()) {
			List<Athlete> athletesInRole = entry.getValue();
			for (Athlete athlete : athletesInRole) {
				athlete.setStamina(0);
			}
		}
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
	 * Gets the main members as a list.
	 * 
	 * @return list of main Athletes
	 */
	public List<Athlete> getMainMembers() {
		List<Athlete> result = new ArrayList<Athlete>();
		for (Map.Entry<Role, List<Athlete>> entry : members.entrySet()) {
			if (entry.getKey() != Role.RESERVE) {
				result.addAll(entry.getValue());
			}
		}
		return result;
	}
	
	/**
	 * Gets the reserve members as a list.
	 * 
	 * @return list of reserve Athletes
	 */
	public List<Athlete> getReserveMembers() {		
		return members.get(Role.RESERVE);
	}

	/**
	 * Gets the name of the Team
	 * 
	 * @return <CODE>String</CODE> of Team Name
	 */
	public String getName() {
		return name;
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
	
	/**
	 * Picks a random Team name from an inputed name list
	 * 
	 * @return Random Team Name
	 */
	private String getRandomTeamName() {

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
	 * @return the logoPath
	 */
	public String getLogoPath() {
		return logoPath;
	}
	
	/**
     * Sets logo path for Team and prevents reuse unless there are no remaining logos
     */
    private void setLogo() {
    	if (availableLogos.size() == 0) {
    		availableLogos = IntStream.range(0, GUIConstants.LOGO_COUNT).boxed().collect(Collectors.toCollection(ArrayList::new));
    	}
    	Random random = new Random();
    	int index = random.nextInt(availableLogos.size());
    	int portrait = availableLogos.get(index);
    	availableLogos.remove(index);
    	
    	this.logoPath = "/main/Resources/logos/" + portrait + ".png";
    }
    
    /**
	 * Gets current size of starting team
	 * 
	 * @return number of athletes in main team
	 */
	private int getMainTeamSize() {
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
	private int getReserveTeamSize() {
		return members.get(Role.RESERVE).size();
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

}
