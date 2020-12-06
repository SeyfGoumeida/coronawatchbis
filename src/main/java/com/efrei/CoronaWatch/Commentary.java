package com.efrei.CoronaWatch;

import javax.persistence.*;
@Entity
public class Commentary {
    private long idCommentary;
    private String commentContent;
    private WebUser commentEditor ;
    private Article commentArticle;

    public Commentary(long idCommentary, String commentContent) {
        this.idCommentary = idCommentary;
        this.commentContent = commentContent;
    }
    public Commentary(){super();}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdCommentary() {
        return idCommentary;
    }

    public void setIdCommentary(long idCommentary) {
        this.idCommentary = idCommentary;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    @ManyToOne(cascade= CascadeType.ALL)
    public WebUser getCommentEditor() {
        return commentEditor;
    }

    public void setCommentEditor(WebUser commentEditor) {
        this.commentEditor = commentEditor;
    }
    @ManyToOne(cascade=CascadeType.ALL)
    public Article getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(Article commentArticle) {
        this.commentArticle = commentArticle;
    }
}
