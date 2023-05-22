package main.exceptions;

/**
 * Thrown when all weeks have passed or player is unable to continue the game.
 * 
 * @author Jiejun Tan
 *
 */
public class GameOverException extends Exception {

	/**
	 * Constructs exception
	 */
	public GameOverException() {
		super();
	}
}
