package com.poc.ecard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServicesImpl implements UserServices{

    @Autowired
    UserDetailsRepository userDetailsRepository;


    @Override
    public String getUserProfileData(String userId) {
        return "It is working";
    }

    @Override
    public User addUser(User user) {
        UserDetails userDetails = new UserDetails(user.getUserNum(), user.getPhoneBookNum().get(0));

        try{
            UserDetails userResponse = userDetailsRepository.save(userDetails);
        } catch (Exception e){
            log.error("exception while adding user : ", e);
        }

        User userAddResponse = new User();
        String response  = "user "+user.getUserNum()+" succesfully added to the system" ;
        userAddResponse.setResponse(response);
        return userAddResponse;
    }

    @Override
    public User findCommonContacts(User user) {
        return null;
    }

}
