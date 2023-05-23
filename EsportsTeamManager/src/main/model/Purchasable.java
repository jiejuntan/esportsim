package main.model;

/**
 * Purchasable class for athletes and items.
 * 
 * @author Jiejun Tan
 *
 */
public abstract class Purchasable {
	
	/**
	 * Image path for purchase
	 */
	protected String portraitPath;
	
	/**
	 * Required method to get base price of purchase
	 * @return	base price of purchase
	 */
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
