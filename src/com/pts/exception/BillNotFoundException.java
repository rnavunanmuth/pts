package com.pts.exception;

public class BillNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message = null;

	public BillNotFoundException() {
		super();
	}
	
	public BillNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public BillNotFoundException(Throwable cause) {
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
