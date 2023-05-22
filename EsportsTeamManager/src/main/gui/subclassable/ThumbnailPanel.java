package main.gui.subclassable;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.GUIConstants;

/**
 * Subclassable thumbnail layout for displaying athletes/items.
 * 
 * @author Jiejun Tan
 *
 */
public class ThumbnailPanel extends BasePanel {
	
	// Gettable components for controller manipulation. Protected properties are also exposed to subclasses.
	private List<JButton> thumbButtons;	
	protected JLabel moneyLabel;
	protected JButton backButton;
	protected JButton confirmButton;
	protected JLabel titleLabel;
	protected JLabel subheadingLabel1;
	protected JLabel subheadingLabel2;
	
	// Exposed components to toggle visibility in subclasses
	
	
	// Prevent instantiation without subclassing
	protected ThumbnailPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, GUIConstants.PORTRAIT_SMALL, 0, GUIConstants.PORTRAIT_SMALL, 0, GUIConstants.PORTRAIT_SMALL, 0, GUIConstants.PORTRAIT_SMALL, 0, GUIConstants.PORTRAIT_SMALL, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{2.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 2.0, 0.0, 3.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		titleLabel = new JLabel();
		super.setupTitle(titleLabel);
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridwidth = 11;
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 1;
		this.add(titleLabel, gbc_titleLabel);
		
		subheadingLabel1 = new JLabel();
		subheadingLabel1.setVisible(false);
		super.setupSubheading(subheadingLabel1);
		GridBagConstraints gbc_subheadingLabel1 = new GridBagConstraints();
		gbc_subheadingLabel1.gridwidth = 11;
		gbc_subheadingLabel1.insets = new Insets(0, 0, 5, 0);
		gbc_subheadingLabel1.gridx = 0;
		gbc_subheadingLabel1.gridy = 3;
		this.add(subheadingLabel1, gbc_subheadingLabel1);
		
		subheadingLabel2 = new JLabel();
		subheadingLabel2.setVisible(false);
		super.setupSubheading(subheadingLabel2);
		GridBagConstraints gbc_subheadingLabel2 = new GridBagConstraints();
		gbc_subheadingLabel2.gridwidth = 11;
		gbc_subheadingLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_subheadingLabel2.gridx = 0;
		gbc_subheadingLabel2.gridy = 7;
		this.add(subheadingLabel2, gbc_subheadingLabel2);
		
		
		thumbButtons = new ArrayList<JButton>();
		
		JButton thumbButton0 = new JButton();
		super.setupThumbnail(thumbButton0);
		thumbButtons.add(thumbButton0);
		GridBagConstraints gbc_thumbButton0 = new GridBagConstraints();
		gbc_thumbButton0.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton0.gridx = 1;
		gbc_thumbButton0.gridy = 5;
		this.add(thumbButton0, gbc_thumbButton0);
		
		JButton thumbButton1 = new JButton();
		super.setupThumbnail(thumbButton1);
		thumbButtons.add(thumbButton1);
		GridBagConstraints gbc_thumbButton1 = new GridBagConstraints();
		gbc_thumbButton1.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton1.gridx = 3;
		gbc_thumbButton1.gridy = 5;
		this.add(thumbButton1, gbc_thumbButton1);
		
		JButton thumbButton2 = new JButton();
		super.setupThumbnail(thumbButton2);
		thumbButtons.add(thumbButton2);
		GridBagConstraints gbc_thumbButton2 = new GridBagConstraints();
		gbc_thumbButton2.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton2.gridx = 5;
		gbc_thumbButton2.gridy = 5;
		this.add(thumbButton2, gbc_thumbButton2);
		
		JButton thumbButton3 = new JButton();
		super.setupThumbnail(thumbButton3);
		thumbButtons.add(thumbButton3);
		GridBagConstraints gbc_thumbButton3 = new GridBagConstraints();
		gbc_thumbButton3.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton3.gridx = 7;
		gbc_thumbButton3.gridy = 5;
		this.add(thumbButton3, gbc_thumbButton3);
		
		JButton thumbButton4 = new JButton();
		super.setupThumbnail(thumbButton4);
		thumbButtons.add(thumbButton4);
		GridBagConstraints gbc_thumbButton4 = new GridBagConstraints();
		gbc_thumbButton4.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton4.gridx = 9;
		gbc_thumbButton4.gridy = 5;
		this.add(thumbButton4, gbc_thumbButton4);
		
		JButton thumbButton5 = new JButton();
		super.setupThumbnail(thumbButton5);
		thumbButtons.add(thumbButton5);
		GridBagConstraints gbc_thumbButton5 = new GridBagConstraints();
		gbc_thumbButton5.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton5.gridx = 1;
		gbc_thumbButton5.gridy = 9;
		this.add(thumbButton5, gbc_thumbButton5);
		
		JButton thumbButton6 = new JButton();
		super.setupThumbnail(thumbButton6);
		thumbButtons.add(thumbButton6);
		GridBagConstraints gbc_thumbButton6 = new GridBagConstraints();
		gbc_thumbButton6.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton6.gridx = 3;
		gbc_thumbButton6.gridy = 9;
		this.add(thumbButton6, gbc_thumbButton6);
		
		JButton thumbButton7 = new JButton();
		super.setupThumbnail(thumbButton7);
		thumbButtons.add(thumbButton7);
		GridBagConstraints gbc_thumbButton7 = new GridBagConstraints();
		gbc_thumbButton7.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton7.gridx = 5;
		gbc_thumbButton7.gridy = 9;
		this.add(thumbButton7, gbc_thumbButton7);
			
		JButton thumbButton8 = new JButton();
		super.setupThumbnail(thumbButton8);
		thumbButtons.add(thumbButton8);
		GridBagConstraints gbc_thumbButton8 = new GridBagConstraints();
		gbc_thumbButton8.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton8.gridx = 7;
		gbc_thumbButton8.gridy = 9;
		this.add(thumbButton8, gbc_thumbButton8);
		
		JButton thumbButton9 = new JButton();
		super.setupThumbnail(thumbButton9);
		thumbButtons.add(thumbButton9);
		GridBagConstraints gbc_thumbButton9 = new GridBagConstraints();
		gbc_thumbButton9.insets = new Insets(0, 0, 5, 5);
		gbc_thumbButton9.gridx = 9;
		gbc_thumbButton9.gridy = 9;
		this.add(thumbButton9, gbc_thumbButton9);
				
		
		moneyLabel = new JLabel();
		moneyLabel.setVisible(false);
		moneyLabel.setFont(new Font(GUIConstants.FONT, GUIConstants.STYLE, GUIConstants.BODY));
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.fill = GridBagConstraints.VERTICAL;
		gbc_moneyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyLabel.gridx = 7;
		gbc_moneyLabel.gridy = 11;
		this.add(moneyLabel, gbc_moneyLabel);
		
		backButton = new JButton("Return");
		super.setupButton(backButton);
		backButton.setVisible(false);
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 0, 5, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 11;
		this.add(backButton, gbc_backButton);
		
		confirmButton = new JButton("Confirm");
		super.setupButton(confirmButton);
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.insets = new Insets(0, 0, 5, 5);
		gbc_confirmButton.gridx = 5;
		gbc_confirmButton.gridy = 11;
		this.add(confirmButton, gbc_confirmButton);
	}

	/**
	 * Hides bottom thumbnail buttons
	 */
	protected void disableBottomThumbs() {
		for (int i = 5; i < 10; i++) {
			thumbButtons.get(i).setVisible(false);
		}
	}
	
	/**
	 * @return the thumbButtons
	 */
	public List<JButton> getThumbButtons() {
		return thumbButtons;
	}

	/**
	 * @return the moneyLabel
	 */
	public JLabel getMoneyLabel() {
		return moneyLabel;
	}

	/**
	 * @return the backButton
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * @return the confirmButton
	 */
	public JButton getConfirmButton() {
		return confirmButton;
	}

	/**
	 * @return the titleLabel
	 */
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	/**
	 * @return the subheadingLabel1
	 */
	public JLabel getSubheadingLabel1() {
		return subheadingLabel1;
	}

	/**
	 * @return the subheadingLabel2
	 */
	public JLabel getSubheadingLabel2() {
		return subheadingLabel2;
	}
	
}
