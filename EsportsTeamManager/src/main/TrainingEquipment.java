package main;

import main.GameEnvironment.Difficulty;

public class TrainingEquipment extends Equipment {

	private TrainingItems item;
	
	public enum TrainingItems {
		GAMING_CHAIR,
		GAMING_KEYBOARD,
		GAMING_MOUSE,
		GAMING_HEADSET,
		HIGH_PERFORMANCE_MONITOR,
		NEW_GEAR
	}
	
    public TrainingEquipment() {
    	
	}
	

	@Override
	public void applyEffect(Athlete athlete) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPurchasePrice(Difficulty difficulty) {
		// TODO Auto-generated method stub
	}


	@Override
	public void setDescription() {
		// TODO Auto-generated method stub
	}


}
