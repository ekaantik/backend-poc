package com.poc.ecard;


import com.google.zxing.WriterException;
import com.poc.ecard.User;
import com.poc.ecard.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/users")
public class UserOps {
    @Autowired
    private UserServices userServices;

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
