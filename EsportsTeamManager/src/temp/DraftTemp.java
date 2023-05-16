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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class DraftTemp {

	private JFrame frame;
	private JTextField athleteTextField;
	private JTextField athleteTextField_0;
	private JTextField athleteTextField_1;
	private JTextField athleteTextField_2;
	private JTextField athleteTextField_3;
	private JTextField athleteTextField_4;
	private JTextField athleteTextField_5;
	private JTextField athleteTextField_6;
	private JTextField athleteTextField_7;

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
		gbl_panel.columnWidths = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0, 0, 10, 0, 0, 10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{3.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{2.0, 0.0, 2.0, 0.0, 0.0, 1.0, 0.0, 0.0, 2.0, 0.0, 3.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		JLabel lblNewLabel = new JLabel("Draft Team");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("<html><center>Athlete 1</center><br>Aggression: 5<br>Toughness: 5<br>Empathy: 5<br>Stamina: 5</html>");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		athleteTextField_0 = new JTextField();
		athleteTextField_0.setPreferredSize(new Dimension(150, 35));
		athleteTextField_0.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_0.setFont(new Font("Unispace", Font.PLAIN, 30));
		athleteTextField_0.setColumns(10);
		athleteTextField_0.setBackground(Color.WHITE);
		GridBagConstraints gbc_athleteTextField_0 = new GridBagConstraints();
		gbc_athleteTextField_0.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_0.gridx = 1;
		gbc_athleteTextField_0.gridy = 3;
		panel.add(athleteTextField_0, gbc_athleteTextField_0);
		
		athleteTextField_1 = new JTextField();
		athleteTextField_1.setPreferredSize(new Dimension(150, 35));
		athleteTextField_1.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_1.setFont(new Font("Unispace", Font.PLAIN, 30));
		athleteTextField_1.setColumns(10);
		athleteTextField_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_athleteTextField_1 = new GridBagConstraints();
		gbc_athleteTextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_1.gridx = 3;
		gbc_athleteTextField_1.gridy = 3;
		panel.add(athleteTextField_1, gbc_athleteTextField_1);
		
		athleteTextField_2 = new JTextField();
		athleteTextField_2.setPreferredSize(new Dimension(150, 35));
		athleteTextField_2.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_2.setFont(new Font("Unispace", Font.PLAIN, 30));
		athleteTextField_2.setColumns(10);
		athleteTextField_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_athleteTextField_2 = new GridBagConstraints();
		gbc_athleteTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_2.gridx = 5;
		gbc_athleteTextField_2.gridy = 3;
		panel.add(athleteTextField_2, gbc_athleteTextField_2);
		
		athleteTextField_3 = new JTextField();
		athleteTextField_3.setPreferredSize(new Dimension(150, 35));
		athleteTextField_3.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_3.setFont(new Font("Unispace", Font.PLAIN, 30));
		athleteTextField_3.setColumns(10);
		athleteTextField_3.setBackground(Color.WHITE);
		GridBagConstraints gbc_athleteTextField_3 = new GridBagConstraints();
		gbc_athleteTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_3.gridx = 7;
		gbc_athleteTextField_3.gridy = 3;
		panel.add(athleteTextField_3, gbc_athleteTextField_3);
		
		
		tglbtnNewToggleButton.setOpaque(true);
		tglbtnNewToggleButton.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton.setBackground(Color.GRAY);
		tglbtnNewToggleButton.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton = new GridBagConstraints();
		gbc_tglbtnNewToggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton.gridx = 1;
		gbc_tglbtnNewToggleButton.gridy = 4;
		panel.add(tglbtnNewToggleButton, gbc_tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("<html>\r\n<center>Athlete 2</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>\r\nStamina: 5\r\n</html>");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton_1.setOpaque(true);
		tglbtnNewToggleButton_1.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_1.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_1.setBackground(Color.GRAY);
		tglbtnNewToggleButton_1.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_1 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_1.gridx = 3;
		gbc_tglbtnNewToggleButton_1.gridy = 4;
		panel.add(tglbtnNewToggleButton_1, gbc_tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("<html>\r\n<center>Athlete 3</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>\r\nStamina: 5\r\n</html>");
		tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton_2.setOpaque(true);
		tglbtnNewToggleButton_2.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_2.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_2.setBackground(Color.GRAY);
		tglbtnNewToggleButton_2.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_2 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_2.gridx = 5;
		gbc_tglbtnNewToggleButton_2.gridy = 4;
		panel.add(tglbtnNewToggleButton_2, gbc_tglbtnNewToggleButton_2);
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("<html>\r\n<center>Athlete 4</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>\r\nStamina: 5\r\n</html>");
		tglbtnNewToggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton_3.setOpaque(true);
		tglbtnNewToggleButton_3.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_3.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_3.setBackground(Color.GRAY);
		tglbtnNewToggleButton_3.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_3 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_3.gridx = 7;
		gbc_tglbtnNewToggleButton_3.gridy = 4;
		panel.add(tglbtnNewToggleButton_3, gbc_tglbtnNewToggleButton_3);
		
		JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("<html>\r\n<center>Athlete 5</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>\r\nStamina: 5\r\n</html>");
		tglbtnNewToggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		athleteTextField_4 = new JTextField();
		athleteTextField_4.setPreferredSize(new Dimension(150, 35));
		athleteTextField_4.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_4.setFont(new Font("Unispace", Font.PLAIN, 30));
		athleteTextField_4.setColumns(10);
		athleteTextField_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_athleteTextField_4 = new GridBagConstraints();
		gbc_athleteTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_4.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_4.gridx = 1;
		gbc_athleteTextField_4.gridy = 6;
		panel.add(athleteTextField_4, gbc_athleteTextField_4);
		
		athleteTextField_5 = new JTextField();
		athleteTextField_5.setPreferredSize(new Dimension(150, 35));
		athleteTextField_5.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_5.setFont(new Font("Unispace", Font.PLAIN, 30));
		athleteTextField_5.setColumns(10);
		athleteTextField_5.setBackground(Color.WHITE);
		GridBagConstraints gbc_athleteTextField_5 = new GridBagConstraints();
		gbc_athleteTextField_5.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_5.gridx = 3;
		gbc_athleteTextField_5.gridy = 6;
		panel.add(athleteTextField_5, gbc_athleteTextField_5);
		
		athleteTextField_6 = new JTextField();
		athleteTextField_6.setFocusable(false);
		athleteTextField_6.setEditable(false);
		athleteTextField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		athleteTextField_6.setText("dsa");
		athleteTextField_6.setHorizontalAlignment(SwingConstants.CENTER);
		athleteTextField_6.setPreferredSize(new Dimension(150, 35));
		athleteTextField_6.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_6.setFont(new Font("Unispace", Font.PLAIN, 30));
		athleteTextField_6.setColumns(10);
		athleteTextField_6.setBackground(Color.WHITE);
		GridBagConstraints gbc_athleteTextField_6 = new GridBagConstraints();
		gbc_athleteTextField_6.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_6.gridx = 5;
		gbc_athleteTextField_6.gridy = 6;
		panel.add(athleteTextField_6, gbc_athleteTextField_6);
		
		athleteTextField_7 = new JTextField();
		athleteTextField_7.setPreferredSize(new Dimension(150, 35));
		athleteTextField_7.setMargin(new Insets(5, 10, 2, 10));
		athleteTextField_7.setFont(new Font("Unispace", Font.PLAIN, 30));
		athleteTextField_7.setColumns(10);
		athleteTextField_7.setBackground(Color.WHITE);
		GridBagConstraints gbc_athleteTextField_7 = new GridBagConstraints();
		gbc_athleteTextField_7.insets = new Insets(0, 0, 5, 5);
		gbc_athleteTextField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_athleteTextField_7.gridx = 7;
		gbc_athleteTextField_7.gridy = 6;
		panel.add(athleteTextField_7, gbc_athleteTextField_7);
		
		
		tglbtnNewToggleButton_4.setOpaque(true);
		tglbtnNewToggleButton_4.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_4.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_4.setBackground(Color.GRAY);
		tglbtnNewToggleButton_4.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_4 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_4.gridx = 1;
		gbc_tglbtnNewToggleButton_4.gridy = 7;
		panel.add(tglbtnNewToggleButton_4, gbc_tglbtnNewToggleButton_4);
		
		JToggleButton tglbtnNewToggleButton_5 = new JToggleButton("<html>\r\n<center>Athlete 6</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>\r\nStamina: 5\r\n</html>");
		tglbtnNewToggleButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton_5.setOpaque(true);
		tglbtnNewToggleButton_5.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_5.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_5.setBackground(Color.GRAY);
		tglbtnNewToggleButton_5.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_5 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_5.gridx = 3;
		gbc_tglbtnNewToggleButton_5.gridy = 7;
		panel.add(tglbtnNewToggleButton_5, gbc_tglbtnNewToggleButton_5);
		
		JToggleButton tglbtnNewToggleButton_6 = new JToggleButton("<html>\r\n<center>Athlete 7</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>\r\nStamina: 5\r\n</html>");
		tglbtnNewToggleButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton_6.setOpaque(true);
		tglbtnNewToggleButton_6.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_6.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_6.setBackground(Color.GRAY);
		tglbtnNewToggleButton_6.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_6 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_6.gridx = 5;
		gbc_tglbtnNewToggleButton_6.gridy = 7;
		panel.add(tglbtnNewToggleButton_6, gbc_tglbtnNewToggleButton_6);
			
		JToggleButton tglbtnNewToggleButton_7 = new JToggleButton("<html>\r\n<center>Athlete 8</center><br>\r\nAggression: 5<br>\r\nToughness: 5<br>\r\nEmpathy: 5<br>\r\nStamina: 5\r\n</html>");
		tglbtnNewToggleButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton_7.setOpaque(true);
		tglbtnNewToggleButton_7.setPreferredSize(new Dimension(200, 200));
		tglbtnNewToggleButton_7.setFont(new Font("Unispace", Font.PLAIN, 20));
		tglbtnNewToggleButton_7.setBackground(Color.GRAY);
		tglbtnNewToggleButton_7.setFocusPainted(false);
		GridBagConstraints gbc_tglbtnNewToggleButton_7 = new GridBagConstraints();
		gbc_tglbtnNewToggleButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnNewToggleButton_7.gridx = 7;
		gbc_tglbtnNewToggleButton_7.gridy = 7;
		panel.add(tglbtnNewToggleButton_7, gbc_tglbtnNewToggleButton_7);
		
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setPreferredSize(new Dimension(200, 50));
		confirmButton.setFocusPainted(false);
		confirmButton.setBackground(Color.GRAY);
		confirmButton.setFont(new Font("Unispace", Font.PLAIN, 30));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("Money: $1000");
		lblNewLabel_1.setFont(new Font("Unispace", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 9;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 9;
		panel.add(confirmButton, gbc_btnNewButton);
		
		
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
	}

}
