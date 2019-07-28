package net.nkt.onlineportalpg.exception;

import java.io.Serializable;

public class PGNotFoundException extends Exception implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public PGNotFoundException() {
		this("PG is not available");
	}
	
	public PGNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": "+ message;
	}
	
	public String getMessage() {
		return message;
	}
}
