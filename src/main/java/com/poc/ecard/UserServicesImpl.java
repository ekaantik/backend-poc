package com.poc.ecard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServicesImpl implements UserServices{

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserPhoneBookRepository userPhoneBookRepository;

    @Override
    public List<User> getAllUsers() {
        List<UserDetails> userDetailsList=userDetailsRepository.findAll();
        List<User> users=new ArrayList<>();
        for(int i=0;i<userDetailsList.size();i++)
        {
            //Setting userDetails to user for single user
            UserDetails ud=userDetailsList.get(i);
            User user=User.builder()
                    .user_name(ud.getUser_name())
                    .user_age(String.valueOf(ud.getUser_age()))
                    .user_description(ud.getUser_description())
                    .user_email(ud.getUser_email())
                    .userNum(ud.getUser_num())
                    .response(null)
                    .build();

            //Setting user_phone_book to user for single user

            //Fetching all UserPhoneBook objects corresponding to single UserDetails object
            List<UserPhoneBook> phoneBookList =ud.getUserPhoneBook();

            //Array list to store all phone book numbers of single user
            List<String> stringList=new ArrayList<>();

            //for-loop to store all phone book numbers in stringList
            for(int j=0;j< phoneBookList.size();j++)
            {
                //Fetching phone book numbers and inserting into the stringList
                stringList.add(phoneBookList.get(j).getPhone_book_num());
            }
            //Passing stringList to User object
            user.setPhoneBookNum(stringList);

            //inserting user into Users List
            users.add(user);
        }
        return users;
    }

    //    Fetching all the attributes of the user by userNum
    @Override
    public User getUserByUser_num(String user_num) {

        UserDetails ud=userDetailsRepository.findByUser_num(user_num);
        User user=User.builder()
                .user_name(ud.getUser_name())
                .user_age(String.valueOf(ud.getUser_age()))
                .user_description(ud.getUser_description())
                .user_email(ud.getUser_email())
                .userNum(ud.getUser_num())
                .response(null)
                .build();

        //storing all userPhoneBook objects in list
        List<UserPhoneBook> userPhoneBooklist=ud.getUserPhoneBook();

        //array list of string type to store phone book num of these objects
        List<String> stringList=new ArrayList<>();

        for(int i=0;i< userPhoneBooklist.size();i++)
        {
            stringList.add(userPhoneBooklist.get(i).getPhone_book_num());
        }
        //setting stringList in user object
        user.setPhoneBookNum(stringList);

        return user;
    }

    //Adding or creating a new to user to database
    @Override
    public User addUser(User user) {

        UserDetails userDetails = UserDetails.builder()
                .user_name(user.getUser_name())
                .user_age(Integer.parseInt(user.getUser_age()))
                .user_description(user.getUser_description())
                .user_email(user.getUser_email())
                .user_num(user.getUserNum())
                .build();
        userDetailsRepository.save(userDetails);


        List<UserPhoneBook> users=new ArrayList<>();
        try{
            for (int i=0;i<user.getPhoneBookNum().size();i++)
            {
                log.info("addUser : {}",user);
                UserPhoneBook userPhoneBook=new UserPhoneBook(user.getUserNum(),user.getPhoneBookNum().get(i));
                //Setting userDetails to userPhoneBook
                userPhoneBook.setUserDetails(userDetails);
                //saving userPhoneBook object to database
                UserPhoneBook userResponse=userPhoneBookRepository.save(userPhoneBook);
                users.add(userResponse);
            }
        } catch (Exception e){
            log.error("exception while adding user : ", e);
        }

        userDetails.setUserPhoneBook(users);
        String response  = "user with name "+user.getUser_name()+" is successfully added to the system" ;
        user.setResponse(response);
        return user;
    }

    @Override
    public User updateUser(String userNum,User user){
        UserDetails userDetails =userDetailsRepository.findByUser_num(userNum);

        userDetails.setUser_name(user.getUser_name());
        userDetails.setUser_age(Integer.parseInt(user.getUser_age()));
        userDetails.setUser_description(user.getUser_description());
        userDetails.setUser_email(user.getUser_email());
        userDetails.setUser_num(user.getUserNum());
        userDetails=userDetailsRepository.save(userDetails);

        //Fetching userPhoneBook objects of the specified user from database
        List<UserPhoneBook> userPhoneBook=userPhoneBookRepository.findByUser_num(userNum);

        //List of phone nos sent by user
        List<String> phoneBookNos=user.getPhoneBookNum();

//        List<UserPhoneBook> users=new ArrayList<>();

        for (int i = 0; i < user.getPhoneBookNum().size(); i++)
        {

                    log.info("addUser : {}", user);
                    //Fetching one object from the list
                    UserPhoneBook upb = userPhoneBook.get(i);
                    //set phone nos sent by user to the object
                    upb.setPhone_book_num(phoneBookNos.get(i));
                    //save the updated userPhonebook object
                    userPhoneBookRepository.save(upb);
        }
        user.builder()
                .user_name(userDetails.getUser_name())
                .user_age(String.valueOf(userDetails.getUser_age()))
                .user_description(userDetails.getUser_description())
                .user_email(userDetails.getUser_email())
                .userNum(userDetails.getUser_num())
                .build();

//Logic for storing phoneBookNum in user_phone_book table for different cases in which way user sent phoneBookNum
//        try
//        {
//            if(phoneBookNos.size()>userPhoneBook.size()) {
//                int j=0;
//                UserPhoneBook[] userPhoneBook1=new UserPhoneBook[(phoneBookNos.size()-userPhoneBook.size())];
//                for (int i = 0; i < phoneBookNos.size(); i++) {
//                    log.info("addUser : {}", user);
//                    //Fetching one object from the list
//                    UserPhoneBook upb = userPhoneBook.get(i);
//                    //set phone nos sent by user to the object
//                    upb.setPhone_book_num(phoneBookNos.get(i));
//                    //save the updated userPhonebook object
//                    UserPhoneBook userResponse = userPhoneBookRepository.save(upb);
//                    if(i>userPhoneBook.size())
//                    {
//                        userPhoneBook1[j].setUser_num(user.getUserNum());
//                        userPhoneBook1[j].setPhone_book_num(phoneBookNos.get(i));
//                        userPhoneBook1[j].setUserDetails(userDetails);
//                        j++;
//                    }
//                    users.add(userResponse);
//                }
//            }
//            else if(phoneBookNos.size()<userPhoneBook.size())
//            {
//                for (int i = 0; i < userPhoneBook.size(); i++) {
//                    log.info("addUser : {}", user);
//                    //Fetching one object from the list
//                    UserPhoneBook upb = userPhoneBook.get(i);
//                    //set phone nos sent by user to the object
//                    upb.setPhone_book_num(phoneBookNos.get(i));
//                    if(i> phoneBookNos.size())
//                    {
//                        userPhoneBookRepository.delete(upb);
//                    }
//                    //save the updated userPhonebook object
//                    UserPhoneBook userResponse = userPhoneBookRepository.save(upb);
//                }
//            }
//        }
//        catch (Exception e)
//        {
//            log.error("exception while adding user : ", e);
//        }
        String response  = "Details of user with name "+user.getUser_name()+" is successfully updated " ;
        user.setResponse(response);
        return user;
    }

    @Override
    public User deleteUser(String user_num) {
        User user=new User();
        UserDetails deletedUser = null;
        try {
            deletedUser = userDetailsRepository.findByUser_num(user_num);
            Long id=deletedUser.getUid();
            if (deletedUser == null) {
                throw new Exception();
            } else {
                userDetailsRepository.deleteById(id);
                String response="User named "+deletedUser.getUser_name()+" is deleted from the database!";
                user.setResponse(response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    //GetMapping to find_common_contacts
    @Override
    public User findCommonContacts(User user) {

        List<String> u1 = userPhoneBookRepository.getCommonContactsByUserPhoneBook(user.getUserNum(), user.getUserNumToSearch());
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