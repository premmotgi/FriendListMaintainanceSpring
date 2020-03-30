package com.devopstest.response;

import com.devopstest.dao.Friend;
import org.springframework.http.HttpStatus;

import java.util.List;

public class GetAllFriendsResponse {

    public List<Friend> friends;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetAllFriendsResponse{" +
                "friends=" + friends +
                ", status=" + status +
                '}';
    }

    public GetAllFriendsResponse(List<Friend> friends, HttpStatus status) {
        this.friends = friends;
        this.status = status;
    }

    public HttpStatus status;

    public GetAllFriendsResponse() {
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public GetAllFriendsResponse(List<Friend> friends) {
        this.friends = friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }


    public static GetAllFriendsResponse build(List<Friend> friends, HttpStatus status){
        return new GetAllFriendsResponse(friends, status);
    }
}
