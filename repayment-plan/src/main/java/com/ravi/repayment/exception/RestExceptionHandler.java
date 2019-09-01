/**
 * 
 */
package com.ravi.repayment.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Ravi
 *
 */
@ControllerAdvice
public class RestExceptionHandler {


	@ExceptionHandler(value=ApplicationException.class)
	protected ResponseEntity<ApiError> handleInvalidRequest(ApplicationException ex) {
		ApiError apiError = new ApiError();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setMessage(ex.getLocalizedMessage());
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

}