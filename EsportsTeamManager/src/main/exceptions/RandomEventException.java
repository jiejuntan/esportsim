package main.exceptions;

/**
 * Thrown when random event occurs.
 * 
 * @author Jiejun Tan
 *
 */
public class RandomEventException extends Exception {

	/**
	 *	Type of event
	 */
	public enum Event {
		ADD, REMOVE, STAT
	}
	private Event event;
	
	/**
	 * Constructs exception
	 */
	public RandomEventException(Event event) {
		super();
		this.event = event;
	}
	
	/**
	 * @return the type
	 */
	public Event getEvent() {
		return event;
	}
	
}
