package com.poc.ecard.controller;


import com.poc.ecard.dtos.*;
import com.poc.ecard.entity.UserContactBook;
import com.poc.ecard.service.impl.ContactBookServicesImpl;
import com.poc.ecard.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-ops/")
@Slf4j
public class UserOps {

    @Autowired
    private ContactBookServicesImpl userProfileServices;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {

//        log.info("able to access test resource");
        return ResponseEntity.ok("Here is your resource");
    }

    @PostMapping("/upload_contacts_book")
//    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
    public ResponseEntity<ContactsBookResponse> uploadContacts(@RequestBody ContactsBookReq contactsBookReq) {
        ContactsBookResponse response = userProfileServices.uploadContacts(contactsBookReq);
        log.info("able to access upload_contacts resource");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update_contact")
    public ResponseEntity<ContactsBookResponse> addContact(@RequestBody ContactsBookReq contactsBookReq) {
        ContactsBookResponse response = userProfileServices.updateContacts(contactsBookReq);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove_contact")
    public ResponseEntity<ContactsBookResponse> deleteContact(@RequestBody ContactsBookReq contactsBookReq) {
        ContactsBookResponse response = userProfileServices.deleteContact(contactsBookReq);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/search")
    public ResponseEntity<List<UserContactBook>> searchProfile(@RequestBody ContactsBookReq contactsBookReq) {
        List<UserContactBook> response = userProfileServices.searchProfile(contactsBookReq);
        return ResponseEntity.ok(response);
    }
//    @PostMapping("/find_common_contacts")
////    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
//    public ResponseEntity<FindCommonContactsResponse> addUser(@RequestBody FindCommonContactsReq findCommonContactsReq) {
////        FindCommonContactsResponse response = userServices.findCommonContacts(findCommonContactsReq);
//        return ResponseEntity.ok(null);
//    }

    @PostMapping("/add_user")
    public ResponseEntity<ContactsBookResponse> uploadUser(@RequestBody UserReq userReq) {
        ContactsBookResponse response = userService.uploaduser(userReq);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove_user")
    public ResponseEntity<ContactsBookResponse> removeuser(@RequestBody UserReq userReq) {
        ContactsBookResponse response = userService.removeuser(userReq);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update_user")
    public ResponseEntity<ContactsBookResponse> updateuser(@RequestBody UserReq userReq) {
        ContactsBookResponse response = userService.updateuser(userReq);
        return ResponseEntity.ok(response);
    }


}
