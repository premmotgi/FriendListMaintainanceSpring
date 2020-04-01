package com.devopstest.controller;


import com.devopstest.authenticationService.AuthenticationClientService;
import com.devopstest.dao.Friend;
import com.devopstest.request.AuthClientRequestBody;
import com.devopstest.request.AuthLoginReqBody;
import com.devopstest.response.AuthClientLoginResponse;
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


    @PostMapping("/v1/register")
    public AuthClientResponse register(@RequestBody AuthClientRequestBody requestBody) throws Exception {


        LOGGER.info("Authentication Client request started with "+requestBody);
        AuthClientResponse response =  authenticationClientService.execute(requestBody);

        LOGGER.info("Authentication client ending with Response :" +response.toString());
        return  response;

    }


    @PostMapping("/v1/authenticate")
    public AuthClientLoginResponse register(@RequestBody AuthLoginReqBody requestBody) throws Exception {


        LOGGER.info("Authentication Client request started with "+requestBody);
        AuthClientLoginResponse response =  authenticationClientService.executeAuthenticate(requestBody);

        LOGGER.info("Authentication client ending with Response :" +response.toString());
        return  response;

    }



}
