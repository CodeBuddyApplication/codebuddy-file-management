package com.chatapp.chatroom.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RoomRequest(
        @Min(3) @Max(50) @NotNull
        String name,
        @Min(3) @Max(50) @NotNull
        String description,

        List<String> participants
) {}
