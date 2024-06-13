package com.example.firsttomcat.dao.impl;

import com.example.firsttomcat.dao.BaseDao;
import com.example.firsttomcat.dao.UserDao;
import com.example.firsttomcat.entity.User;
import com.example.firsttomcat.pool.ConnectionPool;
import org.intellij.lang.annotations.Language;

import java.sql.*;
import java.util.List;
import java.util.Properties;

import static com.example.firsttomcat.constant.Constant.*;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    private static final String SELECT_PASSWORD_FROM_USER = "SELECT password FROM users WHERE login = ?";
    // singleton
    private UserDaoImpl() {
    }

    private static final UserDaoImpl instance = new UserDaoImpl();


    public static UserDaoImpl getInstance() {
        return instance;
    }


    @Override
    public boolean insert(User user) throws SQLException {
        return false;

    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean authenticate(String login, String password) throws ClassNotFoundException {
        boolean match = false;
        try {
            // Регистрация драйвера
            ConnectionPool pool = ConnectionPool.getInstance();
            try (Connection connection = pool.getConnection() ;
                 PreparedStatement statement = connection.prepareStatement(SELECT_PASSWORD_FROM_USER)){
                statement.setString(1, login);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String passFromDb = resultSet.getString("password");
                        match = password.equals(passFromDb);
                    }
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return match;
    }
}


