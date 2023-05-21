package main.gui.market;

import main.gui.subclassable.ThumbnailPanel;

/**
 * Panel for market.
 * 
 * @author Jiejun Tan
 *
 */
public final class MarketPanel extends ThumbnailPanel {

	/**
	 * Constructor for market panel to display purchasable athletes/items and sell button
	 */
	public MarketPanel() {
		titleLabel.setText("Market");
		backButton.setVisible(true);
		subheadingLabel1.setVisible(true);
		subheadingLabel2.setVisible(true);
	}

}
