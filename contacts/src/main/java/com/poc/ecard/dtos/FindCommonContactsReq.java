package com.poc.ecard.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindCommonContactsReq {
    private String userMobileNumber;
    private String otherMobileNumber;

}
