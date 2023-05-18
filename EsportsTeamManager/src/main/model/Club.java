package main.model;

import java.util.List;

import main.model.Team.Role;

public class Club {
	
	/**
	 * Data transfer object
	 */
	private GameData data;
	
    private List<Equipment> inventory;
    
    public Club(GameData data) {
    	this.data = data;
    }
    
    public String athleteDescriptionAt(Role role) {
    	Athlete athlete = data.getTeam().getTeamMembers().get(role);
    	return String.valueOf(athlete);
    }
    
    
//    /**
//     * Swaps Athletes between teamMembers and reserveMembers
//     * 
//     * @param teamIndex
//     * @param reserveIndex
//     */
//    public void swapAthletes(int teamIndex, int reserveIndex) {
//    	
//    	//Gets that Teams Current Players
//        List<Athlete> teamMembers = team.getTeamMembers();
//        List<Athlete> reserveMembers = team.getReserveMembers();
//    	
//    	
//    	 // Get the Athletes to be swapped
//        Athlete teamSwap = teamMembers.get(teamIndex);
//        Athlete reserveSwap = reserveMembers.get(reserveIndex);
//
//        // Swap the Athletes
//        teamMembers.set(teamIndex, reserveSwap);
//        reserveMembers.set(reserveIndex, teamSwap);
//    	
//    }
    
    /**
     * Takes in an item and athlete and applies that items effect to the athlete
     * 
     * @param item
     * @param athlete
     */
    public void useEqupment(TrainingEquipment item, Athlete athlete) {
    	
    	String AffectedStat = item.getItem().getAffectedStat();
    	int itemStatValue = item.getItem().getValue();
    	
    	 switch (AffectedStat) {
         case "reactionTime":
        	 athlete.setReactionTime(athlete.getReactionTime() + itemStatValue);
             break;
         case "eyeSight":
        	 athlete.setEyeSight(athlete.getEyeSight() + itemStatValue);
             break;
         case "intelligence":
        	 athlete.setIntelligence(athlete.getIntelligence() + itemStatValue);
             break;
         case "stamina":
        	 athlete.setStamina(athlete.getStamina() + itemStatValue);
             break;
         default:
             break;
    	 }
    	
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
