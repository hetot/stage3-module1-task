package com.mjc.school.controller.optionImplementation;

import com.mjc.school.controller.optionInteface.OptionInterface;
import com.mjc.school.service.dtomodels.ContentDTO;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.dtomodels.UpdateRequest;
import com.mjc.school.service.service.AppService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UpdateOption implements OptionInterface {
    private final AppService service;

    public UpdateOption() {
        service = AppService.getInstance();
    }

    @Override
    public String process() {
        String id;
        String title;
        String content;
        String authorId;

        System.out.println("Operation: Update news.");

        Scanner br = new Scanner(System.in);
        System.out.println("Enter news id:");
        id = br.nextLine();
        System.out.println("Enter news title:");
        title = br.nextLine();
        System.out.println("Enter news content:");
        content = br.nextLine();
        System.out.println("Enter author's id:");
        authorId = br.nextLine();

        long longId, author;
        try {
            longId = Long.parseLong(id);
            author = Long.parseLong(authorId);
        } catch (Exception e) {
            return e.getMessage();
        }

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setId(longId);
        updateRequest.setContent(content);
        updateRequest.setTitle(title);
        updateRequest.setAuthorId(author);

        ResponseDTO responseDTO = (ResponseDTO) service.processOption(updateRequest);
        if (responseDTO.isSuccessful()) {
            return responseDTO.getContents().toString();
        }
        return responseDTO.getMessage();
    }
}
