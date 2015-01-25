package com.pts.exception;

public class BillerNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message = null;

	public BillerNotFoundException() {
		super();
	}
	
	public BillerNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public BillerNotFoundException(Throwable cause) {
		super(cause);
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return message;
	}
	
}
