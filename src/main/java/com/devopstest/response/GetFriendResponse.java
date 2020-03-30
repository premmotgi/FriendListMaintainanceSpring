package com.devopstest.response;

import com.devopstest.dao.Friend;
import org.springframework.http.HttpStatus;

public class GetFriendResponse {


    Friend friend;
    HttpStatus responseStatus;


    public Friend getFriend() {
        return friend;
    }

    public GetFriendResponse() {
    }

    @Override
    public String toString() {
        return "GetFriendResponse{" +
                "friend=" + friend +
                ", responseStatus=" + responseStatus +
                '}';
    }

    public GetFriendResponse(Friend friend, HttpStatus responseStatus) {
        this.friend = friend;
        this.responseStatus = responseStatus;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }


    public static GetFriendResponse build(Friend friend, HttpStatus status){
        return new GetFriendResponse(friend,status);
    }
}
