package com.RSOhub.hub.dto;

public class LoginResponse {
    public String username;
    public String userType;
    public int userId;
    public boolean loginSuccessful;

    public LoginResponse(String username, int userId, String userType, boolean loginSuccessful) {
        this.username = username;
        this.userId = userId;
        this.userType = userType;
        this.loginSuccessful = loginSuccessful;
    }

    public LoginResponse(boolean loginSuccessful) {
        this.loginSuccessful = false;
    }
}
