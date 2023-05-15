package main;

import java.util.ArrayList;
import java.util.List;

import main.GameData.Difficulty;

public class Match {

    private Difficulty difficulty;
    private int rewardMoney;
    private int rewardPoints;
    private Team homeTeam;
    private Team awayTeam;
    private GameData gameData;
    
    private Match(GameData gameData, Team awayTeam) {
    	
    	this.gameData = gameData;
    	this.homeTeam = gameData.getTeam();
    	this.awayTeam = awayTeam;
    	this.difficulty = gameData.getDifficulty();
    	calculateRewards(difficulty.getModifier());
    	
    	
    };
    
    public void calculateRewards(int difficulty) {
    	
    	
    }
    
    
	/**
	* roles - Defense = Shield points, Offense = attack points, Support = randomly heals/buffs/debuffs, and Tank = takes aggro of opponent team
	* reactionTime = chance of missing an attack/getting an attack
	* intelligence = boosts attack/defense/support power (Players understanding of thier character increases the ingame stats)
	* stamina = as the game goes on each players mental stamina goes down increasing the chance of missing attacks/getting hit
	* 
	* 
	* Each athlete can have an action during each round, and the number of rounds could be determined by the average stamina of the athletes or a fixed number.
	*Simulation of Rounds
	*For each round, iterate over each athlete in the teams. The order can be random or determined by a stat like reaction time or stamina.
	*At the beginning of each round, the stamina stat could affect the reactionTime stat, simulating the mental fatigue of the athletes.
	*Each round shield point regenerate 10% of the characters total shield points
	*
	*Athlete Actions
	*Each athlete will take an action depending on their role:
	*
	*Offense: Their target is determined by the aggro levels of the opposing team. They attack and deal damage based on their intelligence and the opponent's shield points and reaction time. If the attack hits, reduce the target's health points.
	*
	*Defense: They add shield points to their team based on their intelligence. The shield points decrease whenever a teammate is attacked.
	*
	*Support: They can heal a teammate, buff an ally's stats, or debuff an opponent's stats. The choice can be random or based on the current state of the match.
	*
	*Tank: They have the highest aggro level, making them more likely to be the target of attacks. Their attack will be less powerful, but they have more health points
	*
	*Stamina Decrease
	*After each action, reduce the athlete's stamina. This reduces their attack power, shield points, healing power  in the next rounds.
	*
	*Check End Conditions
	*At the end of each round, check if all athletes on a team are out of health. If so, the other team wins.
	*Repeat
	*If no end conditions are met, repeat the process for the next round.
	* 
	* 
	* 
	* 
	*/
    
    
    private void createCharacters() {
    	
    }
    
    
    
    private void action() {}
    

    
    
    public void simulateMatch() {
        // Define a fixed number of rounds or calculate it based on the athletes' stamina
        int totalRounds = 10;

        // Loop over the rounds
        for (int round = 0; round < totalRounds; round++) {
            // Iterate over each athlete in the home team and have them perform an action
            for (Athlete athlete : homeTeam.getTeamMembers()) {
                // The target is determined by the aggro levels of the opposing team
                Athlete target = ?;  // You need to implement getAggro() method in Team class
                action(target);
                decreaseStamina();
            }

            // Iterate over each athlete in the away team and have them perform an action
            for (Athlete athlete : awayTeam.getTeamMembers()) {
                Athlete target = homeTeam.getAggro();
                action(target);
                decreaseStamina();
            }

            // Check if all athletes on a team are out of health. If so, the other team wins
            if (hometeamheath)) {  // You need to implement isDefeated() method in Team class
                return;
            } else if (awayTeamhealth) {
                return;
            }
        }

        // If no team is defeated after all rounds, the team with the highest total stamina wins
        int homeStamina = totalStamina();
        int awayStamina = totalStamina();

        if (homeStamina > awayStamina) {
            System.out.println("Home team wins!");
        } else if (awayStamina > homeStamina) {
            System.out.println("Away team wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }


	
}
