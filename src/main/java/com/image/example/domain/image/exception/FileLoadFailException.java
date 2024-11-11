package com.image.example.domain.image.exception;

public class FileLoadFailException extends RuntimeException{
    public FileLoadFailException(String filename){
        super("Fail to load file, name is : " + filename);
    }
}
