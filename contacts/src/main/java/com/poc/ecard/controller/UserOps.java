package com.poc.ecard.controller;


import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.FindCommonContactsReq;
import com.poc.ecard.dtos.FindCommonContactsResponse;
import com.poc.ecard.service.UserProfileServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserOps {

    @Autowired
    private UserProfileServicesImpl userProfileServices;


    @PostMapping("/upload_contacts")
//    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
    public ResponseEntity<ContactsBookResponse> uploadContacts(@RequestBody ContactsBookReq contactsBookReq) {
//        ContactsBookResponse response = userServices.uploadContacts(contactsBookReq);
        return ResponseEntity.ok(null);
    }


    @PostMapping("/find_common_contacts")
//    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
    public ResponseEntity<FindCommonContactsResponse> addUser(@RequestBody FindCommonContactsReq findCommonContactsReq) {
//        FindCommonContactsResponse response = userServices.findCommonContacts(findCommonContactsReq);
        return ResponseEntity.ok(null);
    }

}
