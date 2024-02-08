package com.poc.ecard.exception.base;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Details implements Serializable {

    private static final long serialVersionUID = 7360620377397887104L;

    private String appError;
    private String appErrorCode;
    private String appErrorMessage;
}
