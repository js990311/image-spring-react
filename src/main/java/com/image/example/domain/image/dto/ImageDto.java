package com.image.example.domain.image.dto;

import com.image.example.domain.image.entity.Image;
import lombok.Getter;

@Getter
public class ImageDto {
    private String filename;
    private String path;

    public ImageDto(String filename, String filePath) {
        this.filename = filename;
        this.path = filePath;
    }

    public static ImageDto from(Image image){
        return new ImageDto(image.getOriginalName(), image.getPath());
    }
}
