package com.okta.springbootvue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionCustom extends RuntimeException {
    public ResourceNotFoundExceptionCustom() {
        super();
    }

    public ResourceNotFoundExceptionCustom(String message) {
        super(message);
    }

    public ResourceNotFoundExceptionCustom(String message, Throwable cause) {
        super(message, cause);
    }
}
