package com.joseph.service.Impl;

import com.joseph.entity.Article;
import com.joseph.repository.ArticleRepository;
import com.joseph.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void addArticle(Article article) {
        Optional<Article> existingArticle = articleRepository.findByLibelle(article.getLibelle());

        if (existingArticle.isPresent()) {
            Article foundArticle = existingArticle.get();
            foundArticle.setQuantity(foundArticle.getQuantity() + article.getQuantity());
            articleRepository.save(foundArticle);
        } else {
            articleRepository.save(article);
        }
    }

    @Override
    public Article getArticleById(int articleId) {
        return articleRepository.findById(articleId).orElse(null);
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleRepository.deleteById(articleId);

        }

    }

