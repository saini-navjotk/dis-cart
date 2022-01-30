package com.tcs.eas.rest.apis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cart Not Found !", value = HttpStatus.NOT_FOUND)
public class CartNotFoundException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3789926208768459709L;

	public CartNotFoundException(String message) {
        super(message);
    }
}
