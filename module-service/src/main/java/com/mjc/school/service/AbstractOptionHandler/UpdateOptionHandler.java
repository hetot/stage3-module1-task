package com.mjc.school.service.AbstractOptionHandler;

import com.mjc.school.repository.AuthorModel.AuthorModel;
import com.mjc.school.repository.ContentModel.ContentModel;
import com.mjc.school.repository.DataSource.DataSource;
import com.mjc.school.service.OptionHandlerInterface.OptionHandlerInterface;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UpdateOptionHandler extends AbstractOptionHandler {
    public UpdateOptionHandler(OptionHandlerInterface successor) {
        super(successor);
    }

    @Override
    public String process(String method, Map<String, String> body) {
        try {
            if (Objects.equals(method, "UPDATE")) {
                if (validator(body)) {
                    ContentModel contentModel = new ContentModel(
                            Long.parseLong(body.get("id")),
                            body.get("title"),
                            body.get("content"),
                            Long.parseLong(body.get("authorId"))
                    );
                    return DataSource.getInstance().updateById(contentModel);
                }
                return "Not valid values!!!";
            } else {
                if (getSuccessor() != null)
                    return getSuccessor().process(method, body);
                return "Invalid option";
            }
        } catch (Exception e) {
            return "Invalid input";
        }
    }

    private boolean validator(Map<String, String> body) {
        if (body.get("title").length() < 5 || body.get("title").length() > 30)
            return false;
        if (body.get("content").length() < 5 || body.get("content").length() > 255)
            return false;
        List<AuthorModel> authors = DataSource.getInstance().getAuthors();
        for (AuthorModel author : authors) {
            if (author.getId() == Long.parseLong(body.get("authorId")))
                return true;
        }
        return false;
    }
}
