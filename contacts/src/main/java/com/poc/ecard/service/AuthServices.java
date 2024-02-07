package com.poc.ecard.service;

import com.poc.ecard.dtos.GenerateOtpReq;
import com.poc.ecard.dtos.GenerateOtpResponse;
import com.poc.ecard.dtos.VerifyOtpReq;
import com.poc.ecard.dtos.VerifyOtpResponse;

public interface AuthServices {
    GenerateOtpResponse generateOtp(GenerateOtpReq generateOtpReq);
    VerifyOtpResponse verifyOtp(VerifyOtpReq verifyOtpReq);


}
