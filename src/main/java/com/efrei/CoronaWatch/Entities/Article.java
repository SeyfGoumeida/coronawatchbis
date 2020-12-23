package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Article {
    private long idArticle;
    private String title;
    private String content;
    private Set<Commentary> articleCommentaries =  new HashSet<Commentary>();
    private Moderator articleModerator ;
    private Redactor articleRedactor;
    private Set<Attachment> articleAttachments = new HashSet<Attachment>();
    private Boolean articleValidate;


    public Article(){super();}
    public Article(String title, String content) {
        this.idArticle = idArticle;
        this.title = title;
        this.content = content;
        this.articleValidate = false;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
    }
    @Column(unique=true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @OneToMany(mappedBy="commentArticle", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Commentary> getArticleCommentaries() {
        return articleCommentaries;
    }

    public void setArticleCommentaries(Set<Commentary> articleCommentaries) {
        this.articleCommentaries = articleCommentaries;
    }
    @ManyToOne(optional = true, targetEntity=Moderator.class)
    public Moderator getArticleModerator() {
        return articleModerator;
    }

    public void setArticleModerator(Moderator articleModerator) {
        this.articleModerator = articleModerator;
    }
    @ManyToOne(optional = true, targetEntity=Redactor.class)
    public Redactor getArticleRedactor() {
        return articleRedactor;
    }

    public void setArticleRedactor(Redactor articleRedactor) {
        this.articleRedactor = articleRedactor;
    }
    @OneToMany(mappedBy="attachementArticle", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Attachment> getArticleAttachments() {
        return articleAttachments;
    }

    public void setArticleAttachments(Set<Attachment> articleAttachments) {
        this.articleAttachments = articleAttachments;
    }

    public Boolean getArticleValidate() {
        return articleValidate;
    }

    public void setArticleValidate(Boolean articleValidate) {
        this.articleValidate = articleValidate;
    }

}
