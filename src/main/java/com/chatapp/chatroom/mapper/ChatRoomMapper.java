package com.chatapp.chatroom.mapper;

import com.chatapp.chatroom.dto.RoomResponse;
import com.chatapp.chatroom.model.ChatRoom;
import com.chatapp.chatroom.model.user.User;

import java.util.List;

public class ChatRoomMapper {

    public static RoomResponse mapChatRoomToRoomResponse(ChatRoom chatRoom, User owner) {
        return RoomResponse.builder()
                .id(chatRoom.id())
                .name(chatRoom.name())
                .owner(UserMapper.mapUserToUserResponse(owner))
                .description(chatRoom.description())
                .build();
    }
}
