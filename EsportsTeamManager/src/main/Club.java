package main;

import java.util.List;

public class Club {
	
	private Team team;
    private List<Equipment> inventory;
    
    public Club(Team team) {
    	this.team = team;
    }

    /**
     * Returns Team Properties in the form of a String ready for console
     * 
     * @param team
     * @return
     */
    public String viewTeamProperties(Team team) {
    	
    	//Shows Team properties
    	String teamProperties = team.toString() 
    			+ "************* Athletes **********\n";
    	//Adds in individual Ahtlete properties to Team Properties String
    	for (Athlete athlete: team.getTeamMembers()) {
    		teamProperties += athlete.toString();
    	}
    	return teamProperties;
    }
    
    /**
     * Swaps Athletes between teamMembers & reserveMembers
     * 
     * @param teamIndex
     * @param reserveIndex
     */
    public void swapAthletes(int teamIndex, int reserveIndex) {
    	
    	//Gets that Teams Current Players
        List<Athlete> teamMembers = team.getTeamMembers();
        List<Athlete> reserveMembers = team.getReserveMembers();
    	
    	
    	 // Get the Athletes to be swapped
        Athlete teamSwap = teamMembers.get(teamIndex);
        Athlete reserveSwap = reserveMembers.get(reserveIndex);

        // Swap the Athletes
        teamMembers.set(teamIndex, reserveSwap);
        reserveMembers.set(reserveIndex, teamSwap);
    	
    }
    
    /**
     * 
     */
    public void useEqupment() {
    	    }
    
    
    /**
     * Gets the Club inventory
	 * @return Club inventory
	 */
	public List<Equipment> getInventory() {
		return inventory;
	}

	/**
	 * Sets the Club inventory
	 * @param inventory to set
	 */
	public void setInventory(List<Equipment> inventory) {
		this.inventory = inventory;
	}

	/**
     * Adds Equipment to the clubs inventory
     * @param Equipment
     */
    public void addToInventory(Equipment Equipment) {
    	inventory.add(Equipment);
    }

}
