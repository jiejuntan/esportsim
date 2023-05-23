package main.gui.stadium;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import main.exceptions.GameOverException;
import main.gui.GameFrame;
import main.gui.subclassable.Controller;
import main.model.Match;
import main.model.Team;

/**
 * Controller for match panel
 * 
 * @author Blake and Jun
 *
 */
public final class MatchController extends Controller {
	
	/**
	 * Opponent team
	 */
	Team opponent;
	
	/**
	 * Match being played
	 */
	Match match;

	/**
	 * Constructor for match screen.
	 * 
	 * @param frame game frame to manage navigation
	 * @param opponent opponent team to play match against
	 */
	public MatchController(GameFrame frame, Team opponent) {
		super(frame);
		this.opponent = opponent;
		this.match = new Match(frame.getGame().getData(), opponent);
		initialize();
	}

	/**
	 * Initializes panel and components then launches panel.
	 */
	@Override
	protected void initialize() {
		panel = new MatchPanel();
		
		setTimer();

		super.launch();
	}
	
	/**
	 * Sets a timer to advance the match and update panel
	 */
	private void setTimer() {		
        TimerTask task = new TimerTask() {
            public void run() {
				try {
					updateLabel();					
				} catch (GameOverException e) {
					cancel();
					showDialog(e.getType());
				}
                
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 300);
    }

	/**
	 * Updates label with match info
	 * @throws GameOverException	if match ends
	 */
	private void updateLabel() throws GameOverException {
		JTextArea matchLabel = ((MatchPanel) panel).getMatchLabel();
		matchLabel.setText(matchLabel.getText() + match.nextTurn() + "\n\n");		
	}
	
	/**
	 * Shows dialog when match ends
	 * 
	 * @param type result of match
	 */
	private void showDialog(GameOverException.Type type) {
		switch (type) {
		case MATCH_WON:
			JOptionPane.showMessageDialog(panel, 
	                "You have won the battle! Your reward is $" + 
			frame.getGame().getData().getDifficulty().prizeMoney + ".", 
	                "Match over!", JOptionPane.INFORMATION_MESSAGE);
			break;
		case MATCH_LOST:
			JOptionPane.showMessageDialog(panel, 
	                "You have lost the battle!\nTry adjusting your team's role distribution.\n\n" +
			"Offense favours Eyesight and Reaction Time allowing you to attack faster and do more damage.\n\n" +
	                		"Support favours Intelligence and Eyesight allowing you to heal more.\n\n" +
			"Tank favours Reaction Time and Intelligence allowing you to take aggro and tank hits.", 
	                "Match over!", JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			break;
		}
		frame.getGame().getData().setHasPlayed(true);
		toHomeScreen();
	}
	
	/**
	 * Returns to home screen after the match
	 */
	private void toHomeScreen() {
		frame.toHomeScreen();
	}
	
}
