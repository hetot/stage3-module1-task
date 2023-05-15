package com.mjc.school.service.dtomodels;

import com.mjc.school.service.dtoInterface.ResponseInterface;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO implements ResponseInterface {
    private String message;
    private boolean successful;
    private List<ContentDTO> contents;

    public ResponseDTO() {
        successful = true;
        contents = new ArrayList<>();
    }

    public String getMessage() {
        return message;
    }

    public void setContents(List<ContentDTO> contents) {
        this.contents = contents;
    }

    public List<ContentDTO> getContents() {
        return contents;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
