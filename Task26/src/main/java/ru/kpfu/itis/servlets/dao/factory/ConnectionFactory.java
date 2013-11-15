package ru.kpfu.itis.servlets.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String driverClassName = "org.postgresql.Driver";
   // private final String connectionUrl = "jdbc:postgresql://localhost:5432/studentbook";
   // private final String dbUser = "user";
   // private final String dbPwd = "qwerty";
   // private final String connectionUrl = "jdbc:postgresql://178.213.246.19:25432/fazliakhmetov_sb";
    private final String connectionUrl = "jdbc:postgresql://localhost:5432/fazliakhmetov_sb";
    private final String dbUser = "practice";
    private final String dbPwd = "123";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}