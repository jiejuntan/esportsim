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
    private HashMap<Role, Athlete> members;
    
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
	private static final int TEAM_LIMIT = 5;
	
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
    	
    	//Role(Health, Damage, Aggro Priority)
    	OFFENSE(50, 100, 2),
    	SUPPORT(25, 0, 3),
    	SUPPORTT(25, 0, 3),
    	TANK(100, 50, 1);
    	
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
    	this.members = new HashMap<Role, Athlete>();
    	this.reserveMembers = new ArrayList<Athlete>();
    	
    	this.wins = 0;
    	this.losses = 0;
    }

    

	/**
	 * Constructor for Opponent/Test Team Generation
	 * 
	 * @param skillLevel
	 */
	public Team(int skillLevel) {
    	this.name = getRandomTeamName();
    	this.wins = 0;
    	this.losses = 0;
    	this.members = new HashMap<Role, Athlete>();
    	this.reserveMembers = new ArrayList<Athlete>();
    	
    	generateTeam(skillLevel);
    	
    }
    
    
    /**
     * Adds an Athlete to the team as a reserve
     * 
     * @param athlete					Athlete to add
     * @throws TeamMemberLimitException if reserves are full
     */
    public void addAthlete(Athlete athlete) throws TeamMemberLimitException {
    	if (reserveMembers.size() < TEAM_LIMIT) {
    		reserveMembers.add(athlete);
    	} else {
    		throw new TeamMemberLimitException();
    	}
    }


    
    /**
     * Removes an Athlete from the Team
     * 
     * @param athlete	Athlete to remove
     */
    public void removeAthlete(Athlete athlete) {
    	if (reserveMembers.contains(athlete)) {
    		reserveMembers.remove(athlete);
    	} else {
	    	members.entrySet().removeIf(
	    			entry -> 
	    			(entry.getValue().equals(athlete)));
    	}
    }

    
    /** 
     * Assigns an athlete to a role, swapping roles with the athlete in that role if one exists.
     * 
     * @param athlete	Athlete to assign
     * @param role		Role to assign to
     */
    public void assignRole(Athlete athlete, Role role) {
    	Athlete toReplace = members.get(role);
    	
    	if (reserveMembers.contains(athlete)) {
    		reserveMembers.remove(athlete);
    		members.put(role, athlete);
    		
    		if (toReplace != null) {
        		reserveMembers.add(toReplace);
        	}
    	} else {
    		for (Map.Entry<Role, Athlete> entry : members.entrySet()) {
        		if (Objects.equals(athlete, entry.getValue())) {
        			Role previousRole = entry.getKey();
        			members.remove(previousRole);
        			members.put(role, athlete);
        			
        			if (toReplace != null) {
                		members.put(previousRole, toReplace);
                	}
        		}
        	}
    	}
    }
    
    
    /**
     * Picks a random Team name from an inputed name list
     * 
     * @return Random Team Name
     */
    public String getRandomTeamName() {
    	
    	//Grabs a list of names
    	String[] namesList = null;
		try {
			namesList = IO.getTextFromFile("src/main/Resources/TeamNames");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		//Picks a random number
    	Random random = new Random();
        int randomNumber = random.nextInt(namesList.length);
        
        //Uses random number to pick a name out of the nameList
        return namesList[randomNumber];
    }
    
    
    /**
     * Sets team name if valid
     * 
     * @param name						name to set
     * @throws IllegalArgumentException	if name is invalid
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
     * @param name	team name to validate
     * @return 		<CODE>true</CODE> if team name is valid
     */
    private boolean isValidTeamName(String name) {
    	return name.matches(VALID_NAME_PATTERN);
    }


    /**
     * Generates a random team full of Athletes
     * 
     * @return Randomly Generated Team
     */
    public void generateTeam(int skillLevel) {
    	    	
    	for (int teamRosterLimit = 0; teamRosterLimit < 5; teamRosterLimit++) {
    		
   		Athlete randomAthlete = new Athlete(skillLevel);    		
   		try {
			addAthlete(randomAthlete);
		} catch (TeamMemberLimitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		}
    	

    }
    
    /********** Simple Getters & Setters **********/
    
    /**
     * Gets the Team Wins
     * @return <CODE>int</CODE> Wins
     */
    public int getWins() {
		return wins;
	}

	/**
	 * Adds a single Win to the Team
	 * @param <CODE>int</CODE> Wins
	 */
	public void addWin(int wins) {
		this.wins++;
	}

	/**
	 * Gets the Team Losses
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
	 * @return <CODE>HashMap<Role, Athlete></CODE> TeamMembers
	 */
	public HashMap<Role, Athlete> getTeamMembers() {
		return members;
	}

	/**
	 * Gets the Team reserve Athletes
	 * @return <CODE>List<Athlete></CODE> reserveMembers
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
	 * @return <CODE>String</CODE> of Team Name
	 */
	public String getName() {
		return name;
	}
    
	/********** Simple Getters and Setters **********/
	
    @Override
    public String toString() {
    	
    	String teamDescription = String.format("Team Name: %s \nWins: %d \nLosses: %d \n", name, wins, losses);
    	
    	teamDescription += "\n**** Starting Team *****\n";
    	
    	//Adds main athletes to the to the teamDescription
    	if (members.size() == 0) {
    		teamDescription += "\nNone\n";
    	} else {
    		for (Map.Entry<Role, Athlete> entry : members.entrySet()) {
        		Athlete athlete = entry.getValue();
        		teamDescription += "\n" + athlete.toString() + "\n";
        	}
    	}
    	
    	teamDescription += "\n***** Reserves *****\n";
    	
    	//Adds reserve athletes to the to the teamDescription
    	if (reserveMembers.size() == 0) {
    		teamDescription += "\nNone\n";
    	} else {
    		for (Athlete athlete: reserveMembers) {
        		teamDescription += "\n" + athlete.toString() + "\n";
        	}
    	}
    	
    	return teamDescription;
    }
}
