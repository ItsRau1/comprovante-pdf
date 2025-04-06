package com.poc.itextpdf.core.domains.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DomainException extends RuntimeException {

	private final Error error;

	private final HttpStatus status;

	public DomainException(Error error, String message) {
		super(message);
		this.error = error;
		this.status = error.getStatus();
	}

}
