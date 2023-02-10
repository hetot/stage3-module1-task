package com.mjc.school.service.AbstractOptionHandler;

import com.mjc.school.repository.DataSource.DataSource;
import com.mjc.school.service.OptionHandlerInterface.OptionHandlerInterface;

import java.util.Map;
import java.util.Objects;

public class GetAllOptionHandler extends AbstractOptionHandler {
    public GetAllOptionHandler(OptionHandlerInterface successor) {
        super(successor);
    }

    @Override
    public String process(String method, Map<String, String> body) {
        if (Objects.equals(method, "GETALL")) {
            return DataSource.getInstance().allToString();
        } else {
            if (getSuccessor() != null)
                return getSuccessor().process(method, body);
            return "Invalid option";
        }
    }
}
