package main.exceptions;

/**
 * Thrown when adding a negative amount or if money is insufficient.
 *
 */
public final class IllegalFundsException extends Exception {

	public IllegalFundsException() {
	}

	public IllegalFundsException(String message) {
		super(message);
	}

}
