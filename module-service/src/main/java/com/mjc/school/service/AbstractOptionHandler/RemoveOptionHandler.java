package com.mjc.school.service.AbstractOptionHandler;

import com.mjc.school.repository.DataSource.DataSource;
import com.mjc.school.service.OptionHandlerInterface.OptionHandlerInterface;

import java.util.Map;
import java.util.Objects;

public class RemoveOptionHandler extends AbstractOptionHandler {
    public RemoveOptionHandler(OptionHandlerInterface successor) {
        super(successor);
    }

    @Override
    public String process(String method, Map<String, String> body) {
        try {
            if (Objects.equals(method, "REMOVE")) {
                DataSource.getInstance().removeById(Long.parseLong(body.get("id")));
                return "Removed";
            } else {
                if (getSuccessor() != null)
                    return getSuccessor().process(method, body);
                return "Invalid option";
            }
        } catch (Exception e) {
            return "Invalid input";
        }
    }
}
