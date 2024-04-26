package com.example.firsttomcat.dao.Imp;

import com.example.firsttomcat.controller.Controller;
import com.example.firsttomcat.dao.BaseDao;
import com.example.firsttomcat.dao.Connection.Pool.Neo4jConnectionManager;
import com.example.firsttomcat.dao.Connection.Neo4jService;
import com.example.firsttomcat.dao.UserDao;
import com.example.firsttomcat.entity.User;
import com.example.firsttomcat.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.neo4j.driver.exceptions.AuthenticationException;
import org.neo4j.driver.exceptions.ServiceUnavailableException;


import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao, AutoCloseable {

    final  private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserDaoImpl.class);

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();
    private final Neo4jConnectionManager connectionManager;

    private UserDaoImpl(){
        this.connectionManager = new Neo4jConnectionManager(
                "neo4j+s://2f26ebae.databases.neo4j.io",
                "neo4j",
                "ipy6ASS3ezx6UmAsYGYEnJH8rJM5o8CuGZ5-ct4RaL8");
        this.connectionManager.connect();
    }

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        throw new UnsupportedOperationException("delete not supported");
        //todo
    }

    @Override
    public List<User> findAll(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override

    public boolean authenticate(String login, String password) throws DaoException {

        try {
            Neo4jService service = new Neo4jService(connectionManager.getDriver());
            String passwordFromDb = service.getUsersPasswordByName(login);
            logger.info("Dao authenticate: password From Db - " + passwordFromDb);


             if (passwordFromDb.equals(password)) {
                logger.info("Dao authenticate: Passed");
                return true;
            } else {
                 logger.info("Dao authenticate: Failed ");
                 return false;
             }

        } catch (ServiceUnavailableException e) {
            logger.error("UserDaoImpl: ServiceUnavailableException: Ошибка при подключении к базе данных", e);
            throw new DaoException(e.getMessage() + "Ошибка при подключении к базе данных" );
        } catch (AuthenticationException e) {
            logger.error("UserDaoImpl: AuthenticationException: Ошибка аутентификации", e);
            throw new DaoException(e.getMessage() +"Ошибка аутентификации");
        } catch (Exception e) {
            logger.error("UserDaoImpl: НЕТ ТАКОГО ПОЛЬЗОВАТЕЛЯ", e);
            //throw new DaoException(e + "НЕТ ТАКОГО ПОЛЬЗОВАТЕЛЯ");
            return false;

        }

    }


    @Override
    public void close() throws Exception {
        try {
            connectionManager.close();
        } catch (Exception e) {
            logger.error("Ошибка при закрытии соединения", e);
            throw e;
        }
    }



}
