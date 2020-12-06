package com.efrei.CoronaWatch.Controlers;

import com.efrei.CoronaWatch.Entities.Article;
import com.efrei.CoronaWatch.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {

    ArticleRepository articleRepository;

    @Autowired
    public RestWebService(ArticleRepository articleRepository) {
        super();
        this.articleRepository = articleRepository;
    }

    @GetMapping("/articles")
    public Iterable<Article> getArtticles(){
        return articleRepository.findAll();
    }

    @PostMapping("/article")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addArticle(@RequestBody Article article) throws Exception {
        articleRepository.save(article);
       /* if(article.getPlateNumber().equals("AA11BB")){
            throw new Exception();
        }*/
    }


}