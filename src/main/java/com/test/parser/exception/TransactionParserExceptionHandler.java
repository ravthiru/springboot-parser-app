package com.test.parser.exception;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class TransactionParserExceptionHandler {

	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<ErrorResponse> invalidRequestException(InvalidRequestException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse("", ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse("", ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TransactionsFileUploadException.class)
	public ResponseEntity<ErrorResponse> TransactionsFileUploadHandler(TransactionsFileUploadException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse("", ex.getMessage(), request.getDescription(false));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<ErrorResponse> handleException(Throwable ex, WebRequest request) {
		ex.printStackTrace();
		ErrorResponse error = new ErrorResponse("", ErrorMessages.GENERIC_ERROR_MESSAGE, request.getDescription(false));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> requestValidationException(ConstraintViolationException ex, WebRequest request) {
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
		ErrorResponse errorDetails = new ErrorResponse("", message, request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}


}