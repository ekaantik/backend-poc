package com.poc.ecard.service;


import com.poc.ecard.dtos.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthServicesImpl implements AuthServices{


    @Override
    public GenerateOtpResponse generateOtp(GenerateOtpReq generateOtpReq) {
        ContactsBookResponse contactsBookResponse = new ContactsBookResponse();
        contactsBookResponse.setMessage("");
        return null;
    }

    @Override
    public VerifyOtpResponse verifyOtp(VerifyOtpReq verifyOtpReq) {
        return null;
    }
}
