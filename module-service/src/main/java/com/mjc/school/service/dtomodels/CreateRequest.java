package com.mjc.school.service.dtomodels;

import com.mjc.school.service.dtoInterface.RequestInterface;

public class CreateRequest implements RequestInterface {
    private String title;
    private String content;
    private long authorId;

    public CreateRequest() {
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

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
