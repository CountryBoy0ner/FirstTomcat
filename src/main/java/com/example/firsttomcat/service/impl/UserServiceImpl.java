package com.example.firsttomcat.service.impl;

import com.example.firsttomcat.dao.UserDao;
import com.example.firsttomcat.dao.impl.UserDaoImpl;
import com.example.firsttomcat.service.UserService;

public class UserServiceImpl implements UserService {
    private static final UserService instance = new UserServiceImpl();

    private UserServiceImpl(){}

    public static UserService getInstance() {
        return instance;
    }




    @Override
    public boolean authenticate(String login, String password) throws ClassNotFoundException {
        //validate login pass + md5
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = userDao.authenticate(login, password);
        return match;
    }
}
