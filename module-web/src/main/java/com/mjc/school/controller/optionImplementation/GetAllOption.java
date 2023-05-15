package com.mjc.school.controller.optionImplementation;

import com.mjc.school.controller.optionInteface.OptionInterface;
import com.mjc.school.service.dtomodels.GetAllRequest;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.service.AppService;

public class GetAllOption implements OptionInterface {
    private final AppService service;

    public GetAllOption() {
        service = AppService.getInstance();
    }

    @Override
    public String process() {
        GetAllRequest getAllRequest = new GetAllRequest();
        ResponseDTO responseDTO = (ResponseDTO) service.processOption(getAllRequest);
        return responseDTO.getContents().toString();
    }
}
