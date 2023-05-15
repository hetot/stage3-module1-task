package com.mjc.school.service.dtomodels;

import com.mjc.school.service.dtoInterface.RequestInterface;

public class RemoveRequest implements RequestInterface {

    private final long id;

    public RemoveRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
