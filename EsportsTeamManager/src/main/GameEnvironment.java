package main;

public class GameEnvironment {
	
    private String teamName;
    private int seasonDuration;
    private int currentWeek;
    private Difficulty difficulty;
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
    
    public GameEnvironment(Difficulty difficulty, String teamName) {
    	this.teamName = teamName;
        this.difficulty = difficulty;
        this.seasonDuration = 8;
        this.currentWeek = 1;
        this.money = 0;
        
        this.team = new Team();
    	this.club = new Club();
    	this.stadium = new Stadium();
    	this.market = new Market();
    }


    public void setupGame() {}
    
    
	public void playGame() {}
	

    public void finishGame() {}
    
    
    /********** Simple Getters & Setters **********/

    public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public int getSeasonDuration() {
		return seasonDuration;
	}


	public void setSeasonDuration(int seasonDuration) {
		this.seasonDuration = seasonDuration;
	}


	public int getCurrentWeek() {
		return currentWeek;
	}


	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}


	public Difficulty getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}


	public Stadium getStadium() {
		return stadium;
	}


	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}


	public Market getMarket() {
		return market;
	}


	public void setMarket(Market market) {
		this.market = market;
	}

	/********** Simple Getters & Setters **********/

}
