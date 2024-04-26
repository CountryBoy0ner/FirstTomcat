package com.example.firsttomcat.dao.Connection;

import com.example.firsttomcat.controller.Controller;
import org.apache.log4j.Logger;
import org.neo4j.driver.*;

import org.neo4j.driver.Record;


public class Neo4jService {
    final org.apache.log4j.Logger logger = Logger.getLogger(Neo4jService.class);


    private final Driver driver;

    public Neo4jService(Driver driver) {
        this.driver = driver;
    }

    // Поиск узла по id
    public void findNodeById(String id) {
        try (Session session = driver.session()) {
            String query = String.format("MATCH (n) WHERE n.id = '%s' RETURN n", id);// todo
            Result result = session.run(query);

            while (result.hasNext()) {
                Record record = result.next();
                System.out.println(record.get("n").asNode().labels());
            }

        }
    }
    // Метод для получения списка пользователей с определенным именем
    public String getUsersPasswordByName(String name) {
        try (Session session = driver.session()) {
            String query = String.format("MATCH (u:User) WHERE u.Name = '%s' RETURN u.Password", name);
            Result result = session.run(query);
            if (result.hasNext()) {
                Record record = result.next();
                logger.info("UserDaoImlp:пользователь найден ");

                return record.get("u.Password").asString();

            } else {
                logger.info("UserDaoImlp:пользователь не найден ");
                return null;
            }
        }
    }
}

