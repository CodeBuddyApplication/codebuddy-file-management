package com.chatapp.chatroom.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record RoomResponse(
        String id,
        String name,
        String description,
        UserResponse owner,
        List<UserResponse> participants
){}