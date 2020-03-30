package com.devopstest.services;

import com.devopstest.dao.Friend;
import com.devopstest.repository.FriendRepository;
import com.devopstest.response.PostFriendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class AddFriendService {

    private static final Logger LOGGER = Logger.getLogger(AddFriendService.class.getName());


    @Value("${api.token}")
    String tokenProperty;


    @Autowired
    FriendRepository friendRepository;

    public PostFriendResponse execute(Friend friend, String token){

        LOGGER.info("Add Friend service started with "+friend);

        if(!friend.getName().isEmpty() && token.equalsIgnoreCase(tokenProperty)) {

            LOGGER.info("Add Friend service Friend Added "+friend);


            LOGGER.info("Saving friend object as :"+friend);

            friend.setAuthorised(true);
            friendRepository.save(friend);

            return PostFriendResponse.build(friend, HttpStatus.ACCEPTED);

        }else{
            friend.setAuthorised(false);
            return PostFriendResponse.build(friend, HttpStatus.UNAUTHORIZED);

        }


    }

}
