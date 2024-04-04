package com.example.firsttomcat.dao.Imp;

import com.example.firsttomcat.dao.BaseDao;
import com.example.firsttomcat.dao.UserDao;
import com.example.firsttomcat.entity.User;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

import java.util.List;

import static org.neo4j.driver.Values.parameters;

public class UserDaoImpl extends BaseDao<User> implements UserDao, AutoCloseable {
    private static final UserDaoImpl INSTANCE = new UserDaoImpl();
    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }

    private final Driver driver;

    public UserDaoImpl() {
        // Replace with your actual Neo4j database URI, username, and password
        final String dbUri = "<neo4j://localhost:7687>";
        final String dbUser = "<neo4j>";
        final String dbPassword = "<vs6z39VUkbZ0jaYF6WtWtIEPKNpb6nYJ5O1fFcjEEZQ>";
        this.driver = GraphDatabase.driver(dbUri, AuthTokens.basic(dbUser, dbPassword));
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
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
    public boolean authenticate(String login, String password) {
        try (var session = driver.session()) {
            var result = session.run("MATCH (u:User {login: $login, password: $password}) RETURN u",
                    parameters("login", login, "password", password));
            return result.hasNext();
        }
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }
}
