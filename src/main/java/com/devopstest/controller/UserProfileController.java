package com.devopstest.controller;


import com.devopstest.profileService.ProfileClientService;
import com.devopstest.request.AccountDeactivateRequest;
import com.devopstest.request.UpdatePasswordRequestBody;
import com.devopstest.response.AccountDeactivateResponse;
import com.devopstest.response.UpdatePasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class UserProfileController {


    @Autowired
    ProfileClientService profileClientService;

    private static final Logger LOGGER = Logger.getLogger(UserProfileController.class.getName());



    @PostMapping("/v1/deactivate")
    public AccountDeactivateResponse register(@RequestBody AccountDeactivateRequest requestBody) throws Exception {

        LOGGER.info("Authentication Client update password request started with "+requestBody);
        AccountDeactivateResponse response =  profileClientService.executeDeactivate(requestBody);
        LOGGER.info("Authentication client update password ending with Response :" +response.toString());
        return  response;

    }





}
