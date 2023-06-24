package com.chatapp.chatroom.controller;

import com.chatapp.chatroom.dto.RoomResponse;
import com.chatapp.chatroom.request.RoomRequest;
import com.chatapp.chatroom.services.ChatRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat-room")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @PostMapping
    public ResponseEntity<String> createChatRoom(
            @RequestBody RoomRequest roomRequest,
            @RequestHeader("User-Id") String userId) {
        chatRoomService.createChatRoom(roomRequest, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Chat room created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getChatRoomById(@PathVariable String id) {
        RoomResponse chatRoom = chatRoomService.getChatRoom(id);
        return ResponseEntity.ok(chatRoom);
    }

    @GetMapping("/add-user/{roomId}/{userId}")
    public ResponseEntity<String> addUserToChatRoom(@PathVariable String roomId, @PathVariable String userId) {
        chatRoomService.addUserToChatRoom(roomId, userId);
        return ResponseEntity.ok("User added to chat room successfully");
    }

    @GetMapping("/remove-user/{roomId}/{userId}")
    public ResponseEntity<String> removeUserFromChatRoom(
            @PathVariable String roomId,
            @PathVariable String userId,
            @RequestHeader("User-Id") String currentUserId) {
        chatRoomService.removeUserFromChatRoom(roomId, userId, currentUserId);
        return ResponseEntity.ok("User removed from chat room successfully");
    }
}
