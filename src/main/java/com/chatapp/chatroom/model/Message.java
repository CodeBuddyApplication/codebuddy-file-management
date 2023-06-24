package com.chatapp.chatroom.model;

import com.chatapp.chatroom.model.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "messages")
public record Message(
        @Id String id,
        String text,
        @DBRef User sender,
        LocalDateTime timestamp,
        @DBRef FileData fileData
) {
}