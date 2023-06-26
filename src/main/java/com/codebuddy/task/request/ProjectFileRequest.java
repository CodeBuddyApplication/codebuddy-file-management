package com.codebuddy.task.request;

import lombok.Data;

@Data
public class ProjectFileRequest {
    private String id;
    private String name;
    private String content;
    private String language;
    private String directory;
    private String projectId;
}
