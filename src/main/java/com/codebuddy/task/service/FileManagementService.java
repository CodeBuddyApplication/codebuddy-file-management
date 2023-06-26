package com.codebuddy.task.service;

import com.codebuddy.task.collections.ProjectFile;
import com.codebuddy.task.dto.ProjectFileResponse;
import com.codebuddy.task.dto.ProjectTreeNodeResponse;
import com.codebuddy.task.mapper.ProjectFilesMapper;
import com.codebuddy.task.repository.FileManagementRepository;
import com.codebuddy.task.request.ProjectFileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileManagementService {

    private final FileManagementRepository fileManagementRepository;
    private final ProjectFilesMapper projectFilesMapper;

    public void updateFile(String id, String content) {
        fileManagementRepository.findById(id).ifPresent(file -> {
            file.setContent(content);
            fileManagementRepository.save(file);
        });
    }

    public void saveFile(ProjectFileRequest projectFileRequest) {
        ProjectFile projectFile = projectFilesMapper.mapToProjectFile(projectFileRequest);
        fileManagementRepository.save(projectFile);
    }

    public void deleteFile(String id) {
        fileManagementRepository.deleteById(id);
    }

    public ProjectFileResponse getFile(String id) {
        return fileManagementRepository.findById(id)
                .map(projectFilesMapper::mapToProjectFileResponse)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }

    public ProjectTreeNodeResponse getAllProjectFiles(String id) {
        return projectFilesMapper.convertToFileTree(fileManagementRepository.findAllByProjectId(id));
    }

}
