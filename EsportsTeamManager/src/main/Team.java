package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team {
	
    private String name;
    private List<Athlete> teamMembers;
    private List<Athlete> reserveMembers;
    private int wins;
    private int losses;
    
	/**
	 * Regex pattern for team name validation
	 */
	private static final String VALID_NAME_PATTERN = "[ a-zA-Z0-9]{3,15}";
	
    /**
     * Constructor for the players Team
     * 
     * @param name
     * @param difficulty
     */
    public Team() {
    	this.name = getRandomTeamName();
    	this.wins = 0;
    	this.losses = 0;
    	this.teamMembers = new ArrayList<Athlete>();
    	this.reserveMembers = new ArrayList<Athlete>();
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
    	return name.matches(Team.VALID_NAME_PATTERN);
    }
    
    /**
     * Adds the inputed Athlete to the Team
     * 
     * @param athlete
     */
    public void addAthlete(Athlete athlete) {
    	if (athlete.isReserve()) {
    		reserveMembers.add(athlete);
    	}
    	else {
    		teamMembers.add(athlete);
    	}
    }

    /**
     * Removes the inputed Athlete from the Team
     * 
     * @param athlete
     */
    public void removeAthlete(Athlete athlete) {
    	
    	//Checks which team list the inputed athlete is in and remove it
    	if (teamMembers.contains(athlete)) {
    		teamMembers.remove(athlete);
    	} 
    	else if (reserveMembers.contains(athlete)) {
    		reserveMembers.remove(athlete);
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
     * Generates a random team full of Athletes
     * 
     * @return Randomly Generated Team
     */
    public ArrayList<Athlete> generateTeam(boolean isReserve) {
    	
    	ArrayList<Athlete> generatedTeam = new ArrayList<Athlete>();
    	
    	for (int teamRosterLimit = 5; teamRosterLimit > 0; teamRosterLimit--) {
    		
//    		Athlete randomAthlete = new Athlete(isReserve);
//    		generatedTeam.add(randomAthlete);
    	}
    	
    	return generatedTeam;
    }
    
    /********** Simple Getters & Setters **********/
    
    /**
     * Gets the Team Wins
     * @return
     */
    public int getWins() {
		return wins;
	}

	/**
	 * Adds a single Win to the Team
	 * @param wins
	 */
	public void addWin(int wins) {
		this.wins++;
	}

	/**
	 * Gets the Team Losses
	 * @return
	 */
	public int getLosses() {
		return losses;
	}

	/**
	 * @param losses
	 */
	public void addLoss(int losses) {
		this.losses++;
	}

	/**
	 * Gets the Team main Athletes
	 * @return
	 */
	public List<Athlete> getTeamMembers() {
		return teamMembers;
	}

	/**
	 * Gets the Team reserve Athletes
	 * @return
	 */
	public List<Athlete> getReserveMembers() {
		return reserveMembers;
	}

	/**
	 * Sets the main Team members
	 * @param teamMembers
	 */
	public void setTeamMembers(List<Athlete> teamMembers) {
		this.teamMembers = teamMembers;
	}

	/**
	 * Sets the Team reserve members
	 * @param reserveMembers
	 */
	public void setReserveMembers(List<Athlete> reserveMembers) {
		this.reserveMembers = reserveMembers;
	}

	/**
	 * Gets the name of the Team
	 * @return
	 */
	public String getName() {
		return name;
	}
    
	/********** Simple Getters & Setters **********/
	
    @Override
    public String toString() {
    	
    	String teamDescription = String.format("Team Name: %s \nWins: %d \nLosses: %d \n", name, wins, losses);
    	
    	teamDescription += "***** Main Team Players *****\n";
    	
    	//Adds main athletes to the to the teamDescription
    	for (Athlete athlete: teamMembers) {
    		teamDescription += "\n" + athlete.toString() + "\n";
    	}
    	
    	teamDescription += "***** Main Team Players *****\n";
    	
    	//Adds reserve athletes to the to the teamDescription
    	for (Athlete athlete: reserveMembers) {
    		teamDescription += "\n" + athlete.toString() + "\n";
    	}
 
    	return teamDescription;
    }
}
