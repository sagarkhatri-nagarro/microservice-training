package com.nagarro.assignment.account.exception;

/**
 * @author sagarkhatri
 *
 */
public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException(String exceptionText) {
		super(exceptionText);
	}

}
