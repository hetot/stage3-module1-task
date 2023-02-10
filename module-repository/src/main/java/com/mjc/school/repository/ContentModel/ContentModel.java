package com.mjc.school.repository.ContentModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ContentModel {
    private Long id;
    private String title;
    private String content;
    private Date createDate;
    private Date lastUpdateDate;
    private Long authorId;

    public ContentModel(Long id, String title, String content, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = new Date();
        this.lastUpdateDate = new Date();
        this.authorId = authorId;
    }

    public ContentModel(List<String> stringList) {
        for (int i = 1; i < stringList.size(); i++) {
            if (Objects.equals(stringList.get(i - 1), "__id__")) {
                this.id = Long.parseLong(stringList.get(i));
            } else if (Objects.equals(stringList.get(i - 1), "__title__")) {
                StringBuilder stringBuilder = new StringBuilder();
                while (i < stringList.size() && !stringList.get(i).matches("^__.*__$")) {
                    stringBuilder.append(stringList.get(i));
                    i++;
                }
                this.title = stringBuilder.toString();
            } else if (Objects.equals(stringList.get(i - 1), "__content__")) {
                StringJoiner stringJoiner = new StringJoiner("\n");
                while (i < stringList.size() && !stringList.get(i).matches("^__.*__$")) {
                    stringJoiner.add(stringList.get(i));
                    i++;
                }
                this.content = stringJoiner.toString();
            } else if (Objects.equals(stringList.get(i - 1), "__createDate__")) {
                String createDate = stringList.get(i);
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                try {
                    this.createDate = df.parse(createDate);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            } else if (Objects.equals(stringList.get(i - 1), "__lastUpdateDate__")) {
                String lastUpdate = stringList.get(i);
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                try {
                    this.lastUpdateDate = df.parse(lastUpdate);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            } else if (Objects.equals(stringList.get(i - 1), "__authorId__")) {
                this.authorId = Long.parseLong(stringList.get(i));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long id) {
        this.authorId = id;
        this.lastUpdateDate = new Date();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.lastUpdateDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.lastUpdateDate = new Date();
    }

    public String toString() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        return "[\n" +
                "id=" + this.id + "\n" +
                "title=" + this.title + "\n" +
                "content=" + this.content + "\n" +
                "createdDate=" + df.format(createDate) + "\n" +
                "lastUpdateDate=" + df.format(lastUpdateDate) + "\n" +
                "authorId=" + this.authorId + "\n" +
                "]\n";
    }
}
