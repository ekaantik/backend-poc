package com.poc.ecard.controller;


import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.FindCommonContactsReq;
import com.poc.ecard.dtos.FindCommonContactsResponse;
import com.poc.ecard.service.impl.UserProfileServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-ops/")
@Slf4j
public class UserOps {

    @Autowired
    private UserProfileServicesImpl userProfileServices;

    @GetMapping("/test")
    public ResponseEntity<String> test() {

        log.info("able to access test resource");
        return ResponseEntity.ok("Here is your resource");
    }

    @PostMapping("/upload_contacts")
//    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
    public ResponseEntity<ContactsBookResponse> uploadContacts(@RequestBody ContactsBookReq contactsBookReq) {
//        ContactsBookResponse response = userServices.uploadContacts(contactsBookReq);
        log.info("able to access upload_contacts resource");
        return ResponseEntity.ok(null);
    }


    @PostMapping("/find_common_contacts")
//    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
    public ResponseEntity<FindCommonContactsResponse> addUser(@RequestBody FindCommonContactsReq findCommonContactsReq) {
//        FindCommonContactsResponse response = userServices.findCommonContacts(findCommonContactsReq);
        return ResponseEntity.ok(null);
    }

}
