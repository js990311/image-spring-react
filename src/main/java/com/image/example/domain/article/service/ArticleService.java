package com.image.example.domain.article.service;

import com.image.example.domain.article.entity.Article;
import com.image.example.domain.article.repository.ArticleRepository;
import com.image.example.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ArticleService {
    private ArticleRepository articleRepository;
    private ImageService imageService;

    /* C */
    @Transactional
    public void createArticle(String content, List<MultipartFile> files){
        Article article = new Article(content);
        Article save = articleRepository.save(article);
        for(MultipartFile file : files){
            imageService.saveImage(file, save.getId());
        }
    }

    /* R */

    /* U */

    /* D */
}
