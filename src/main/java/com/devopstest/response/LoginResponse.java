package com.devopstest.response;

import com.devopstest.dao.Friend;

public class LoginResponse {

    public LoginResponse(Friend friendObject, String responseStatus) {
        this.friendObject = friendObject;
        this.responseStatus = responseStatus;
    }

    Friend friendObject;
    String responseStatus;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse(Friend friendObject, String responseStatus, String token) {
        this.friendObject = friendObject;
        this.responseStatus = responseStatus;
        this.token = token;
    }

    String token;

    public Friend getFriendObject() {
        return friendObject;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "friendObject=" + friendObject +
                ", responseStatus='" + responseStatus + '\'' +
                '}';
    }

    public void setFriendObject(Friend friendObject) {
        this.friendObject = friendObject;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public static LoginResponse build(Friend friendObject, String status, String token){

        return new LoginResponse(friendObject, status, token);

    }
}
