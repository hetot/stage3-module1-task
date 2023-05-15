package com.mjc.school.service.handlerImplementation;

import com.mjc.school.service.optionInteface.OptionHandlerInterface;

public class OptionsBuilder {
    public OptionHandlerInterface build() {
        return new CreateHandler(new GetAllOptionHandler(new GetByIdOptionHandler(new RemoveOptionHandler(new UpdateHandler(null)))));
    }
}
