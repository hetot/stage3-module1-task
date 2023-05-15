package com.mjc.school;

import com.mjc.school.controller.engine.AppEngine;


public class Main {

    public static void main(String[] args) throws Exception {
        AppEngine engine = AppEngine.getInstance();
        engine.runApp();
    }
}