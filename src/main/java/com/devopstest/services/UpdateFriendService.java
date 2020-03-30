package com.devopstest.services;

import com.devopstest.dao.Friend;
import com.devopstest.repository.FriendRepository;
import com.devopstest.response.UpdateFriendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UpdateFriendService {

    @Autowired
    FriendRepository friendRepository;

    private static final Logger LOGGER = Logger.getLogger(UpdateFriendService.class.getName());

    public UpdateFriendResponse execute(Long id, Friend friend){

            LOGGER.info("Update Friend Service Started for id "+id);
            Friend friendObj = friendRepository.findById(id).get();

            LOGGER.info("Friend Found for ID is: "+friendObj);

            if(friendObj!= null){

                LOGGER.info("Deleting Friend with ID "+id);

                friendRepository.deleteById(id);

                LOGGER.info("Saving updated friend as: "+friend);
                Friend friendResponse = friendRepository.save(friend);


                UpdateFriendResponse response = UpdateFriendResponse.build(friendResponse, HttpStatus.ACCEPTED);

                LOGGER.info("Update Friend Service Ending with response: "+response);
                return response;

            }else{

                UpdateFriendResponse response = UpdateFriendResponse.build(null, HttpStatus.NOT_FOUND);

                LOGGER.info("Update Friend Service Ending with response: "+response);
                return response;

            }

    }


}
