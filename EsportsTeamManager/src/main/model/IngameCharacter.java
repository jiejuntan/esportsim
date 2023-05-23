package main.model;

import main.model.Team.Role;

/**
 * Holds data for the Athletes ingame chracters druring a match
 * 
 * @author Blake and Jun
 *
 */
public final class IngameCharacter {
	
	/**
	 * Athlete playing the character
	 */
	private Athlete athlete;
	/**
	 * Name of athlete
	 */
	private String name;
	/**
	 * Role of athlete
	 */
    private Role role;

    /**
     * Health of character
     */
    private int health = 100;
    /**
     * Strength of character
     */
    private int power;
    /**
     * Ability of character to draw focus
     */
    private int aggro;
    /**
     * How quickly the character can take their turn
     */
    private int speed;
    
    /**
     * Constructor for characters during a match
     * @param athlete athlete to construct character for
     */
	public IngameCharacter(Athlete athlete) {
		this.athlete = athlete;
		this.name = athlete.getName();
		
		this.role = athlete.getRole();
		
		this.speed = role.getSpeed();
		this.aggro = role.getAggro();
		
		switch (role) {
		case OFFENSE:
			power = athlete.getEyeSight() + athlete.getReactionTime();
			break;
		case SUPPORT:
			power = (athlete.getIntelligence() + athlete.getEyeSight() / 2);
			break;
		case TANK:
			power += (athlete.getReactionTime() + athlete.getIntelligence()) / 2;
			break;
		default:
			break;
		}
	}

	/**
	 * @return the athlete
	 */
	public Athlete getAthlete() {
		return athlete;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health to heal
	 */
	public void heal(int health) {
		this.health = Math.min(this.health + health, 100);
	}
	
	/**
	 * 
	 * @param damage taken
	 */
	public void takeDamage(int damage) {
		this.health -= damage;
	}
	
	/**
	 * 
	 * @return if character is dead
	 */
	public boolean isDead() {
		return health <= 0;
	}

	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @return the aggro
	 */
	public int getAggro() {
		return aggro;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	
}
