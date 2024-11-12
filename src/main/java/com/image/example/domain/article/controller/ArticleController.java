package com.image.example.domain.article.controller;

import com.image.example.domain.article.controller.form.CreateArticleForm;
import com.image.example.domain.article.dto.ArticleDto;
import com.image.example.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/article")
@RestController
public class ArticleController {
    private ArticleService articleService;

    @PostMapping("/create")
    public ArticleDto createArticle(
            @ModelAttribute CreateArticleForm form
            ){
        ArticleDto article = articleService.createArticle(form.getContent(), form.getFiles());
        return article;
    }
}
