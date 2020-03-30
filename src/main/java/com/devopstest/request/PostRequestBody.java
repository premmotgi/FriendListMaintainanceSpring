package com.devopstest.request;

import com.devopstest.dao.Friend;

public class PostRequestBody {

    public Friend friend;
    public String token;


    public PostRequestBody(){}


    public Friend getFriend() {
        return friend;
    }

    @Override
    public String toString() {
        return "PostRequestBody{" +
                "friend=" + friend +
                ", token='" + token + '\'' +
                '}';
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
