package com.poc.itextpdf.core.domains.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {

    INTERNAL_SERVER_ERROR("RDBANK01", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST("RDBANK02", HttpStatus.BAD_REQUEST);

    private final String code;

    private final HttpStatus status;

    Error(String code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }

}
