package main.exceptions;

/**
 * Thrown when team member limit is reached.
 *
 */
public class TeamMemberLimitException extends RuntimeException {
	public TeamMemberLimitException() {
		super();
	}
	
	public TeamMemberLimitException(String message) {
		super(message);
	}
}
