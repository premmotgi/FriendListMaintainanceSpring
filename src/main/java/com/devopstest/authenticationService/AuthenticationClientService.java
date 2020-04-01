package com.devopstest.authenticationService;

import com.devopstest.request.AuthClientRequestBody;
import com.devopstest.response.AuthClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

}
