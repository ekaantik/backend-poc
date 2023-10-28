package com.poc.ecard.service;

import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.UserReq;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();

    ContactsBookResponse uploaduser(UserReq req);


    ContactsBookResponse removeuser(UserReq req);

    ContactsBookResponse updateuser(UserReq req);
}
