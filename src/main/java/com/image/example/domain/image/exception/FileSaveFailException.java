package com.image.example.domain.image.exception;

import com.image.example.domain.image.service.file.FileSystemAccessObject;

public class FileSaveFailException extends RuntimeException{
    public FileSaveFailException(String filename){
        super("Fail to save file, name is : " + filename);
    }
}
