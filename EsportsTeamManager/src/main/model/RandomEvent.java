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
	private GameData gameData;
	private Random random;
	/**
	 * This variable is for the gui to know if an event was activated
	 */
	private int activatedEvent;
	
	public RandomEvent(GameData gameData) {
		this.activatedEvent = -1;
		this.gameData = gameData;
		this.team = gameData.getTeam();
		this.random = new Random();
	}
	

    /**
     * Activates a random event if a random number is greater than % threshold
     */
    public void triggerEvent() {
    	
    	
    	double threshold = 98;
    	
    	//Generates the random number
    	double randomNumber = random.nextGaussian(50,50);
    	
    	//If threshold is passed pickEvent is called choosing one of the events 
    	if(randomNumber > threshold) {
    		pickEvent(random.nextInt(3));	
    	}
    	
    	
    }
    
    /**
     * Activates one of the events
     * 
     * @param eventNumber
     */
    private void pickEvent(int eventNumber) {
    	
    	switch(eventNumber) {
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
    
    /**
     * Random Event - Adds an athlete to the team
     */
    private void addAthlete() {    
		if (!team.isMainTeamFull()) {
			//Adds an Athlete with a skill based on the difficulty modifier and a random role
			team.addAthlete(new Athlete(gameData.getDifficulty().getModifier()), team.getRandomRole(false));
			
		} else if (!team.isReserveTeamFull()) {
			//Adds an Athlete with a skill based on the difficulty modifier and the reserver role
			team.addAthlete(new Athlete(gameData.getDifficulty().getModifier()), Team.Role.RESERVE);
			
			this.activatedEvent = 1;
		} else {
			//Both main team and reserves are full so a different event is picked
			pickEvent(random.nextInt(1,3));
		}
    }
    
    /**
     * Random Event - Removes an athlete from the team
     */
    private void removeAthlete() {
    	
    	//Chooses a random (role : List<Athletes>) to get remove an athlete from
    	List<Athlete> athletes = team.getTeamMembers().get(team.getRandomRole(true));
    	
    	//Removes the athlete from 
    	team.removeAthlete(athletes.get(random.nextInt(athletes.size())));
    	
    	this.activatedEvent = 2;
    	
    }
    
    /**
     * Random Event - Increases a stats for one of the teams Athletes
     */
    private void statsIncrease() {
    	
    	//Chooses a random (role : List<Athletes>) to get an athlete to increases thier stat
    	List<Athlete> athletes = team.getTeamMembers().get(team.getRandomRole(true));
    	
    	Athlete athlete = athletes.get(random.nextInt(athletes.size()));
    	
    	//Picks one of the Athletes stats to randomly increase by 1 point
    	switch(random.nextInt(5)) {
			case 0:
				athlete.setEyeSight(athlete.getEyeSight() + 1);
				break;
			case 1:
				athlete.setIntelligence(athlete.getIntelligence() + 1);
				break;
			case 2:
				;
				athlete.setReactionTime(athlete.getReactionTime() + 1);
				break;
			case 3:
				athlete.setStamina(athlete.getStamina() + 1);
				break;
			default:
				System.out.println("This Shouldnt Happen!");
    	}
    }


	/**
	 * @return the activatedEvent
	 */
	public int getActivatedEvent() {
		return activatedEvent;
	}

    
    
}
