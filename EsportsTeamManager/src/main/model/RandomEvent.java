package main.model;

public class RandomEvent {
	
    private Events eventType;
    private float chance;
    
    public enum Events {
    	INJURY,
    	EQUIPMENT_MALFUNCTION,
    	SPONSORSHIP_OFFER,
    	TEAM_BONDING_EVENT,
    	WEATHER_DELAYS,
    	UNEXPECTED_WIN_STREAK,
    	UNEXPECTED_LOSS_STREAK
    }


    public void triggerEvent() {}

}
