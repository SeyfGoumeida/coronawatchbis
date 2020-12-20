package com.efrei.CoronaWatch.Entities;

import javax.persistence.*;
@Entity
public class Commentary {
    private long idCommentary;
    private String commentContent;
    private User commentEditor ;
    private Article commentArticle;
    private Boolean inappropriate;

    public Boolean getInappropriate() {
        return inappropriate;
    }

    public void setInappropriate(Boolean inappropriate) {
        this.inappropriate = inappropriate;
    }

    public Commentary( String commentContent) {
        this.commentContent = commentContent;
        this.inappropriate = false;

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
    @ManyToOne(cascade= CascadeType.ALL,optional = true, targetEntity=WebUser.class)
    public User getCommentEditor() {
        return commentEditor;
    }

    public void setCommentEditor(User commentEditor) {
        this.commentEditor = commentEditor;
    }
    @ManyToOne(optional = true, targetEntity=Article.class)
    public Article getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(Article commentArticle) {
        this.commentArticle = commentArticle;
    }
}
