package com.efrei.CoronaWatch.Controlers;

import com.efrei.CoronaWatch.Entities.Article;
import com.efrei.CoronaWatch.Entities.Commentary;
import com.efrei.CoronaWatch.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/Articles/Article")
    public Article getArticle(@RequestParam(name = "id") long id){
            Article article = articleRepository.findByIdArticle(id);
            if (article == null) {
                System.out.println("----------------------------------");
                System.out.println("There is no article with suck id");
                System.out.println("----------------------------------");
                return null;
            }else {
                System.out.println("----------------------------------");
                System.out.println(article.getTitle());
                System.out.println(article.getContent());
                System.out.println("----------------------------------");
                return article;
            }

    }

    @GetMapping("/Articles/Article/Comments")
    public Iterable<Commentary> getArticleComments(@RequestParam(name = "id") long id){
        Article article = articleRepository.findByIdArticle(id);

        if (article == null) {
            System.out.println("----------------------------------");
            System.out.println("There is no article with suck id");
            System.out.println("----------------------------------");
            return null;
        }else {
            System.out.println("----------------------------------");
            System.out.println(article.getTitle());
            System.out.println(article.getContent());
            System.out.println(article.getArticleCommentaries());
            System.out.println("----------------------------------");
            return article.getArticleCommentaries();
        }

    }
    //----------------POST----------------------


    @PostMapping("/Articles/AddArticle")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addArticle(@RequestBody Article article) throws Exception {
        articleRepository.save(article);

    }

    //----------------DELETE----------------------
    @DeleteMapping("/Articles/DeleteArticle")

    public void deleteArticle(@RequestParam(name = "id") long id) {
        Article article = articleRepository.findByIdArticle(id);
        if (article == null) {
            System.out.println( "----------------------------------" );
            System.out.println( "There is no article with suck id" );
            System.out.println( "----------------------------------" );

        }
        else {
            articleRepository.delete(article);
        }
    }

    //----------------PUT----------------------
    @PutMapping ("/Articles/EditArticle")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)

    public void editArticle(@RequestParam(name = "id") long id , @RequestBody Article editedarticle) {
        Article article = articleRepository.findByIdArticle(id);
        if (article == null) {
            System.out.println( "----------------------------------" );
            System.out.println( "There is no article with suck id" );
            System.out.println( "----------------------------------" );

        }
        else {
            article.setArticleValidate(editedarticle.getArticleValidate());
            article.setArticleRedactor(editedarticle.getArticleRedactor());
            article.setArticleModerator(editedarticle.getArticleModerator());
            article.setContent(editedarticle.getContent());
            article.setTitle(editedarticle.getTitle());

            articleRepository.save(article);
        }
    }

    @PutMapping ("/Articles/Article/Validate")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)

    public void ValidateArticle(@RequestParam(name = "id") long id , @RequestParam(name = "validate") Boolean validate ) {
        Article article = articleRepository.findByIdArticle(id);
        if (article == null) {
            System.out.println( "----------------------------------" );
            System.out.println( "There is no article with suck id" );
            System.out.println( "----------------------------------" );

        }
        else {
            article.setArticleValidate(validate);
            articleRepository.save(article);
        }
    }

    @PutMapping("/Articles/Article/Comments")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void InappropriateComments(@RequestParam(name = "id") long id,@RequestParam(name = "commentId") long commentId,@RequestParam(name = "inappropriate") Boolean inappropriate){
        Article article = articleRepository.findByIdArticle(id);

        if (article == null) {
            System.out.println("----------------------------------");
            System.out.println("There is no article with suck id");
            System.out.println("----------------------------------");
        }else {
            for (Commentary c : article.getArticleCommentaries()){
                if (c.getIdCommentary()==commentId){
                    c.setInappropriate(inappropriate);
                }
            }
        }

    }


}