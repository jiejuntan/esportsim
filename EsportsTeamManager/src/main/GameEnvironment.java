package main;

public class GameEnvironment {
	
    private String teamName;
    private int seasonDuration;
    private int currentWeek;
    private Difficulty Difficulty;
    private int money;
    private Team team;
    private Club club;
    private Stadium stadium;
    private Market market;
    
    public enum Difficulty {
    	EASY,
    	MEDIUM,
    	HARD
    }

    public void setupGame() {}

    public void playGame() {}

    public void finishGame() {}
	
	

}
