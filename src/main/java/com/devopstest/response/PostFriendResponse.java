package com.devopstest.response;

import com.devopstest.dao.Friend;
import org.springframework.http.HttpStatus;


public class PostFriendResponse {

    public Friend getFriendObject() {
        return friendObject;
    }

    public PostFriendResponse() {
    }

    public PostFriendResponse(Friend friendObject, HttpStatus responseStatus) {
        this.friendObject = friendObject;
        this.responseStatus = responseStatus;
    }

    public void setFriendObject(Friend friendObject) {
        this.friendObject = friendObject;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    private Friend friendObject;

    @Override
    public String toString() {
        return "PostFriendResponse{" +
                "friendObject=" + friendObject +
                ", responseStatus=" + responseStatus +
                '}';
    }

    private HttpStatus responseStatus;


    public static PostFriendResponse build(Friend friend, HttpStatus status){

        return new PostFriendResponse(friend, status);

    }
}
