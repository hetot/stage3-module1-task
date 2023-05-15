package com.mjc.school.service.validators;

public class ValidatorResponse {
    private String message;
    private boolean valid;

    public ValidatorResponse() {
        valid = true;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return !valid;
    }
}
