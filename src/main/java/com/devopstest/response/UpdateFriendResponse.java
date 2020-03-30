package com.devopstest.response;

import com.devopstest.dao.Friend;
import org.springframework.http.HttpStatus;

public class UpdateFriendResponse extends PostFriendResponse {

    public UpdateFriendResponse(){
            }

    public UpdateFriendResponse(Friend friendObject, HttpStatus responseStatus) {
        super(friendObject, responseStatus);
    }

    public static UpdateFriendResponse build(Friend friend, HttpStatus status){

        return new UpdateFriendResponse(friend, status);
    }


}
