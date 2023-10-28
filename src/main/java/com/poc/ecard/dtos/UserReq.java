package com.poc.ecard.dtos;

import com.poc.ecard.entity.UserContactBook;
import lombok.*;

import java.util.List;

@Data
@ToString
public class UserReq {
    private String mobileNum;
    private String firstName;
    private String lastName;
    private String city;

    private List<ContactsBookReq> contactList;
}
