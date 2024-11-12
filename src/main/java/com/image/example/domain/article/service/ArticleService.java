package com.image.example.domain.article.service;

import com.image.example.domain.article.dto.ArticleDto;
import com.image.example.domain.article.entity.Article;
import com.image.example.domain.article.repository.ArticleRepository;
import com.image.example.domain.image.dto.ImageDto;
import com.image.example.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ImageService imageService;

    /* C */
    @Transactional
    public ArticleDto createArticle(String content, List<MultipartFile> files){
        Article article = new Article(content);
        article = articleRepository.save(article);
        List<ImageDto> images = new ArrayList<>();
        for(MultipartFile file : files){
            ImageDto image = imageService.saveImage(file, article.getId());
            images.add(image);
        }
        return ArticleDto.from(article, images);
    }

    /* R */

    public ArticleDto findById(Long id){
        Article article = articleRepository.findById(id).orElseThrow();
        List<ImageDto> images = imageService.findByImages(id);
        return ArticleDto.from(article, images);
    }

    /* U */

    /* D */
}
