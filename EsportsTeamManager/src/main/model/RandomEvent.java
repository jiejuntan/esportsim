package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import main.model.Team.Role;

public class RandomEvent {
	
	private GameData gameData;
	
	public RandomEvent(GameData gameData) {
		this.gameData = gameData;
	}
	

    /**
     * Activates a random event if a random number is greater than % threshold
     */
    public void triggerEvent() {
    	Random random = new Random();
    	
    	double threshold = 0;
    	
    	//Generates the random number
    	double randomNumber = random.nextGaussian(50,50);
    	
    	//Random event picker
    	int randomEvent = random.nextInt(3);
    	
    	if(randomNumber > threshold) {
    		
    		switch(randomEvent) {
	    		case 0:
	    			addAthlete();
	    			break;
	    		case 1:
	    			removeAthlete();
	    			break;
	    		case 2:
	    			statsIncrease();
	    			break;
	    		default:
	    			System.out.println("This Shouldnt Happen!");
    		}
    		
    	}
    	
    	
    }
    
    /**
     * Random Event - Adds an athlete to the team
     */
    public void addAthlete() {    
    	
    	Team team = gameData.getTeam();
    	
        Athlete athlete = team.getTeamMembers().get(random);
        
        
    	team.removeAthlete(athlete);
    	
    }
    
    /**
     * Random Event - Removes an athlete from the team
     */
    public void removeAthlete() {
    	
    }
    
    /**
     * Random Event - Increases a stats for one of the teams Athletes
     */
    public void statsIncrease() {
    	
    }

}
