package main;

import main.GameEnvironment.Difficulty;

public class Ingestible extends Equipment {

	private IngestibleItem item;

    public enum IngestibleItem {
        ENERGY_DRINK,
        FOCUS_BOOSTER,
        VITAMIN_SUPPLEMENT,
        HEALTHY_SNACK,
        RECOVERY_SHAKE
    }
    
    public Ingestible() {

    }

	@Override
	public void applyEffect(Athlete athlete) {
		
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
