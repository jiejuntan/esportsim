package temp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import main.gui.GUIConstants;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class DraftTemp {
	
	private List<JButton> athleteButtons;	
	private JLabel moneyLabel;
	private JButton confirmButton;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DraftTemp window = new DraftTemp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DraftTemp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1600,900));
		frame.setResizable(false);
		frame.setBounds(100, 100, 100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 20);
		UIManager.put("Button.hoverBorderColor", Color.GRAY);
		UIManager.put("TextComponent.arc", 20);
		UIManager.put("Component.focusColor", Color.GRAY);
		UIManager.put("Component.focusedBorderColor", Color.GRAY);
		
		
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{2.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 2.0, 0.0, 3.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);


		JLabel titleLabel = new JLabel("Draft Team");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.HEADING));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridwidth = 11;
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 1;
		panel.add(titleLabel, gbc_titleLabel);
		
		
		athleteButtons = new ArrayList<JButton>();
		
		JLabel removableSubtitleLabel1 = new JLabel("Placeholder");
		removableSubtitleLabel1.setVisible(false);
		removableSubtitleLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		removableSubtitleLabel1.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.SUBHEADING));
		GridBagConstraints gbc_removableSubtitleLabel1 = new GridBagConstraints();
		gbc_removableSubtitleLabel1.gridwidth = 11;
		gbc_removableSubtitleLabel1.insets = new Insets(0, 0, 5, 0);
		gbc_removableSubtitleLabel1.gridx = 0;
		gbc_removableSubtitleLabel1.gridy = 3;
		panel.add(removableSubtitleLabel1, gbc_removableSubtitleLabel1);
		
		JButton athleteButton0 = new JButton("Athlete");
		athleteButtons.add(athleteButton0);
		athleteButton0.setOpaque(true);
		athleteButton0.setPreferredSize(new Dimension(250, 200));
		athleteButton0.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton0.setBackground(GUIConstants.COMPONENT);
		athleteButton0.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton0 = new GridBagConstraints();
		gbc_athleteButton0.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton0.gridx = 1;
		gbc_athleteButton0.gridy = 5;
		panel.add(athleteButton0, gbc_athleteButton0);
		
		JButton athleteButton1 = new JButton("Athlete");
		athleteButtons.add(athleteButton1);
		athleteButton1.setOpaque(true);
		athleteButton1.setPreferredSize(new Dimension(250, 200));
		athleteButton1.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton1.setBackground(GUIConstants.COMPONENT);
		athleteButton1.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton1 = new GridBagConstraints();
		gbc_athleteButton1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton1.gridx = 3;
		gbc_athleteButton1.gridy = 5;
		panel.add(athleteButton1, gbc_athleteButton1);
		
		JButton athleteButton2 = new JButton("Athlete");
		athleteButtons.add(athleteButton2);
		athleteButton2.setOpaque(true);
		athleteButton2.setPreferredSize(new Dimension(250, 200));
		athleteButton2.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton2.setBackground(GUIConstants.COMPONENT);
		athleteButton2.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton2 = new GridBagConstraints();
		gbc_athleteButton2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton2.gridx = 5;
		gbc_athleteButton2.gridy = 5;
		panel.add(athleteButton2, gbc_athleteButton2);
		
		JButton athleteButton3 = new JButton("Athlete");
		athleteButtons.add(athleteButton3);
		athleteButton3.setOpaque(true);
		athleteButton3.setPreferredSize(new Dimension(250, 200));
		athleteButton3.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton3.setBackground(GUIConstants.COMPONENT);
		athleteButton3.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton3 = new GridBagConstraints();
		gbc_athleteButton3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton3.gridx = 7;
		gbc_athleteButton3.gridy = 5;
		panel.add(athleteButton3, gbc_athleteButton3);
		
		JButton athleteButton3_1 = new JButton("Athlete");
		athleteButton3_1.setPreferredSize(new Dimension(250, 200));
		athleteButton3_1.setOpaque(true);
		athleteButton3_1.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton3_1.setFocusPainted(false);
		athleteButton3_1.setBackground(GUIConstants.COMPONENT);
		GridBagConstraints gbc_athleteButton3_1 = new GridBagConstraints();
		gbc_athleteButton3_1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton3_1.gridx = 9;
		gbc_athleteButton3_1.gridy = 5;
		panel.add(athleteButton3_1, gbc_athleteButton3_1);
		
		JLabel removableSubtitleLabel2 = new JLabel("Placeholder");
		removableSubtitleLabel2.setVisible(false);
		removableSubtitleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		removableSubtitleLabel2.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.SUBHEADING));
		GridBagConstraints gbc_removableSubtitleLabel2 = new GridBagConstraints();
		gbc_removableSubtitleLabel2.gridwidth = 11;
		gbc_removableSubtitleLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_removableSubtitleLabel2.gridx = 0;
		gbc_removableSubtitleLabel2.gridy = 7;
		panel.add(removableSubtitleLabel2, gbc_removableSubtitleLabel2);
		
		JButton athleteButton4 = new JButton("Athlete");
		athleteButtons.add(athleteButton4);
		athleteButton4.setOpaque(true);
		athleteButton4.setPreferredSize(new Dimension(250, 200));
		athleteButton4.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton4.setBackground(GUIConstants.COMPONENT);
		athleteButton4.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton4 = new GridBagConstraints();
		gbc_athleteButton4.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton4.gridx = 1;
		gbc_athleteButton4.gridy = 9;
		panel.add(athleteButton4, gbc_athleteButton4);
		
		JButton athleteButton5 = new JButton("Athlete");
		athleteButtons.add(athleteButton5);
		athleteButton5.setOpaque(true);
		athleteButton5.setPreferredSize(new Dimension(250, 200));
		athleteButton5.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton5.setBackground(GUIConstants.COMPONENT);
		athleteButton5.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton5 = new GridBagConstraints();
		gbc_athleteButton5.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton5.gridx = 3;
		gbc_athleteButton5.gridy = 9;
		panel.add(athleteButton5, gbc_athleteButton5);
		
		JButton athleteButton6 = new JButton("Athlete");
		athleteButtons.add(athleteButton6);
		athleteButton6.setOpaque(true);
		athleteButton6.setPreferredSize(new Dimension(250, 200));
		athleteButton6.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton6.setBackground(GUIConstants.COMPONENT);
		athleteButton6.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton6 = new GridBagConstraints();
		gbc_athleteButton6.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton6.gridx = 5;
		gbc_athleteButton6.gridy = 9;
		panel.add(athleteButton6, gbc_athleteButton6);
			
		JButton athleteButton7 = new JButton("Athlete");
		athleteButtons.add(athleteButton7);
		athleteButton7.setOpaque(true);
		athleteButton7.setPreferredSize(new Dimension(250, 200));
		athleteButton7.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton7.setBackground(GUIConstants.COMPONENT);
		athleteButton7.setFocusPainted(false);
		GridBagConstraints gbc_athleteButton7 = new GridBagConstraints();
		gbc_athleteButton7.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton7.gridx = 7;
		gbc_athleteButton7.gridy = 9;
		panel.add(athleteButton7, gbc_athleteButton7);
		
		JButton athleteButton7_1 = new JButton("Athlete");
		athleteButton7_1.setPreferredSize(new Dimension(250, 200));
		athleteButton7_1.setOpaque(true);
		athleteButton7_1.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.DETAIL));
		athleteButton7_1.setFocusPainted(false);
		athleteButton7_1.setBackground(GUIConstants.COMPONENT);
		GridBagConstraints gbc_athleteButton7_1 = new GridBagConstraints();
		gbc_athleteButton7_1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteButton7_1.gridx = 9;
		gbc_athleteButton7_1.gridy = 9;
		panel.add(athleteButton7_1, gbc_athleteButton7_1);
				
		
		moneyLabel = new JLabel("$9999");
		moneyLabel.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.fill = GridBagConstraints.VERTICAL;
		gbc_moneyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moneyLabel.gridx = 3;
		gbc_moneyLabel.gridy = 11;
		panel.add(moneyLabel, gbc_moneyLabel);
		
		
		confirmButton = new JButton("Confirm");
		confirmButton.setPreferredSize(new Dimension(250, 50));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(GUIConstants.COMPONENT);
		confirmButton.setFont(new Font(GUIConstants.FONT, Font.PLAIN, GUIConstants.BODY));
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.insets = new Insets(0, 0, 5, 5);
		gbc_confirmButton.gridx = 5;
		gbc_confirmButton.gridy = 11;
		panel.add(confirmButton, gbc_confirmButton);
		
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
	}

}
