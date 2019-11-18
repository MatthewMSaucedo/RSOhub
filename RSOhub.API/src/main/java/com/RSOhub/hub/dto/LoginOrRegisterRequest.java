package com.RSOhub.hub.dto;

import lombok.Getter;

public class LoginOrRegisterRequest {
    @Getter private String username;
    @Getter private String password;
    @Getter private int refUniversityId;
}
