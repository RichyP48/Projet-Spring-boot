package com.mogou.service;

import com.mogou.model.Article;
import com.mogou.model.Commentaire;
import com.mogou.repository.ArticleRepository;
import com.mogou.repository.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService {
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    private ArticleService articleService;

    public List<Commentaire> getCommentsByArticle(Long articleId) {
        return articleService.getArticleById(articleId).getCommentaires();
    }

    public Commentaire addCommentToArticle(Long articleId, Commentaire commentaire) {
        Article article = articleService.getArticleById(articleId);
        commentaire.setArticle(article);
        return commentaireRepository.save(commentaire);
    }
}