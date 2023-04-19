package main;

import java.io.IOException;
import java.util.Random;

import main.GameEnvironment.Difficulty;

/**
 * 
 * testing commit to local branch
 *
 */
public class Athlete extends Purchasable {
   
	private String name;
	private int reactionTime;
    private int eyeSight;
    private int intelligence;
    
    private AthleteRole role;
    private boolean isReserve;
    
    
    public enum AthleteRole {
    	AthleteRole,
    	SUPPORT,
    	DPS,
    	TANK,
    	HEALER,
    	NONE,
    	Blank
    }
    
    /**
     * Contructor for creating default Athlete
     * 
     * @param isReserve
     */
    public Athlete(boolean isReserve) {
    	this.role = AthleteRole.NONE;
    	name = getRandomName();
    	
    	this.isReserve = isReserve;
    	
    	//Generates the athelets stats around the inputed value
    	generateAthleteStats(3);
    	
    	setDescription();

    }
    
    /**
     * Contructor for creating Athlete with a define skill level
     * 
     * @param isReserve
     */
    public Athlete(boolean isReserve, int skillLevel) {
    	this.role = AthleteRole.NONE;
    	name = getRandomName();
    	
    	this.isReserve = isReserve;
    	
    	//Generates the athelets stats around the inputed value
    	generateAthleteStats(skillLevel);
    	
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
     * Generates the athelets skills and also gives an athlete one special skill
     * 
     * @param Int which sill numbers are generated around
     */
    public void generateAthleteStats(int defaultSkillNumber) {
    	
    	Random random = new Random();
    	
    	//Adds some more randomness
    	double skillDeviation = random.nextInt(2);
    	
    	//Generate the Athletes skils 
    	this.reactionTime = (int) random.nextGaussian(defaultSkillNumber, skillDeviation);
    	this.eyeSight = (int) random.nextGaussian(defaultSkillNumber, skillDeviation);
    	this.intelligence = (int) random.nextGaussian(defaultSkillNumber, skillDeviation);
    	
    	//Picks a skill to be the athletes special skill
    	int specialSkill = random.nextInt(3);
    	
    	//Adds 2-4 skill points to the special skill
    	switch (specialSkill) {
	        case 0:
	        	this.reactionTime += (int) random.nextGaussian(3, 1);
	            break;
	        case 1:
	        	this.eyeSight += (int) random.nextGaussian(3, 1);
	            break;
	        case 2:
	        	this.intelligence += (int) random.nextGaussian(3, 1);
	            break;
            }
    }
    
    
	/**
     * Calculates the Athletes Skill Level based on the Athletes stats
     * 
     * @return Athletes Skill Level
     */
    public int calculateSkillLevel() {
    	//Still needs improvment
        return getEyeSight() + getIntelligence() + getReactionTime();
    }
    
    
    /**
     * Calculates contract price based on the GameEnvironments difficulty level
     * 
     * @param Game Settings
     * @return Athlete Contract Price
     */
    public void setPurchasePrice(Difficulty difficulty) {
    	
    	int price = 0;
    	
    	switch(difficulty) {
        case EASY:
        	price = 100;
            break;
//        case MEDIUM:
//        	price = 500;
//            break;
        case HARD:
        	price = 1000;
            break;
        }
    	
    	super.purchasePrice = price * calculateSkillLevel();
    }
    
    
    
    /**
     * Sets the athletes description
     * @return 
     */
    public void setDescription() {
    	 super.description = String.format("Name: %s \nReaction Time: %d \nEye Sight: %d \nIntelligence", name, reactionTime, intelligence);
    }

    
    @Override
    public String toString() {
    	return super.description;
    }
    
    /********** Simple Getters & Setters **********/
    
	
	public String getName() {
		return name;
	}
	
	public int getReactionTime() {
		return reactionTime;
	}
	
	public int getEyeSight() {
		return eyeSight;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public AthleteRole getRole() {
		return role;
	}
	
	public boolean isReserve() {
		return isReserve;
	}
	
    public void setReserve(boolean isReserve) {
		this.isReserve = isReserve;
	}

	/********** Simple Getters & Setters **********/

}
