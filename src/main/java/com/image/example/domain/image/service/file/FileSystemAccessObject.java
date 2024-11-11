package com.image.example.domain.image.service.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileSystemAccessObject {
    public boolean save(String path, MultipartFile file);
    public Resource load(String path);
}
