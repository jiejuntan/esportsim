package main.exceptions;

/**
 * Thrown when adding a negative amount or if money is insufficient.
 *
 */
public final class IllegalFundsException extends Exception {

	/**
	 * Constructs exception
	 */
	public IllegalFundsException() {
	}

	/**
	 * Constructs exception with message
	 */
	public IllegalFundsException(String message) {
		super(message);
	}

}
