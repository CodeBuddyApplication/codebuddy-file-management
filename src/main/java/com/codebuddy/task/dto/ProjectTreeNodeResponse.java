package com.codebuddy.task.dto;

import com.codebuddy.task.enums.Type;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectTreeNodeResponse {
    private String id;
    private String name;
    private String content;
    private String language;
    private Type type;
    private List<ProjectTreeNodeResponse> children = new ArrayList<>();
}
