package com.poc.ecard.controller;


import com.poc.ecard.dtos.GenerateOtpReq;
import com.poc.ecard.dtos.GenerateOtpResponse;
import com.poc.ecard.dtos.VerifyOtpReq;
import com.poc.ecard.dtos.VerifyOtpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class Auth {

//    @Autowired
//    AuthServices authServices;

    @PostMapping("/generate_otp")
    public ResponseEntity<GenerateOtpResponse> generateOtp(@RequestBody GenerateOtpReq generateOtpReq) {
//        GenerateOtpResponse generateOtpResponse = authServices.generateOtp(generateOtpReq);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/verify_otp")
    public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody VerifyOtpReq verifyOtpReq) {
//        VerifyOtpResponse verifyOtpResponse = authServices.verifyOtp(verifyOtpReq);
        return ResponseEntity.ok(null);
    }

}
