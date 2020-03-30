package com.devopstest.services;

import com.devopstest.response.DeleteFriendResponse;
import com.devopstest.dao.Friend;
import com.devopstest.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DeleteFriendService {


    private static final Logger LOGGER = Logger.getLogger(DeleteFriendService.class.getName());

    @Autowired
    FriendRepository friendRepository;


    public DeleteFriendResponse execute(Long id){


        LOGGER.info("DeleteFriendService started for id"+id);

        Friend friendResp = friendRepository.findById(id).get();

        LOGGER.info("Found friend as:"+friendResp);

        try {
            friendRepository.deleteById(id);
        }catch(Exception e){

            LOGGER.info("Some error as:"+e.getMessage());
            return DeleteFriendResponse.build(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        LOGGER.info("Deleted Friend "+friendResp);

        DeleteFriendResponse response = DeleteFriendResponse.build(friendResp, HttpStatus.NO_CONTENT);

        LOGGER.info("DeleteFriendService ended with response"+response);

        return response;
    }

}
