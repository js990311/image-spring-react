package com.image.example.domain.article.controller;

import com.image.example.domain.article.controller.form.CreateArticleForm;
import com.image.example.domain.article.dto.ArticleDto;
import com.image.example.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/article")
@RestController
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/create")
    public ArticleDto createArticle(
            @ModelAttribute CreateArticleForm form
            ){
        ArticleDto article = articleService.createArticle(form.getContent(), form.getFiles());
        return article;
    }
}
