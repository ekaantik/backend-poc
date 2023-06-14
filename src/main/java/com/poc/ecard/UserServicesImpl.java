package com.poc.ecard;

import com.poc.ecard.User;
import com.poc.ecard.UserDetailsRepository;
import com.poc.ecard.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserDetailsRepository userDetailsRepository;



    //Overriding UserServices methods
    //@Override
    //public String getUserProfileData(String userId) {
    //    long userid=Long.parseLong(userId);
    //    return String.valueOf(userDetailsRepository.findById(userid).orElse(null));
    //}
    @Override
    public User addUser(User user) {

        try{
            for (int i=0;i<user.getPhoneBookNum().size();i++)
            {
                UserDetails userDetails=new UserDetails(user.getUserNum(), user.getPhoneBookNum().get(i));
                UserDetails userResponse=userDetailsRepository.save(userDetails);
            }
        }
        catch(Exception e){

            System.out.println(e.getMessage());
        }
        String response="user "+ user.getUserNum()+" successfully added to the system";
        User userAddResponse=new User();
        userAddResponse.setResponse(response);
        return userAddResponse;
    }

    @Override
    public User findCommonContacts(User user) {

        List<String> u1 = userDetailsRepository.getCommonContactsByUserDetails(user.getUserNum(), user.getUserNumToSearch());
//        System.out.println(u1);
        user.setCommonContacts(u1);
        if (u1.isEmpty()){
            user.setResponse("Empty String");
        }
        else{
            user.setResponse( user.getUserNum()+ " searches for "+ user.getUserNumToSearch()+  " and we find "+ user.getCommonContacts()+ " common contacts");
        }
        return user;
    }
}