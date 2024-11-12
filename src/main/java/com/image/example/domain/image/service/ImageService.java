package com.image.example.domain.image.service;

import com.image.example.domain.image.dto.ImageDto;
import com.image.example.domain.image.entity.Image;
import com.image.example.domain.image.exception.FileSaveFailException;
import com.image.example.domain.image.repository.ImageRepository;
import com.image.example.domain.image.service.file.FileSystemAccessObject;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final FileSystemAccessObject fileSystemAO;

    /* C */
    @Transactional
    public ImageDto saveImage(MultipartFile targetImage){
        Image image = new Image(targetImage.getOriginalFilename());
        boolean save = fileSystemAO.save(image.getPath(), targetImage);
        if(!save){
            throw new FileSaveFailException(targetImage.getOriginalFilename());
        }
        imageRepository.save(image);
        return ImageDto.from(image);
    }

    @Transactional
    public ImageDto saveImage(MultipartFile targetImage, Long ownerId){
        Image image = new Image(targetImage.getOriginalFilename(), ownerId);
        boolean save = fileSystemAO.save(image.getPath(), targetImage);
        if(!save){
            throw new FileSaveFailException(targetImage.getOriginalFilename());
        }
        imageRepository.save(image);
        return ImageDto.from(image);
    }

    /* R */
    public Resource loadImage(String filename){
        return fileSystemAO.load(filename);
    }

    public List<ImageDto> findByImages(Long ownerId){
        List<Image> images = imageRepository.findByOwnerId(ownerId);
        return images.stream().map(ImageDto::from).toList();
    }
    /* U */

    /* D */
}
