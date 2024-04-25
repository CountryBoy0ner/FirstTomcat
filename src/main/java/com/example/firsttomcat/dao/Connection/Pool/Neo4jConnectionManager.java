package com.example.firsttomcat.dao.Connection.Pool;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
// драйвер Neo4j Java, уже включает в себя пул соединений
public class Neo4jConnectionManager {


    public static Neo4jConnectionManager getInstance;


    private final String dbUri;
    private final String dbUser;
    private final String dbPassword;
    private Driver driver;

    public Neo4jConnectionManager(String dbUri, String dbUser, String dbPassword) {
        this.dbUri = dbUri;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public void connect() {
        this.driver = GraphDatabase.driver(dbUri, AuthTokens.basic(dbUser, dbPassword));
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void close() {
        if (this.driver != null) {
            this.driver.close();
        }
    }
    public void destroyPool() {
        if (this.driver != null) {
            this.driver.close();
            this.driver = null;
        }
    }
    // todo deregister driver
}
