package main;

public class Athlete implements Purchasable {
    private int reactionTime;
    private int eyeSight;
    private int intelligence;
    private AthleteRole role;
    private String team;
    private boolean isReserve;
    private String name;
    private int contractPrice;
    private int sellBackPrice;
    private String description;
    
    public enum AthleteRole {

    	AthleteRole,
    	SUPPORT,
    	DPS,
    	TANK,
    	HEALER

    }
    
	@Override
	public int getContractPrice() {
		return 0;
	}
	@Override
	public int getSellBackPrice() {
		return 0;
	}
	@Override
	public String getDescription() {
		return null;
	}
	
    public int calculateSkillLevel() {
        return 0;
    }

}
