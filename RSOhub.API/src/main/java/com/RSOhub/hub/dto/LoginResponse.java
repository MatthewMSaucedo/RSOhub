package com.RSOhub.hub.dto;

public class LoginResponse {
    public String username;
    public String userType;
    public boolean loginSuccessful;

    public LoginResponse(String username, String userType, boolean loginSuccessful) {
        this.username = username;
        this.userType = userType;
        this.loginSuccessful = loginSuccessful;
    }

    public LoginResponse(boolean loginSuccessful) {
        this.loginSuccessful = false;
    }
}
