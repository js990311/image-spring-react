package com.image.example.domain.article.dto;

import com.image.example.domain.article.entity.Article;
import com.image.example.domain.image.dto.ImageDto;
import com.image.example.domain.image.entity.Image;
import lombok.Getter;

import java.util.List;

@Getter
public class ArticleDto {
    private Long id;
    private String content;
    private List<ImageDto> images;

    public ArticleDto(Long id, String content, List<ImageDto> images) {
        this.id = id;
        this.content = content;
        this.images = images;
    }

    public static ArticleDto from(Article article, List<ImageDto> images){
        return new ArticleDto(article.getId(), article.getContent(), images);
    }
}
