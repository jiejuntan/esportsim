package main;

public abstract class Equipment {
	
    private int contractPrice;
    private int sellBackPrice;
    private String description;
    private int effectDuration;
    
    public Equipment(int contractPrice, int sellBackPrice, String description, int effectDuration) {
        this.contractPrice = contractPrice;
        this.sellBackPrice = sellBackPrice;
        this.description = description;
        this.effectDuration = effectDuration;
    }

    public int getContractPrice() {
        return contractPrice;
    }

    public int getSellBackPrice() {
        return sellBackPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getEffectDuration() {
        return effectDuration;
    }

    public abstract void applyEffect(Athlete athlete);
	


}
