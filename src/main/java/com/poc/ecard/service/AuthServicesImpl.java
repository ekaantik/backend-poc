package com.poc.ecard.service;

import com.poc.ecard.config.TwilioConfig;
import com.poc.ecard.dtos.*;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public abstract class AuthServicesImpl implements AuthServices {

    @Autowired
    private TwilioConfig twilioConfig;

    Map<String, String> otpMap = new HashMap<>();

    @Override
    public Mono<GenerateOtpResponse> sendOTPForPasswordReset(GenerateOtpReq generateOtpReq) {

        GenerateOtpResponse generateOtpResponse = null;
        try {
            PhoneNumber to = new PhoneNumber(generateOtpReq.getUserMobileNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
            String otpMessage = "Dear Customer , Your OTP is ##" + otp + "##. Use this Passcode to complete your transaction. Thank You.";
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            otpMap.put(generateOtpReq.getUserMobileNumber(), otp);
            generateOtpResponse = new GenerateOtpResponse(OtpStatus.DELIVERED, otpMessage);
        }
        catch (Exception ex){
            generateOtpResponse = new GenerateOtpResponse(OtpStatus.FAILED, ex.getMessage());
        }
        return Mono.just(generateOtpResponse);
    }

    /*@Override
    public String generateOTP() {
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }*/

    @Override
    public Mono<String> validateOTP(String userInputOtp, String userMobileNumber)
    {
        if (userInputOtp.equals(otpMap.get(userMobileNumber))) {
            otpMap.remove(userMobileNumber,userInputOtp);
            return Mono.just("Valid OTP please proceed with your transaction !");
        }
        else {
            return Mono.just("Invalid otp please retry !");
        }
    }
}