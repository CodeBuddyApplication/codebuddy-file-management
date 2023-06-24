package com.chatapp.chatroom.dto;

import lombok.Builder;

@Builder
public record FileDataResponse(
        String fileName,
        String getFileAwsS3Url
) {
}
