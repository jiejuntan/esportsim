package main.model;


import java.util.List;
import java.util.Map;
import java.util.Random;

import main.model.Team.Role;


/**
 * Random events which can occur during the menu gameplay
 * 
 * @author Blake and Jun
 *
 */
public class RandomEvent {
	
	private Team team;
	
	public RandomEvent(GameData gameData) {
		this.team = gameData.getTeam();
	}
	

    /**
     * Activates a random event if a random number is greater than % threshold
     */
    public void triggerEvent() {
    	Random random = new Random();
    	
    	double threshold = 98;
    	
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
	    			//removeAthlete();
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
//		if (team.getMainTeamSize() + team.getReserveTeamSize() <= 10) {
//    	Athlete athlete = new Athlete(3);
//    	team.addAthlete(athlete,Team.Role.RESERVE);}
    }
    
    /**
     * Random Event - Removes an athlete from the team
     */
//    public void removeAthlete() {
//    	
//    	for (Map.Entry<Role,  List<Athlete>> entry : team.getTeamMembers().entrySet()) {
//    		//Gets the Athlete from the team and picks a random one to remove
//    		Random random = new Random();
//    	    
//    	    for (Athlete athlete :  entry.getValue()) {
//    	    	//Create a new ingame character for each Athlete and adds to the matches homeTeam list
//        	    team.add(new IngameCharacters(athlete, role));
//    	    }
//    	    
//    	    
//    	}
//    	
//    }
    
    /**
     * Random Event - Increases a stats for one of the teams Athletes
     */
    public void statsIncrease() {
    	
    }

}
