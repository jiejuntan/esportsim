package main.gui;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import main.gui.controllers.DraftDetailController;
import main.gui.controllers.ClubController;
import main.gui.controllers.ClubDetailController;
import main.gui.controllers.DraftController;
import main.gui.controllers.HomeController;
import main.gui.controllers.RoleSwapController;
import main.gui.controllers.MatchController;
import main.gui.controllers.SetupController;
import main.gui.controllers.StartController;
import main.gui.controllers.StadiumController;
import main.gui.panels.ClubPanel;
import main.gui.panels.ThumbnailPanel;
import main.gui.panels.HomePanel;
import main.gui.panels.SetupPanel;
import main.gui.panels.StartPanel;
import main.model.Athlete;
import main.model.GameEnvironment;
import main.model.Team;

import javax.swing.JButton;

/**
 * Main access point of game, initializes frame and game environment, handles navigation
 * 
 * @author Jiejun Tan
 *
 */
public class GameFrame {

	/**
	 * App frame
	 */
	private JFrame frame;
	/**
	 * Game environment
	 */
	private GameEnvironment game;
	
	/**
	 * Get the game environment.
	 * @return
	 */
	public GameEnvironment getGame() {
		return game;
	}
	
	
	/**
	 * Update the frame to display new panel.
	 * @param panel	panel to display
	 */
	public void launchPanel(JPanel panel) {
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
	}	
	
	/**
	 * Close the current panel.
	 */
	public void closePanel() {
		frame.getContentPane().removeAll();
	}
	
	
	/**
	 * Launch the start screen.
	 */
	public void toStartScreen() {
		new StartController(this);
	}
	
	/**
	 * Launch the setup screen.
	 */
	public void toSetupScreen() {
		new SetupController(this);
	}
	
	/**
	 * Launch the draft screen.
	 */
	public void toDraftScreen() {
		new DraftController(this);
	}
	
	/**
	 * Launch the specified Athlete's detail screen.
	 * @param athlete	Athlete to view
	 */
	public void toDraftDetailScreen(Athlete athlete) {
		new DraftDetailController(this, athlete);
	}
	
	/**
	 * Launch the screen to swap specified Athlete.
	 */
	public void toRoleSwapScreen(Athlete athlete) {
		new RoleSwapController(this, athlete);
	}
	
	/**
	 * Launch the home screen.
	 */
	public void toHomeScreen() {
		new HomeController(this);
	}
	
	/**
	 * Launch the club screen.
	 */
	public void toClubScreen() {
		new ClubController(this);
	}
	
	public void toClubDetailScreen(Athlete athlete) {
		new ClubDetailController(this, athlete);
	}
	
	/**
	 * Launch the inventory screen.
	 */
	public void toInventoryScreen() {
		
	}
	
	/**
	 * Launch the market screen.
	 */
	public void toMarketScreen() {
		
	}
	
	/**
	 * Launch the stadium screen.
	 */
	public void toStadiumScreen() {
		new StadiumController(this);
	}
	
	/**
	 * Launch the match screen.
	 */
	public void toMatchScreen() {
		new MatchController(this);
	}
	
	/**
	 * Launch the end game screen.
	 */
	public void toEndgameScreen() {
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1600,900));
		frame.setResizable(false);
		frame.setBounds(100, 100, 100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlatLightLaf.setup();
		UIManager.put("Button.arc", 20);
		UIManager.put("Button.hoverBorderColor", Color.GRAY);
		UIManager.put("TextComponesssssnt.arc", 20);
		UIManager.put("Component.focusColor", Color.GRAY);
		UIManager.put("Component.focusedBorderColor", Color.GRAY);
	}
	
	/**
	 * Construct the game environment.
	 */
	private void initializeEnvironment() {
		game = new GameEnvironment();
	}
	
	/**
	 * Initialize the application.
	 */
	public GameFrame() {
		initializeEnvironment();
		initializeFrame();
		toStartScreen();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame window = new GameFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
