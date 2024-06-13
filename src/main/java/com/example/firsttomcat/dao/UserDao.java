package com.example.firsttomcat.dao;

import java.sql.SQLException;

public interface UserDao {
    boolean authenticate(String login, String password) throws SQLException, ClassNotFoundException;
//    boolean register(String login, String password);

}
