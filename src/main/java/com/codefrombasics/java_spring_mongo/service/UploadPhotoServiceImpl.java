package com.codefrombasics.java_spring_mongo.service;

import com.codefrombasics.java_spring_mongo.model.Photo;
import com.codefrombasics.java_spring_mongo.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class UploadPhotoServiceImpl implements UploadPhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public String addPhoto(String originalFilename, MultipartFile image) throws
            IOException {
        Photo photo
                = new Photo();
        photo.setTitle(originalFilename);
        //converting the image into Binary format
        photo.setPhoto(new Binary(BsonBinarySubType.BINARY,image.getBytes()));
        return photoRepository.save(photo).getId();
    }

    @Override
    public Photo getPhoto(String id) {
        return photoRepository.findById(id).get();
    }
}
