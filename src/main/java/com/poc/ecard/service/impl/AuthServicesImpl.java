package com.poc.ecard.service.impl;

import com.poc.ecard.dtos.*;
import com.poc.ecard.entity.Role;
import com.poc.ecard.entity.User;
import com.poc.ecard.repository.UserRepo;
import com.poc.ecard.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServicesImpl  {//implements AuthServices
    @Autowired
    private OtpService otpService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepo userRepo;

    public GenerateOtpResponse generateOtp(GenerateOtpReq req) {
        log.info("method sendOTPForPasswordReset .... ");
        GenerateOtpResponse generateOtpResponse = null;
        try {
            otpService.generateOtp(req.getUserMobileNum());
            generateOtpResponse = new GenerateOtpResponse(OtpStatus.DELIVERED, "");
        }
        catch (Exception ex){
            log.info("Exception in generateOtp : {} ",ex);
            generateOtpResponse = new GenerateOtpResponse(OtpStatus.FAILED, ex.getMessage());
        }
        return generateOtpResponse;
    }



    public VerifyOtpResponse verifyOtp(@RequestBody VerifyOtpReq req){
        VerifyOtpResponse response = null;
        try{
            if(req.getOtp().equals(otpService.getCacheOtp(req.getUserMobileNum()))){
                log.info("OTP is verified with cache");
//                String jwtToken = createAuthToken(req);
                User user = User.builder().mobileNum(req.getUserMobileNum()).role(Role.USER).build();
                Optional<User> dbResponse = userRepo.findByMobileNum(req.getUserMobileNum());
                if(dbResponse.isEmpty()){
                    userRepo.save(user);
                }

                String jwtToken = jwtService.generateToken(user);
                response = new VerifyOtpResponse("success","Otp verified successfully",jwtToken);
//                otpService.clearOtp(req.getUserMobileNumber());
            }else{
                response = new VerifyOtpResponse("success","Otp is either expired or incorrect","Could not generate jwt token");
            }

        } catch (Exception e){
            log.info("Exception while doing verification of otp : {}",e);
            response = new VerifyOtpResponse("failed",e.getMessage(),"Exception occurred while generating jwt token");
        }
        return response;
    }

//    public String createAuthToken(VerifyOtpReq req) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(req.getUserMobileNumber(), "")
//            );
//        }
//        catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
////        final UserDetails userDetails = userDetailsService
////                .loadUserByUsername(req.getUserMobileNumber());
////        Generate Token
////        jwtTokenUtil.generateToken(userDetails);
//        return null;
//    }


}