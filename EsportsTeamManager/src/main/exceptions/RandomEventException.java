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
		/**
		 * Athlete added
		 */
		ADD, 
		/**
		 * Athlete removed
		 */
		REMOVE, 
		/**
		 * Stat of athlete increased
		 */
		STAT
	}
	/**
	 * Property for event type
	 */
	private Event event;
	
	/**
	 * Constructs exception
	 */
	public RandomEventException(Event event) {
		super();
		this.event = event;
	}
	
	/**
	 * Gets event
	 * @return the type
	 */
	public Event getEvent() {
		return event;
	}
	
}
