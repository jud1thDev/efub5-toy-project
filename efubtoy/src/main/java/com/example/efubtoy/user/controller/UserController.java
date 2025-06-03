package com.example.efubtoy.user.controller;

import com.example.efubtoy.user.dto.request.UserCreateRequest;
import com.example.efubtoy.user.dto.response.UserProfileWithContentResponseDto;
import com.example.efubtoy.user.dto.response.UserResponse;
import com.example.efubtoy.user.service.UserService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User", description = "유저 관련 API")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 유저 프로필 조회
    @Operation(summary = "유저 프로필 조회", description = "특정 유저의 프로필과 게시글 목록을 조회합니다.")
    @GetMapping("/{userId}/profile")
    public ResponseEntity<UserProfileWithContentResponseDto> getMyProfile(@PathVariable Long userId) {
        UserProfileWithContentResponseDto responseDto = userService.getMyProfile(userId);
        return ResponseEntity.ok(responseDto);
    }

    // 유저 생성
    @Operation(summary = "유저 생성", description = "유저를 생성합니다.")
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(201).body(response);
    }

}