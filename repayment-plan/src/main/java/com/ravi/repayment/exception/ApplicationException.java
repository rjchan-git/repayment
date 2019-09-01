/**
 * 
 */
package com.ravi.repayment.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Ravi
 *
 */
public class ApplicationException extends Exception {
	private static final long serialVersionUID = 567859878L;
	private  HttpStatus code;
	private String message;



	public ApplicationException(String message) {
		super();
		this.message = message;
	}

	public ApplicationException(String message, Throwable cause, HttpStatus code) {
		super(message, cause);
		this.code = code;
	}

	public ApplicationException(String message, HttpStatus code) {
		this.message=message;
		this.code = code;
	}

	public ApplicationException(Throwable cause, HttpStatus code) {
		super(cause);
		this.code = code;
	}

	public HttpStatus getCode() {
		return this.code;
	}
	
	public String getMessage() {
		return message;
	}
}