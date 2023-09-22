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

    //    User addUser(User user);
//    FindCommonContactsResponse findCommonContacts(FindCommonContactsReq findCommonContactsReq);
}
