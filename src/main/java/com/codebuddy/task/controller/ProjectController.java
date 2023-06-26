package com.codebuddy.task.controller;

import com.codebuddy.task.request.ProjectRequest;
import com.codebuddy.task.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create")
    public void createProject(@RequestBody ProjectRequest projectRequest) {
        projectService.createProject(projectRequest.getName());
    }
}
