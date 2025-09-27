package com.mogou.controller;

import com.mogou.model.Article;
import com.mogou.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    @Operation(summary = "Récupérer tous les articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un article par son ID")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un nouvel article")
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un article existant")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un article")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
