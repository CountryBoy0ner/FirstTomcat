package com.example.firsttomcat.controller;

import com.example.firsttomcat.command.Command;
import com.example.firsttomcat.command.CommandType;
import com.example.firsttomcat.dao.Connection.Pool.Neo4jConnectionManager;
import com.example.firsttomcat.exception.CommandException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns ={ "/controller", "*.do"})
public class Controller extends HttpServlet {

    public void init() {
        BasicConfigurator.configure();

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final Logger logger = Logger.getLogger(Controller.class);
        logger.info("doGet controller");// todo this, should be named properly
        String commandStr = request.getParameter("command");
        Command command = CommandType.define(commandStr);
        String page;
        try {
            page = command.execute(request);
            //request.getRequestDispatcher(page).forward(request, response);
            //response.sendRedirect(page);
            response.sendRedirect(request.getContextPath() + "/" + page);
        } catch (CommandException e) {
            //response.sendError(500);
            // throw new ServletException(e);
            request.setAttribute("error_msg", e.getCause()); //3
            request.getRequestDispatcher("pages/error/error_500.jsp").forward(request, response); //3
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Add some code that can throw IOException or ServletException
        throw new IOException("This is a test IOException");
    }

    public void destroy() {
        Neo4jConnectionManager.getInstance.destroyPool();
    }
}