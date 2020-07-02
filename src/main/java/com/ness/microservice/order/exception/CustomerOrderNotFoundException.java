package com.ness.microservice.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomerOrderNotFoundException extends RuntimeException {

	public CustomerOrderNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
