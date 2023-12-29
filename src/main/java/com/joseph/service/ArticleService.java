package com.joseph.service;

import com.joseph.entity.Article;
import com.joseph.entity.Customer;

import java.util.List;

public interface ArticleService {

    List<Article> getArticles();
    void addArticle(Article article);

    public Article getArticleById(int articleId);

    public void saveArticle(Article article);

    void deleteArticle(int articleId);
}
