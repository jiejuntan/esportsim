package main.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	public static final int RESERVE_LIMIT = 5;

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
		/**
		 * Offense role enum
		 */
		OFFENSE(1, 3, "eyeSight", "reactionTime"), 
		/**
		 * Support role enum
		 */
		SUPPORT(2, 2, "intelligence", "eyeSight"), 
		/**
		 * Tank role enum
		 */
		TANK(3, 1, "reactionTime", "intelligence"), 
		/**
		 * Reserve role enum
		 */
		RESERVE(0, 0, "", "");
		
		/**
		 * How fast the role attacks
		 */
		private final int speed;
		/**
		 * How much the role is targeted
		 */
		private final int aggro;
		/**
		 * Primary stat of role
		 */
		private final String primaryStat;
		/**
		 * Secondary stat of role
		 */
		private final String secondaryStat;
		
		/**
		 * Constructor for role enum
		 * @param speed		how fast the role attacks
		 * @param aggro		how much the role is attacked
		 * @param primary	primary stat of role
		 * @param secondary	secondary stat of role
		 */
		Role(int speed, int aggro, String primary, String secondary) {
			this.speed = speed;
			this.aggro = aggro;
			this.primaryStat = primary;
			this.secondaryStat = secondary;
		}

		/**
		 * @return speed of role
		 */
		public int getSpeed() {
			return speed;
		}

		/**
		 * 
		 * @return aggro of role
		 */
		public int getAggro() {
			return aggro;
		}

		/**
		 * @return the primaryStat
		 */
		public String getPrimaryStat() {
			return primaryStat;
		}

		/**
		 * @return the secondaryStat
		 */
		public String getSecondaryStat() {
			return secondaryStat;
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
	 * Constructor for opponent teams
	 * 
	 * @param currentWeek current week
	 */
    public Team(int currentWeek) {
        this.name = getRandomTeamName();
        this.members = new HashMap<Role, List<Athlete>>();
        for (Role role : Role.values()) {
            members.put(role, new ArrayList<Athlete>());
        }
		
        for (int athleteCount = 0; athleteCount < MAIN_LIMIT; athleteCount++) {
			try {
				addAthlete(new Athlete(currentWeek),getRandomRole(false));
			} catch (TeamLimitException e) {
				// Exception is unrecoverable
				e.printStackTrace();
			}
		}
        setLogo();

        Random rand = new Random();
        this.wins = currentWeek > 1 ? rand.nextInt(currentWeek - 1) : 0; 
        this.losses = currentWeek > 1 ? currentWeek - 1 - this.wins : 0;
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
	 * Returns the average skill level of the team
	 * 
	 * @return average skill level
	 */
	public int calculateTeamlevel() {
		int totalSkillLevel = 0;
		 
		for (Athlete athlete : getMainMembers()) {
			totalSkillLevel += athlete.calculateSkillLevel();
		}
		return totalSkillLevel / 5;
	}
	
	/**
	 * Adds an new Athlete in a main role or reserve
	 * 
	 * @param athlete 					Athlete to add
	 * @param role 						Role to add Athlete in
	 * @throws TeamLimitException 		if whole, main, or reserve team is full
	 */
	public void addAthlete(Athlete athlete, Role role) throws TeamLimitException {
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
	 * @throws TeamLimitException 	if target role (main/reserve) is full
	 */
	public void changeRole(Athlete athlete, Role role) throws TeamLimitException {
		// Do nothing if source and target roles are the same
		if (athlete.getRole() == role) {
			return;
		}
		// Changing to and from a main role should be legal
		if (role != Role.RESERVE && athlete.getRole() != Role.RESERVE) {
			try {
				removeAthlete(athlete);
				addAthlete(athlete, role);
				return;
			} catch (TeamLimitException e) {
				// Unrecoverable exception
				e.printStackTrace();
			}
		}
		// If changing between main and reserve roles, check if full to initiate swap
		if (role == Role.RESERVE && isReserveTeamFull()) {
			throw new TeamLimitException(Type.RESERVE);
		}
		if (role != Role.RESERVE && isMainTeamFull()) {
			throw new TeamLimitException(Type.MAIN);
		}
		// Target role is not full, changing role should be legal without swapping
		try {
			removeAthlete(athlete);
			addAthlete(athlete, role);
		} catch (TeamLimitException e) {
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
		} catch (TeamLimitException e1) {
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
	
	/**
	 * Gets the Team main Athletes
	 * 
	 * @return team members hash map
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
		IO io = new IO();
		InputStream is = io.getFileFromResourceAsStream(GUIConstants.TEAM_NAME_PATH);
		String[] namesList = io.getString(is).split(",");
		
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
    	
    	this.logoPath = GUIConstants.LOGO_PATH + portrait + ".png";
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
     * @return number of wins
     */
    public int getWins() {
		return wins;
	}

	/**
	 * Adds a single Win to the Team
	 */
	public void addWin() {
		this.wins++;
	}

	/**
	 * Gets the Team Losses
	 * 
	 * @return number of losses
	 */
	public int getLosses() {
		return losses;
	}

	/**
	 * Adds a loss to the players team
	 */
	public void addLoss() {
		this.losses++;
	}

}
