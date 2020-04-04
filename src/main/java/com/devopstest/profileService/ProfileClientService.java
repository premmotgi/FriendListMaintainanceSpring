package com.devopstest.profileService;

import com.devopstest.request.AccountDeactivateRequest;
import com.devopstest.response.AccountDeactivateResponse;
import com.devopstest.response.AuthClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class ProfileClientService {
    private static final Logger LOGGER = Logger.getLogger(ProfileClientService.class.getName());

    public AccountDeactivateResponse executeDeactivate(AccountDeactivateRequest requestBody) {


        LOGGER.info("Profile Deactivation Started with request body" + requestBody);

        final String uri = "http://localhost:8080/deactivate";

        RestTemplate restTemplate = new RestTemplate();


        AccountDeactivateResponse result;
        try {

            result = restTemplate.postForObject(uri, requestBody, AccountDeactivateResponse.class);

        } catch (Exception e) {

            LOGGER.info("Request Failed with error " + e.getMessage());
            return AccountDeactivateResponse.build(requestBody.getId(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), false);


        }

        LOGGER.info("Request successful with resonse" + result);
        return result;


    }

}
