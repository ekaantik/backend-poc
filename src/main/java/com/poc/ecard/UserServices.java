package com.poc.ecard;

public interface UserServices {
    String getUserProfileData(String userId);
    User addUser(User user);
    User findCommonContacts(User user);
}
