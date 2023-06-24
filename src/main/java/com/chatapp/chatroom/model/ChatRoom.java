package com.chatapp.chatroom.model;

import com.chatapp.chatroom.model.user.User;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chatrooms")
@Builder
public record ChatRoom(
        @Id String id,
        String name,
        String description,
        String ownerId,
        List<String> participantIds,
        @DBRef(lazy = true) List<Message> messages
) {}