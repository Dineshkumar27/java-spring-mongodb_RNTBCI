package com.codefrombasics.java_spring_mongo.service;

import com.codefrombasics.java_spring_mongo.model.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadPhotoService {
    String addPhoto(String originalFilename, MultipartFile image) throws IOException;

    Photo getPhoto(String id);
}
