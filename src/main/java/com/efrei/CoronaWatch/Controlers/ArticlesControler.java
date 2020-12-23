package com.efrei.CoronaWatch.Controlers;

import com.efrei.CoronaWatch.Entities.Article;
import com.efrei.CoronaWatch.Entities.Attachment;
import com.efrei.CoronaWatch.Entities.Commentary;
import com.efrei.CoronaWatch.Entities.WebUser;
import com.efrei.CoronaWatch.Payload.Response.AttachmentResponse;
import com.efrei.CoronaWatch.Payload.Response.MessageResponse;
import com.efrei.CoronaWatch.Repositories.ArticleRepository;
import com.efrei.CoronaWatch.Repositories.AttachmentRepository;
import com.efrei.CoronaWatch.Repositories.UserRepository;
import com.efrei.CoronaWatch.Service.AttachmentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ArticlesControler {

    ArticleRepository articleRepository;
    UserRepository userRepository;
    AttachmentStorageService attachmentStorageService;
    AttachmentRepository attachmentRepository;


    @Autowired
    public ArticlesControler(ArticleRepository articleRepository,UserRepository userRepository,AttachmentStorageService attachmentStorageService,AttachmentRepository attachmentRepository) {
        super();
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.attachmentStorageService = attachmentStorageService;
        this.attachmentRepository = attachmentRepository;
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
        article.setArticleValidate(false);
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
            article.setArticleValidate(false);
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

    @PostMapping("/Articles/Article/AddComment")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
        public void AddComment(@RequestParam(name = "id") long id,@RequestParam(name = "content") String content,@RequestParam(name = "idUser") long idUser){
        Article article = articleRepository.findByIdArticle(id);

        if (article == null) {
            System.out.println("----------------------------------");
            System.out.println("There is no article with suck id");
            System.out.println("----------------------------------");
        }else {
            Commentary myComment = new Commentary(content);
            myComment.setCommentArticle(article);
            Set<Commentary> comments = new HashSet<Commentary>();
            comments.add(myComment);
            WebUser myUser = (WebUser) userRepository.findByIdUser(idUser);
            myUser.setWebUserCommentaries(comments);
            myComment.setCommentEditor(myUser);
            article.setArticleCommentaries(comments);
            userRepository.save(myUser);
            articleRepository.save(article);

        }


    }

// ATTACHMENT :
// GET ATTACHMENT (GET)----------------------------------------------------------------------------------
@GetMapping("/Articles/Article/Attachments")
public  ResponseEntity<List<AttachmentResponse>> getArticleAttachments(@RequestParam(name = "id") long id){
    Article article = articleRepository.findByIdArticle(id);

    if (article == null) {
        System.out.println("----------------------------------");
        System.out.println("There is no article with suck id");
        System.out.println("----------------------------------");
        return null;
    }else {
        List<AttachmentResponse> attachments = article.getArticleAttachments().stream().map(attachment -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/Articles/Article/Attachments/")
                    .path(attachment.getIdAttachment()+"")
                    .toUriString();
            return new AttachmentResponse(
                    attachment.getTitle(),
                    fileDownloadUri,
                    attachment.getType(),
                    attachment.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(attachments);
    }

}
// this is for the downloading url :
//-------------------------------------------------------------------------------------------------------
@GetMapping("/Articles/Article/Attachments/{id}")
public ResponseEntity<byte[]> getFile(@PathVariable long id) {
    Attachment attachment = attachmentStorageService.getAttachment(id);

    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getTitle() + "\"")
            .body(attachment.getData());
}
// ADD ATTACHMENT (POST)---------------------------------------------------------------------------------

    @PostMapping("/Articles/Article/AddAttachment")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public ResponseEntity<MessageResponse> AddAttachment(@RequestParam(name = "id") long id, @RequestParam(name = "file") MultipartFile file){
        Article article = articleRepository.findByIdArticle(id);
        String message = "";

        if (article == null) {
            message = "There is no article with such id: " ;
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        }else {
            try{
                Attachment attachment = attachmentStorageService.store(file);
                attachment.setAttachementArticle(article);
                article.getArticleAttachments().add(attachment);
                attachmentRepository.save(attachment);
                articleRepository.save(article);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));

            }catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
            }


        }


    }
}