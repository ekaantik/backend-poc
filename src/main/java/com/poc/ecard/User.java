package com.poc.ecard;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String userNum;
    private String userNumToSearch;
    private String response;
    private List<String> phoneBookNum;
    private List<String> commonContacts;
    private String qrCodePath;
    private byte[] byteCode;
}
