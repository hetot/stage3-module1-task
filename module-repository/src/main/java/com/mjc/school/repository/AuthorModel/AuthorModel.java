package com.mjc.school.repository.AuthorModel;

import java.util.List;
import java.util.Objects;

public class AuthorModel {
    private Long id;
    private String name;

    public AuthorModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorModel(List<String> stringList) {
        for (int i = 1; i < stringList.size(); i++) {
            if (Objects.equals(stringList.get(i - 1), "__id__")) {
                this.id = Long.parseLong(stringList.get(i));
            } else if (Objects.equals(stringList.get(i - 1), "__name__")) {
                this.name = stringList.get(i);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
