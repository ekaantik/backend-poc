package com.poc.ecard;

import lombok.*;

import java.util.List;

//Class to interact with user at frontend
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

    private String user_name;

    private String user_age;

    private String user_email;

    private String user_description;

    private String userNum;

    private String userNumToSearch;

    private String response;

    private List<String> phoneBookNum ;

    private List<String> commonContacts ;
}