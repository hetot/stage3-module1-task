package com.mjc.school.service.dtomodels;

import com.mjc.school.service.dtoInterface.RequestInterface;

public class GetByIdRequest implements RequestInterface {
    private final long id;

    public GetByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
