package com.poc.ecard;

import java.util.List;

public interface UserServices {
    //Fetching all the users from the database
    List<User> getAllUsers();

    //Fetching all the attributes of the user by userNum
    User getUserByUser_num(String user_num);

    //Adding a new user to database
    User addUser(User user);

    //Updating details of existing user to the database
    User updateUser(String userNum,User user);

    //deleting records of the user from the database
    User deleteUser(String user_num);

    //Fetching common contacts of the user and userNumToSearch
    User findCommonContacts(User user);
}