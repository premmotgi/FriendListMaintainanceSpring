package com.devopstest.controller;


import com.devopstest.authenticationService.AuthenticationClientService;
import com.devopstest.dao.Friend;
import com.devopstest.request.AuthClientRequestBody;
import com.devopstest.response.AuthClientResponse;
import com.devopstest.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class AuthClientController {


    private static final Logger LOGGER = Logger.getLogger(AuthClientController.class.getName());

    @Autowired
    AuthenticationClientService authenticationClientService;


    @PostMapping("/verifyMe")
    public AuthClientResponse greeting(@RequestBody AuthClientRequestBody requestBody) throws Exception {


        LOGGER.info("Authentication Client request started with "+requestBody);
        AuthClientResponse response =  authenticationClientService.execute(requestBody);

        LOGGER.info("Authentication client ending with Response :" +response.toString());
        return  response;

    }



}
