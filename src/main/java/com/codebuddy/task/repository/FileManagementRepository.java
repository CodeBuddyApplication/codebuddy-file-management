package com.codebuddy.task.repository;

import com.codebuddy.task.collections.ProjectFile;
import com.codebuddy.task.dto.ProjectFileResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileManagementRepository extends MongoRepository<ProjectFile, String> {

    @Query(value = "{ 'projectId' : ?0 }")
    List<ProjectFile> findAllByProjectId(String id);
}
