package com.devopstest.request;


/*
{
        "userName":"knemali",
        "password": "sid",
        "active": true
        }
*/
public class AuthClientRequestBody {

    public String userName;
    public String password;
    public boolean active;

    public AuthClientRequestBody() {
    }

    public AuthClientRequestBody(String userName, String password, boolean active) {
        this.userName = userName;
        this.password = password;
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "AuthClientRequestBody{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
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


    public static AuthClientRequestBody build(String userName, String password, boolean active){

        return  new AuthClientRequestBody(userName,password,active);

    }
}
