package com.unla.farmacia.exceptions;

public class InvalidTipoPersonaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3151265485767803726L;
	private int code;
	private String message;

	public InvalidTipoPersonaException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	
}
