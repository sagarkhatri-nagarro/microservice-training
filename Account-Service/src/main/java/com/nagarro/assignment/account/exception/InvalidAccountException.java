package com.nagarro.assignment.account.exception;

/**
 * @author sagarkhatri
 *
 */
public class InvalidAccountException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidAccountException(String exceptionText) {
		super(exceptionText);
	}

}
