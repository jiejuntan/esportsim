package main.gui.gameover;

import javax.swing.JButton;

import main.gui.GameFrame;
import main.gui.subclassable.Controller;
import main.model.GameData;

/**
 * Controller for end screen.
 * 
 * @author Jiejun Tan
 *
 */
public final class EndController extends Controller {
	
	/**
	 * Constructor for end screen
	 * 
	 * @param frame game frame to manage navigation
	 */
	public EndController(GameFrame frame) {
		super(frame);
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new EndPanel();
		
		GameData data = frame.getGame().getData();
		String teamName = data.getTeam().getName();
		int weeks = data.getCurrentWeek();
		int money = data.getMoney();
		int wins = data.getTeam().getWins();
		int losses = data.getTeam().getLosses();
		
		JButton endGameButton = ((EndPanel) panel).getNewGameButton();
		endGameButton.setText("<html><center><span style=\"font-size: 70px\">"
				+ "Game Over"
				+ "<br></span>"
				+ "<span style=\"font-size: 20px\">"
				+ String.format("You lead the %s to:<br><br>%s wins and %s losses<br>Over %s weeks<br>While making $%s.<br>Awesome.",
						teamName, wins, losses, weeks, money)
				+ "<br><br>"
				+ "Thank you for playing!"
				+ "<br><br>"
				+ "</span></center></html>");
		super.launch();
	}
	
}
