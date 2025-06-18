package org.example.user.infrastructure.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.example.user.domain.exception.DefaultException;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException ex) {
        int status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        String error = "Internal Server Error";
        String message = ex.getMessage();

        if (ex instanceof DefaultException dEx) {
            status = dEx.getStatusCode();
            error = Response.Status.fromStatusCode(status).getReasonPhrase();
        }
        return Response.status(status)
                .entity(new ErrorResponse(error, message))
                .build();
    }
}
