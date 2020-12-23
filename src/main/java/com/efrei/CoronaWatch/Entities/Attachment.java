package com.efrei.CoronaWatch.Entities;

import javax.persistence.*;

@Entity

public class Attachment {
    private long idAttachment;
    private String title;
    private String type;
    private byte[] data;
    private Article attachementArticle;

    public Attachment(){super();}
    public Attachment(String title,String type, byte[] data) {
        this.title = title;
        this.type = type;
        this.data = data;
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

    public byte[] getData() { return data; }

    public void setData(byte[] data) { this.data = data; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(optional = true, targetEntity=Article.class)
    public Article getAttachementArticle() {
        return attachementArticle;
    }

    public void setAttachementArticle(Article attachementArticle) {
        this.attachementArticle = attachementArticle;
    }
}
