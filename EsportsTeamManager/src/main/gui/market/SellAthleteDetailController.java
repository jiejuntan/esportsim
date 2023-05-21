package main.gui.market;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GameFrame;
import main.gui.subclassable.DetailController;
import main.model.Athlete;
import main.model.GameData.Difficulty;
import main.model.Market;

/**
 * Controller for detail screen when selling athlete in market
 * 
 * @author Jiejun Tan
 *
 */
public class SellAthleteDetailController extends DetailController {

	/**
	 * Athlete to sell.
	 */ 
	private Athlete athlete;
	
	/**
	 * Constructor when selling team athlete
	 * 
	 * @param frame 	game frame to manage navigation
	 * @param athlete 	Athlete to sell
	 */
	public SellAthleteDetailController(GameFrame frame, Athlete athlete) {
		super(frame);
		this.athlete = athlete;
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new SellAthleteDetailPanel();
		
		setHeading();
		super.setPortrait(((SellAthleteDetailPanel) panel).getPortraitLabel(), athlete.getPortraitPath());
		setStats();
		
		super.initializeBackButton();
		initializeConfirmButton();

		super.launch();

	}

	/**
	 * Sets heading to athlete's name
	 */
	private void setHeading() {
		JButton changeNameButton = ((SellAthleteDetailPanel) panel).getChangeNameButton();
		changeNameButton.setText(athlete.getName());
	}
	
	/**
	 * Displays athlete's current stats and sale price
	 */
	private void setStats() {
		JLabel reactionValueLabel = ((SellAthleteDetailPanel) panel).getReactionValueLabel();
		reactionValueLabel.setText(String.valueOf(athlete.getReactionTime()));
		
		JLabel eyesightValueLabel = ((SellAthleteDetailPanel) panel).getEyesightValueLabel();
		eyesightValueLabel.setText(String.valueOf(athlete.getEyeSight()));
		
		JLabel intelligenceValueLabel = ((SellAthleteDetailPanel) panel).getIntelligenceValueLabel();
		intelligenceValueLabel.setText(String.valueOf(athlete.getIntelligence()));
		
		JLabel staminaValueLabel = ((SellAthleteDetailPanel) panel).getStaminaValueLabel();
		staminaValueLabel.setText(String.valueOf(athlete.getStamina()));
		
		Difficulty diff = frame.getGame().getData().getDifficulty();
		int price = athlete.calculateSalePrice(diff.modifier);
		JLabel priceValueLabel = ((SellAthleteDetailPanel) panel).getPriceValueLabel();
		priceValueLabel.setText("$" + String.valueOf(price));
	}
	
	/**
	 * Initializes confirm button to confirm sale
	 */
	private void initializeConfirmButton() {
		JButton confirmButton = ((SellAthleteDetailPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Market market = frame.getGame().getMarket();
				market.sellAthlete(athlete);
				toPreviousScreen();
			}
		});
	}
	
	/**
	 * Returns to previous screen
	 */
	@Override
	protected void toPreviousScreen() {
		frame.toMarketScreen(true);
	}

}
