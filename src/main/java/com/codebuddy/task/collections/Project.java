package com.codebuddy.task.collections;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "projects")
@Builder
public class Project {

    @Id
    private String id;
    private String name;
}
