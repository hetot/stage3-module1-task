package com.mjc.school.controller.Options;

import com.mjc.school.controller.OptionInterface.OptionInterface;
import com.mjc.school.service.Service.AppService;

public class GetAllOption implements OptionInterface {
    private final AppService service;

    public GetAllOption() {
        service = AppService.getInstance();
    }

    @Override
    public String process() {
        return service.processOption("GETALL", null);
    }
}
