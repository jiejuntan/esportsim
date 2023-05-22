package main.gui.home;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GUIConstants;
import main.gui.subclassable.BasePanel;

/**
 * Panel for home screen.
 * 
 * @author Jiejun Tan
 *
 */
public final class HomePanel extends BasePanel {
	
	// Gettable components for controller manipulation. Protected properties are also exposed to subclasses.
	private JLabel weekLabel;
	private JLabel moneyLabel;
	private JLabel winsLabel;
	private JLabel lossesLabel;
	private JButton clubButton;
	private JButton stadiumButton;
	private JButton marketButton;
	private JButton endWeekButton;
	
	/**
	 * Constructor for home panel
	 */
	public HomePanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 100, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		JLabel titleLabel = new JLabel("Esports Simulator");
		super.setupTitle(titleLabel);
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.gridwidth = 3;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 1;
		this.add(titleLabel, gbc_titleLabel);
		
		
		weekLabel = new JLabel();
		weekLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_weekLabel = new GridBagConstraints();
		gbc_weekLabel.insets = new Insets(0, 0, 5, 5);
		gbc_weekLabel.gridx = 1;
		gbc_weekLabel.gridy = 3;
		this.add(weekLabel, gbc_weekLabel);
		
		moneyLabel = new JLabel();
		moneyLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyLabel.gridx = 1;
		gbc_moneyLabel.gridy = 4;
		this.add(moneyLabel, gbc_moneyLabel);
		
		winsLabel = new JLabel();
		winsLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_winsLabel = new GridBagConstraints();
		gbc_winsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_winsLabel.gridx = 1;
		gbc_winsLabel.gridy = 5;
		this.add(winsLabel, gbc_winsLabel);
		
		lossesLabel = new JLabel();
		lossesLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_lossesLabel = new GridBagConstraints();
		gbc_lossesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lossesLabel.gridx = 1;
		gbc_lossesLabel.gridy = 6;
		this.add(lossesLabel, gbc_lossesLabel);
		
		clubButton = new JButton("Club");
		super.setupButton(clubButton);
		GridBagConstraints gbc_clubButton = new GridBagConstraints();
		gbc_clubButton.insets = new Insets(0, 0, 5, 5);
		gbc_clubButton.gridx = 3;
		gbc_clubButton.gridy = 3;
		this.add(clubButton, gbc_clubButton);
		
		stadiumButton = new JButton("Stadium");
		super.setupButton(stadiumButton);
		GridBagConstraints gbc_btnStadium = new GridBagConstraints();
		gbc_btnStadium.insets = new Insets(0, 0, 5, 5);
		gbc_btnStadium.gridx = 3;
		gbc_btnStadium.gridy = 4;
		this.add(stadiumButton, gbc_btnStadium);
		
		marketButton = new JButton("Market");
		super.setupButton(marketButton);
		GridBagConstraints gbc_marketButton = new GridBagConstraints();
		gbc_marketButton.insets = new Insets(0, 0, 5, 5);
		gbc_marketButton.gridx = 3;
		gbc_marketButton.gridy = 5;
		this.add(marketButton, gbc_marketButton);
		
		
		endWeekButton = new JButton("End Week");
		super.setupButton(endWeekButton);
		GridBagConstraints gbc_endWeekButton = new GridBagConstraints();
		gbc_endWeekButton.gridwidth = 3;
		gbc_endWeekButton.insets = new Insets(0, 0, 5, 5);
		gbc_endWeekButton.gridx = 1;
		gbc_endWeekButton.gridy = 8;
		this.add(endWeekButton, gbc_endWeekButton);
	}

	/**
	 * @return the weekLabel
	 */
	public JLabel getWeekLabel() {
		return weekLabel;
	}

	/**
	 * @return the moneyLabel
	 */
	public JLabel getMoneyLabel() {
		return moneyLabel;
	}

	/**
	 * @return the winsLabel
	 */
	public JLabel getWinsLabel() {
		return winsLabel;
	}

	/**
	 * @return the lossesLabel
	 */
	public JLabel getLossesLabel() {
		return lossesLabel;
	}

	/**
	 * @return the clubButton
	 */
	public JButton getClubButton() {
		return clubButton;
	}
	
	/**
	 * @return the clubButton
	 */
	public JButton getStadiumButton() {
		return stadiumButton;
	}

	/**
	 * @return the marketButton
	 */
	public JButton getMarketButton() {
		return marketButton;
	}

	/**
	 * @return the endWeekButton
	 */
	public JButton getEndWeekButton() {
		return endWeekButton;
	}
	

}
