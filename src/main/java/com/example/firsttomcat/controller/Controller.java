package com.example.firsttomcat.controller;

import java.io.*;

import com.example.firsttomcat.command.Command;
import com.example.firsttomcat.command.CommandType;
import jakarta.servlet.ServletException;
import org.apache.log4j.BasicConfigurator;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.log4j.Logger;

@WebServlet(name = "helloServlet", urlPatterns ={ "/controller", "*.do"})
public class Controller extends HttpServlet {

    public void init() {
        BasicConfigurator.configure();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final Logger logger = Logger.getLogger(Controller.class);
        logger.info("doGet controller");// todo this, should be named properly

        String commandStr = request.getParameter("command");
        Command command = CommandType.define(commandStr);
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}