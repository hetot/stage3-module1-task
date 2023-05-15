package com.mjc.school.service.validators;

import com.mjc.school.repository.source.DataSource;
import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtomodels.CreateRequest;
import com.mjc.school.service.dtomodels.UpdateRequest;

public class DtoValidator {
    public static ValidatorResponse validate(RequestInterface requestDto) {
        if (requestDto instanceof CreateRequest) {
            return createValidator((CreateRequest) requestDto);
        } else if (requestDto instanceof UpdateRequest) {
            return updateValidator((UpdateRequest) requestDto);
        }
        return null;
    }

    private static ValidatorResponse updateValidator(UpdateRequest requestDto) {
        ValidatorResponse response = new ValidatorResponse();
        if (requestDto.getTitle() == null || requestDto.getAuthorId() == 0 || requestDto.getContent() == null || requestDto.getId() == 0) {
            response.setValid(false);
            response.setMessage("request has null/empty field/fields");
            return response;
        }
        validateContent(response, requestDto.getId());
        validateTitle(response, requestDto.getTitle());
        validateContent(response, requestDto.getContent());
        validateAuthor(response, requestDto.getAuthorId());
        return response;
    }

    private static void validateTitle(ValidatorResponse response, String title) {
        if (title.length() < 5 || title.length() > 30) {
            response.setValid(false);
            response.setMessage("invalid title (it`s length has to be between 5 and 30)");
        }
    }

    private static void validateContent(ValidatorResponse response, String content) {
        if (content.length() < 5 || content.length() > 255) {
            response.setValid(false);
            response.setMessage("invalid content (it`s length has to be between 5 and 30)");
        }
    }

    private static void validateAuthor(ValidatorResponse response, long id) {
        if (DataSource.getInstance().getAuthors().stream().noneMatch(authorModel -> authorModel.id() == id)) {
            response.setValid(false);
            response.setMessage("author is not found");
        }
    }

    private static void validateContent(ValidatorResponse response, long id) {
        if (DataSource.getInstance().getContents().stream().noneMatch(contentModel -> contentModel.getId() == id)) {
            response.setValid(false);
            response.setMessage("content is not found");
        }
    }

    private static ValidatorResponse createValidator(CreateRequest requestDto) {
        ValidatorResponse response = new ValidatorResponse();
        if (requestDto.getTitle() == null || requestDto.getAuthorId() == 0 || requestDto.getContent() == null) {
            response.setValid(false);
            response.setMessage("request has null/empty field/fields");
            return response;
        }
        validateTitle(response, requestDto.getTitle());
        validateContent(response, requestDto.getContent());
        validateAuthor(response, requestDto.getAuthorId());
        return response;
    }
}
