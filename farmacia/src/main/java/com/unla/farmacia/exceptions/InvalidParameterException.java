package com.unla.farmacia.exceptions;

public class InvalidParameterException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8507299493813327213L;
	private int code;
	private String message;

	public InvalidParameterException(String message) {
		super();
		this.message = message;
	}
}
