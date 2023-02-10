package com.mjc.school.service.Service;

import com.mjc.school.service.AbstractOptionHandler.OptionsBuilder;
import com.mjc.school.service.OptionHandlerInterface.OptionHandlerInterface;

import java.util.Map;

public class AppService {
    private static AppService instance = null;
    private static OptionHandlerInterface handlersChain;

    private AppService() {
    }

    public String processOption(String method, Map<String, String> body) {
        handlersChain = new OptionsBuilder().build();
        return handlersChain.process(method, body);
    }

    public static AppService getInstance() {
        if (instance == null) {
            instance = new AppService();
        }
        return instance;
    }
}
