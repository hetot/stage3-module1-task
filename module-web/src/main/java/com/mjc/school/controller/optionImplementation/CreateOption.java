package com.mjc.school.controller.optionImplementation;

import com.mjc.school.controller.optionInteface.OptionInterface;
import com.mjc.school.service.dtoInterface.ResponseInterface;
import com.mjc.school.service.dtomodels.CreateRequest;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.service.AppService;

import java.util.Scanner;

public class CreateOption implements OptionInterface {
    private final AppService service;

    public CreateOption() {
        service = AppService.getInstance();
    }

    @Override
    public String process() {
        String title;
        String content;
        String authorId;

        System.out.println("Operation: Create news.");

        Scanner br = new Scanner(System.in);
        System.out.println("Enter news title:");
        title = br.nextLine();
        System.out.println("Enter news content:");
        content = br.nextLine();
        System.out.println("Enter author's id:");
        authorId = br.nextLine();

        long author;
        try {
            author = Long.parseLong(authorId);
        } catch (Exception e) {
            return e.getMessage();
        }

        CreateRequest request = new CreateRequest();
        request.setTitle(title);
        request.setContent(content);
        request.setAuthorId(author);
        ResponseDTO response = (ResponseDTO) service.processOption(request);
        if (response.isSuccessful()) {
            return response.getContents().toString();
        }
        return response.getMessage();
    }
}
