package com.mjc.school.controller.menu;

import com.mjc.school.controller.optionImplementation.Options;

import java.util.List;

public class Menu {
    private static Menu instance = null;

    private Menu() {

    }

    public void show(List<Options> options) {
        System.out.println("Enter the number of operation:");
        for (Options option : options) {
            System.out.println(option.toString());
        }
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }
}
