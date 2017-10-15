package com.ingenico.payment.exception;

/**
 * @author Mahendra
 * Runtime exception will be thrown if some exception occured 
 * while saving data
 */
public class DataFormatException extends RuntimeException {
	private static final long serialVersionUID = -4019736304397608728L;
	public DataFormatException() {
		super();
	}
	public DataFormatException(String message, Throwable ex) {
		super(message,ex);
	}
	public DataFormatException(String message) {
		super(message);
	}
	public DataFormatException(Throwable ex) {
		super(ex);
	}

}
