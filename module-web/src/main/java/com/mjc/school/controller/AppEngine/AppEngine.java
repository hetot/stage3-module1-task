package com.mjc.school.controller.AppEngine;

import com.mjc.school.controller.Menu.Menu;
import com.mjc.school.controller.Options.*;

import java.util.List;
import java.util.Scanner;

public class AppEngine {
    private static AppEngine instance = null;
    private static Menu menu = null;
    private static final List<Options> options = List.of(Options.values());

    public void runApp() {
        boolean run = true;
        while (run) {
            menu.show(options);
            Scanner reader = new Scanner(System.in);
            String userIn = reader.nextLine();
            for (Options o : options) {
                if (o.getOptionNumber() == Integer.parseInt(userIn)) {
                    System.out.println(o.getOption().process());
                    if (o == Options.EXIT) {
                        run = false;
                    }
                    break;
                }
            }
        }
    }

    private AppEngine() {
        menu = Menu.getInstance();
    }

    public static AppEngine getInstance() {
        if (instance == null) {
            instance = new AppEngine();
        }
        return instance;
    }
}
