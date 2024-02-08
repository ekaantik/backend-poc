package com.poc.ecard.service;

import com.google.zxing.WriterException;
import com.poc.ecard.dtos.User;
import com.poc.ecard.entity.UserDetails;
import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.FindCommonContactsReq;
import com.poc.ecard.dtos.FindCommonContactsResponse;

import java.io.IOException;
import java.util.List;

public interface UserServices {
    ContactsBookResponse uploadContacts(ContactsBookReq contactsBookReq);
//    User addUser(User user);
    FindCommonContactsResponse findCommonContacts(FindCommonContactsReq findCommonContactsReq);

    List<UserDetails> getUser();
    User addUser(User user);
    User findCommonContacts(User user);

    User generateQRCode(User user) throws WriterException, IOException;

    User generateByteCode(User user) throws WriterException, IOException;
}
