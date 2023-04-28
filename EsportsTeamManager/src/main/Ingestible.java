package main;

import java.util.Random;

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
    	setitem();

    }
    
    public void setitem() {
        Random random = new Random();

        // Get the values of the IngestibleItem enum
        IngestibleItem[] ingestibleItems = IngestibleItem.values();

        // Generate a random index within the range of values in IngestibleItems
        int randomItemIndex = random.nextInt(ingestibleItems.length);

        // Set the item to the random enum value
        this.item = ingestibleItems[randomItemIndex];
    	
    }

	@Override
	public void applyEffect(Athlete athlete) {
		
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
