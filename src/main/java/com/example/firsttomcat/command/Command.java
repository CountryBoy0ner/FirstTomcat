package com.example.firsttomcat.command;

import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpRequest;

@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest request);
    default void refresh(){}
}
