package com.devopstest.services;

import com.devopstest.controller.FriendController;
import com.devopstest.dao.Friend;
import com.devopstest.repository.FriendRepository;
import com.devopstest.response.GetAllFriendsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
public class GetAllFriendsService {

    private static final Logger LOGGER = Logger.getLogger(GetAllFriendsService.class.getName());


    @Autowired
    FriendRepository friendRepository;


    public GetAllFriendsResponse execute(){

        LOGGER.info("Get ALL friends service started");

        List<Friend> friends = friendRepository.findAll();

        LOGGER.info("Friends resource found are: "+ friends);

        if(friends== null || friends.size() == 0 ){

          GetAllFriendsResponse response =   GetAllFriendsResponse.build(null, HttpStatus.NOT_FOUND);

          LOGGER.info("Get all friends service ended with response: "+ response);

          return  response;
        }

        GetAllFriendsResponse response = GetAllFriendsResponse.build(friends, HttpStatus.ACCEPTED);

        LOGGER.info("Get all friends service ended with response: "+ response);

        return response;

    }

}
