package com.poc.ecard;


import com.poc.ecard.User;
import com.poc.ecard.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserOps {
    @Autowired
    private UserServices userServices;

    //Mapping to getUserProfileData
    //@GetMapping
    //public ResponseEntity<String> findCustomers(@PathVariable String userId)
    //{
    //    String response=userServices.getUserProfileData(userId);
    //    return ResponseEntity.ok(response);
    //}

    //Mapping to addUser
    @PostMapping("/add")
    public ResponseEntity<User> addCustomer(@RequestBody User user)
    {
        return ResponseEntity.ok(userServices.addUser(user));
    }

    //Mapping to get
    @GetMapping("/find_common_contacts")
    public ResponseEntity<User> find_Common_Contacts(@RequestBody User user)
    {
        return ResponseEntity.ok(userServices.findCommonContacts(user));
    }
}
