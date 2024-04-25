package com.example.firsttomcat.command;

import com.example.firsttomcat.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpRequest;

@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
    default void refresh(){}
}
