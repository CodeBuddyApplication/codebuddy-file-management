package com.codebuddy.task.controller;

import com.codebuddy.task.request.ProjectFileRequest;
import com.codebuddy.task.service.FileManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private static int counter = 0;

    private final SimpMessagingTemplate messagingTemplate;
    private final FileManagementService fileManagementService;

    @MessageMapping("/test01")
    @SendTo("/topic/test01")
    public String processMessageFromClient(ProjectFileRequest message) {
        System.out.println(counter++);
        fileManagementService.updateFile(message.getId(), message.getContent());
        messagingTemplate.convertAndSend("/topic/test01", message + " (from server)");
        return "Response from server: " + message;
    }
}
