package com.codebuddy.task.controller;

import com.codebuddy.task.dto.ProjectFileResponse;
import com.codebuddy.task.dto.ProjectTreeNodeResponse;
import com.codebuddy.task.request.ProjectFileRequest;
import com.codebuddy.task.service.FileManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/project-files")
public class ProjectFilesController {

    private final FileManagementService fileManagementService;

    @PostMapping("/create")
    public void createFile(@RequestBody ProjectFileRequest projectFileRequest) {
        fileManagementService.saveFile(projectFileRequest);
    }

    @GetMapping("/{id}")
    public ProjectFileResponse getFile(@PathVariable String id) {
        return fileManagementService.getFile(id);
    }

    @GetMapping("/project/{id}")
    public ProjectTreeNodeResponse getAllProjectFiles(@PathVariable String id) {
        return fileManagementService.getAllProjectFiles(id);
    }
}
