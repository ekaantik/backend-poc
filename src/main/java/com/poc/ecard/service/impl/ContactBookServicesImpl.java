package com.poc.ecard.service.impl;


import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.UserReq;
import com.poc.ecard.entity.User;
import com.poc.ecard.entity.UserContactBook;
import com.poc.ecard.repository.UserContactBookRepo;
import com.poc.ecard.service.ContactBookServices;
import com.poc.ecard.utils.UserContactUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContactBookServicesImpl implements ContactBookServices {

    @Autowired
    UserContactBookRepo userContactBookRepo;


    @Override
    public ContactsBookResponse uploadContacts(ContactsBookReq req) {
        String response = "";
        try {
            UserContactBook userContactBook = new UserContactBook(req.getUserMobileNumber(), req.getFirstName(), req.getLastName(), req.getCurrentOccupation(), req.getLinkedinProfileLink());
            userContactBookRepo.save(userContactBook);

//            for (int i=0;i<req.getContactList().size();i++)
//            {
//                UserContactBook userContactBook = new UserContactBook(req.getUserMobileNumber(),req.getContactList().get(i));
//                userContactBookRepo.save(userContactBook);
//            }
            response = "contact book successfully added to the system for user " + req.getUserMobileNumber();
        } catch (Exception e) {
            log.info("Exception occurred while uploading contact book for user : {} with exception", req.getUserMobileNumber(), e.getMessage());
            response = "Error occurred while uploading contact book for user : " + req.getUserMobileNumber();
        }
        ContactsBookResponse contactsBookResponse = new ContactsBookResponse(response);
        return contactsBookResponse;
    }


    @Override
    public ContactsBookResponse updateContacts(ContactsBookReq req) {
        String response = "";
        try {
            Optional<UserContactBook> result = userContactBookRepo.findByUserMobileNum(req.getUserMobileNumber());
            if (result.isPresent()) {
                UserContactBook userContactBook = result.get();
                userContactBook.setFirstName(req.getFirstName());
                userContactBook.setLastName(req.getLastName());
                userContactBook.setCurrentOccupation(req.getCurrentOccupation());
                userContactBook.setLinkedinProfileLink(req.getLinkedinProfileLink());
                userContactBookRepo.save(userContactBook);
                response = "contact book successfully updated to the system for user " + req.getUserMobileNumber();
            } else {
                response = "User not found in the system";
            }

//            for (int i=0;i<req.getContactList().size();i++)
//            {
//                UserContactBook userContactBook = new UserContactBook(req.getUserMobileNumber(),req.getContactList().get(i));
//                userContactBookRepo.save(userContactBook);
//            }

        } catch (Exception e) {
            log.info("Exception occurred while uploading contact book for user : {} with exception", req.getUserMobileNumber(), e.getMessage());
            response = "Error occurred while uploading contact book for user : " + req.getUserMobileNumber();
        }
        ContactsBookResponse contactsBookResponse = new ContactsBookResponse(response);
        return contactsBookResponse;
    }

    @Override
    public ContactsBookResponse deleteContact(ContactsBookReq req) {
        String response = "";
        try {

            List<String> numlist = new ArrayList<>();
            for (String str : numlist)
            {
                numlist.add(req.getUserMobileNumber());
            }
            userContactBookRepo.deleteByUserMobileNum(numlist.toString());
                response = "Deleted..." + req.getUserMobileNumber();
//            for (int i=0;i<req.getContactList().size();i++) {
//                UserContactBook userContactBook = new UserContactBook(req.getUserMobileNumber(),req.getContactList().get(i));
//                userContactBookRepo.delete(userContactBook);
//                userContactBookRepo.deleteByUserMobileNum(req.getUserMobileNumber(),req.getContactList().get(i));
//                userContactBookRepo.deleteUserContactBookRepo(req.getUserMobileNumber(),req.getContactList().get(i));
//            }
        } catch (Exception e) {
            log.info("Exception occurred while deleting contact for user : {} with exception {}", req.getUserMobileNumber(), e.getMessage());
            response = "Error occurred while deleting contact for user : " + req.getUserMobileNumber();
        }
        ContactsBookResponse contactsBookResponse = new ContactsBookResponse(response);
        return contactsBookResponse;
    }

    @Override
    public List<UserContactBook> searchProfile(ContactsBookReq req) {
        List<UserContactBook> result = userContactBookRepo.findByFirstName(req.getFirstName());
        return result;
    }

//    @Override
//    public FindCommonContactsResponse findCommonContacts(FindCommonContactsReq findCommonContactsReq) {
////        findCommonContactsReq.ge
//        return null;
//    }


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
