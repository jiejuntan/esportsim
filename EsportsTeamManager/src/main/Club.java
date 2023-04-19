package main;

import java.util.List;

public class Club {
	
    private List<Equipment> inventory;

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

    public void useItem() {}

}
