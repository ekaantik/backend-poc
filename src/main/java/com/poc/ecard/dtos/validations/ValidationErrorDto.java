package com.poc.ecard.dtos.validations;

import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import org.springframework.validation.FieldError;

//import javax.validation.ConstraintViolation;

@Getter
public class ValidationErrorDto {

    private final String field;

    private final String message;

    private final Object value;

    public ValidationErrorDto(ConstraintViolation<?> violation) {
        this.field = violation.getPropertyPath().toString();
        this.message = violation.getMessage();
        this.value = violation.getInvalidValue();
    }

    public ValidationErrorDto(FieldError error) {
        this.field = error.getField();
        this.message = error.getDefaultMessage();
        this.value = error.getRejectedValue();
    }

}
