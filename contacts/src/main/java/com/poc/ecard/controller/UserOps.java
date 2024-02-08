package com.poc.ecard.controller;


import com.google.zxing.WriterException;
import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.User;
import com.poc.ecard.entity.UserDetails;
import com.poc.ecard.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserOps {

    @Autowired
    private UserServices userServices;


    @PostMapping("/upload_contacts")
//    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
    public ResponseEntity<ContactsBookResponse> uploadContacts(@RequestBody ContactsBookReq contactsBookReq) {
//        ContactsBookResponse response = userServices.uploadContacts(contactsBookReq);
        return ResponseEntity.ok(null);
    }


//    @PostMapping("/find_common_contacts")
////    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
//    public ResponseEntity<FindCommonContactsResponse> addUser(@RequestBody FindCommonContactsReq findCommonContactsReq) {
////        FindCommonContactsResponse response = userServices.findCommonContacts(findCommonContactsReq);
//        return ResponseEntity.ok(null);
//    }

    @GetMapping
    public ResponseEntity<List<UserDetails>> getUsers() throws IOException, WriterException {
        List<UserDetails> userDetails = userServices.getUser();
        return ResponseEntity.ok(userServices.getUser());
    }

    //Mapping to addUser
    @PostMapping("/add")
    public ResponseEntity<User> addCustomer(@RequestBody User user) throws IOException, WriterException {
        userServices.generateByteCode(user);
        userServices.generateQRCode(user);
        return ResponseEntity.ok(userServices.addUser(user));
    }

    //Mapping to get
    @PostMapping("/find_common_contacts")
    public ResponseEntity<User> find_Common_Contacts(@RequestBody User user)
    {
        return ResponseEntity.ok(userServices.findCommonContacts(user));
    }

}
