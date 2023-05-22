package main.gui;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import main.gui.club.ClubController;
import main.gui.club.ClubDetailController;
import main.gui.club.ClubRoleSwapController;
import main.gui.club.InventoryController;
import main.gui.club.ItemDetailController;
import main.gui.club.UseAthleteDetailController;
import main.gui.club.UseItemController;
import main.gui.drafting.DraftController;
import main.gui.drafting.DraftDetailController;
import main.gui.drafting.RoleSwapController;
import main.gui.gameover.EndController;
import main.gui.home.HomeController;
import main.gui.home.TrainAthleteController;
import main.gui.home.TrainAthleteDetailController;
import main.gui.market.MarketController;
import main.gui.market.MarketRoleSwapController;
import main.gui.market.PurchaseAthleteDetailController;
import main.gui.market.PurchaseItemDetailController;
import main.gui.market.SellAthleteDetailController;
import main.gui.market.SellItemDetailController;
import main.gui.stadium.MatchController;
import main.gui.stadium.StadiumController;
import main.gui.stadium.StadiumTeamDetailsController;
import main.gui.starting.SetupController;
import main.gui.starting.StartController;
import main.model.Athlete;
import main.model.Item;
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
	 * Launch the screen to swap specified Athlete in draft.
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
	 * Launch the training screen.
	 */
	public void toTrainAthleteScreen() {
		new TrainAthleteController(this);
	}
	
	/**
	 * Launch the training detail screen.
	 * 
	 * @param athlete 	Athlete to train
	 * @param item		Item to use for training
	 */
	public void toTrainAthleteDetailController(Athlete athlete, Item item) {
		new TrainAthleteDetailController(this, athlete, item);
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
	 * Launch the screen to swap specified Athlete in club.
	 */
	public void toClubRoleSwapScreen(Athlete athlete) {
		new ClubRoleSwapController(this, athlete);
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
	public void toItemDetailScreen(Item item) {
		new ItemDetailController(this, item);
	}
	
	/**
	 * Launch the athlete picking screen to use items
	 * 
	 * @param item	item to use
	 */
	public void toUseItemScreen(Item item) {
		new UseItemController(this, item);		
	}
	
	/**
	 * Launch the athlete detail screen to display bonus stats and confirm item use
	 * 
	 * @param athlete	Athlete to use item on 
	 * @param item		Item to use
	 */
	public void toUseAthleteDetailController(Athlete athlete, Item item) {
		new UseAthleteDetailController(this, athlete, item);		
	}
	
	/**
	 * Launch the market screen.
	 * 
	 * @param isSelling buy/sell mode
	 */
	public void toMarketScreen(boolean isSelling) {
		new MarketController(this, isSelling);
	}
	
	/**
	 * Launch the detail screen to purchase an athlete
	 * 
	 * @param athlete	athlete to purchase
	 */
	public void toPurchaseAthleteDetailScreen(Athlete athlete) {
		new PurchaseAthleteDetailController(this, athlete);
	}
	
	/**
	 * Launch the screen to swap specified Athlete in market.
	 */
	public void toMarketRoleSwapScreen(Athlete athlete) {
		new MarketRoleSwapController(this, athlete);
	}
	
	/**
	 * Launch the detail screen to sell an athlete
	 * 
	 * @param athlete	athlete to sell
	 */
	public void toSellAthleteDetailScreen(Athlete athlete) {
		new SellAthleteDetailController(this, athlete);
	}
	
	/**
	 * Launch the detail screen to purchase an item
	 * 
	 * @param item	item to purchase
	 */
	public void toPurchaseItemDetailScreen(Item item) {
		new PurchaseItemDetailController(this, item);
	}
	
	/**
	 * Launch the detail screen to sell an item
	 * 
	 * @param item	item to sell
	 */
	public void toSellItemDetailScreen(Item item) {
		new SellItemDetailController(this, item);
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
	public void toGameOverScreen() {
		new EndController(this);
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
