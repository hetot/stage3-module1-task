package com.mjc.school.controller.Options;

import com.mjc.school.controller.OptionInterface.OptionInterface;

public class ExitOption implements OptionInterface {
    @Override
    public String process() {
        return "Closing...";
    }
}
