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
	
	private String name;
	
	private int reactionTime;
    private int eyeSight;
    private int intelligence;
    private int stamina;
    
    private Role role;


	/**
     * Constructor for creating Athlete with scaling skill level
     * 
     * @param skillLevel	skill level of athlete
     */
    public Athlete(int skillLevel) {
    	setName(getRandomName());
    	setPortrait();
    	generateAthleteStats(skillLevel);
    	
    	// not sure this is needed anymore
    	setDescription();
    }
    
    /**
     * Picks a random name from an inputed name list
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
     * Generates the athelets skills and also gives an athlete one special skill
     * 
     * @param defaultSkillNumber int which sill numbers are generated around
     */
    public void generateAthleteStats(int defaultSkillNumber) {
    	
    	Random random = new Random();
    	
    	//Average amount of skill level added to special skill
    	int specialSkillNumber = 2;
    	
    	//Adds some more randomness
    	double skillDeviation = random.nextInt(2);
    	
    	//Generate the Athletes skils 
    	this.reactionTime = (int) random.nextGaussian(defaultSkillNumber, skillDeviation);
    	this.eyeSight = (int) random.nextGaussian(defaultSkillNumber, skillDeviation);
    	this.intelligence = (int) random.nextGaussian(defaultSkillNumber, skillDeviation);
    	this.stamina = (int) random.nextGaussian(defaultSkillNumber, skillDeviation);
    	
    	//NEED TO ADD CHECK TO SEE IF ANY SKILLS ARE 0
    	
    	//Picks a skill to be the athletes special skill
    	int specialSkill = random.nextInt(4);
    	
    	//Adds 2-4 skill points to the special skill
    	switch (specialSkill) {
	        case 0:
	        	this.reactionTime += (int) random.nextGaussian(specialSkillNumber, 1);
	            break;
	        case 1:
	        	this.eyeSight += (int) random.nextGaussian(specialSkillNumber, 1);
	            break;
	        case 2:
	        	this.intelligence += (int) random.nextGaussian(specialSkillNumber, 1);
	            break;
	        case 3:
	        	this.stamina += (int) random.nextGaussian(specialSkillNumber, 1);
	            break;
            }
    }

	/**
     * Calculates the Athletes Skill Level based on the Athletes stats
     * 
     * @return Athletes Skill Level
     */
    public int calculateSkillLevel() {
    	// Still needs improvement ?
    	
        return getEyeSight() + getIntelligence() + getReactionTime() + getStamina();
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
	
    /**
     * Sets the athlete's description
     */
    public void setDescription() {
    	super.description = String.format(
    			"Reaction Time: %d<br>"
    			+ "Eyesight: %d<br>"
    			+ "Intelligence: %d<br>"
    			+ "Stamina: %d", 
    			reactionTime, eyeSight, intelligence, stamina);
    }
    
	@Override
    public String toString() {
    	return super.getDescription();
    }
}
