package com.poc.ecard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userNum;

    private String userNumToSearch;

    private String response;

    private List<String> phoneBookNum ;

    private List<String> commonContacts ;

}
