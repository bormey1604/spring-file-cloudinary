package com.techgirl.spring_file_cloudinary.controller;

import com.techgirl.spring_file_cloudinary.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileUrl = cloudinaryService.uploadFile(file);
        return ResponseEntity.ok(fileUrl);
    }

    @GetMapping("/get/{publicId}")
    public ResponseEntity<?> getFile(@PathVariable String publicId) throws Exception {
        var getFile = cloudinaryService.getFile(publicId);
        return ResponseEntity.ok(getFile);
    }

}
