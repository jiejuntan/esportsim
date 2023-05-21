package main.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import main.gui.controllers.DraftDetailController;
import main.gui.controllers.ClubController;
import main.gui.controllers.ClubDetailController;
import main.gui.controllers.DraftController;
import main.gui.controllers.HomeController;
import main.gui.controllers.InventoryController;
import main.gui.controllers.ItemDetailController;
import main.gui.controllers.MarketController;
import main.gui.controllers.RoleSwapController;
import main.gui.controllers.MatchController;
import main.gui.controllers.SetupController;
import main.gui.controllers.StartController;
import main.gui.controllers.StadiumController;
import main.gui.controllers.StadiumTeamDetailsController;
import main.model.Athlete;
import main.model.Equipment;
import main.model.GameEnvironment;
import main.model.Team;

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
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		revalidate();
	}	
	
	/**
	 * Revalidates frame if updates are needed.
	 */
	public void revalidate() {
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
	
	/**
	 * Launches athlete detail screen from club screen.
	 * 
	 * @param athlete	Athlete to view
	 */
	public void toClubDetailScreen(Athlete athlete) {
		new ClubDetailController(this, athlete);
	}
	
	/**
	 * Launch the inventory screen.
	 */
	public void toInventoryScreen() {
		new InventoryController(this);
	}
	
	/**
	 * Launch the item detail screen.
	 * 
	 * @param item	item to view
	 */
	public void toItemDetailScreen(Equipment item) {
		new ItemDetailController(this, item);
	}
	
	/**
	 * Launch the market screen.
	 */
	public void toMarketScreen() {
		new MarketController(this);
	}
	
	/**
	 * Launch the stadium screen.
	 */
	public void toStadiumScreen() {
		new StadiumController(this);
	}
	
	/**
	 * Launch the stadium team details screen.
	 */
	public void toTeamDetailsScreen(Team team) {
		new StadiumTeamDetailsController(this, team);
	}

	
	/**
	 * Launch the match screen.
	 */
	public void toMatchScreen(Team team) {
		new MatchController(this, team);
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
	 * Constructs the music player.
	 */
	private void initializeMusic() {
		Music player = new Music();
		player.setFile(GUIConstants.BACKGROUND_MUSIC);
		player.play();
	}
	
	/**
	 * Initialize the application.
	 */
	public GameFrame() {
		initializeEnvironment();
		initializeFrame();
		initializeMusic();
		initializeFont();
		toStartScreen();
	}

	/*
	 * Doesn't work
	 */
	private void initializeFont() {
		try {
			File file = new File(this.getClass().getResource(GUIConstants.UNISPACE).toURI());
			Font font = Font.createFont(Font.TRUETYPE_FONT, file);
		} catch (FontFormatException | IOException | URISyntaxException e) {
			e.printStackTrace();
		}
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
