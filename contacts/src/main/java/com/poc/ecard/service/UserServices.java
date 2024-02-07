package com.poc.ecard.service;

import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.FindCommonContactsReq;
import com.poc.ecard.dtos.FindCommonContactsResponse;

public interface UserServices {
    ContactsBookResponse uploadContacts(ContactsBookReq contactsBookReq);
//    User addUser(User user);
    FindCommonContactsResponse findCommonContacts(FindCommonContactsReq findCommonContactsReq);
}
