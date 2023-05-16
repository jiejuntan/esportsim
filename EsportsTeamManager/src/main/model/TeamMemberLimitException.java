package main.model;

public class TeamMemberLimitException extends Exception {
	public TeamMemberLimitException() {
		super();
	}
	
	public TeamMemberLimitException(String message) {
		super(message);
	}
}
