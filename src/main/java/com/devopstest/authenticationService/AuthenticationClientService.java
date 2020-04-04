package com.devopstest.authenticationService;

import com.devopstest.request.AuthClientRequestBody;
import com.devopstest.request.AuthLoginReqBody;
import com.devopstest.request.UpdatePasswordRequestBody;
import com.devopstest.response.AuthClientLoginFalseResponse;
import com.devopstest.response.AuthClientLoginResponse;
import com.devopstest.response.AuthClientResponse;
import com.devopstest.response.UpdatePasswordResponse;
import com.devopstest.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.logging.Logger;

@Service
public class AuthenticationClientService {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationClientService.class.getName());


    @Autowired
    PasswordUtil passwordUtil;

    public AuthClientResponse execute(AuthClientRequestBody requestBody){

        LOGGER.info("Client Authentication Started with request body"+requestBody);

        final String uri = "http://3.101.42.211:8080/register";

        RestTemplate restTemplate = new RestTemplate();

        String result ="";

        try {

            requestBody.setPassword(passwordUtil.encrypt(requestBody.getPassword()));
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




        if(requestBody.isAuthAgain()){

            LOGGER.info("Client Authentication Login Started with request body for auth again "+true);

            final String uri = "http://3.101.42.211:8080/authenticate?reauthenticate=true";

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("Authorization", "Bearer "+requestBody.getJwt());

            HttpEntity<AuthLoginReqBody> entity = new HttpEntity<>(requestBody, headers);


            AuthClientLoginResponse result = null;

            try {

                LOGGER.info("Client Call made for url"+uri);
                result = restTemplate.postForObject(uri,entity,AuthClientLoginResponse.class);

            }catch (Exception e){

                LOGGER.info("Request Failed");
                return AuthClientLoginResponse.build(null, "Error", "Error");


            }
            LOGGER.info("Client Authentication Login response body");

            if(result != null){
                LOGGER.info("Request successful"+result);
                return result;

            }

            LOGGER.info("Request Failed"+result);
            return AuthClientLoginResponse.build(null, "Error", "Error");


        }else{

            LOGGER.info("Client Authentication Login Started with request body for auth again "+false);

            final String uri = "http://3.101.42.211:8080/authenticate?reauthenticate=false";

            RestTemplate restTemplate = new RestTemplate();

            AuthClientLoginResponse result;

            try {
                LOGGER.info("Client Call made for url"+uri);
                result = restTemplate.postForObject(uri,requestBody,AuthClientLoginResponse.class);

            }catch (Exception e){

                LOGGER.info("Request Failed");
                return AuthClientLoginResponse.build(null,"error","error");


            }
            LOGGER.info("Client Authentication Login response body");

            if(result != null){
                LOGGER.info("Request successful"+result);
                return result;

            }

            LOGGER.info("Request Failed"+result);
            return AuthClientLoginResponse.build(null,"error","error");


        }



    }



    public UpdatePasswordResponse executeUpdatePassword(UpdatePasswordRequestBody requestBody){
        LOGGER.info("Client Authentication- executeUpdatePassword Started with request body for auth again "+requestBody);
        final String uri = "http://localhost:8080/updatePassword";
        RestTemplate restTemplate = new RestTemplate();
        UpdatePasswordResponse result;
        try {
            LOGGER.info("Client Call made for url"+uri);
            requestBody.setNewPassword(passwordUtil.encrypt(requestBody.getNewPassword()));
            LOGGER.info("new pass"+requestBody.getNewPassword());
            result = restTemplate.postForObject(uri,requestBody,UpdatePasswordResponse.class);
            LOGGER.info("Client Authentication- executeUpdatePassword Response"+result);
            return  result;
        }catch (Exception e){
            LOGGER.info("Request Failed" + e.getMessage());
            return UpdatePasswordResponse.build(requestBody.getId(),HttpStatus.INTERNAL_SERVER_ERROR.toString());
        }
    }
}
