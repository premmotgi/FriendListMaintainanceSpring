package com.devopstest.response;

import com.devopstest.dao.Friend;
import org.springframework.http.HttpStatus;

public class DeleteFriendResponse {
    HttpStatus reposeStatus;
    Friend friend;

    public DeleteFriendResponse() {
    }

    public DeleteFriendResponse(HttpStatus reposeStatus, Friend friend) {
        this.reposeStatus = reposeStatus;
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "DeleteFriendResponse{" +
                "reposeStatus=" + reposeStatus +
                ", friend=" + friend +
                '}';
    }

    public HttpStatus getReposeStatus() {
        return reposeStatus;
    }

    public void setReposeStatus(HttpStatus reposeStatus) {
        this.reposeStatus = reposeStatus;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public static DeleteFriendResponse build(Friend friend, HttpStatus status){
        return new DeleteFriendResponse(status, friend);
    }
}
