package com.poc.ecard.controller;


import com.poc.ecard.dtos.GenerateOtpReq;
import com.poc.ecard.dtos.GenerateOtpResponse;
import com.poc.ecard.dtos.VerifyOtpReq;
import com.poc.ecard.dtos.VerifyOtpResponse;
import com.poc.ecard.service.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("api/v1")
public class Auth {

    @Autowired
    public AuthServices authServices;


    @PostMapping("/generate_otp")
    public ResponseEntity<GenerateOtpResponse> sendOTPForPasswordReset(@RequestBody GenerateOtpReq generateOtpReq) {
       Mono<GenerateOtpResponse> generateOtpResponse = authServices.sendOTPForPasswordReset(generateOtpReq);
       return ResponseEntity.ok(null);
    }


    @PostMapping("/verify_otp")
    public ResponseEntity<GenerateOtpResponse> validateOTP(@RequestBody VerifyOtpReq verifyOtpReq) {
        Mono<String> verifyOtpResponse = authServices.validateOTP(verifyOtpReq.getOtp(), verifyOtpReq.getUserMobileNumber());
        return ResponseEntity.ok(null);
    }
}
