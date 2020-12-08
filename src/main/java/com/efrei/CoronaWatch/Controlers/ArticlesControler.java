package com.efrei.CoronaWatch.Controlers;

import com.efrei.CoronaWatch.Entities.Article;
import com.efrei.CoronaWatch.Repositories.ArticleRepository;
import com.efrei.CoronaWatch.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticlesControler {

    ArticleRepository articleRepository;

    @Autowired
    public ArticlesControler(ArticleRepository articleRepository) {
        super();
        this.articleRepository = articleRepository;
    }


    @GetMapping("/Articles")
    public Iterable<Article> getArticles(){
        return articleRepository.findAll();
    }
    @GetMapping("/Articles/Validate")
    public Iterable<Article> getValidatesArticles(){
        Iterable<Article> listOfArticles = getArticles();
        List<Article> listOfValidatesArticles = new ArrayList<>();
        for(Article article :listOfArticles ){
            if(article.getArticleValidate())
            {
                listOfValidatesArticles.add(article);
            }
        }
        return listOfValidatesArticles;
    }
    @GetMapping("/Articles/Invalidate")
    public Iterable<Article> getInvalidatesArticles(){
        Iterable<Article> listOfArticles = getArticles();
        List<Article> listOfInvalidatesArticles = new ArrayList<>();
        for(Article article :listOfArticles ){
            if(!article.getArticleValidate())
            {
                listOfInvalidatesArticles.add(article);
            }
        }
        return listOfInvalidatesArticles;
    }

    @PostMapping("/Articles")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addArticle(@RequestBody Article article) throws Exception {
        articleRepository.save(article);

    }


}