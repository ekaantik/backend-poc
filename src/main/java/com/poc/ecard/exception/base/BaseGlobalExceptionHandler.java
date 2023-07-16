package com.poc.ecard.exception.base;

import com.poc.ecard.dtos.validations.ExceptionResponseDto;
import com.poc.ecard.dtos.validations.ValidationErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import retrofit2.HttpException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseGlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ValidationErrorDto> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(ValidationErrorDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ValidationErrorDto>> handleConstraintViolationException(
            ConstraintViolationException ex) {
        List<ValidationErrorDto> errors = ex.getConstraintViolations().stream()
                .map(ValidationErrorDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EcardException.class)
    public ResponseEntity<ExceptionResponseDto> handleDigiWalletException(EcardException ex) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(exceptionResponseDto);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<String> handleHttpException(HttpException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ex.getMessage());
    }

}
