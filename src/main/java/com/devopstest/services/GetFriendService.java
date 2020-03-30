package com.devopstest.services;


import com.devopstest.dao.Friend;
import com.devopstest.repository.FriendRepository;
import com.devopstest.response.GetFriendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GetFriendService {

    private static final Logger LOGGER = Logger.getLogger(GetFriendService.class.getName());

    @Autowired
    FriendRepository friendRepository;


    public GetFriendResponse execute(Long id){

        LOGGER.info("GetFriendService started for id"+id);
        Friend friendResp = friendRepository.findById(id).get();
        GetFriendResponse response = GetFriendResponse.build(friendResp, HttpStatus.ACCEPTED);
        LOGGER.info("GetFriendService ended with response"+response);

        return response;
    }


}
