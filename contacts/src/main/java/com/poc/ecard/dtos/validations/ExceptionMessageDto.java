package com.poc.ecard.dtos.validations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionMessageDto extends Exception {

    private String message;

}
