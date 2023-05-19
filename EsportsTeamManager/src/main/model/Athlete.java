package main.model;

import java.io.IOException;
import java.util.Random;

import main.gui.GUIConstants;

/**
 * Represents the characters in the game.
 * 
 * @author Blake and Jun
 *
 */
public class Athlete extends Purchasable {
	
	/**
	 * Regex pattern for athlete name validation
	 */
	private static final String VALID_NAME_PATTERN = "[ a-zA-Z]{3,10}";
	
	private String name;
	
	private int reactionTime;
    private int eyeSight;
    private int intelligence;
    private int stamina;
    
    private String portraitPath;
    

    /**
     * Constructor for creating Athlete with scaling skill level
     * 
     * @param skillLevel	skill level of athlete
     */
    public Athlete(int skillLevel) {
    	setName(getRandomName());
    	
    	generateAthleteStats(skillLevel);
    	
    	setDescription();
    	this.portraitPath = GUIConstants.PORTRAIT_PLACEHOLDER;
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
     * Sets team name if valid
     * 
     * @param name						name to set
     * @throws IllegalArgumentException	if name is invalid
     */
    public void changeName(String name) throws IllegalArgumentException {
    	if (isValidName(name)) {
    		this.name = name;
    	} else {
    		throw new IllegalArgumentException();
    	}
    }
    
    
    /**
     * Checks if athlete name matches pattern
     * 
     * @param name	name to validate
     * @return 		<CODE>true</CODE> if name is valid
     */
    private boolean isValidName(String name) {
    	return name.matches(VALID_NAME_PATTERN);
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



	/**
	 * @return the portraitPath
	 */
	public String getPortraitPath() {
		return portraitPath;
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
        



	
}
