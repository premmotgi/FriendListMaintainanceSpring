package com.devopstest.request;

public class AuthLoginReqBody {

    public String username;

    public AuthLoginReqBody() {
    }

    public String getUsername() {
        return username;
    }

    public AuthLoginReqBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthLoginReqBody(String username, String password, String jwt) {
        this.username = username;
        this.password = password;
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "AuthLoginReqBody{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jwt='" + jwt + '\'' +
                '}';
    }

    public String password;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String jwt;



}
