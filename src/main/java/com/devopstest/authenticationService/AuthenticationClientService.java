package com.devopstest.authenticationService;

import com.devopstest.request.AuthClientRequestBody;
import com.devopstest.request.AuthLoginReqBody;
import com.devopstest.response.AuthClientLoginResponse;
import com.devopstest.response.AuthClientResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.logging.Logger;

@Service
public class AuthenticationClientService {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationClientService.class.getName());

    public AuthClientResponse execute(AuthClientRequestBody requestBody){

        LOGGER.info("Client Authentication Started with request body"+requestBody);

        final String uri = "http://localhost:8080/register/";

        RestTemplate restTemplate = new RestTemplate();

        String result ="";

        try {
             result = restTemplate.postForObject(uri, requestBody,String.class);

        }catch (Exception e){

            LOGGER.info("Request Failed");
            return AuthClientResponse.build("Something is messed up on Auth Client request didnt go throgh", HttpStatus.INTERNAL_SERVER_ERROR);


        }
        LOGGER.info("Client Authentication response body");

        if(result != null){
            LOGGER.info("Request successful"+result);
            return AuthClientResponse.build("Registration Done!", HttpStatus.CREATED);

        }

        LOGGER.info("Request Failed"+result);
        return AuthClientResponse.build("Something is messed up on Auth Client", HttpStatus.INTERNAL_SERVER_ERROR);

    }


    public AuthClientLoginResponse executeAuthenticate(AuthLoginReqBody requestBody){

        LOGGER.info("Client Authentication Login Started with request body"+requestBody);

        final String uri = "http://localhost:8080/authenticate?reauthenticate=false";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+requestBody.getJwt());

        HttpEntity<AuthLoginReqBody> entity = new HttpEntity<>(requestBody, headers);


        AuthClientLoginResponse result;

        try {
            result = restTemplate.postForObject(uri,entity,AuthClientLoginResponse.class);

        }catch (Exception e){

            LOGGER.info("Request Failed");
            return AuthClientLoginResponse.build("Something is messed up on Auth Client request didnt go throgh");


        }
        LOGGER.info("Client Authentication Login response body");

        if(result != null){
            LOGGER.info("Request successful"+result);
            return AuthClientLoginResponse.build(result.getJwt());

        }

        LOGGER.info("Request Failed"+result);
        return AuthClientLoginResponse.build("Something is messed up on Auth Client");


    }

}
