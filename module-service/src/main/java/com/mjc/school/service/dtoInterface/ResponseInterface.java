package com.mjc.school.service.dtoInterface;

import com.mjc.school.service.dtomodels.ContentDTO;

import java.util.List;

public interface ResponseInterface {
    String getMessage();

    void setMessage(String message);

    void setSuccessful(boolean successful);

    boolean isSuccessful();

    void setContents(List<ContentDTO> contents);
    List<ContentDTO> getContents();
}
