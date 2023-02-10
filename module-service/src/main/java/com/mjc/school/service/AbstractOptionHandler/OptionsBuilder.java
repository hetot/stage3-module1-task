package com.mjc.school.service.AbstractOptionHandler;

import com.mjc.school.service.OptionHandlerInterface.OptionHandlerInterface;

public class OptionsBuilder {
    public OptionHandlerInterface build() {
        return new CreateHandler(new GetAllOptionHandler(new GetByIdOptionHandler(new RemoveOptionHandler(new UpdateOptionHandler(null)))));
    }
}
