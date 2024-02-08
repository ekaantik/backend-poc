package com.poc.ecard.service;


import com.google.zxing.WriterException;
import com.poc.ecard.dtos.User;
import com.poc.ecard.entity.UserDetails;
import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.FindCommonContactsReq;
import com.poc.ecard.dtos.FindCommonContactsResponse;
import com.poc.ecard.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class UserProfileServicesImpl implements UserServices{

    @Autowired
    UserProfileRepository userProfileRepository;


    @Override
    public ContactsBookResponse uploadContacts(ContactsBookReq contactsBookReq) {
        return null;
    }

    @Override
    public FindCommonContactsResponse findCommonContacts(FindCommonContactsReq findCommonContactsReq) {

        return null;
    }

    @Override
    public List<UserDetails> getUser() {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User findCommonContacts(User user) {
        return null;
    }

    @Override
    public User generateQRCode(User user) throws WriterException, IOException {
        return null;
    }

    @Override
    public User generateByteCode(User user) throws WriterException, IOException {
        return null;
    }


//    @Override
//    public User addUser(User user) {
//        UserProfile userProfile = new UserProfile(user.getUserNum());
//
//        try{
//            UserProfile userResponse = userDetailsRepository.save(userProfile);
//        } catch (Exception e){
//            log.error("exception while adding user : ", e);
//        }
//
//        User userAddResponse = new User();
//        String response  = "user "+user.getUserNum()+" successfully added to the system" ;
//        userAddResponse.setResponse(response);
//        return userAddResponse;
//    }


}
