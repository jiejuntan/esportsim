package main;

import main.GameData.Difficulty;

public abstract class Purchasable {
	
    protected int purchasePrice;
    private int sellBackPrice;
    protected String description;
	
    public abstract void setPurchasePrice(Difficulty difficulty);
    
	public abstract void setDescription();
    
	public int setSellBackPrice() {
		return getPurchasePrice() / 2;
	}
	
	public String getDescription() {
		return description;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getSellBackPrice() {
		return sellBackPrice;
	}
    
}
