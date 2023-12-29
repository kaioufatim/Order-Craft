package com.joseph.web;

import com.joseph.entity.Article;
import com.joseph.entity.Customer;
import com.joseph.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public String showArticleList(Model theModel) {
        List<Article> articles = articleService.getArticles();
        theModel.addAttribute("articles", articles);
        return "article-form";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("article", new Article());
        return "article-add";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute("article") Article article) {
        articleService.addArticle(article);
        return "redirect:/article/list";  // Redirect to the article list page
    }
    @GetMapping("/EditArticle")
    public String showEditCustomerForm(@RequestParam("id") int articleId, Model model) {
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "article-edit";
    }

    @PostMapping("/EditArticle")
    public String processEditCustomerForm(@ModelAttribute("article") Article editedArticle) {
        articleService.saveArticle(editedArticle);
        return "redirect:/article/list";
    }
    @GetMapping("/delete")
    public String deleteArticle(@RequestParam("id") int articleId) throws NullPointerException {
        articleService.deleteArticle(articleId);
        return "redirect:/article/list";
    }
}
