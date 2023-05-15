package main;

import main.Athlete.AthleteRole;

public class IngameCharacter {
	
    //Ingame Character Stats
    private int health;
    private int damage;
    private int shield;
    private int aggroLevel;
    private AthleteRole role;
    
	public IngameCharacter(Athlete athlete) {
		this.role = athlete.getRole();
		this.health = role.getHealth();
		this.damage = role.getHealth();
		this.shield = role.getHealth();
		this.aggroLevel = aggroLevel();
	}
	
	public int aggroLevel() {
		int aggro = 0;
		
	    switch (this.role) {
	        case TANK:
	        	aggro = 1;
	        	break;
	        case ATTACK:
	        	aggro = 2;
	        	break;
	        case DEFENSE:
	        	aggro = 3;
	        	break;
	        case SUPPORT:
	        	aggro = 4;
	        	break;
	    }	
	    
	    return aggro;
	}
    
    

}
