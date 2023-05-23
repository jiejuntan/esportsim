package main.exceptions;


/**
 * Thrown when match is won or lost.
 * Thrown when all weeks have passed or player is unable to continue the game.
 * 
 * @author Jiejun Tan
 *
 */
public class GameOverException extends Exception {

	/**
	 *	How the game or match ended
	 */
	public enum Type {
		/**
		 *  All weeks passed
		 */
		FINISHED, 
		/**
		 *  Not enough members and not enough money
		 */
		NO_TEAM_NO_MONEY, 
		/**
		 *  Match won
		 */
		MATCH_WON, 
		/**
		 *  Match lost
		 */
		MATCH_LOST
	}
	/**
	 * Property storing how the game or match ended
	 */
	private Type type;
	
	/**
	 * Constructs exception
	 * @param type how the game or match ended
	 */
	public GameOverException(Type type) {
		super();
		this.type = type;
	}
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
}
