package com.mjc.school.controller.optionImplementation;

import com.mjc.school.controller.optionInteface.OptionInterface;
import com.mjc.school.service.dtomodels.ContentDTO;
import com.mjc.school.service.dtomodels.GetByIdRequest;
import com.mjc.school.service.dtomodels.RemoveRequest;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.service.AppService;

import java.util.Scanner;

public class RemoveOption implements OptionInterface {
    private final AppService service;

    public RemoveOption() {
        service = AppService.getInstance();
    }

    @Override
    public String process() {
        String id;

        System.out.println("Operation: Remove news.");

        Scanner br = new Scanner(System.in);
        System.out.println("Enter news id:");
        id = br.nextLine();

        long longId;
        try {
            longId = Long.parseLong(id);
        } catch (Exception e) {
            return e.getMessage();
        }

        RemoveRequest removeRequest = new RemoveRequest(longId);
        ResponseDTO responseDTO = (ResponseDTO) service.processOption(removeRequest);

        if (responseDTO.isSuccessful()) {
            return responseDTO.getContents().toString();
        }
        return responseDTO.getMessage();
    }
}
