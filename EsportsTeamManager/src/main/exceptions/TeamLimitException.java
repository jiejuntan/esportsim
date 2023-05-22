package main.exceptions;

/**
 * Thrown when team member limit is reached.
 *
 */
public final class TeamLimitException extends Exception {
	
	/**
	 *	Part of team that is full
	 */
	public enum Type {
		WHOLE, MAIN, RESERVE
	}
	private Type type;
	
	/**
	 * Constructor with type detail
	 * @param type which part of team is full
	 */
	public TeamLimitException(Type type) {
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
