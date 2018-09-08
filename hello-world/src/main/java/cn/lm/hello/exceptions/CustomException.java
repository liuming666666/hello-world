package cn.lm.hello.exceptions;

import util.ResCode;

public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4919392642068246368L;
	
	private ResCode resCode;
	
	public CustomException() {
		super();
	}
	
	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(ResCode resCode) {
		super(resCode.getMessage());
		this.resCode = resCode;
	}
	
	public CustomException(Throwable t) {
		super(t);
	}
	
	public CustomException(String message, Throwable t) {
		super(message, t);
	}
	
	public ResCode getResCode() {
		return resCode;
	}

}
