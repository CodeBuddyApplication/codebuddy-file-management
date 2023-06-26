package com.codebuddy.task.service;

import com.codebuddy.task.collections.Project;
import com.codebuddy.task.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void createProject(String name) {
        projectRepository.save(Project.builder()
                .name(name)
                .build());
    }

}
