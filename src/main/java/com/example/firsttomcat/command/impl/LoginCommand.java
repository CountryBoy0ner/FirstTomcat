package com.example.firsttomcat.command.impl;

import com.example.firsttomcat.command.Command;
import com.example.firsttomcat.exception.CommandException;
import com.example.firsttomcat.exception.ServiceException;
import com.example.firsttomcat.service.UserService;
import com.example.firsttomcat.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//import java.net.http.HttpRequest;

public class LoginCommand implements Command {
    final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginCommand.class);


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        logger.info("LoginCommand:execute");

        String login  = request.getParameter("login");
        String password = request.getParameter("pass");
        UserService userService= UserServiceImpl.getInstance();
        String page;
        HttpSession session = request.getSession();
        try {
            if ( userService.authenticate(login, password)) {
                request.setAttribute("user", login);

                session.setAttribute("user_name", login);
                logger.info("LoginCommand: return main index page ");

                page = "pages/main.jsp";
            }else {

                request.setAttribute("login_msg", "Wrong login or password");
                page = "index.jsp";

                logger.info("LoginCommand: return index page ");
            }
            session.setAttribute("current_page", page);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return page;
    }
}



//        logger.info("LoginCommand:execute");
//
//        String login = request.getParameter("login");
//        String password = request.getParameter("pass");
//        UserService userService = UserServiceImpl.getInstance();
//        String page;
//        HttpSession session = request.getSession();
//        try {
//            if (userService.authenticate(login, password)) {
//                request.setAttribute("user", login);
//                session.setAttribute("user_name", login);
//                logger.info("LoginCommand: return main index page ");
//                page = "pages/main.jsp";
//            } else {
//                request.setAttribute("login_msg", "Неверный логин или пароль");
//                page = "index.jsp";
//                logger.info("LoginCommand: return index page ");
//            }
//            session.setAttribute("current_page", page);
//        } catch (ServiceException e) {
//            throw new CommandException(e);
//        }
//        return page; // Возвращаем имя страницы, куда нужно перенаправиться
//    }
//}