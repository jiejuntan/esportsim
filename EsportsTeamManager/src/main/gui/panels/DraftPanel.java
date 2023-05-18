package main.gui.panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.gui.GUIConstants;

/**
 * Modular layout for screens displaying athletes such as drafting, club, market screen
 * 
 * @author Jiejun Tan
 *
 */
public class DraftPanel extends JPanel {
	
	private List<JButton> athleteButtons;	
	private JLabel moneyLabel;
	private JButton confirmButton;

	public DraftPanel() {	
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{2.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 2.0, 0.0, 3.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);


		JLabel titleLabel = new JLabel("Draft Team");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.HEADING));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridwidth = 11;
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 1;
		this.add(titleLabel, gbc_titleLabel);
		
		JLabel removableSubtitleLabel1 = new JLabel("Placeholder");
		removableSubtitleLabel1.setVisible(false);
		removableSubtitleLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		removableSubtitleLabel1.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.SUBHEADING));
		GridBagConstraints gbc_removableSubtitleLabel1 = new GridBagConstraints();
		gbc_removableSubtitleLabel1.gridwidth = 11;
		gbc_removableSubtitleLabel1.insets = new Insets(0, 0, 5, 0);
		gbc_removableSubtitleLabel1.gridx = 0;
		gbc_removableSubtitleLabel1.gridy = 3;
		this.add(removableSubtitleLabel1, gbc_removableSubtitleLabel1);
		
		JLabel removableSubtitleLabel2 = new JLabel("Placeholder");
		removableSubtitleLabel2.setVisible(false);
		removableSubtitleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		removableSubtitleLabel2.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.SUBHEADING));
		GridBagConstraints gbc_removableSubtitleLabel2 = new GridBagConstraints();
		gbc_removableSubtitleLabel2.gridwidth = 11;
		gbc_removableSubtitleLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_removableSubtitleLabel2.gridx = 0;
		gbc_removableSubtitleLabel2.gridy = 7;
		this.add(removableSubtitleLabel2, gbc_removableSubtitleLabel2);
		
		
		athleteButtons = new ArrayList<JButton>();
		
		JButton athleteButton0 = new JButton();
		athleteButtons.add(athleteButton0);
		BufferedImage athletePortrait0 = null;
		try {
			athletePortrait0 = ImageIO.read(new File(getClass()
					.getResource(GUIConstants.PORTRAIT_PLACEHOLDER)
					.toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		athleteButton0.setIcon(new ImageIcon(athletePortrait0
				.getScaledInstance(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL, Image.SCALE_DEFAULT)));
		athleteButton0.setRolloverIcon(
				new ImageIcon(GUIConstants
						.tintImage(athletePortrait0, GUIConstants.PORTRAIT_BUTTON_ROLLOVER)
						.getScaledInstance(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL, Image.SCALE_DEFAULT)));
		athleteButton0.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton0.setBorder(GUIConstants.PORTRAIT_BORDER_SMALL);
		athleteButton0.setEnabled(false);
		GridBagConstraints gbc_athleteButton0 = new GridBagConstraints();
		gbc_athleteButton0.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton0.gridx = 1;
		gbc_athleteButton0.gridy = 5;
		this.add(athleteButton0, gbc_athleteButton0);
		
		JButton athleteButton1 = new JButton();
		athleteButtons.add(athleteButton1);
		athleteButton1.setEnabled(false);
		athleteButton1.setOpaque(true);
		athleteButton1.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton1.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton1.setBackground(GUIConstants.COMPONENT);
		athleteButton1.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton1 = new GridBagConstraints();
		gbc_athleteButton1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton1.gridx = 3;
		gbc_athleteButton1.gridy = 5;
		this.add(athleteButton1, gbc_athleteButton1);
		
		JButton athleteButton2 = new JButton();
		athleteButtons.add(athleteButton2);
		athleteButton2.setEnabled(false);
		athleteButton2.setOpaque(true);
		athleteButton2.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton2.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton2.setBackground(GUIConstants.COMPONENT);
		athleteButton2.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton2 = new GridBagConstraints();
		gbc_athleteButton2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton2.gridx = 5;
		gbc_athleteButton2.gridy = 5;
		this.add(athleteButton2, gbc_athleteButton2);
		
		JButton athleteButton3 = new JButton();
		athleteButtons.add(athleteButton3);
		athleteButton3.setEnabled(false);
		athleteButton3.setOpaque(true);
		athleteButton3.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton3.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton3.setBackground(GUIConstants.COMPONENT);
		athleteButton3.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton3 = new GridBagConstraints();
		gbc_athleteButton3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton3.gridx = 7;
		gbc_athleteButton3.gridy = 5;
		this.add(athleteButton3, gbc_athleteButton3);
		
		JButton athleteButton4 = new JButton();
		athleteButtons.add(athleteButton4);
		athleteButton4.setEnabled(false);
		athleteButton4.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton4.setOpaque(true);
		athleteButton4.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton4.setFocusPainted(false);
		athleteButton4.setBackground(GUIConstants.COMPONENT);
		GridBagConstraints gbc_athleteButton4 = new GridBagConstraints();
		gbc_athleteButton4.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton4.gridx = 9;
		gbc_athleteButton4.gridy = 5;
		this.add(athleteButton4, gbc_athleteButton4);
		
		JButton athleteButton5 = new JButton();
		athleteButtons.add(athleteButton5);
		athleteButton5.setEnabled(false);
		athleteButton5.setOpaque(true);
		athleteButton5.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton5.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton5.setBackground(GUIConstants.COMPONENT);
		athleteButton5.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton5 = new GridBagConstraints();
		gbc_athleteButton5.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton5.gridx = 1;
		gbc_athleteButton5.gridy = 9;
		this.add(athleteButton5, gbc_athleteButton5);
		
		JButton athleteButton6 = new JButton();
		athleteButtons.add(athleteButton6);
		athleteButton6.setEnabled(false);
		athleteButton6.setOpaque(true);
		athleteButton6.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton6.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton6.setBackground(GUIConstants.COMPONENT);
		athleteButton6.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton6 = new GridBagConstraints();
		gbc_athleteButton6.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton6.gridx = 3;
		gbc_athleteButton6.gridy = 9;
		this.add(athleteButton6, gbc_athleteButton6);
		
		JButton athleteButton7 = new JButton();
		athleteButtons.add(athleteButton7);
		athleteButton7.setEnabled(false);
		athleteButton7.setOpaque(true);
		athleteButton7.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton7.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton7.setBackground(GUIConstants.COMPONENT);
		athleteButton7.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton7 = new GridBagConstraints();
		gbc_athleteButton7.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton7.gridx = 5;
		gbc_athleteButton7.gridy = 9;
		this.add(athleteButton7, gbc_athleteButton7);
			
		JButton athleteButton8 = new JButton();
		athleteButtons.add(athleteButton8);
		athleteButton8.setEnabled(false);
		athleteButton8.setOpaque(true);
		athleteButton8.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton8.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton8.setBackground(GUIConstants.COMPONENT);
		athleteButton8.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton8 = new GridBagConstraints();
		gbc_athleteButton8.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton8.gridx = 7;
		gbc_athleteButton8.gridy = 9;
		this.add(athleteButton8, gbc_athleteButton8);
		
		JButton athleteButton9 = new JButton();
		athleteButtons.add(athleteButton9);
		athleteButton9.setEnabled(false);
		athleteButton9.setPreferredSize(new Dimension(GUIConstants.PORTRAIT_SMALL, GUIConstants.PORTRAIT_SMALL));
		athleteButton9.setOpaque(true);
		athleteButton9.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton9.setFocusPainted(false);
		athleteButton9.setBackground(GUIConstants.COMPONENT);
		GridBagConstraints gbc_athleteButton9 = new GridBagConstraints();
		gbc_athleteButton9.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton9.gridx = 9;
		gbc_athleteButton9.gridy = 9;
		this.add(athleteButton9, gbc_athleteButton9);
				
		
		moneyLabel = new JLabel("$9999");
		moneyLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.fill = GridBagConstraints.VERTICAL;
		gbc_moneyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyLabel.gridx = 3;
		gbc_moneyLabel.gridy = 11;
		this.add(moneyLabel, gbc_moneyLabel);
		
		
		confirmButton = new JButton("Confirm");
		confirmButton.setPreferredSize(new Dimension(250, 50));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(GUIConstants.COMPONENT);
		confirmButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.insets = new Insets(0, 0, 5, 5);
		gbc_confirmButton.gridx = 5;
		gbc_confirmButton.gridy = 11;
		this.add(confirmButton, gbc_confirmButton);
	}

	/**
	 * @return the athleteButtons
	 */
	public List<JButton> getAthleteButtons() {
		return athleteButtons;
	}

	/**
	 * @return the moneyLabel
	 */
	public JLabel getMoneyLabel() {
		return moneyLabel;
	}

	/**
	 * @return the confirmButton
	 */
	public JButton getConfirmButton() {
		return confirmButton;
	}
	
}
