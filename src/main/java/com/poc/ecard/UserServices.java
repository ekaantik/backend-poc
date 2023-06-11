package com.poc.ecard;

import com.poc.ecard.User;

public interface UserServices {
    //String getUserProfileData(String userId);
    User addUser(User user);
    User findCommonContacts(User user);
}
