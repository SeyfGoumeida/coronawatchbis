package com.efrei.CoronaWatch.Entities;

import com.efrei.CoronaWatch.Entities.Article;

import javax.persistence.*;

@Entity

public class Attachment {
    private long idAttachment;
    private String title;
    private String content ;
    private Article attachementArticle;

    public Attachment(){super();}
    public Attachment(long idAttachment, String title, String content) {
        this.idAttachment = idAttachment;
        this.title = title;
        this.content = content;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(long idAttachment) {
        this.idAttachment = idAttachment;
    }

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

    @ManyToOne(cascade= CascadeType.ALL)
    public Article getAttachementArticle() {
        return attachementArticle;
    }

    public void setAttachementArticle(Article attachementArticle) {
        this.attachementArticle = attachementArticle;
    }
}
