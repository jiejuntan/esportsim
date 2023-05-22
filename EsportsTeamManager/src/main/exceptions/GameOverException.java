package main.exceptions;

import main.exceptions.TeamLimitException.Type;

/**
 * Thrown when all weeks have passed or player is unable to continue the game.
 * 
 * @author Jiejun Tan
 *
 */
public class GameOverException extends Exception {

	/**
	 *	How the game ended
	 */
	public enum Type {
		FINISHED, NO_TEAM_NO_MONEY
	}
	private Type type;
	
	/**
	 * Constructs exception
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
