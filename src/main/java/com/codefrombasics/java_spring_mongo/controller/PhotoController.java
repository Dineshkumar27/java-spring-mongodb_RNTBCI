package com.codefrombasics.java_spring_mongo.controller;

import com.codefrombasics.java_spring_mongo.model.Photo;
import com.codefrombasics.java_spring_mongo.service.UploadPhotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private UploadPhotoService photoService;

    @PostMapping
    public String addPhoto(@RequestParam("image") MultipartFile image) throws IOException {
        String id = photoService.addPhoto(image.getOriginalFilename(),image);
        return  id;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable String id) {
        Photo photo = photoService.getPhoto(id);
        Resource resource
                = (Resource) new ByteArrayResource(photo.getPhoto().getData());

        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + photo.getTitle() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}