package main;

public abstract class Equipment extends Purchasable{
	
    private int effectDuration;
    

    public int getEffectDuration() {
        return effectDuration;
    }

    public abstract void applyEffect(Athlete athlete);
    
    
	


}
