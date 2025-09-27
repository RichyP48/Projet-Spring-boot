package com.mogou.service;

import com.mogou.model.Article;
import com.mogou.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Article non trouvé avec l'id : " + id));
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article articleDetails) {
        Article article = getArticleById(id);
        article.setTitre(articleDetails.getTitre());
        article.setContenu(articleDetails.getContenu());
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.delete(getArticleById(id));
    }
}