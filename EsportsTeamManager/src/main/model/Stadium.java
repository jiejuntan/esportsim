package main.model;

import java.util.List;

import main.model.GameData.Difficulty;

public class Stadium {
	
    private List<Match> matches;
    
    public Stadium(Difficulty difficulty) {
    	generateMatches(difficulty);
    }

    public void generateMatches(Difficulty difficulty) {
    	
    }

    public void chooseMatch(Match match) {}

}
