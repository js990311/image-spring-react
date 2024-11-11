package com.image.example.domain.image.controller;

import com.image.example.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload-single-image")
    public String uploadSingleImage(@RequestParam("file") MultipartFile file){
        imageService.saveImage(file);
    }
}
