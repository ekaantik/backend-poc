package com.poc.ecard.userops.controller;


import com.poc.ecard.User;
import com.poc.ecard.userops.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user)
    {
        User response = userServices.addUser(user);
        return ResponseEntity.ok(response);
    }

    //Mapping to get
    @PostMapping("/find_common_contacts")
    public ResponseEntity<User> find_Common_Contacts(@RequestBody User user)
    {
        return ResponseEntity.ok(userServices.findCommonContacts(user));
    }
}
