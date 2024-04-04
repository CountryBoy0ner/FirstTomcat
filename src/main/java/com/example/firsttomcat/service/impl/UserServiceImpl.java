package com.example.firsttomcat.service.impl;

import com.example.firsttomcat.dao.Imp.UserDaoImpl;
import com.example.firsttomcat.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new  UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) {
        //validate login, pass+ md5
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = userDao.authenticate(login, password);


        return match;
    }
}
