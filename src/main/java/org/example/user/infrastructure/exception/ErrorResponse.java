package org.example.user.infrastructure.exception;

public record ErrorResponse(
        String error,
        String message
) { }
