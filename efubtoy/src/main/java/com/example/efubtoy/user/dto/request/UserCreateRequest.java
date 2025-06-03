package com.example.efubtoy.user.dto.request;

import lombok.Getter;

@Getter
public class UserCreateRequest {
    private String username;
    private String nickname;
    private String bio;
}

