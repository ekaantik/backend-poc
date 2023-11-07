package com.poc.ecard.service;

import com.google.zxing.WriterException;
import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.UserReq;
import com.poc.ecard.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    UserDetailsService userDetailsService();

    String uploadImage(String path, MultipartFile file) throws IOException;

    ContactsBookResponse uploaduser(UserReq req);

    ContactsBookResponse removeuser(UserReq req);

    ContactsBookResponse updateuser(UserReq req);


}
