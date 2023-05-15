package com.mjc.school.repository.source;

import com.mjc.school.repository.models.AuthorModel;
import com.mjc.school.repository.models.ContentModel;
import com.mjc.school.repository.models.ContentModelJson;
import com.mjc.school.repository.reader.NewsReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataSource {
    private static DataSource instance = null;
    private List<ContentModel> contents;
    private List<AuthorModel> authors;

    private DataSource() {
        loadData();
    }

    private void loadData() {
        authors = NewsReader.getAuthors();
        List<ContentModelJson> contentModelJsons = NewsReader.getContents();
        contents = new ArrayList<>();
        for (ContentModelJson contentModelJson : contentModelJsons) {
            Optional<AuthorModel> matchingAuthor = authors.stream().filter(a -> (a.id() == contentModelJson.getAuthorId())).findFirst();
            matchingAuthor.ifPresent(
                    authorModel -> contents.add(new ContentModel(
                                    contentModelJson.getId(),
                                    contentModelJson.getTitle(),
                                    contentModelJson.getContent(),
                                    contentModelJson.getCreateDate(),
                                    contentModelJson.getLastUpdateDate(),
                                    authorModel
                            )
                    )
            );
        }
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

    public ContentModel addContent(ContentModel content) {
        long newId = generateContentId();
        content.setId(newId);
        contents.add(content);
        return content;
    }

    public ContentModel updateContent(ContentModel content) {
        Optional<ContentModel> optionalContentModel = contents.stream().filter(c -> c.getId() == content.getId()).findFirst();
        if (optionalContentModel.isPresent()) {
            optionalContentModel.get().update(content);
            return optionalContentModel.get();
        }
        return null;
    }

    public void remove(ContentModel content) {
        contents.removeIf(c -> c.getId() == content.getId());
    }

    private long generateContentId() {
        return contents
                .stream()
                .mapToLong(ContentModel::getId)
                .max().orElse(-2) + 1;
    }
}
