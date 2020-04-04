package com.devopstest.response;

public class AccountDeactivateResponse {
    int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AccountDeactivateResponse{" +
                "id=" + id +
                ", active=" + active +
                ", responseStatus='" + responseStatus + '\'' +
                '}';
    }

    public AccountDeactivateResponse() {
    }

    public AccountDeactivateResponse(int id, boolean active, String responseStatus) {
        this.id = id;
        this.active = active;
        this.responseStatus = responseStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    boolean active;
    String responseStatus;


    public static AccountDeactivateResponse build(int id, String responseStatus, boolean active){
        return new AccountDeactivateResponse(id, active, responseStatus);
    }

}
