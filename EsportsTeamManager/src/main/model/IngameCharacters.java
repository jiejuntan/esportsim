package main.model;

import main.model.Team.Role;

/**
 * Holds data for the Athletes ingame chracters druring a match
 * 
 * @author Blake and Jun
 *
 */
public final class IngameCharacters {
	
	private String name;
	
    //Ingame Character Stats
    private int health;
    private int damage;
    private int aggroLevel;
    private int lives;

    //AtheleStatisics
	private int reactionTime;
    private int intelligence;
    private int stamina;
    
    //Used when restoring health have player has died
    private int baseHealth;
    
    
    private Role role;
    
	public IngameCharacters(Athlete athlete, Role role) {
		this.name = athlete.getName();
		this.role = role;
		this.health = role.getHealth();
		this.baseHealth = this.health;
		this.damage = role.getDamage();
		this.aggroLevel = role.getAggro();
		this.reactionTime = athlete.getReactionTime();
		this.intelligence = athlete.getIntelligence();
		this.stamina = athlete.getStamina();
		this.lives = 3;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Damge = Damge + Intelligence
	 * 
	 * @return the damage
	 */
	public int getDamage() {
		return damage + intelligence;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @return the aggroLevel
	 */
	public int getAggroLevel() {
		return aggroLevel;
	}

	/**
	 * @param aggroLevel the aggroLevel to set
	 */
	public void setAggroLevel(int aggroLevel) {
		this.aggroLevel = aggroLevel;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the lives
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * @param lives the lives to set
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
	 * Resets the players health back to default
	 */
	public void resetHealth() {
		this.health = this.baseHealth;
	}
	
	
	

}
