package temp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;

import com.formdev.flatlaf.FlatLightLaf;

public class StartTemp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartTemp window = new StartTemp();
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
	public StartTemp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1080,720));
		frame.setResizable(false);
		frame.setBounds(100, 100, 100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 20);
		
		JPanel panel = new JPanel();
		
		JButton newGameButton = new JButton("<html><center><span style=\"font-size: 50px\">"
				+ "Esports Simulator"
				+ "<br><br><br></span>"
				+ "<span style=\"font-size: 20px\">"
				+ "Press any button to start"
				+ "</span></center></html>");
		newGameButton.setContentAreaFilled(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setFont(new Font("Unispace", Font.PLAIN, 10));
		
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				frame.closePanel();
//				frame.launchSetupPanel();
			}
		});
		newGameButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				frame.closePanel();
//				frame.launchSetupPanel();
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(newGameButton, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(newGameButton, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
	}

}
