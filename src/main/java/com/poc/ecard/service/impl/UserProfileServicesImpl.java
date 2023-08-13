package com.poc.ecard.service.impl;


import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.FindCommonContactsReq;
import com.poc.ecard.dtos.FindCommonContactsResponse;
import com.poc.ecard.repository.UserRepo;
import com.poc.ecard.service.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserProfileServicesImpl implements UserServices {

    @Autowired
    UserRepo userRepo;


    @Override
    public ContactsBookResponse uploadContacts(ContactsBookReq contactsBookReq) {
        return null;
    }

    @Override
    public FindCommonContactsResponse findCommonContacts(FindCommonContactsReq findCommonContactsReq) {

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
