package com.chatapp.chatroom.model.user;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class User {
    private String id;
    private String name;
    private String email;
}