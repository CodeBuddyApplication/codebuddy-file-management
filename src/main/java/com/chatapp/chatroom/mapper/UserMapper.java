package com.chatapp.chatroom.mapper;

import com.chatapp.chatroom.dto.UserResponse;
import com.chatapp.chatroom.model.user.User;

public class UserMapper {

    public static UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getName())
                .email(user.getEmail())
                .build();
    }
}
