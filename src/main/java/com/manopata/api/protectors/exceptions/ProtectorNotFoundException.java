package com.manopata.api.protectors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProtectorNotFoundException extends RuntimeException {
    public ProtectorNotFoundException(String message) {
        super(message);
    }
}
