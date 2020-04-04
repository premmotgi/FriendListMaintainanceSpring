package com.devopstest.request;

public class AccountDeactivateRequest {

    int id;
    String password;
    boolean active;

    public AccountDeactivateRequest() {
    }

    @Override
    public String toString() {
        return "AccountDeactivateRequest{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }

    public AccountDeactivateRequest(int id, String password, boolean active) {
        this.id = id;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
