package com.codebuddy.task.collections;

import com.codebuddy.task.enums.CodeLanguage;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "textFiles")
@Data
@Builder
public class ProjectFile {
    @Id
    private String id;
    private String projectId;
    private String name;
    private String content;
    private CodeLanguage language;
    private String directory;
}
