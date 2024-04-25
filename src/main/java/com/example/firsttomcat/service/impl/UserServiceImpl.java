package com.example.firsttomcat.service.impl;

import com.example.firsttomcat.dao.Imp.UserDaoImpl;
import com.example.firsttomcat.exception.DaoException;
import com.example.firsttomcat.exception.ServiceException;
import com.example.firsttomcat.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new  UserServiceImpl();
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);


    private UserServiceImpl() {
    }


    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) throws ServiceException {
        // todo     validate login, pass+ md5
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = false;
        try {
            match = userDao.authenticate(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        logger.info("UserService authenticate match: " + match);

        return match;
    }
}
