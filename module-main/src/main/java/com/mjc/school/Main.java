package com.mjc.school;

import com.mjc.school.controller.AppEngine.AppEngine;

public class Main {
    public static void main(String[] args) {
        AppEngine engine = AppEngine.getInstance();
        engine.runApp();
    }
}