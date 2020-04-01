package com.devopstest.response;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonInclude;

public class AuthClientLoginResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String id, jwt, message;


    public AuthClientLoginResponse(String id, String jwt, String message) {
        this.id = id;
        this.jwt = jwt;
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthClientLoginFalseResponse{" +
                "id='" + id + '\'' +
                ", jwt='" + jwt + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public AuthClientLoginResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static AuthClientLoginResponse build(String id, String jwt, String message){
        return new AuthClientLoginResponse( id,  jwt,  message);
    }
}
