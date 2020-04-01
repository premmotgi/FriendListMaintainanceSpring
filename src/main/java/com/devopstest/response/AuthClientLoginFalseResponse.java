package com.devopstest.response;


/*
{{
    "id": "200",
    "message": "JWT token validated",
    "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcmVtMiIsImV4cCI6MTU4NTc0NjY0NiwiaWF0IjoxNTg1NzEwNjQ2fQ.dqiT4_Nf-owzQMw_EV5igKx_nXvMemZvhxq06_70gFA"
}
*/
public class AuthClientLoginFalseResponse {


    String id, jwt, message;

    public AuthClientLoginFalseResponse(String id, String jwt, String message) {
        this.id = id;
        this.jwt = jwt;
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthClientLoginFalseResponse{" +
                "status='" + id + '\'' +
                ", errorId='" + jwt + '\'' +
                ", errorMessage='" + message + '\'' +
                '}';
    }

    public AuthClientLoginFalseResponse() {
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


    public static AuthClientLoginFalseResponse build(String errorId, String errorMessage, String status){
        return new AuthClientLoginFalseResponse( status,  errorId,  errorMessage);
    }
}
