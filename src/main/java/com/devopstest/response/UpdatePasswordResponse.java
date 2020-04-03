package com.devopstest.response;

public class UpdatePasswordResponse {

    public int getId() {
        return id;
    }

    public UpdatePasswordResponse(int id, String responseMessage) {
        this.id = id;
        this.responseMessage = responseMessage;
    }

    public UpdatePasswordResponse() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int id;
    public String responseMessage;

    public static UpdatePasswordResponse build(int id, String responseMessage){


        return new UpdatePasswordResponse(id, responseMessage);

    }




}
