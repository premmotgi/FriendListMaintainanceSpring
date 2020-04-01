package com.devopstest.response;

import org.springframework.http.HttpStatus;

public class AuthClientResponse {
    public AuthClientResponse() {
    }

    @Override
    public String toString() {
        return "AuthClientResponse{" +
                "message='" + message + '\'' +
                ", responseStatus=" + responseStatus +
                '}';
    }

    public String message;

    public String getMessage() {
        return message;
    }

    public AuthClientResponse(String message, HttpStatus responseStatus) {
        this.message = message;
        this.responseStatus = responseStatus;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public HttpStatus responseStatus;

    public static AuthClientResponse build(String message, HttpStatus responseStatus){
        return new AuthClientResponse(message, responseStatus);
    }

}
