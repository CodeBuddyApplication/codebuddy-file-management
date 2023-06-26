package com.codebuddy.task.mapper;

import com.codebuddy.task.collections.ProjectFile;
import com.codebuddy.task.dto.ProjectFileResponse;
import com.codebuddy.task.dto.ProjectTreeNodeResponse;
import com.codebuddy.task.enums.CodeLanguage;
import com.codebuddy.task.enums.Type;
import com.codebuddy.task.request.ProjectFileRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProjectFilesMapper {

    public ProjectFile mapToProjectFile(ProjectFileRequest request) {
        return ProjectFile.builder()
                .name(request.getName())
                .content(request.getContent())
                .language(CodeLanguage.valueOf(request.getLanguage().toUpperCase()))
                .projectId(request.getProjectId())
                .directory(request.getDirectory())
                .build();
    }

    public ProjectFileResponse mapToProjectFileResponse(ProjectFile projectFile) {
        return ProjectFileResponse.builder()
                .id(projectFile.getId())
                .name(projectFile.getName())
                .content(projectFile.getContent())
                .language(projectFile.getLanguage().getLanguageValue())
                .directory(projectFile.getDirectory())
                .build();
    }

    public ProjectTreeNodeResponse convertToFileTree(List<ProjectFile> files) {
        Map<String, ProjectTreeNodeResponse> createdProjectNodes = new HashMap<>();

        ProjectTreeNodeResponse root = new ProjectTreeNodeResponse();
        root.setName("");
        root.setType(Type.DIRECTORY);
        createdProjectNodes.put("", root);

        for (ProjectFile file : files) {
            String[] directories = file.getDirectory().split("/");
            ProjectTreeNodeResponse currentNode = root;

            for (int i = 0; i < directories.length; i++) {
                String directory = directories[i];
                String path = String.join("/", Arrays.copyOfRange(directories, 0, i + 1));

                if (!createdProjectNodes.containsKey(path)) {
                    ProjectTreeNodeResponse newNode = new ProjectTreeNodeResponse();
                    newNode.setName(directory);
                    newNode.setType(Type.DIRECTORY);
                    currentNode.getChildren().add(newNode);
                    createdProjectNodes.put(path, newNode);
                }

                currentNode = createdProjectNodes.get(path);
            }
            ProjectTreeNodeResponse fileNode = new ProjectTreeNodeResponse();
            fileNode.setName(file.getName());
            fileNode.setType(Type.FILE);
            fileNode.setId(file.getId());
            fileNode.setLanguage(file.getLanguage().getLanguageValue());
            fileNode.setContent(file.getContent());

            currentNode.getChildren().add(fileNode);
        }

        return root;
    }

}
