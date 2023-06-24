package com.chatapp.chatroom.services;

import com.chatapp.chatroom.dto.RoomResponse;
import com.chatapp.chatroom.excpetions.ChatRoomException;
import com.chatapp.chatroom.mapper.ChatRoomMapper;
import com.chatapp.chatroom.model.ChatRoom;
import com.chatapp.chatroom.model.user.User;
import com.chatapp.chatroom.repository.ChatRoomRepository;
import com.chatapp.chatroom.request.RoomRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserService userService;

    public void createChatRoom(RoomRequest roomRequest, String ownerId) {

        ChatRoom chatRoom = ChatRoom.builder()
                .name(roomRequest.name())
                .description(roomRequest.description())
                .ownerId(ownerId)
                .participantIds(roomRequest.participants())
                .build();
       chatRoomRepository.save(chatRoom);
    }

    public RoomResponse getChatRoom(String roomId) {
        ChatRoom chatRoom = findChatRoomById(roomId);
        User owner = userService.getUserById(chatRoom.ownerId());
        return ChatRoomMapper.mapChatRoomToRoomResponse(chatRoom, owner);
    }
    public void addUserToChatRoom(String roomId, String userId) {
        ChatRoom chatRoom = findChatRoomById(roomId);
        chatRoom.participantIds().add(userId);
        chatRoomRepository.save(chatRoom);
    }

    public void removeUserFromChatRoom(String roomId, String userId, String currentUserId) {
        ChatRoom chatRoom = findChatRoomById(roomId);
        chatRoom.participantIds().remove(userId);
        chatRoomRepository.save(chatRoom);
    }

    private ChatRoom findChatRoomById(String id) {
        return chatRoomRepository.findById(id)
                .orElseThrow(() -> new ChatRoomException("Chat room not found with id : " + id));
    }
}
