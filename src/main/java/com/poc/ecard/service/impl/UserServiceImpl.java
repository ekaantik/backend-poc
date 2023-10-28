package com.poc.ecard.service.impl;

import com.poc.ecard.dtos.ContactsBookReq;
import com.poc.ecard.dtos.ContactsBookResponse;
import com.poc.ecard.dtos.UserReq;
import com.poc.ecard.entity.User;
import com.poc.ecard.entity.UserContactBook;
import com.poc.ecard.repository.UserContactBookRepo;
import com.poc.ecard.repository.UserRepo;
import com.poc.ecard.service.UserService;
import com.poc.ecard.utils.UserContactUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepository;
    @Autowired
    UserContactBookRepo userContactBookRepo;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByMobileNum(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public ContactsBookResponse uploaduser(UserReq req) {
        String response = "";
        try{

            Optional<User> result = userRepository.findByMobileNum(req.getMobileNum());
            if(result.isPresent())
            {
                response="User Already Exits...";
            }
            else{
                User user = new User();
                user.setMobileNum(req.getMobileNum());
                user.setFirstname(req.getFirstName());
                user.setLastname(req.getLastName());
                user.setCity(req.getCity());
                user.setContactList(UserContactUtils.contactLists(req.getContactList(),user));
                userRepository.save(user);
                response="user Added Succssfully "+ req.getMobileNum();

            }
        }
        catch(Exception e){
            response="Error occurred while uploading user : " + req.getMobileNum();
        }
        ContactsBookResponse contactsBookResponse  = new ContactsBookResponse(response);
        return contactsBookResponse;
    }
    @Override
    public ContactsBookResponse removeuser(UserReq req) {
        String response = "";
        try{
            Optional<User> result = userRepository.findByMobileNum(req.getMobileNum());
            if(result.isPresent())
            {

                    userRepository.deleteByMobileNum(req.getMobileNum());
                response="Deleted Successfully...";
            }
            else{
                response="User Not Exits...";

            }
        }
        catch(Exception e){
            response="Error occurred while Deleting user : " + req.getMobileNum();
        }
        ContactsBookResponse contactsBookResponse  = new ContactsBookResponse(response);
        return contactsBookResponse;
    }
    @Override
    public ContactsBookResponse updateuser(UserReq req) {
        String response = "";
        try{

            Optional<User> result = userRepository.findByMobileNum(req.getMobileNum());
            if(result.isPresent())
            {
                User user = result.get();
                user.setFirstname(req.getFirstName());
                user.setLastname(req.getLastName());
                user.setCity(req.getCity());
                userRepository.save(user);
                response="user updated Succssfully "+ req.getMobileNum();
            }
            else{
                response="User Not Already Exits...";
            }
        }
        catch(Exception e){
            response="Error occurred while uploading user : " + req.getMobileNum();
        }
        ContactsBookResponse contactsBookResponse  = new ContactsBookResponse(response);
        return contactsBookResponse;
    }
}
