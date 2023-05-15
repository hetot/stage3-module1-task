package com.mjc.school.service.service;

import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtoInterface.ResponseInterface;
import com.mjc.school.service.handlerImplementation.OptionsBuilder;
import com.mjc.school.service.optionInteface.OptionHandlerInterface;

public class AppService {
    private static AppService instance = null;
    private static OptionHandlerInterface handlersChain;

    private AppService() {
    }

    public ResponseInterface processOption(RequestInterface requestDto) {
        handlersChain = new OptionsBuilder().build();
        return handlersChain.process(requestDto);
    }

    public static AppService getInstance() {
        if (instance == null) {
            instance = new AppService();
        }
        return instance;
    }
}
