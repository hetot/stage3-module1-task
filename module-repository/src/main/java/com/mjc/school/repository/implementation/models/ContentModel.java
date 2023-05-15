package com.mjc.school.repository.implementation.models;

import java.util.Date;

public class ContentModel {
    private long id;
    private String title;
    private String content;
    private Date createDate;
    private Date lastUpdateDate;
    private AuthorModel author;

    public ContentModel() {
    }

    public ContentModel(long id, String title, String content, Date createDate, Date lastUpdateDate, AuthorModel author) {
        this.id = id;
        this.lastUpdateDate = lastUpdateDate;
        this.createDate = createDate;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(ContentModel other) {
        this.lastUpdateDate = new Date();
        this.title = other.title;
        this.content = other.content;
        this.author = other.author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public AuthorModel getAuthor() {
        return author;
    }
}
