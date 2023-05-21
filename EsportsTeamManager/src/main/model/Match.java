package main.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import main.model.GameData.Difficulty;
import main.model.Team.Role;

/**
 * Handles matches between the players team and opponents team
 * 
 * @author Blake and Jun
 *
 */
public class Match {

    private Difficulty difficulty;
    private int rewardMoney;
    private List<IngameCharacters> homeTeam;
    private List<IngameCharacters> opponentTeam;
    private int homeTurn;
    private int opponentTurn;
    private int outcome;
    
    private int round;

    private List<String> roundResults;
    
    public Match(GameData gameData, Team opponent) {
    	this.homeTurn = 0;
    	this.round = 0;
    	this.outcome = -1;
    	this.opponentTurn = 0;
    	this.difficulty = gameData.getDifficulty();
    	calculateRewards(difficulty.getModifier());
    	
    	homeTeam = new ArrayList<IngameCharacters>();
    	opponentTeam = new ArrayList<IngameCharacters>();
    	roundResults = new ArrayList<String>();
    	
    	createIngameCharacters(gameData.getTeam(), opponent);
    	
    };
    
    public void calculateRewards(int difficulty) {
    	
    	
    }
    
    
	/**
	* roles - Defense = Shield points, Offense = attack points, Support = randomly heals/buffs/debuffs, and Tank = takes aggro of opponent team
	* reactionTime = chance of missing an attack/getting an attack
	* intelligence = boosts attack/defense/support power (Players understanding of thier character increases the ingame stats)
	* stamina = as the game goes on each players mental stamina goes down increasing the chance of missing attacks/getting hit
	* 
	* 
	* Each athlete can have an action during each round, and the number of rounds could be determined by the average stamina of the athletes or a fixed number.
	*Simulation of Rounds
	*For each round, iterate over each athlete in the teams. The order can be random or determined by a stat like reaction time or stamina.
	*At the beginning of each round, the stamina stat could affect the reactionTime stat, simulating the mental fatigue of the athletes.
	*Each round shield point regenerate 10% of the characters total shield points
	*
	*Athlete Actions
	*Each athlete will take an action depending on their role:
	*
	*Offense: Their target is determined by the aggro levels of the opposing team. They attack and deal damage based on their intelligence and the opponent's shield points and reaction time. If the attack hits, reduce the target's health points.
	*
	*Defense: They add shield points to their team based on their intelligence. The shield points decrease whenever a teammate is attacked.
	*
	*Support: They can heal a teammate, buff an ally's stats, or debuff an opponent's stats. The choice can be random or based on the current state of the match.
	*
	*Tank: They have the highest aggro level, making them more likely to be the target of attacks. Their attack will be less powerful, but they have more health points
	*
	*Stamina Decrease
	*After each action, reduce the athlete's stamina. This reduces their attack power, shield points, healing power  in the next rounds.
	*
	*Check End Conditions
	*At the end of each round, check if all athletes on a team are out of health. If so, the other team wins.
	*Repeat
	*If no end conditions are met, repeat the process for the next round.
	* 
	* 
	* 
	* 
	*/
    
    
    /**
     * 
     * Converts the Athletes into their virtual Characters 
     * 
     * @param home
     * @param opponents
     */
    public void createIngameCharacters(Team home, Team opponents) {
    	
    	
    	//Gets the players Team Members
    	for (Map.Entry<Role,  List<Athlete>> entry : home.getTeamMembers().entrySet()) {
    		//Gets the Athlete and Role from the team
    	    Role role = entry.getKey();
    	    
    	    for (Athlete athlete :  entry.getValue()) {
    	    	//Create a new ingame character for each Athlete and adds to the matches homeTeam list
        	    homeTeam.add(new IngameCharacters(athlete, role));
    	    }
    	    
    	    
    	}
    	
    	//Gets the players the Opponent Team 
    	for (Map.Entry<Role, List<Athlete>> entry : opponents.getTeamMembers().entrySet()) {
    		//Gets the Athlete and Role from the team
    	    Role role = entry.getKey();
    	    
    	    for (Athlete athlete :  entry.getValue()) {
    	    	//Create a new ingame character for each Athlete and adds to the matches homeTeam list
    	    	opponentTeam.add(new IngameCharacters(athlete, role));
    	    }
    	    
    	}
    	
    	homeTeam.sort(Comparator.comparing(IngameCharacters::getReactionTime).reversed());
    	opponentTeam.sort(Comparator.comparing(IngameCharacters::getReactionTime).reversed());
    	
    }
    

    /**
     * Simulates one player chracter vs an opponent character, every time this function is called the 
     * team battle progresses until a team wins
     * @return <CODE>int</CODE> Returns -1 if game is still going | 0 If player losses | 1 if player wins. 
     */
    public void simulateMatchup() {
     	roundResults.clear();
    	
    	//Checks if all chracters have played their round, If so loop back to first character
    	if (homeTurn > homeTeam.size()-1) {
    		homeTurn = 0;
    	}
    	
    	if (opponentTurn > opponentTeam.size()-1) {
    		opponentTurn = 0;
    	}
    	
    	
    	
    	//Both teams are already sorted from highest reaction time to lowest
    	//each round increment through the list of quickest chracters to the slowest
    	IngameCharacters homePlayer = homeTeam.get(homeTurn);
    	IngameCharacters opponentPlayer = opponentTeam.get(opponentTurn);
    	
        //Determines the highest reaction time of both team characters to dermine who goes first
        if (homePlayer.getReactionTime() > opponentPlayer.getReactionTime()) {
        	//Home Team player was quicker, Will now pick opponent target with the highest aggro
            action(homePlayer, getHighestSkillAthlete(opponentTeam, "Aggro"));
            action(opponentPlayer, getHighestSkillAthlete(homeTeam, "Aggro"));
            
            //Testing
            //roundResults.add("Home Wins Round " +round+" |H Health: "+getTeamHealth(homeTeam)+" |O Health: "+getTeamHealth(opponentTeam));
            recordRoundResults(homePlayer, opponentPlayer);
        } else {
        	//Opponent Team player was quicker, Will now pick opponent target with the highest aggro
            action(opponentPlayer, getHighestSkillAthlete(homeTeam, "Aggro"));
            action(homePlayer, getHighestSkillAthlete(opponentTeam, "Aggro"));
            
            //Testing
           // roundResults.add("Opponent Wins Round "+round+" |H Health: "+getTeamHealth(homeTeam)+" |O Health: "+getTeamHealth(opponentTeam));
        }
        
    	//Increments to the next matchup of characters
    	this.round++;
    	
    	this.homeTurn++;
    	this.opponentTurn++;
    	
    	if (homePlayer.getHealth() <= 0) {
    		homeTeam.remove(homePlayer);
    	} else if (opponentPlayer.getHealth() <= 0) {
    		opponentTeam.remove(opponentPlayer);
    	}
    	
    	

        
        // Check if all athletes on a team are out of health. If so, the other team wins
        if (getTeamHealth(homeTeam) <= 0) {  
        	this.outcome = 0;
        } else if (getTeamHealth(opponentTeam) <= 0) {
        	this.outcome = 1;
        }
        
        //No winner has been determined yet
        this.outcome = -1;
    	  	
    }
    
    private void recordRoundResults(IngameCharacters home, IngameCharacters opponent) {
    	
    	
    }
    
    

	/**
     * 
     *Athlete Actions
	 *Each athlete will take an action depending on their role:
	 *
	 *Offense: Their target is determined by the aggro levels of the opposing team. They attack and deal damage based on their intelligence. If the attack hits, reduce the target's health points.
	 *
	 *Support: They can heal a teammate, buff an ally's stats, or debuff an opponent's stats. The choice can be random or based on the current state of the match.
	 *
	 *Tank: They have the highest aggro level, making them more likely to be the target of attacks. Their attack will be less powerful, but they have more health points
     * @param currentCharacter
     * @param Target
     */
    public void action(IngameCharacters currentCharacter, IngameCharacters target) {
        Role role = currentCharacter.getRole();
        int damage = 0;
        int newHealth = 0;
        switch (role) {
            case OFFENSE:
                // Offense character attacks target
            	System.out.println("Offense Activate");
                damage = currentCharacter.getIntelligence()+ currentCharacter.getDamage();
                newHealth = target.getHealth() - damage;
                target.setHealth(newHealth > 0 ? newHealth : 0);
                    
                
                break;
           
            case SUPPORT:
            	
            	
            	
                // Support character heals a teammate, buffs an ally's stats, or debuffs an opponent's stats
//                for (IngameCharacters character : homeTeam) {
//                    if (character.getHealth() < character.getRole().getHealth()) {
//                        character.setHealth(character.getHealth() + currentCharacter.getIntelligence());
//                    }
//                }
            	System.out.println("Support Activate");
                damage = currentCharacter.getIntelligence()+ currentCharacter.getDamage();
                
                newHealth = target.getHealth() - damage;
                target.setHealth(newHealth > 0 ? newHealth : 0);
            
                break;
            case TANK:
            	System.out.println("Tank Activate");

                damage = currentCharacter.getIntelligence()+ currentCharacter.getDamage();
                newHealth = target.getHealth() - damage;
                target.setHealth(newHealth > 0 ? newHealth : 0);
                
                break;
            default:
                // No action for an unknown role
                break;
        }

        // Reduce athlete's stamina after each action
        currentCharacter.setStamina(currentCharacter.getStamina() - 1);
    }

    
    /**
     * Returns the character with the highest skill number of a specified skill
     * 
     * @param Lists of Characters
     * @return Character with the highest Aggro that is still alive
     */
    public IngameCharacters getHighestSkillAthlete(List<IngameCharacters> characters, String skill) {
        IngameCharacters highestSkillCharacter = characters.get(0);
        
        switch (skill) {
	        case "Aggro":
	        	//Finds the character with the highest Aggro in the team
	            for (IngameCharacters character : characters) {
	                if (character.getHealth() > 0) {
	                	
	                	//Agrro Levels go like 1>2>3>4
	                    if (character.getAggroLevel() < highestSkillCharacter.getAggroLevel()) {
	                    	highestSkillCharacter = character;
	                    }
	                }
	            }
	            break;
	       
	        case "ReactionTime":
	        	//Finds the character with the highest Reaction Time in the team
	            for (IngameCharacters character : characters) {
	                if (character.getHealth() > 0) {
	                    if (character.getReactionTime() > highestSkillCharacter.getReactionTime()) {
	                    	highestSkillCharacter = character;
	                    }
	                }
	            }
	            break;
	        default:
	            // No search for an unknown skill
	            break;
            }
        
        return highestSkillCharacter;
    }
    
    
    /**
     * Gets the total health left in the team
     * 
     * @param IngameCharacters Team List
     * @return Total health of the team
     */
    public int getTeamHealth(List<IngameCharacters> characters) {
    	int totalHealth = 0;
    	for (IngameCharacters character : characters) {
    		totalHealth += character.getHealth();
    	}
    	return totalHealth;
    }

	/**
	 * @return the homeTeam
	 */
	public List<IngameCharacters> getHomeTeam() {
		return homeTeam;
	}

	/**
	 * @return the opponentTeam
	 */
	public List<IngameCharacters> getOpponentTeam() {
		return opponentTeam;
	}
	
    /**
	 * @return the roundResults
	 */
	public List<String> getRoundResults() {
		return roundResults;
	}

	/**
	 * @return the outcome
	 */
	public int getOutcome() {
		return outcome;
	}

	/**
	 * @return the homeTurn
	 */
	public int getHomeTurn() {
		return homeTurn;
	}

	/**
	 * @return the opponentTurn
	 */
	public int getOpponentTurn() {
		return opponentTurn;
	}
	
	
	
	
	
}
