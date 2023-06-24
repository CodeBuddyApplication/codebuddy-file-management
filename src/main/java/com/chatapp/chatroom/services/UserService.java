package com.chatapp.chatroom.services;

import com.chatapp.chatroom.model.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserById(String id) {
        //todo fetch user from user microservice
        return User.builder()
                .name("Test User")
                .email("Test Email")
                .id(id)
                .name("Test Name")
                .build();
    }
}
