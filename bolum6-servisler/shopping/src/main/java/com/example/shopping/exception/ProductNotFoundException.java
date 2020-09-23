package com.example.shopping.exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -2600611698036809749L;

	public ProductNotFoundException() {
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException(Throwable cause) {
		super(cause);
	}

	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
