package com.poc.ecard.service;

import com.poc.ecard.config.TwilioConfig;
import com.poc.ecard.dtos.GenerateOtpReq;
import com.poc.ecard.dtos.GenerateOtpResponse;
import com.poc.ecard.dtos.OtpStatus;
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
public class AuthServicesImpl  {//implements AuthServices

    @Autowired
    private TwilioConfig twilioConfig;

    Map<String, String> otpMap = new HashMap<>();


    public Mono<GenerateOtpResponse> sendOTPForPasswordReset(GenerateOtpReq generateOtpReq) {
        log.info("method sendOTPForPasswordReset .... ");
        GenerateOtpResponse generateOtpResponse = null;
        try {
            PhoneNumber to = new PhoneNumber(generateOtpReq.getUserMobileNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
            String otpMessage = "Dear Customer , Your OTP is ##" + otp + "##. Use this Passcode to complete your transaction. Thank You.";
            log.info("otpMessage : {} to phone number {} frp, phone number {}",otpMessage, to,from);
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            log.info(" message : {} ",message);
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


}