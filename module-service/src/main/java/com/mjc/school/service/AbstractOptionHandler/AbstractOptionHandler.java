package com.mjc.school.service.AbstractOptionHandler;

import com.mjc.school.service.OptionHandlerInterface.OptionHandlerInterface;

public abstract class AbstractOptionHandler implements OptionHandlerInterface {
    private OptionHandlerInterface successor;

    AbstractOptionHandler(OptionHandlerInterface successor) {
        this.successor = successor;
    }

    protected OptionHandlerInterface getSuccessor() {
        return successor;
    }
}
