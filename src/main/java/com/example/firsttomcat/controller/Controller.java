package com.example.firsttomcat.controller;

import com.example.firsttomcat.command.Command;
import com.example.firsttomcat.command.CommandType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import org.apache.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns ={ "/controller"})

public class Controller extends HttpServlet {

   // final static Logger logger = Logger.getLogger(Controller.class);
    public void init() {}
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/htm");

        String commandStr = request.getParameter("command");
        Command command = CommandType.defineCommand(commandStr);
        String page = null; //choose what to use (request)
        try {
            page = command.execute(request);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher(page).forward(request, response);
        //implement sessions

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


    }


}