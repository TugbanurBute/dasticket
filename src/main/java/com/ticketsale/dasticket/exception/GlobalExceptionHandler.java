package com.ticketsale.dasticket.exception;

import com.ticketsale.dasticket.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEventNotFound(EventNotFoundException ex,
                                                             HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                errorResponseBuilder(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage(),
                        null,
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex,
                                                                   HttpServletRequest request) {
        Map<String,String> validationError = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> {
                    validationError.put(
                            fieldError.getField(),
                            fieldError.getDefaultMessage()
                    );
                });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseBuilder(
                HttpStatus.BAD_REQUEST,
                "Validation failed",
                validationError,
                request.getRequestURI()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex,
                                                                HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseBuilder(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred.",
                null,
                request.getRequestURI()
        ));
    }

    private ErrorResponse errorResponseBuilder(
            HttpStatus status,
            String message,
            Map<String,String> validationErrors,
            String path) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.name())
                .message(message)
                .validationErrors(validationErrors)
                .path(path)
                .build();
    }
}
