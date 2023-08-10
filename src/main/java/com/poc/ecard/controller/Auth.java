package com.poc.ecard.controller;


import com.poc.ecard.dtos.GenerateOtpReq;
import com.poc.ecard.dtos.GenerateOtpResponse;
import com.poc.ecard.service.AuthServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("api/v1")
@Slf4j
public class Auth {

    @Autowired
    public AuthServicesImpl authServices;


    @PostMapping("/generate_otp")
    public ResponseEntity<GenerateOtpResponse> sendOTPForPasswordReset(@RequestBody GenerateOtpReq generateOtpReq) {
       log.info("request received for sendOTPForPasswordReset : {}",generateOtpReq);
       Mono<GenerateOtpResponse> generateOtpResponse = authServices.sendOTPForPasswordReset(generateOtpReq);
       return ResponseEntity.ok(null);
    }

//
//    @PostMapping("/verify_otp")
//    public ResponseEntity<GenerateOtpResponse> validateOTP(@RequestBody VerifyOtpReq verifyOtpReq) {
//        Mono<String> verifyOtpResponse = authServices.validateOTP(verifyOtpReq.getOtp(), verifyOtpReq.getUserMobileNumber());
//        return ResponseEntity.ok(null);
//    }
}
