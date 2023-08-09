package com.poc.ecard.service;

import com.poc.ecard.dtos.GenerateOtpReq;
import com.poc.ecard.dtos.GenerateOtpResponse;
import com.poc.ecard.dtos.VerifyOtpReq;
import com.poc.ecard.dtos.VerifyOtpResponse;
import lombok.Data;
import reactor.core.publisher.Mono;

public interface AuthServices {
    Mono<GenerateOtpResponse> sendOTPForPasswordReset(GenerateOtpReq generateOtpReq);

    GenerateOtpResponse generateOtp(GenerateOtpReq generateOtpReq);

    VerifyOtpResponse verifyOtp(VerifyOtpReq verifyOtpReq);


    String generateOTP();

    Mono<String> validateOTP(String userInputOtp, String userName);

    String validateOTP(VerifyOtpReq verifyOtpReq);
}
