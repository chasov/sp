package edu.rd.spcity.controller;

import edu.rd.spcity.dto.error.ErrorResultDto;
import edu.rd.spcity.exception.MigrationEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Перехватчик ошибок
 */
@Slf4j
@RestControllerAdvice
public class ResponseControllerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResultDto> handleValidationError(MethodArgumentNotValidException ex) {
        List<FieldError> constraintViolations = ex.getBindingResult().getFieldErrors();
        String debugMessage;
        if (constraintViolations.isEmpty()) {
            debugMessage = ex.getMessage();
        } else {
            debugMessage = constraintViolations.stream()
                    .map(x -> x.getField() + " " + x.getDefaultMessage() + " value was " + x.getRejectedValue())
                    .collect(Collectors.joining(" and "));
        }
        ErrorResultDto responseDto = ErrorResultDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Bad request")
                .debugInfo(debugMessage)
                .build();
        return ResponseEntity
                .status(responseDto.getStatus())
                .body(responseDto);
    }

    @ExceptionHandler({MigrationEntityException.class})
    public ResponseEntity<ErrorResultDto> handleMigrationError(MigrationEntityException e) {
        log.error(e.getMessage(), e);
        ErrorResultDto responseDto = ErrorResultDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Failed to migrate entity")
                .debugInfo(e.getMessage())
                .build();
        return ResponseEntity
                .status(responseDto.getStatus())
                .body(responseDto);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResultDto> handleExceptionError(Exception e) {
        log.error(e.getMessage(), e);
        ErrorResultDto responseDto = ErrorResultDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Internal error")
                .debugInfo(e.getMessage())
                .build();
        return ResponseEntity
                .status(responseDto.getStatus())
                .body(responseDto);
    }
}
