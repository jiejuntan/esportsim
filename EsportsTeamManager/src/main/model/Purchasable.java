package main.model;

public abstract class Purchasable {
	
    protected String description;
	
    public abstract int getBasePrice();
    
	public abstract void setDescription();
	
	public String getDescription() {
		return description;
	} 

}
