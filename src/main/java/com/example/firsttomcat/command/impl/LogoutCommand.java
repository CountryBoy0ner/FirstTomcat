package com.example.firsttomcat.command.impl;

import com.example.firsttomcat.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpRequest;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index.jsp";
    }
}
