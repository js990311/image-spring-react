package com.image.example.domain.image.service.file;

import com.image.example.domain.image.exception.FileLoadFailException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

@Component
public class LocalFileSystemAccessObject implements FileSystemAccessObject{
    private static final String IMAGE_DIRECTORY = "images/";
    @Override
    public boolean save(String path, MultipartFile file)  {
        try {
            Path savePath = Paths.get( IMAGE_DIRECTORY + path);
            Files.write(savePath, file.getBytes());
            return true;
        }catch (IOException e){
            return false;
        }
    }

    @Override
    public Resource load(String path) {
        Path filePath = Paths.get(IMAGE_DIRECTORY + path);
        if(!Files.exists(filePath)){
            throw new NoSuchElementException();
        }
        try {
            return new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new FileLoadFailException(path);
        }
    }
}
