package main.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import main.gui.GUIConstants;
import main.model.Team.Role;

/**
 * Represents the characters in the game.
 * 
 * @author Blake and Jun
 *
 */
public final class Athlete extends Purchasable {
	
	/** 
	 * Static property storing unused portrait indexes
	 */
	private static List<Integer> availablePortraits = IntStream.range(0, GUIConstants.PORTRAIT_COUNT).boxed().collect(Collectors.toCollection(ArrayList::new));
	
	/**
	 * Maximum stamina
	 * 0 = Injured
	 * 1 = Questionable
	 * 2 = Optimal
	 */
	private static int MAX_STAMINA = 2;
	public static String[] STAMINA_LEVELS = new String[] {
			"\"Get me out\"", 
			"\"Meh\"",
			"Optimal"};
	
	private String name;
	
	private int reactionTime;
    private int eyeSight;
    private int intelligence;
    private int stamina = MAX_STAMINA;
    
    private Role role;


	/**
     * Constructor for creating Athlete with scaling skill level
     * 
     * @param currentWeek		current week
     */
    public Athlete(int currentWeek) {
    	setName(getRandomName());
    	setPortrait();
    	generateAthleteStats(currentWeek);
    }
    
    /**
     * Picks a random name from a list
     * 
     * @return Random Name
     */
    public String getRandomName() {
    	
    	//Grabs a list of names
    	String[] namesList = null;
		try {
			namesList = IO.getTextFromFile("src/main/Resources/Names");
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
     * Sets portrait path for athlete and prevents reuse unless there are no remaining portraits
     */
    private void setPortrait() {
    	if (availablePortraits.size() == 0) {
    		availablePortraits = IntStream.range(0, GUIConstants.PORTRAIT_COUNT).boxed().collect(Collectors.toCollection(ArrayList::new));
    	}
    	Random random = new Random();
    	int index = random.nextInt(availablePortraits.size());
    	int portrait = availablePortraits.get(index);
    	availablePortraits.remove(index);
    	
    	this.portraitPath = "/main/Resources/athletePortraits/portrait_clear_" + portrait + ".png";
    }
    
    /**
     * Generates the athelete's skills and also gives an athlete one special skill
     * 
     * @param currentWeek 		current week
     */
    public void generateAthleteStats(int currentWeek) {
    	int base = 20;
    	int cap = 80;
    	int perWeek = (cap - base) / 15;
    	int current = currentWeek == 0 ? perWeek : perWeek * currentWeek;
    	
    	Random random = new Random();
    	this.reactionTime = Math.min(base + (int) random.nextGaussian(current, current / 3), cap);
    	this.eyeSight = Math.min(base + (int) random.nextGaussian(current, current / 3), cap);
    	this.intelligence = Math.min(base + (int) random.nextGaussian(current, current / 3), cap);
    	
    	
    	// Sets stats to favour a particular combination
    	int combination = random.nextInt(3);
    	int primarySkill = random.nextInt(2);
    	switch (combination) {
	        case 0:
	        	this.reactionTime *= primarySkill == 0 ? 1 : 1.25;
	        	this.eyeSight *= primarySkill == 0 ? 1.25 : 1;
	        	this.intelligence /= 1.5;
	            break;
	        case 1:
	        	this.reactionTime /= 1.5;
	        	this.eyeSight *= primarySkill == 0 ? 1 : 1.25;
	        	this.intelligence *= primarySkill == 0 ? 1.25 : 1;
	            break;
	        case 2:
	        	this.reactionTime *= primarySkill == 0 ? 1 : 1.25;
	        	this.eyeSight /= 1.5;
	        	this.intelligence *= primarySkill == 0 ? 1.25 : 1;
	            break;
	        default:
	        	 break;
    	}
    }

	/**
     * Calculates the Athletes Skill Level based on the Athletes stats
     * 
     * @return Athletes Skill Level
     */
    public int calculateSkillLevel() {    	
        return getEyeSight() + getIntelligence() + getReactionTime();
    }
    
    /**
     * Calculates base purchase price before difficulty scaling
     * 
     * @return Athlete contract price
     */
    public int getBasePrice() {
    	// implement some value calculation based on stats
    	
    	return calculateSkillLevel() * 5;
    }   
    

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the reactionTime
	 */
	public int getReactionTime() {
		return reactionTime;
	}

	/**
	 * @param reactionTime the reactionTime to set
	 */
	public void setReactionTime(int reactionTime) {
		this.reactionTime = reactionTime;
	}

	/**
	 * @return the eyeSight
	 */
	public int getEyeSight() {
		return eyeSight;
	}

	/**
	 * @param eyeSight the eyeSight to set
	 */
	public void setEyeSight(int eyeSight) {
		this.eyeSight = eyeSight;
	}

	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	/**
	 * @return the stamina
	 */
	public int getStamina() {
		return stamina;
	}

	/**
	 * @param stamina the stamina to set
	 */
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	/**
	 * Resets stamina every week
	 */
	public void resetStamina() {
		this.stamina = MAX_STAMINA;
	}
	
    /**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
