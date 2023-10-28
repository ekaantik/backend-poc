package com.poc.ecard.utils;

import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.entity.User;
import com.poc.ecard.entity.UserContactBook;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
@Slf4j
public class UserContactUtils
{
    public static List<UserContactBook> contactLists(List<ContactsBookReq> contactsBookReqList, User user)
    {
        List<UserContactBook> userContactBookList = new ArrayList<>();
        for(ContactsBookReq contactsBookReq: contactsBookReqList){
            UserContactBook userContactBook = new UserContactBook();
            userContactBook.setUserMobileNum(contactsBookReq.getUserMobileNumber());
            userContactBook.setFirstName(contactsBookReq.getFirstName());
            userContactBook.setLastName(contactsBookReq.getLastName());
            userContactBook.setCurrentOccupation(contactsBookReq.getCurrentOccupation());
            userContactBook.setLinkedinProfileLink(contactsBookReq.getLinkedinProfileLink());
            userContactBook.setCurrentOccupation(contactsBookReq.getCurrentOccupation());
            userContactBook.setUser(user);
            userContactBookList.add(userContactBook);
        }
        return  userContactBookList;
    }

    public static List<UserContactBook> deletelist(List<ContactsBookReq> contactsBookReqList, User user)
    {
        List<UserContactBook> userContactBookList = new ArrayList<>();
        for(ContactsBookReq contactsBookReq: contactsBookReqList){
            UserContactBook userContactBook = new UserContactBook();
            userContactBook.setUserMobileNum(contactsBookReq.getUserMobileNumber());
            userContactBook.setUser(user);
            userContactBookList.add(userContactBook);
        }
        return  userContactBookList;
    }

}
