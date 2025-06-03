package com.example.efubtoy.user.dto.response;

import com.example.efubtoy.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private Long userId;
    private String username;
    private String nickname;
    private String bio;
    private boolean isVerified;

    @Builder
    public UserResponse(Long userId, String username, String nickname, String bio, boolean isVerified) {
        this.userId = userId;
        this.username = username;
        this.nickname = nickname;
        this.bio = bio;
        this.isVerified = isVerified;
    }

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .bio(user.getBio())
                .isVerified(user.isVerified())
                .build();
    }
}
