package com.mjc.school.repository.DataSource;

import com.mjc.school.repository.AuthorModel.AuthorModel;
import com.mjc.school.repository.ContentModel.ContentModel;
import com.mjc.school.repository.NewsReader.NewsReader;

import java.util.List;
import java.util.Objects;

public class DataSource {
    private static DataSource instance = null;
    private static final String authorsFile = "authors.txt";
    private static final String contentsFile = "contents.txt";

    private List<ContentModel> contents;
    private List<AuthorModel> authors;

    private DataSource() {
        NewsReader newsReader = new NewsReader(authorsFile, contentsFile);
        contents = newsReader.getContents();
        authors = newsReader.getAuthors();
    }

    public void addNews(ContentModel content) {
        contents.add(content);
    }

    public void updateNews(ContentModel content) {
        int target = 0;
        for (int i = 0; i < contents.size(); i++) {
            if (Objects.equals(contents.get(i).getId(), content.getId())) {
                target = i;
                break;
            }
        }
        contents.set(target, content);
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public List<ContentModel> getContents() {
        return contents;
    }

    public Long generateIdForContent() {
        long maxId = 0;
        for (ContentModel contentModel : contents) {
            if (contentModel.getId() > maxId) {
                maxId = contentModel.getId();
            }
        }
        return maxId + 1;
    }

    public String allToString() {
        StringBuilder sb = new StringBuilder();
        for (ContentModel contentModel : contents) {
            sb.append(contentModel.toString());
        }
        return sb.toString();
    }

    public String getNewsById(Long id) {
        for (ContentModel contentModel : contents) {
            if (Objects.equals(contentModel.getId(), id)) {
                return contentModel.toString();
            }
        }
        return "Not found";
    }

    public void removeById(Long id) {
        contents.removeIf(s -> Objects.equals(s.getId(), id));
    }

    public String updateById(ContentModel contentModel) {
        for (ContentModel content : contents) {
            if (Objects.equals(contentModel.getId(), content.getId())) {
                content.setContent(contentModel.getContent());
                content.setTitle(contentModel.getTitle());
                content.setAuthorId(contentModel.getAuthorId());
                return "Updated";
            }
        }
        return "Not found";
    }
}
