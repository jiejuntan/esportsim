package main.model;

public abstract class Purchasable {
	
    protected String description;
	protected String portraitPath;
	
    public abstract int getBasePrice();
    public abstract void setDescription();
    
    /**
	 * Calculates purchase price
	 * 
	 * @param modifier	difficulty modifier
	 * @return			purchase price
	 */
	public int calculatePurchasePrice(int modifier) {
		return getBasePrice() * modifier;
	} 
	
	/**
     * Calculates sale price
     * 
     * @param modifier	difficulty modifier
     * @return			sale price
     */
    public int calculateSalePrice(int modifier) {
    	return getBasePrice();
    }
    
	public String getDescription() {
		return description;
	}
	/**
	 * @return the portraitPath
	 */
	public String getPortraitPath() {
		return portraitPath;
	}

}
