package com.image.example.domain.article.controller.form;

import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreateArticleForm {
    private String content;
    private List<MultipartFile> files;
}
