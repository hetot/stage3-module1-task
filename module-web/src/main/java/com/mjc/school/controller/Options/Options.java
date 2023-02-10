package com.mjc.school.controller.Options;

import com.mjc.school.controller.OptionInterface.OptionInterface;

public enum Options {
    GETALLNEWS(new GetAllOption(), 1, "Get all news."),
    GETNEWSBYID(new GetByIdOption(), 2, "Get news by ID."),
    CREATENEWS(new CreateOption(), 3, "Create news."),
    UPDATENEWS(new UpdateOption(), 4, "Update news."),
    REMOVENEWSBYID(new RemoveOption(), 5, "Remove news by ID."),
    EXIT(new ExitOption(), 0, "Exit.");

    private final OptionInterface option;
    private final int optionNumber;

    private final String text;

    Options(OptionInterface option, int optionNumber, String text) {
        this.option = option;
        this.optionNumber = optionNumber;
        this.text = text;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public OptionInterface getOption() {
        return option;
    }

    public String toString() {
        return optionNumber + " - " + text;
    }
}
