package main.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import main.exceptions.GameOverException;
import main.exceptions.GameOverException.Type;
import main.model.Team.Role;

/**
 * Handles matches between the players team and opponents team
 * 
 * @author Blake and Jun
 *
 */
public final class Match {
	/**
	 * Data transfer object
	 */
	private GameData data;
	/**
	 * Name of opponent's team
	 */
    private String opponentTeamName;
    /**
     * Starting list of player's athletes as in-game characters
     */
    private List<IngameCharacter> playerTeam;
    /**
     * Starting list of opponent's athletes as in-game characters
     */
    private List<IngameCharacter> opponentTeam;
    /**
     * List of all active characters in descending order of speed
     */
    private List<IngameCharacter> attackOrder = new ArrayList<IngameCharacter>();
    /**
     * List of player's characters in descending order of aggro
     */
    private List<IngameCharacter> playerDefenseOrder = new ArrayList<IngameCharacter>();
    /**
     * List of opponent's characters in descending order of aggro
     */
    private List<IngameCharacter> opponentDefenseOrder = new ArrayList<IngameCharacter>();
    /**
     * Random number generator
     */
    private Random random = new Random();
    
    /**
     * Constructor for match
     * @param data		data transfer object
     * @param opponent	opponent team
     */
    public Match(GameData data, Team opponent) {
    	this.data = data;
    	this.opponentTeamName = opponent.getName();
    	
    	playerTeam = new ArrayList<IngameCharacter>();
    	opponentTeam = new ArrayList<IngameCharacter>();
    	
    	for (Athlete athlete : data.getTeam().getMainMembers()) {
    		IngameCharacter character = new IngameCharacter(athlete);
    		playerTeam.add(character);
    	}
       	for (Athlete athlete : opponent.getMainMembers()) {
    		IngameCharacter character = new IngameCharacter(athlete);
    		opponentTeam.add(character);
    	}
       	initialize();
    };
    
    /**
     * Calculates skewed random number
     * @param min	min value
     * @param max	max value
     * @param skew	how tightly bound
     * @param bias	left/right bias
     * @return		random skewed int
     */
    private int nextSkewedInt(double min, double max, double skew, double bias) {
        double range = max - min;
        double mid = min + range / 2.0;
        double unitGaussian = random.nextGaussian();
        double biasFactor = Math.exp(bias);
        double retval = mid+(range*(biasFactor/(biasFactor+Math.exp(-unitGaussian/skew))-0.5));
        return (int) Math.round(retval);
    }
    
    /**
     * Initializes the match
     */
    private void initialize() {
    	prepareTurns();

    	playerDefenseOrder.addAll(playerTeam);
    	playerDefenseOrder.sort(Comparator.comparing(IngameCharacter::getAggro));
    	
    	opponentDefenseOrder.addAll(opponentTeam);
    	opponentDefenseOrder.sort(Comparator.comparing(IngameCharacter::getAggro));
    }
    
    /**
     * Resets turns for alive characters once all characters have taken a turn
     */
    private void prepareTurns() {
    	attackOrder.clear();
    	attackOrder.addAll(playerTeam);
    	attackOrder.addAll(opponentTeam);
    	attackOrder.sort(Comparator.comparing(IngameCharacter::getSpeed));
    }
    
    /**
     * Advances the match by a turn
     * 
     * @return						string message to display
     * @throws GameOverException	if match ends
     */
    public String nextTurn() throws GameOverException {
    	String result = "";
    	String attackTeam = "";
    	String defendTeam = "";
    	
    	// Check if game should end if entire team dies
    	if (playerTeam.size() > 0 && opponentTeam.size() > 0) {
    		
    		// Check if every character has taken their turn, then reset turns for alive characters
    		if (attackOrder.size() <= 0) {
    			prepareTurns();
    		}
    		
    		// Gets an attacker skewed towards the fastest characters
    		IngameCharacter attacker = attackOrder.remove(nextSkewedInt(0, attackOrder.size(), 1, -3));
    		attackTeam = playerTeam.contains(attacker) ? data.getTeam().getName() : opponentTeamName;
    		// Gets a defender from the opposite team skewed towards the highest aggro characters
    		IngameCharacter defender = playerTeam.contains(attacker) ? 
    				opponentDefenseOrder.get(nextSkewedInt(0, opponentDefenseOrder.size(), 1, -3)) :
    					playerDefenseOrder.get(nextSkewedInt(0, playerDefenseOrder.size(), 1, -3));
    		defendTeam = playerTeam.contains(defender) ? data.getTeam().getName() : opponentTeamName;

    		// Gets a defender from ally team
    		IngameCharacter ally = playerTeam.contains(attacker) ? 
    				playerDefenseOrder.get(random.nextInt(playerDefenseOrder.size())) :
    					opponentDefenseOrder.get(random.nextInt(opponentDefenseOrder.size()));
    	
    		int damage = defender.getRole() == Role.TANK ? attacker.getPower() / 2 : attacker.getPower();
    		switch (attacker.getRole()) {
    		case OFFENSE:
    			// Attacks the target, deals half damage to tanks
    			defender.takeDamage(damage);
    			result += String.format("%s's %s deals %s damage to %s's %s.", attackTeam, attacker.getName(), damage, defendTeam, defender.getName());
    			break;
    		case SUPPORT:
    			// Heals an ally
    			int heal = attacker.getPower();
    			ally.heal(heal);
    			result += String.format("%s's %s heals %s for %s health.", attackTeam, attacker.getName(), defender.getName(), heal);
    			break;
    		case TANK:
    			// Attacks the target, deals half damage to everyone
    			defender.takeDamage(damage);
    			result += String.format("%s's %s deals %s damage to %s's %s.", attackTeam, attacker.getName(), damage, defendTeam, defender.getName());
    			break;
			default:
				break;
    		}
    		
    		// After turn is taken, check if defender is dead and remove them from game and update their stamina out of game
    		if (defender.isDead()) {
    			attackOrder.remove(defender);
    			if (playerTeam.contains(defender)) {
    				playerTeam.remove(defender);
    				playerDefenseOrder.remove(defender);
    				defender.getAthlete().setStamina(random.nextInt(3));
    				
    				result += String.format("\n\n%s from %s was killed. You have %s players remaining.", defender.getName(), defendTeam, playerTeam.size());
    			} else {
    				opponentTeam.remove(defender);
    				opponentDefenseOrder.remove(defender);
    				
    				result += String.format("\n\n%s from %s was killed. They have %s players remaining.", defender.getName(), defendTeam, opponentTeam.size());
    			}
    		}
    		return result;
    	} else {
    		// Game is over, check which team won and act accordingly
    		if (playerTeam.size() == 0) {
    			data.getTeam().addLoss(1);
    			throw new GameOverException(Type.MATCH_LOST);
    		} else {
    			data.getTeam().addWin(1);
    			data.incrementMoney(data.getDifficulty().prizeMoney);
    			throw new GameOverException(Type.MATCH_WON);

    		}
    	}
    }	
	
}
