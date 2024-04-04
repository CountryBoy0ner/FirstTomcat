package com.example.firsttomcat.command.impl;

import com.example.firsttomcat.command.Command;
import com.example.firsttomcat.service.UserService;
import com.example.firsttomcat.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpRequest;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String login  = request.getParameter("login");
        String password = request.getParameter("pass");
        UserService userService= UserServiceImpl.getInstance();
        String page;
        if ( userService.authenticate(login, password)) {
            request.setAttribute("user", login);
            page = "pages/main.jsp";
        }else {
            request.setAttribute("login_msg", "Wrong login or password");
            page = "index.jsp";
        }
        return page;
    }
}
