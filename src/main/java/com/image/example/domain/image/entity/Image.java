package com.image.example.domain.image.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "images")
public class Image {
    @Id @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    @Column
    private String path;

    @Column
    private String filename;

    public Image(String filename) {
        this.filename = filename;
        this.path = UUID.randomUUID().toString();
    }
}
