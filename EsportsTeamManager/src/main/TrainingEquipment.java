package main;

import java.util.Random;

import main.Ingestible.IngestibleItem;

public class TrainingEquipment extends Equipment {

	private TrainingItem item;
	
	public enum TrainingItem {
		GAMING_CHAIR,
		GAMING_KEYBOARD,
		GAMING_MOUSE,
		GAMING_HEADSET,
		HIGH_PERFORMANCE_MONITOR
	}
	
    public TrainingEquipment() {
    	setitem();
	}
    
    public void setitem() {
        Random random = new Random();

        // Get the values of the TrainingItem enum
        TrainingItem[] trainingItems = TrainingItem.values();

        // Generate a random index within the range of values in IngestibleItems
        int randomItemIndex = random.nextInt(trainingItems.length);

        // Set the item to the random enum value
        this.item = trainingItems[randomItemIndex];
    	
    }
	

	@Override
	public void applyEffect(Athlete athlete) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getBasePrice() {
		// TODO Auto-generated method stub
	}


	@Override
	public void setDescription() {
		// TODO Auto-generated method stub
	}


}
