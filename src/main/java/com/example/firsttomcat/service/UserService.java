package com.example.firsttomcat.service;

public interface UserService {
    boolean authenticate(String login, String password) throws ClassNotFoundException;
}
