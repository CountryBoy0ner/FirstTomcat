package com.example.firsttomcat.service;

import com.example.firsttomcat.exception.ServiceException;

public interface UserService {
    boolean authenticate(String login, String password) throws  ServiceException;
}
