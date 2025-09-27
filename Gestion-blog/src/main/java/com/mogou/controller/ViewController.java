package com.mogou.controller;

import com.mogou.model.Article;
import com.mogou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public String viewArticlesPage(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "articles";
    }

    @GetMapping("/articles/{id}")
    public String viewArticleDetail(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "article-detail";
    }

    @GetMapping("/articles/new")
    public String viewArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "article-form";
    }

    @PostMapping("/articles")
    public String saveArticle(@ModelAttribute Article article) {
        articleService.createArticle(article);
        return "redirect:/articles";
    }

    @GetMapping("/articles/edit/{id}")
    public String editArticleForm(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "article-form";
    }

    @PostMapping("/articles/update/{id}")
    public String updateArticle(@PathVariable Long id, @ModelAttribute Article article) {
        articleService.updateArticle(id, article);
        return "redirect:/articles";
    }

    @GetMapping("/articles/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/articles";
    }
    
    @GetMapping("/test-tailwind")
    public String testTailwind() {
        return "test-tailwind";
    }
}