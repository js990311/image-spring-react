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
    @Id @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    @Column
    private String path;

    @Column
    private String filename;

    @Column
    private String extension;

    @Column
    private Long ownerId;

    public Image(String filename) {
        this.filename = filename;
        this.path = UUID.randomUUID().toString();
    }
}
