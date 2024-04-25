package com.example.firsttomcat.dao;

import com.example.firsttomcat.exception.DaoException;

public interface UserDao {
    boolean authenticate(String login, String password) throws DaoException;



}
