package com.mogou.controller;


import com.mogou.model.Commentaire;
import com.mogou.service.CommentaireService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles/{articleId}/comments")
public class CommentaireController {
    @Autowired
    private CommentaireService commentaireService;

    @GetMapping
    @Operation(summary = "Récupérer les commentaires d'un article")
    public List<Commentaire> getCommentsByArticle(@PathVariable Long articleId) {
        return commentaireService.getCommentsByArticle(articleId);
    }

    @PostMapping
    @Operation(summary = "Ajouter un commentaire à un article")
    public Commentaire addComment(@PathVariable Long articleId, @RequestBody Commentaire commentaire) {
        return commentaireService.addCommentToArticle(articleId, commentaire);
    }
}