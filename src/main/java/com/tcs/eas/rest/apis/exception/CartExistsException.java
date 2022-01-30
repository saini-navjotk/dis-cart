package com.tcs.eas.rest.apis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "cart already exists !", value = HttpStatus.BAD_REQUEST)
public class CartExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4730366414907710866L;

	public CartExistsException(String message) {
        super(message);
    }
}
