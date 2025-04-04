package com.poc.itextpdf.inbound.controller.handler;

import com.poc.itextpdf.core.domains.exception.DomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<?> handleDomainException(WebRequest request, DomainException exception) {
        return ResponseEntity
                .status(exception.getStatus())
                .body(new ApiError(exception.getError().getCode(), List.of(exception.getMessage())));
    }

}
