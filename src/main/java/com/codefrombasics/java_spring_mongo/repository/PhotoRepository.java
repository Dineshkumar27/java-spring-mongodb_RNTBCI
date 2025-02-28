package com.codefrombasics.java_spring_mongo.repository;

import com.codefrombasics.java_spring_mongo.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
