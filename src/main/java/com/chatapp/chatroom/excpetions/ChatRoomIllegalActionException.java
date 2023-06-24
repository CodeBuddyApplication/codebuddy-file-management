package com.chatapp.chatroom.excpetions;

public class ChatRoomIllegalActionException extends RuntimeException {
    public ChatRoomIllegalActionException(String message) {
        super(message);
    }
}
