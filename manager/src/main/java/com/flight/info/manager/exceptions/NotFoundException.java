package com.flight.info.manager.exceptions;

import static java.lang.String.format;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id, String message) {
        super(format(message, id));
    }
}
