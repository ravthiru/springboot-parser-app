package com.test.parser.exception;

public class TransactionsFileUploadException extends Exception {

	static final long serialVersionUID = 1L;

	public TransactionsFileUploadException() {
	}

	public TransactionsFileUploadException(String message) {
		super(message);
	}

	public TransactionsFileUploadException(Throwable cause) {
		super(cause);
	}

	public TransactionsFileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransactionsFileUploadException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
