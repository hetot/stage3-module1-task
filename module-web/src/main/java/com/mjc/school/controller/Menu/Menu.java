package com.mjc.school.controller.Menu;

import com.mjc.school.controller.Options.Options;

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
