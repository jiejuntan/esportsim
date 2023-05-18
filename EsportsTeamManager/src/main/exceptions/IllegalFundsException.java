package main.exceptions;

/**
 * Thrown when adding a negative amount or if money is insufficient.
 *
 */
public class IllegalFundsException extends RuntimeException {

	public IllegalFundsException() {
	}

	public IllegalFundsException(String message) {
		super(message);
	}

}
