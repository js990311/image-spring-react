package com.image.example.domain.image.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "images")
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column
    private String savePathName;

    @Column
    private String originalName;

    @Column
    private String extension;

    @Column
    private Long ownerId;

    public String getPath(){
        return this.savePathName +"."+ this.extension;
    }

    public String getExtension(){
        if(this.extension != null){
            return this.extension;
        }
        int doti = originalName.lastIndexOf('.');
        this.extension = originalName.substring(doti+1);
        return this.extension;
    }

    public Image(String filename) {
        this.originalName = filename;
        this.savePathName = UUID.randomUUID().toString();
        this.extension = getExtension();
    }

    public Image(String fileName, Long ownerId) {
        this(fileName);
        this.originalName = fileName;
        this.ownerId = ownerId;
    }
}
