package com.poc.ecard;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@Slf4j
public class UserOps {

    @Autowired
    private UserServicesImpl userServices;

    //GetMapping to get all users
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users=null;
        users = userServices.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //GetMapping to getByUserNum
    @GetMapping("/getByUserNum/{no}")
    public ResponseEntity<User> getByUserNum(@PathVariable("no") String userNum)
    {
        User user=userServices.getUserByUser_num(userNum);
        return ResponseEntity.ok(user);
    }

    //PostMapping to create User
    @PostMapping ("/add")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        User userResponse=null;
        userResponse=userServices.addUser(user);
        return ResponseEntity.ok(userResponse);
    }

    //Put Mapping to update User
    @PutMapping("/update/{no}")
    public ResponseEntity<User> updateUser(@PathVariable("no") String userNum,@RequestBody User user)
    {
        User userResponse=null;
        userResponse=userServices.updateUser(userNum,user);
        return ResponseEntity.ok(userResponse);
    }

    //Delete Mapping to delete user
    @DeleteMapping ("/deleteUser/{no}")
    public ResponseEntity<User> deleteUser(@PathVariable("no") String userNum)
    {
        User deletedUser=null;
        deletedUser=userServices.deleteUser(userNum);
        return ResponseEntity.ok(deletedUser);
    }

    //Get Mapping to find common contacts of two users
    @GetMapping ("/find_common_contacts")
    public ResponseEntity<User> findCommonContacts(@RequestBody User user) {
        User userResponse = userServices.findCommonContacts(user);
        return ResponseEntity.ok(userResponse);
    }

}