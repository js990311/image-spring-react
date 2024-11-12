package com.image.example.domain.image.repository;

import com.image.example.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByOwnerId(Long ownerId);
}
