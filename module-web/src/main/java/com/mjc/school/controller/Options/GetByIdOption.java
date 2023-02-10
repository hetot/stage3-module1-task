package com.mjc.school.controller.Options;

import com.mjc.school.controller.OptionInterface.OptionInterface;
import com.mjc.school.service.Service.AppService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GetByIdOption implements OptionInterface {
    private final AppService service;

    public GetByIdOption() {
        service = AppService.getInstance();
    }

    @Override
    public String process() {
        String id;

        System.out.println("Operation: Get news by id.");

        Scanner br = new Scanner(System.in);
        System.out.println("Enter news id:");
        id = br.nextLine();

        Map<String, String> body = new HashMap<>();
        body.put("id", id);

        return service.processOption("GETBYID", body);
    }
}
