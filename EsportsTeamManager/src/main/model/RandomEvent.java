package main.model;


import java.util.Random;


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
		if (team.getMainTeamSize() + team.getReserveTeamSize() <= Team.getMainLimit() + Team.getReserveLimit()) {
    	Athlete athlete = new Athlete(3);
    	team.addAthlete(athlete,Team.Role.RESERVE);}
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
