package com.poc.ecard.controller;


import com.poc.ecard.dtos.GenerateOtpReq;
import com.poc.ecard.dtos.GenerateOtpResponse;
import com.poc.ecard.dtos.VerifyOtpReq;
import com.poc.ecard.dtos.VerifyOtpResponse;
import com.poc.ecard.service.impl.AuthServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auth/")
@Slf4j
public class Auth {

    @Autowired
    public AuthServicesImpl authServices;


    @PostMapping("/generate_otp")
    public ResponseEntity<GenerateOtpResponse> generateOtp(@RequestBody GenerateOtpReq generateOtpReq) {

       GenerateOtpResponse generateOtpResponse = authServices.generateOtp(generateOtpReq);
       return ResponseEntity.ok(generateOtpResponse);
    }

    @PostMapping("/verify_otp")
    public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody VerifyOtpReq verifyOtpReq) {
        VerifyOtpResponse response = authServices.verifyOtp(verifyOtpReq);
        return ResponseEntity.ok(response);
    }


}
