package org.example.user.domain.exception;

public class DefaultException extends RuntimeException {
    private final int statusCode;

    public DefaultException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
