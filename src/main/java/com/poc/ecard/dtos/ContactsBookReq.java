package com.poc.ecard.dtos;

import lombok.*;

import java.util.List;

@Data
@ToString
public class ContactsBookReq {
    private String userMobileNumber;
    private String firstName;
    private String lastName;
    private String currentOccupation;
    private String linkedinProfileLink;


    private List<String> contactList;

}
