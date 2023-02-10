package com.mjc.school.controller.Options;

import com.mjc.school.controller.OptionInterface.OptionInterface;
import com.mjc.school.service.Service.AppService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        Map<String, String> body = new HashMap<>();
        body.put("id", id);
        body.put("title", title);
        body.put("content", content);
        body.put("authorId", authorId);

        return service.processOption("UPDATE", body);
    }
}
