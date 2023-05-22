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
    private int round;
    private int teamTurn;
    
    private int opponentWins;
    private int homeWins;
    

    private String homeResults;
    private String opponentResults;
    
    
    
    public Match(GameData gameData, Team opponent) {
    	this.round = 0;
    	this.outcome = -1;
    	
    	this.opponentWins = 0;
    	this.homeWins = 0;
    	
    	this.difficulty = gameData.getDifficulty();
    	calculateRewards(difficulty.getModifier());
    	
    	homeTeam = new ArrayList<IngameCharacters>();
    	opponentTeam = new ArrayList<IngameCharacters>();
    	homeResults = "";
    	opponentResults = "";
    	
    	createIngameCharacters(gameData.getTeam(), opponent);
    	
    	
    };
    
    
    // Win conditions
    //- other team looses all focus
    // team wins 2/3 rounds
    
    
    
    
    
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
     * Simulates a round between both teams
     */
    public void simulateRound() {
    	IngameCharacters homePlayer = homeTeam.get(0);
    	IngameCharacters opponentPlayer = opponentTeam.get(0);
    	
    	//Loops until all player of a team have been killed or all player in a team are out of stamina
    	do {
    		
    		//Sets the fatest character to go first  FUCK UP BALANCE SOMEHOW
//    		if (homePlayer.getReactionTime() >= opponentPlayer.getReactionTime()) {
//    			this.teamTurn = 0;
//    		} else {
//    			this.teamTurn = 1;
//    		}
    		
    		
    		
    		if (teamTurn % 2 == 0) {
    			
    			
    			//Player died select next opponent
    			if (!isPlayerAlive(homePlayer)) {
    				homePlayer = decideNextPlayer(homePlayer);
    			}
    			//Player goes first
    			action(homePlayer, getHighestAggrolAthlete(opponentTeam));
    			//Next players turn
    			homePlayer = decideNextPlayer(homePlayer);
    			System.out.println(homeResults);
    			

    		} else {

    			//Opponent died select next opponent
    			if (!isPlayerAlive(opponentPlayer)) {
    				opponentPlayer = decideNextPlayer(opponentPlayer);
    			}
    			
    			//Opponent now attacks
    			action(opponentPlayer, getHighestAggrolAthlete(homeTeam));
    			//Next players turn
    			opponentPlayer = decideNextPlayer(opponentPlayer);
    			System.out.println(opponentResults);
    		}
    		
    		
    		this.teamTurn++;
    		
    		
    		
    		
    		
    		
    		
//    		//Player with the fastest reaction time goes first
//    		if (homePlayer.getReactionTime() >= opponentPlayer.getReactionTime()) {
//    			
//    			//Player died select next opponent
//    			if (!isPlayerAlive(homePlayer)) {
//    				homePlayer = decideNextPlayer(homePlayer);
//    			}
//    			//Player goes first
//    			action(homePlayer, getHighestAggrolAthlete(opponentTeam));
//    			System.out.println(homeResults);
//    			
//    			//Opponent died select next opponent
//    			if (!isPlayerAlive(opponentPlayer)) {
//    				opponentPlayer = decideNextPlayer(opponentPlayer);
//    			}
//    			
//    			//Opponent now attacks
//    			action(opponentPlayer, getHighestAggrolAthlete(homeTeam));
//    			System.out.println(opponentResults);
//    			
//    		} else {
//    			
//    			//Opponent died select next opponent
//    			if (!isPlayerAlive(opponentPlayer)) {
//    				opponentPlayer = decideNextPlayer(opponentPlayer);
//    			}
//    			//Opponent goes first
//    			action(opponentPlayer, getHighestAggrolAthlete(homeTeam));
//    			System.out.println(opponentResults);
//    			
//    			//player died select next player
//    			if (!isPlayerAlive(homePlayer)) {
//    				homePlayer = decideNextPlayer(homePlayer);
//    			}
//    			
//    			//Player attacks
//    			action(homePlayer, getHighestAggrolAthlete(opponentTeam));
//    			System.out.println(homeResults);
//    			
//    		
//    		}
////    		Change the players for the next matchup
//    		homePlayer = decideNextPlayer(homePlayer);
//    		opponentPlayer = decideNextPlayer(opponentPlayer);
//    		
    	} while(!isRoundOver());
    	

    	
    	//Checks to see if match over conditions are meet
    	if (isMatchOver() != -1) {
    		this.outcome = isMatchOver();
    	}

    }
    	
    
    /**
     * Checks Both teams health to see if end of round conditions are meet
     * Increases win count for team that won roound
     * @return <CODE>boolean</CODE> 
     */
    public boolean isRoundOver() {
    	
    	int playerTeamHealth = getTeamHealth(homeTeam);
    	int opponentTeamHealth = getTeamHealth(opponentTeam);
    	
    	//Check Health both teams health
    	//If a team has killed the other team, round over, reset everybodies health
    	//Increase wins
    	if (playerTeamHealth == 0 ) {
        	System.out.println("home: "+getTeamHealth(homeTeam));
        	System.out.println("Opponent: "+getTeamHealth(opponentTeam));

    		this.opponentWins++;
    		this.round++;
    		resetTeamsHealth();
    		return true;
    		
    	} else if (opponentTeamHealth == 0) {
        	System.out.println("home: "+getTeamHealth(homeTeam));
        	System.out.println("Opponent: "+getTeamHealth(opponentTeam));

    		this.homeWins++;
    		this.round++;
    		resetTeamsHealth();
    		return true;
    	}
    	
    	return false;
    	
    }
    
    /**
     * Checks to see if a team has won best of 3 rounds or if a teams stamina is depleted
     * 
     * @return <CODE>int</CODE> returns -1 if match not over , Returns 1 if homeTeam won, Returns 0 if opponentTeam won
     */
    public int isMatchOver() {
    	
    	int playerTeamStamina = getTeamStamina(homeTeam);
    	int opponentTeamStamina = getTeamStamina(opponentTeam);
    	int matchSatus = -1;
    	
//    	if (playerTeamStamina == 0 ) {
//    		matchSatus = 0;
//    	} else if (opponentTeamStamina == 0) {
//    		matchSatus = 1;
//    	}
    	
    	if (homeWins == 2 || opponentWins == 2) {
    		if (homeWins > opponentWins) {
    			matchSatus = 1;
    		} else {
    			matchSatus = 0;
    		}
    	}
    	
    
        
    	return matchSatus;
    	
    	
    	
    }
    
    /**
     * Resets both teams health
     */
    private void resetTeamsHealth() {
    	//Resets homeTeam Health
    	for (IngameCharacters player: homeTeam) {
    		player.resetHealth();
    	}
    	//Resets opponentTeam health
    	for (IngameCharacters player: opponentTeam) {
    		player.resetHealth();
    	}
    }
    
    /**
     * Returns the next player that is to play after the inputed player
     * 
     * @param currentPlayer 
     * @return <CODE>IngameCharacters</CODE> Next player up 
     */
    public IngameCharacters decideNextPlayer(IngameCharacters currentPlayer) {
    	IngameCharacters returnPlayer = null;
    	int playerIndex = 0;
    	
    	
    	
    	//Check which team the next player is being decided for
    	if (homeTeam.contains(currentPlayer)) {
    		//Increase player index to currentPlayer + 1
    		playerIndex = homeTeam.indexOf(currentPlayer) + 1;
    		
    		//Check if player index is greater than the length of the team and set to 0 if true
    		playerIndex = playerIndex > homeTeam.size() - 1? 0 : playerIndex;
    		
    		returnPlayer = homeTeam.get(playerIndex);
    		
    	} else {
    		//Increase player index to currentPlayer + 1
    		playerIndex = opponentTeam.indexOf(currentPlayer) + 1;
    		
    		//Check if player index is greater than the length of the team and set to 0 if true
    		playerIndex = playerIndex > opponentTeam.size() - 1? 0 : playerIndex;
    		
    		returnPlayer = opponentTeam.get(playerIndex);

    	}
    	
    	//Recursively finds the next alive player
		if (!isPlayerAlive(returnPlayer)) {
			
			returnPlayer = decideNextPlayer(returnPlayer);
		}
    	
    	return returnPlayer;
    }
    
    
    /**
     * Returns the character with the highest Aggro number of a specified skill
     * 
     * @param Lists of Characters
     * @return Character with the highest Aggro that is still alive
     */
    public IngameCharacters getHighestAggrolAthlete(List<IngameCharacters> characters) {
    	IngameCharacters highestAggroCharacter = decideNextPlayer(characters.get(0));
        
    	//Finds the character with the highest Aggro in the team
        for (IngameCharacters character : characters) {
            if (isPlayerAlive(character)) {
            	
            	//Agrro Levels go like 1>2>3>4
                if (character.getAggroLevel() < highestAggroCharacter.getAggroLevel()) {
                	highestAggroCharacter = character;
                }
            }
        }
        
        return highestAggroCharacter;
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
    public void action(IngameCharacters currentPlayer, IngameCharacters target) {
        Role role = currentPlayer.getRole();
        
        int damage = 0;
        int newHealth = 0;
        
        switch (role) {
            case OFFENSE:
                damage = currentPlayer.getDamage();
                newHealth = target.getHealth() - damage;
                target.setHealth(newHealth > 0 ? newHealth : 0);
                break;
           
            case SUPPORT:
                damage = currentPlayer.getDamage();
                newHealth = target.getHealth() - damage;
                target.setHealth(newHealth > 0 ? newHealth : 0);
                break;
                
            case TANK:
                damage = currentPlayer.getDamage();
                newHealth = target.getHealth() - damage;
                target.setHealth(newHealth > 0 ? newHealth : 0);
                
                break;
		case RESERVE:
			break;
		default:
			break;
                }
        
        //If player died reduce lives and stamina, also record battle results
        if (!isPlayerAlive(target)) {
        	//Target has been killed
        	target.setLives(target.getLives() - 1);
        	target.setStamina(target.getStamina() - 1);
        	recordRoundResults(currentPlayer, target, damage ,0, true);
        	
        } else {
        	recordRoundResults(currentPlayer, target, damage ,0, false);
        }
        
    }  
  
    
    /**
     * Returns false if player has 0 lives or 0 health, else returns true
     * @param player
     * @return <CODE>bolean</CODE> 
     */
    private boolean isPlayerAlive(IngameCharacters player) {
    	if (player.getHealth() == 0 || player.getLives() == 0) {
    		return false;
    	} else if (player.getLives() + this.round != 3) { 
    		return true;
    	} else { 
    		return true;}
    	
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
    	
    	//Check if target is dead
    	if (isTargetDead) {
    		results = String.format("%s has killed %s!", currentPlayerName, targetName, damage) ;
    	} else {
    		
    		//Check if support did something different from damage
    		if (support > 0) {
    			results = String.format("%s has buffed %s for %d damage!", currentPlayerName, targetName, damage);
    		} else {
    			results = String.format("%s has attacked %s for %d damage!", currentPlayerName, targetName, damage);
    		}
    		
    	}
    	
    	//Record what actions occured
    	if (homeTeam.contains(currentPlayer)) {
        	homeResults = results;
        	
    	} else {
    		opponentResults = results;
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
     * Gets the total stamina left in the team
     * 
     * @param IngameCharacters Team List
     * @return Total stamina of the team
     */
    public int getTeamStamina(List<IngameCharacters> characters) {
    	int totalStamina = 0;
    	for (IngameCharacters character : characters) {
    		totalStamina += character.getStamina();
    	}
    	return totalStamina;
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
	 * @return the round
	 */
	public int getRound() {
		return round;
	}


	/**
	 * @return the outcome
	 */
	public int getOutcome() {
		return outcome;
	}
	
}
