package com.codebuddy.task.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectFileResponse {
    private String id;
    private String name;
    private String content;
    private String language;
    private String directory;
}
