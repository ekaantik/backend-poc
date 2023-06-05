package com.poc.ecard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")

public class UserOps {

    @Autowired
    private UserServicesImpl userServices;


//    @Operation(summary = "Find all Customers for a Distributor/ Admin")
    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
    public ResponseEntity<String> findCustomers(@RequestParam("userId") String userId) {
//        String response = userServices.getUserProfileData(userId);
        return ResponseEntity.ok("working");
    }


    @PostMapping("/add")
//    @PreAuthorize("hasAnyAuthority('ADMIN','DISTRIBUTOR_ADMIN')")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User userResponse = userServices.addUser(user);
        return ResponseEntity.ok(userResponse);
    }


//    @PostMapping("/find_common_contacts")
//    public ResponseEntity<User> findCommonContacts(@RequestBody User user) {
//        User userResponse = userServices.findCommonContacts(user);
//        return ResponseEntity.ok(userResponse);
//    }

}
