package main.model;

import java.util.ArrayList;
import java.util.Arrays;
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
public final class Match {

    private Difficulty difficulty;
    private int rewardMoney;
    private int outcome;
    
    private List<IngameCharacters> homeTeam;
    private List<IngameCharacters> opponentTeam;
    
    private int homeTurn;
    private int opponentTurn;

    private String homeResults;
    private String opponentResults;
    
	IngameCharacters homePlayer;
	IngameCharacters opponentPlayer;
    
    public Match(GameData gameData, Team opponent) {
    	this.homeTurn = 0;
    	this.opponentTurn = 0;
    	
    	this.outcome = -1;
    	
    	this.difficulty = gameData.getDifficulty();
    	calculateRewards(difficulty.getModifier());
    	
    	homeTeam = new ArrayList<IngameCharacters>();
    	opponentTeam = new ArrayList<IngameCharacters>();
    	homeResults = "";
    	opponentResults = "";
    	
    	createIngameCharacters(gameData.getTeam(), opponent);
    	
    };
    
    /**
     * For unit tests
     * @param gameData
     * @param home
     * @param opponent
     */
    public Match(GameData gameData,  Team home, Team opponent) {
    	this.homeTurn = 0;
    	this.opponentTurn = 0;
    	
    	this.outcome = -1;
    	
    	this.difficulty = gameData.getDifficulty();
    	calculateRewards(difficulty.getModifier());
    	
    	homeTeam = new ArrayList<IngameCharacters>();
    	opponentTeam = new ArrayList<IngameCharacters>();
    	homeResults = "";
    	opponentResults = "";
    	
    	createIngameCharacters(home, opponent);
    	
    };
    
    
    
    
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
     	turnCheck();

    	
    	//Both teams are already sorted from highest reaction time to lowest
    	//each round increment through the list of quickest chracters to the slowest
    	homePlayer = homeTeam.get(homeTurn);
    	opponentPlayer = opponentTeam.get(opponentTurn);
    	
    	//If a character is dead skip them
    	if (homePlayer.getHealth() <= 0) {
    		this.homeTurn++;
    		turnCheck();
    		homePlayer = homeTeam.get(homeTurn);
        	opponentPlayer = opponentTeam.get(opponentTurn);
    	} else if (opponentPlayer.getHealth() <= 0) {
    		this.opponentTurn++;
    		turnCheck();
    		homePlayer = homeTeam.get(homeTurn);
        	opponentPlayer = opponentTeam.get(opponentTurn);
    	}
    	
        //Determines the highest reaction time of both team characters to dermine who goes first
        if (homePlayer.getReactionTime() >= opponentPlayer.getReactionTime()) {
        	//Home Team player was quicker, Will now pick opponent target with the highest aggro
            action(homePlayer, getHighestAggrolAthlete(opponentTeam));
            action(opponentPlayer, getHighestAggrolAthlete(homeTeam));
            
        } else {
        	//Opponent Team player was quicker, Will now pick opponent target with the highest aggro
            action(opponentPlayer, getHighestAggrolAthlete(homeTeam));
            action(homePlayer, getHighestAggrolAthlete(opponentTeam));
        }
        
    	//Increments to the next matchup of characters
    	this.homeTurn++;
    	this.opponentTurn++;


        // Check if all athletes on a team are out of health. If so, the other team wins
        if (getTeamHealth(homeTeam) <= 0) {  
        	this.outcome = 0;
        } else if (getTeamHealth(opponentTeam) <= 0) {
        	this.outcome = 1;
        }
        
        //No winner has been determined yet
        this.outcome = -1;
    	  	
    }
    
    /**
     * Records the moves played by the ingame characters
     * 
     * @param currentPlayer
     * @param target
     * @param damage
     * @param heals
     */
    private void recordRoundResults(IngameCharacters currentPlayer, IngameCharacters target , int damage, int support, boolean isTargetDead) {
    	
    	String currentPlayerName = currentPlayer.getName();
    	String targetName = target.getName();
    	String results = "";
    	
    	if (isTargetDead) {
    		results = String.format("%s has killed %s!", currentPlayerName, targetName, damage) ;
    	} else {
    		
    		if (support > 0) {
    			results = String.format("%s has buffed %s for %d damage!", currentPlayerName, targetName, damage);
    		} else {
    			results = String.format("%s has attacked %s for %d damage!", currentPlayerName, targetName, damage);
    		}
    		
    	}
    	
    	
    	if (homeTeam.contains(currentPlayer)) {
        	homeResults = results;
        	
    	} else {
    		opponentResults = results;
    	}
    	
    	
    	
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
                damage = currentCharacter.getIntelligence() + currentCharacter.getDamage();
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
                damage = currentCharacter.getIntelligence()+ currentCharacter.getDamage();
                newHealth = target.getHealth() - damage;
                target.setHealth(newHealth > 0 ? newHealth : 0);
                break;
                
            case TANK:
                damage = currentCharacter.getIntelligence()+ currentCharacter.getDamage();
                newHealth = target.getHealth() - damage;
                target.setHealth(newHealth > 0 ? newHealth : 0);
                
                break;
            default:
                // No action for an unknown role
                break;
                }
        
        //Record results of round
        if (target.getHealth() == 0) {
        	//Target has been killed
        	playerDied(target);
        	recordRoundResults(currentCharacter, target, damage ,0, true);
        	removeCharacter(target);
        	
        } else {
        	recordRoundResults(currentCharacter, target, damage ,0, false);
        }
        

        // Reduce athlete's stamina after each action
        currentCharacter.setStamina(currentCharacter.getStamina() - 1);
    }
    
    /**
     * Checks to see if player/opponents turns are still within bounds
     */
    private void turnCheck() {
    	
    	//Checks if all chracters have played their round, If so loop back to first character
    	if (homeTurn == homeTeam.size() - 1) {
    		homeTurn = 0;
    	}
    	
    	if (opponentTurn == opponentTeam.size() - 1) {
    		opponentTurn = 0;
    	}
    	
    }
    
    private void playerDied(IngameCharacters killedPlayer) {
    	if (killedPlayer == homePlayer) {
        	this.homeTurn++;
        	turnCheck();
    		homePlayer = homeTeam.get(homeTurn);
        	
    		
    	} else if (killedPlayer == opponentPlayer) {
    		this.opponentTurn++;
    		turnCheck();
    		opponentPlayer = opponentTeam.get(opponentTurn);
    	}
    }
    
    /**
     * Calculates rewards for winning a game
     * 
     * @param modifier
     * @return
     */
    public int calculateRewards(int modifier) {
    	
    	return 250 * modifier;
    }

    
    /**
     * Returns the character with the highest Aggro number of a specified skill
     * 
     * @param Lists of Characters
     * @return Character with the highest Aggro that is still alive
     */
    public IngameCharacters getHighestAggrolAthlete(List<IngameCharacters> characters) {
        IngameCharacters highestAggroCharacter = characters.get(0);
    	//Finds the character with the highest Aggro in the team
        for (IngameCharacters character : characters) {
            if (character.getHealth() > 0) {
            	
            	//Agrro Levels go like 1>2>3>4
                if (character.getAggroLevel() < highestAggroCharacter.getAggroLevel()) {
                	highestAggroCharacter = character;
                }
            }
        }
        
        return highestAggroCharacter;
    }
    
    private void removeCharacter(IngameCharacters killedPlayer) {
    	if (killedPlayer == homePlayer) {
        	homeTeam.remove(killedPlayer);
        	
    		
    	} else if (killedPlayer == opponentPlayer) {
    		opponentTeam.remove(killedPlayer);
    	}
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
		return Arrays.asList(homeResults, opponentResults);
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
