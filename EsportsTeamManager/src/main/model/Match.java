package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.model.GameData.Difficulty;
import main.model.Team.Role;

public class Match {

    private Difficulty difficulty;
    private int rewardMoney;
    private List<IngameCharacters> homeTeam;
    private List<IngameCharacters> opponentTeam;
    
    private Match(GameData gameData, Team opponents) {
    	
    	this.difficulty = gameData.getDifficulty();
    	calculateRewards(difficulty.getModifier());
    	
    	homeTeam = new ArrayList<IngameCharacters>();
    	opponentTeam = new ArrayList<IngameCharacters>();
    	
    	createIngameCharacters(gameData.getTeam(), opponents);
    	
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
    private void createIngameCharacters(Team home, Team opponents) {
    	
    	//Gets the players Team Members
    	for (Map.Entry<Role, Athlete> entry : home.getTeamMembers().entrySet()) {
    		//Gets the Athlete and Role from the team
    	    Role role = entry.getKey();
    	    Athlete athlete = entry.getValue();
    	    
    	    //Create a new ingame character for each Athlete and adds to the matches homeTeam list
    	    homeTeam.add(new IngameCharacters(athlete, role));
    	}
    	
    	//Gets the players Team Members
    	for (Map.Entry<Role, Athlete> entry : opponents.getTeamMembers().entrySet()) {
    		//Gets the Athlete and Role from the team
    	    Role role = entry.getKey();
    	    Athlete athlete = entry.getValue();
    	    
    	    //Create a new ingame character for each Athlete and adds to the matches awayTeam list
    	    opponentTeam.add(new IngameCharacters(athlete, role));
    	}
 
    	
    }
    
    /**
     * Starts the match by determining who goes first based on reaction time
     */
    public void startMatch() {

        
        //Determines what team goes first
        if (getHighestSkillAthlete(homeTeam, "ReactionTime").getReactionTime() > getHighestSkillAthlete(opponentTeam, "ReactionTime").getReactionTime()) {
        	simulateMatch(homeTeam, opponentTeam);
        } else {
        	simulateMatch(opponentTeam, homeTeam);
        }


    }
    
    /**
     * 
     * Simulates combat in a turn based style 
     * 
     * @param fastTeam
     * @param slowTeam
     */
    private void simulateMatch(List<IngameCharacters> fastTeam, List<IngameCharacters> slowTeam) {
    	
        // total number of turn based rounds in a match
        int totalRounds = 10;
    	
        // Loop over the turn based rounds
        for (int round = 0; round < totalRounds; round++) {
            // Iterate over each athlete in the home team and have them perform an action
            for (IngameCharacters character : fastTeam) {
                // The target is determined by the aggro levels of the opposing team
            	IngameCharacters target = getHighestSkillAthlete(slowTeam, "Aggro");  
                action(character, target);
            }
            
            // Iterate over each athlete in the opponent team and have them perform an action
            for (IngameCharacters character : slowTeam) {
                // The target is determined by the aggro levels of the opposing team
            	IngameCharacters target = getHighestSkillAthlete(fastTeam, "Aggro");  
                action(character, target);
            }
            
            // Check if all athletes on a team are out of health. If so, the other team wins
            if (getTeamHealth(homeTeam) <= 0) {  
                return;
            } else if (getTeamHealth(opponentTeam) <= 0) {
                return;
            }
        }
    	
    }
    
    
    
    /**
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
     * @param currentCharacter
     * @param Target
     */
    private void action(IngameCharacters currentCharacter, IngameCharacters target) {
        Role role = currentCharacter.getRole();
        
        switch (role) {
            case OFFENSE:
                // Offense character attacks target
                int damage = currentCharacter.getIntelligence();
                if (damage > 0) {
                    int newHealth = target.getHealth() - damage;
                    //used the ternery operator hell yea
                    target.setHealth(newHealth > 0 ? newHealth : 0);
                }
                break;
           
            case SUPPORT:
                // Support character heals a teammate, buffs an ally's stats, or debuffs an opponent's stats
                for (IngameCharacters character : homeTeam) {
                    if (character.getHealth() < character.getRole().getHealth()) {
                        character.setHealth(character.getHealth() + currentCharacter.getIntelligence());
                    }
                }
                break;
            case TANK:
                
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
    private IngameCharacters getHighestSkillAthlete(List<IngameCharacters> characters, String skill) {
        IngameCharacters highestSkillCharacter = null;
        
        switch (skill) {
	        case "Aggro":
	        	//Finds the character with the highest Aggro in the team
	            for (IngameCharacters character : characters) {
	                if (character.getHealth() > 0) {
	                    if (highestSkillCharacter == null || character.getAggroLevel() > highestSkillCharacter.getAggroLevel()) {
	                    	highestSkillCharacter = character;
	                    }
	                }
	            }
	            break;
	       
	        case "ReactionTime":
	        	//Finds the character with the highest Reaction Time in the team
	            for (IngameCharacters character : characters) {
	                if (character.getHealth() > 0) {
	                    if (highestSkillCharacter == null || character.getReactionTime() > highestSkillCharacter.getReactionTime()) {
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
    private int getTeamHealth(List<IngameCharacters> characters) {
    	int totalHealth = 0;
    	for (IngameCharacters character : characters) {
    		totalHealth += character.getHealth();
    	}
    	return totalHealth;
    }
    

    
    





	
}
