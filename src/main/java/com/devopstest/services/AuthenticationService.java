package com.devopstest.services;

import com.devopstest.dao.Friend;
import com.devopstest.response.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthenticationService {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationService.class.getName());


    //never delcare variables as static in spring, otherwise it will populate to null
    @Value("${api.authenticate.user.admin}")
    private String admin;


    @Value("${api.token}")
    private String token;

    public LoginResponse execute(Friend friend){

        LOGGER.info("Authentication request started with Friend "+friend.toString());

        if(authenticate(friend.getName())){
            LOGGER.info("AuthenticationService:Creating Response for 200");

            friend.setAuthorised(true);
            return LoginResponse.build(friend, HttpStatus.valueOf(200).toString(),token);
        }
        LOGGER.info("AuthenticationService:Creating Response for 404");
        friend.setAuthorised(false);

        return LoginResponse.build(friend, HttpStatus.valueOf(404).toString(),null);

    }


    public boolean authenticate(String name){

        LOGGER.info("authenticating user for name "+admin);
        if(name.equalsIgnoreCase(admin)){
            LOGGER.info("AuthenticationService:Admin Found");
            return  true;
        }else{
            LOGGER.info("AuthenticationService:Admin Not Found");
            return  false;
        }

    }

}
