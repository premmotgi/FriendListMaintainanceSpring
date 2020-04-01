package com.devopstest.response;

public class AuthClientLoginResponse {

    public String jwt;

    @Override
    public String toString() {
        return "AuthClientLoginResponse{" +
                "jwt='" + jwt + '\'' +
                '}';
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public AuthClientLoginResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthClientLoginResponse() {
    }


    public static AuthClientLoginResponse build(String jwt){
        return  new AuthClientLoginResponse(jwt);
    }
}
