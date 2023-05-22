package main.model;


import java.util.List;
import java.util.Random;
import main.exceptions.TeamLimitException;


/**
 * Random events which can occur every new week
 * 
 * @author Blake and Jun
 *
 */
public final class RandomEvent {
	
	private Team team;
	private GameData gameData;
	private Random random;
	
	public RandomEvent(GameData gameData) {
		this.gameData = gameData;
		this.team = gameData.getTeam();
		this.random = new Random();
	}
	

    /**
     * Activates a random event if a lucky number is hit
     */
    public int triggerEvent() {
    	if (gameData.getCurrentWeek() > 1) {
    		
    		int count = 20;
        	int result = random.nextInt(count);
        	if (result == 5) {
        		int event = random.nextInt(1, 4);
        		pickEvent(event);
        		return event;
        	}
        	return 0;
    	}
    	return 0;
    }
    
    /**
     * Activates one of the random events
     * 
     * @param eventNumber	type of event
     */
    private void pickEvent(int eventNumber) {
    	switch(eventNumber) {
		case 1:
			addAthlete();
			break;
		case 2:
			removeAthlete();
			break;
		case 3:
			statsIncrease();
			break;
		default:
			break;
    	}
    }
    
    /**
     * Random Event - Adds an athlete to the team
     */
    private void addAthlete() {    
		if (!team.isMainTeamFull()) {
			try {
				team.addAthlete(new Athlete(gameData.getCurrentWeek()), Team.getRandomRole(false));
			} catch (TeamLimitException e) {
				// Unrecoverable exception
				e.printStackTrace();
			}
			
		} else if (!team.isReserveTeamFull()) {
			try {
				team.addAthlete(new Athlete(gameData.getCurrentWeek()), Team.Role.RESERVE);
			} catch (TeamLimitException e) {
				// Unrecoverable exception
				e.printStackTrace();
			}
		} else {
			//Both main team and reserves are full so a different event is picked
			pickEvent(random.nextInt(2,4));
		}
    }
    
    /**
     * Random Event - Removes an athlete from the team
     */
    private void removeAthlete() {
    	List<Athlete> athletes = team.getMainMembers();
    	athletes.addAll(team.getReserveMembers());
    	
    	if (athletes.size() > 0) {
        	int toRemove = random.nextInt(athletes.size());
        	team.removeAthlete(athletes.get(toRemove));  
    	}  	
    }
    
    /**
     * Random Event - Increases a stats for one of the teams Athletes
     */
    private void statsIncrease() {    	    	
    	List<Athlete> athletes = team.getMainMembers();
    	athletes.addAll(team.getReserveMembers());
    	
    	if (athletes.size() > 0) {
    		Athlete athlete = athletes.get(random.nextInt(athletes.size()));

        	switch(random.nextInt(3)) {
			case 0:
				athlete.setReactionTime(athlete.getReactionTime() + 15);
				break;
			case 1:
				athlete.setEyeSight(athlete.getEyeSight() + 15);
				break;
			case 2:
				athlete.setIntelligence(athlete.getIntelligence() + 15);
				break;
			default:
				break;
        	}
    	}  	    	
    }
    
}
