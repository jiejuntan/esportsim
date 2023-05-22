package main.model;

public abstract class Purchasable {
	
	protected String portraitPath;
	
    public abstract int getBasePrice();
    
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
    
	/**
	 * @return the portraitPath
	 */
	public String getPortraitPath() {
		return portraitPath;
	}

}
