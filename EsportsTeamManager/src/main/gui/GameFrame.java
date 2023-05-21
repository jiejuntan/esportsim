package main.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import main.gui.club.ClubController;
import main.gui.club.ClubDetailController;
import main.gui.club.InventoryController;
import main.gui.club.ItemDetailController;
import main.gui.drafting.DraftController;
import main.gui.drafting.DraftDetailController;
import main.gui.drafting.RoleSwapController;
import main.gui.home.HomeController;
import main.gui.market.MarketController;
import main.gui.stadium.MatchController;
import main.gui.stadium.StadiumController;
import main.gui.stadium.StadiumTeamDetailsController;
import main.gui.starting.SetupController;
import main.gui.starting.StartController;
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
public final class GameFrame {

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
		frame.revalidate();
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
