package com.mjc.school.repository.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjc.school.repository.models.AuthorModel;
import com.mjc.school.repository.models.ContentModelJson;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class NewsReader {
    private static final InputStream authorsFileName = NewsReader.class.getClassLoader().getResourceAsStream("authors.json");
    private static final InputStream contentsFileName = NewsReader.class.getClassLoader().getResourceAsStream("news.json");
    private static final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public static List<AuthorModel> getAuthors() {
        try {
            return objectMapper.readValue(
                    authorsFileName,
                    new TypeReference<List<AuthorModel>>() {
                    }
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<ContentModelJson> getContents() {
        System.out.println(contentsFileName.toString());
        try {
            return objectMapper.readValue(
                    contentsFileName,
                    new TypeReference<>() {
                    }
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
