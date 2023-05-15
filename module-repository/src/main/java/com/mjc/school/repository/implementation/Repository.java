package com.mjc.school.repository.implementation;

import com.mjc.school.repository.implementation.models.ContentModel;
import com.mjc.school.repository.implementation.source.DataSource;

import java.util.List;
import java.util.Objects;

public class Repository {
    private final DataSource dataSource;

    public Repository() {
        this.dataSource = DataSource.getInstance();
    }

    public List<ContentModel> readAll() {
        return this.dataSource.getContents();
    }


    public ContentModel readById(Long newsId) {
        return this.dataSource.getContents().stream()
                .filter(news -> Objects.equals(newsId, news.getId()))
                .findFirst()
                .orElse(null);
    }

    public ContentModel create(ContentModel model) {
        List<ContentModel> newsList = this.dataSource.getContents();
        Long maxId = newsList.stream().mapToLong(ContentModel::getId).max().orElse(0L);
        Long nextId = maxId + 1L;
        model.setId(nextId);
        newsList.add(model);
        return model;
    }


    public ContentModel update(ContentModel model) {
        ContentModel newsModel = readById(model.getId());
        newsModel.setTitle(model.getTitle());
        newsModel.setContent(model.getContent());
        newsModel.setAuthor(model.getAuthor());
        return newsModel;
    }


    public Boolean deleteById(Long newsId) {
        List<ContentModel> newsList = dataSource.getContents();
        int originalSize = newsList.size();
        newsList.removeIf(news -> newsId.equals(news.getId()));
        return originalSize != newsList.size();
    }

    public Boolean isExistById(Long newsId) {
        return this.dataSource.getContents().stream()
                .anyMatch(news -> newsId.equals(news.getId()));
    }
}
