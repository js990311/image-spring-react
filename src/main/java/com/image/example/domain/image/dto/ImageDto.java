package com.image.example.domain.image.dto;

import com.image.example.domain.image.entity.Image;
import lombok.Getter;

@Getter
public class ImageDto {
    private String filename;
    private String filePath;

    public ImageDto(String filename, String filePath) {
        this.filename = filename;
        this.filePath = filePath;
    }

    public static ImageDto from(Image image){
        return new ImageDto(image.getOriginalName(), image.getPath());
    }
}
