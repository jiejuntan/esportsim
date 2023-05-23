package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.exceptions.RandomEventException;
import main.exceptions.TeamLimitException;
import main.exceptions.RandomEventException.Event;


/**
 * Random events which can occur every new week
 * 
 * @author Blake and Jun
 *
 */
public final class RandomEvent {
	
	/**
	 * Team instance
	 */
	private Team team;
	/**
	 * Data transfer object
	 */
	private GameData data;
	/**
	 * Random number generator
	 */
	private Random random;
	
	/**
	 * Constructor for random events
	 * @param data	data transfer object
	 */
	public RandomEvent(GameData data) {
		this.data = data;
		this.team = data.getTeam();
		this.random = new Random();
	}

    /**
     * Activates a random event if a lucky number is hit
     * Chance of any random event increases if athletes get injured or reserve team is not full.
     * Chance of an athlete joining increases depending on empty slots in reserve team
     * Chance of an athlete quitting increases depending on how many got injured
     * @throws RandomEventException if event is triggered
     */
    public void triggerEvent() throws RandomEventException {
    	if (data.getCurrentWeek() > 1) {
    		int emptyReserves = Team.MAIN_LIMIT - team.getReserveTeamSize();
    		int count = 20 - getInjuredCount() - emptyReserves;
    		int result = random.nextInt(count);
    		if (result == 5) {
    			List<Integer> events = new ArrayList<Integer>() {
    				{
    					add(1); 
    					add(2); 
    					add(3);
    					
    					for (int i = 0; i < emptyReserves; i++) {
    						add(1);
    					}
    					for (int i = 0; i < getInjuredCount(); i++) {
    						add(2);
    					}
    				}
    			};
        		int event = events.get(random.nextInt(events.size()));
        		pickEvent(event);
        	}
    	}
    }
    
    /**
     * Counts the number of injured athletes
     * @return number of injured athletes
     */
    private int getInjuredCount() {
    	int count = 0;
    	
    	for (Athlete athlete : team.getMainMembers()) {
    		if (athlete.getStamina() == 0) {
    			count ++;
    		}
    	}
    	return count;
    }
    
    /**
     * Activates one of the random events
     * 
     * @param eventNumber	type of event
     * @throws RandomEventException if event is triggered
     */
    private void pickEvent(int eventNumber) throws RandomEventException {
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
     * @throws RandomEventException if event is triggered
     */
    private void addAthlete() throws RandomEventException {    
		if (!team.isMainTeamFull()) {
			try {
				team.addAthlete(new Athlete(data.getCurrentWeek()), Team.getRandomRole(false));
				throw new RandomEventException(Event.ADD);
			} catch (TeamLimitException e) {
				// Unrecoverable exception
				e.printStackTrace();
			}
			
		} else if (!team.isReserveTeamFull()) {
			try {
				team.addAthlete(new Athlete(data.getCurrentWeek()), Team.Role.RESERVE);
				throw new RandomEventException(Event.ADD);
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
     * @throws RandomEventException if event is triggered
     */
    private void removeAthlete() throws RandomEventException {
    	List<Athlete> athletes = team.getMainMembers();
    	athletes.addAll(team.getReserveMembers());
    	List<Athlete> injured = new ArrayList<Athlete>();
    	
    	for (Athlete athlete : team.getMainMembers()) {
    		if (athlete.getStamina() == 0) {
    			injured.add(athlete);
    			athletes.remove(athlete);
    		}
    	}
    	if (injured.size() > 0) {
        	int toRemove = random.nextInt(injured.size());
        	team.removeAthlete(injured.get(toRemove));  
    		throw new RandomEventException(Event.REMOVE);
    	} else if (athletes.size() > 0) {
        	int toRemove = random.nextInt(athletes.size());
        	team.removeAthlete(athletes.get(toRemove));
    		throw new RandomEventException(Event.REMOVE);
    	} else {
    		statsIncrease();
    	}
    }
    
    /**
     * Random Event - Increases a stats for one of the teams Athletes
     * @throws RandomEventException if event is triggered
     */
    private void statsIncrease() throws RandomEventException {    	    	
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
    		throw new RandomEventException(Event.STAT);
    	}  	    	
    }
    
}
