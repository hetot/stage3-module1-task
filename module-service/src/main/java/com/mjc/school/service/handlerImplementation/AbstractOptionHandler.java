package com.mjc.school.service.handlerImplementation;

import com.mjc.school.service.optionInteface.OptionHandlerInterface;

public abstract class AbstractOptionHandler implements OptionHandlerInterface {
    private OptionHandlerInterface successor;

    AbstractOptionHandler(OptionHandlerInterface successor) {
        this.successor = successor;
    }

    protected OptionHandlerInterface getSuccessor() {
        return successor;
    }
}
