package com.chatapp.chatroom.repository;

import com.chatapp.chatroom.model.FileData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<FileData, String> {
}
