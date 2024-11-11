package com.image.example.domain.image.service;

import com.image.example.domain.image.entity.Image;
import com.image.example.domain.image.exception.FileSaveFailException;
import com.image.example.domain.image.repository.ImageRepository;
import com.image.example.domain.image.service.file.FileSystemAccessObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final FileSystemAccessObject fileSystemAO;

    /* C */
    @Transactional
    public void saveImage(MultipartFile targetImage){
        Image image = new Image(targetImage.getOriginalFilename());
        boolean save = fileSystemAO.save(image.getPath(), targetImage);
        if(!save){
            throw new FileSaveFailException(targetImage.getOriginalFilename());
        }
        imageRepository.save(image);
    }

    /* R */

    /* U */

    /* D */
}
