package com.poc.ecard.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactsBookReq {
    private String userMobileNumber;

    private List<String> contactList;

}
