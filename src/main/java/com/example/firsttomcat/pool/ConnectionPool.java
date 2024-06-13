package com.example.firsttomcat.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.example.firsttomcat.constant.Constant.*;

public class ConnectionPool {
    private static volatile ConnectionPool instance;
    private static final Object lock = new Object(); // Объект блокировки
    private BlockingQueue<Connection> free = new LinkedBlockingQueue<>(8);
    private BlockingQueue<Connection> used = new LinkedBlockingQueue<>(8);

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }


    private ConnectionPool() {
        Properties properties = new Properties();
        properties.put("user", USER);
        properties.put("password", PASSWORD_DB);

        for (int i = 0; i < 8; i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, properties);
                free.add(connection);
            } catch (SQLException e) {
                throw new RuntimeException("Error getting connection: " + e.getMessage(), e);
            }
        }
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error registering Driver: " + e.getMessage(), e);
        }
    }



    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = free.take();
            used.put(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error getConnection: " + e.getMessage(), e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        try {
            if (connection != null && used.remove(connection)) {
                free.put(connection);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Error  releaseConnection: " + e.getMessage(), e);
        }
    }
}
