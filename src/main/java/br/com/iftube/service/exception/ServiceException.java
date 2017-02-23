package br.com.iftube.service.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6713220791650916173L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Exception e) {
		super(e);
	}

}
