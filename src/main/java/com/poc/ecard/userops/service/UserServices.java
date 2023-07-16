package com.poc.ecard.userops.service;

import com.poc.ecard.User;

public interface UserServices {
    //String getUserProfileData(String userId);
    User addUser(User user);
    User findCommonContacts(User user);
}
