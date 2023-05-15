package com.mjc.school.controller.optionImplementation;

import com.mjc.school.controller.optionInteface.OptionInterface;

public class ExitOption implements OptionInterface {
    @Override
    public String process() {
        return "Closing...";
    }
}
