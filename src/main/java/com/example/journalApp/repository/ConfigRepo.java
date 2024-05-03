package com.example.journalApp.repository;

import com.example.journalApp.entity.ConfigJournalAppEntity;
import com.example.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigRepo extends MongoRepository<ConfigJournalAppEntity, ObjectId> {



}
