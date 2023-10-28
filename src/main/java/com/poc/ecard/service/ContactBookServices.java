package com.poc.ecard.service;

import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.FindCommonContactsReq;
import com.poc.ecard.dtos.FindCommonContactsResponse;
import com.poc.ecard.entity.UserContactBook;

import java.util.List;

public interface ContactBookServices {
    ContactsBookResponse uploadContacts(ContactsBookReq contactsBookReq);
    ContactsBookResponse updateContacts(ContactsBookReq contactsBookReq);


    ContactsBookResponse deleteContact(ContactsBookReq contactsBookReq);
    List<UserContactBook> searchProfile(ContactsBookReq contactsBookReq);

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

    //    User addUser(User user);
//    FindCommonContactsResponse findCommonContacts(FindCommonContactsReq findCommonContactsReq);
}
