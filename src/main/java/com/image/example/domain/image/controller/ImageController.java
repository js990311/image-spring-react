package com.image.example.domain.image.controller;

import com.image.example.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload-single-image")
    public String uploadSingleImage(@RequestParam("file") MultipartFile file){
        String path = imageService.saveImage(file);
        return path;
    }

    @GetMapping("/image/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable("filename") String filename){
        Resource resource = imageService.loadImage(filename);
        String header = new StringBuilder()
                .append("attachment;")
                .append("filename=\"")
                .append(filename)
                .append("\"").toString();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, header)
                .body(resource);

    }
}
